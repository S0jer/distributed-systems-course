package org.agh.edu.pl.service;

import io.grpc.Status;
import org.agh.edu.pl.gen.*;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class NbaStatsGrpcImpl extends NbaStatsGrpc.NbaStatsImplBase {
    private final ConcurrentHashMap<Integer, ServerCallStreamObserver<PlayerStatisticsResponse>> subscribers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, List<PlayerStatisticsResponse>> bufferedResponses = new ConcurrentHashMap<>();

    private final int maxRetries = 12;
    private final int retryDelay = 1000;
    private final NbaStatisticsGenerator nbaStatisticsGenerator = new NbaStatisticsGenerator();

    @Override
    public void subscribeNbaStats(NbaStatsSubscription request,
                                  StreamObserver<PlayerStatisticsResponse> responseObserver) {
        ServerCallStreamObserver<PlayerStatisticsResponse> serverObserver =
                (ServerCallStreamObserver<PlayerStatisticsResponse>) responseObserver;
        int playerId = request.getPlayerId();
        List<String> seasons = request.getSeasonsList();

        subscribers.put(playerId, serverObserver);

        if (bufferedResponses.containsKey(playerId)) {
            List<PlayerStatisticsResponse> responses = bufferedResponses.get(playerId);
            for (PlayerStatisticsResponse response : responses) {
                serverObserver.onNext(response);
            }
            bufferedResponses.remove(playerId);
        }

        serverObserver.setOnCancelHandler(() -> subscribers.remove(playerId));

        AtomicInteger failedAttempts = new AtomicInteger();

        while (!serverObserver.isCancelled()) {
            seasons.forEach(season -> {
                PlayerStatisticsResponse response = nbaStatisticsGenerator.generateGameStatistics(playerId, season);

                try {
                    if (serverObserver.isCancelled()) throw new StatusRuntimeException(Status.CANCELLED);
                    serverObserver.onNext(response);
                    failedAttempts.set(0);
                } catch (StatusRuntimeException e) {
                    bufferedResponses.computeIfAbsent(playerId, k -> new ArrayList<>()).add(response);
                    if (failedAttempts.incrementAndGet() > maxRetries) {
                        subscribers.remove(playerId);
                        return;
                    }
                }
            });

            try {
                Thread.sleep(retryDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (failedAttempts.get() > maxRetries) {
                subscribers.remove(playerId);
                bufferedResponses.remove(playerId);
                return;
            } else if (!serverObserver.isCancelled() && bufferedResponses.containsKey(playerId)) {
                bufferedResponses.get(playerId).forEach(responseObserver::onNext);
            }
        }
    }

    @Override
    public void getSeasonAverages(SeasonAveragesRequest request,
                                  StreamObserver<SeasonAveragesResponse> responseObserver) {
        String season = request.getSeason();
        int playerId = request.getPlayerId();

        SeasonAveragesResponse response = nbaStatisticsGenerator.generateSeasonAverages(playerId, season);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
