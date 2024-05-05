package org.agh.edu.pl.service;

import org.agh.edu.pl.gen.*;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import org.agh.edu.pl.model.NbaPlayer;
import org.agh.edu.pl.model.StatsSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NbaStatsGrpcImpl extends NbaStatsGrpc.NbaStatsImplBase {
    List<StatsSubscriber> statsSubscribers = new ArrayList<>();
    NbaStatisticsGenerator nbaStatisticsGenerator;
    private final List<NbaPlayer> nbaPlayers;
    private final int maxRetries = 12;
    private final int retryDelay = 1000;

    public NbaStatsGrpcImpl(List<NbaPlayer> nbaPlayers) {
        this.nbaPlayers = nbaPlayers;
    }

    @Override
    public void subscribeNbaStats(NbaStatsSubscription request,
                                  StreamObserver<PlayerStatisticsResponse> responseObserver) {
        ServerCallStreamObserver<PlayerStatisticsResponse> serverObserver =
                (ServerCallStreamObserver<PlayerStatisticsResponse>) responseObserver;
        int clientId = request.getClientId();
        List<Integer> playerIds = request.getPlayerIdsList();
        List<String> seasons = request.getSeasonsList();
        StatsSubscriber statsSubscriber = findOrCreateSubscriber(clientId, playerIds, seasons, responseObserver);
        List<NbaPlayer> filteredPlayers = nbaPlayers.stream()
                .filter(player -> playerIds.contains(player.getId()))
                .toList();
        filteredPlayers.forEach(filteredPlayer -> filteredPlayer.addSubscriber(statsSubscriber));
    }

    private StatsSubscriber findOrCreateSubscriber(int clientId, List<Integer> playerIds, List<String> seasons, StreamObserver<PlayerStatisticsResponse> responseObserver) {
        Optional<StatsSubscriber> optSubscriber = statsSubscribers.stream().filter(x -> x.getClientId() == clientId).findFirst();
        if (optSubscriber.isPresent()) {
            StatsSubscriber statsSubscriber = optSubscriber.get();
            statsSubscriber.setResponseObserver(responseObserver);
            return statsSubscriber;
        }
        StatsSubscriber statsSubscriber = new StatsSubscriber(clientId, playerIds, seasons, responseObserver);
        statsSubscribers.add(statsSubscriber);
        return statsSubscriber;
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
