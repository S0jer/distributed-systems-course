package org.agh.edu.pl.model;

import io.grpc.stub.StreamObserver;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.agh.edu.pl.gen.PlayerStatisticsResponse;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
@Setter
@NoArgsConstructor
public class StatsSubscriber {
    private int clientId;
    private List<Integer> playerIds;
    private List<String> seasons;
    private StreamObserver<PlayerStatisticsResponse> responseObserver;
    private List<PlayerStatisticsResponse> statsBuffer = new CopyOnWriteArrayList<>();
    private int failedAttempts = 0;
    private boolean isActive = true;

    public StatsSubscriber(int clientId, List<Integer> playerIds, List<String> seasons, StreamObserver<PlayerStatisticsResponse> responseObserver) {
        this.clientId = clientId;
        this.playerIds = playerIds;
        this.seasons = seasons;
        this.responseObserver = responseObserver;
    }

    public void incrementFailures() {
        failedAttempts++;
    }

    public synchronized void bufferStat(PlayerStatisticsResponse stats) {
        statsBuffer.add(stats);
    }

    public void notifySubscriber() throws InterruptedException {
        if (responseObserver instanceof io.grpc.stub.ServerCallStreamObserver) {
            io.grpc.stub.ServerCallStreamObserver<PlayerStatisticsResponse> serverObserver =
                    (io.grpc.stub.ServerCallStreamObserver<PlayerStatisticsResponse>) responseObserver;

            if (serverObserver.isCancelled()) {
                incrementFailures();
            } else {
                dispatchBufferedStats();
            }
        }
    }

    private void dispatchBufferedStats() {
        statsBuffer.forEach(responseObserver::onNext);
        clearStatsBuffer();
    }

    private synchronized void clearStatsBuffer() {
        statsBuffer.clear();
    }
}
