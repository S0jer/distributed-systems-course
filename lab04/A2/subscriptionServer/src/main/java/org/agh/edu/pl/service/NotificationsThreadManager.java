package org.agh.edu.pl.service;

import org.agh.edu.pl.model.NbaPlayer;
import org.agh.edu.pl.model.StatsSubscriber;

import java.util.List;

public class NotificationsThreadManager extends Thread {

    List<NbaPlayer> nbaPlayers;


    public NotificationsThreadManager(List<NbaPlayer> nbaPlayers) {
        this.nbaPlayers = nbaPlayers;
    }


    public void run() {
        while (true) {
            nbaPlayers.forEach(nbaPlayer -> {
                var statsSubscribers = nbaPlayer.getStatsSubscribers();
                if (statsSubscribers != null && !statsSubscribers.isEmpty()) {
                    if (nbaPlayer.getGameStatisticsResponse() != null) {
                        for (StatsSubscriber statsSubscriber : statsSubscribers) {
                            statsSubscriber.bufferStat(nbaPlayer.getGameStatisticsResponse());
                        }
                        for (StatsSubscriber statsSubscriber : statsSubscribers) {
                            try {
                                statsSubscriber.notifySubscriber();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            });
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
