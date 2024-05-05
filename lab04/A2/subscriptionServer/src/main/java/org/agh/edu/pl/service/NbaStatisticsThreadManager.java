package org.agh.edu.pl.service;


import lombok.AllArgsConstructor;
import lombok.Setter;
import org.agh.edu.pl.model.NbaPlayer;

import java.util.List;

@Setter
@AllArgsConstructor
public class NbaStatisticsThreadManager extends Thread {
    List<NbaPlayer> nbaPlayers;

    public void run() {
        NbaStatisticsGenerator nbaStatisticsGenerator = new NbaStatisticsGenerator();
        while (true) {
            nbaPlayers.forEach(nbaPlayer -> {
                var seasonAveragesResponse = nbaStatisticsGenerator.generateSeasonAverages(nbaPlayer.getId(), nbaPlayer.getSeasons().getFirst());
                var gameStatistics = nbaStatisticsGenerator.generateGameStatistics(nbaPlayer.getId(), nbaPlayer.getSeasons().getFirst());
                var playerStatisticsResponses = nbaStatisticsGenerator.generatePlayerStatistics(nbaPlayer.getId(), nbaPlayer.getSeasons());
                nbaPlayer.setSeasonAveragesResponse(seasonAveragesResponse);
                nbaPlayer.setGameStatisticsResponse(gameStatistics);
                nbaPlayer.setPlayerStatisticsResponse(playerStatisticsResponses);
            });
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
