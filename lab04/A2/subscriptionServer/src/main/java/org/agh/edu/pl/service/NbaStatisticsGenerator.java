package org.agh.edu.pl.service;

import org.agh.edu.pl.gen.*;


import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NbaStatisticsGenerator {

    private final Random random = new Random();

    public List<PlayerStatisticsResponse> generatePlayerStatistics(int playerId, List<String> seasons) {
        return seasons.stream()
                .map(season -> generateGameStatistics(playerId, season))
                .collect(Collectors.toList());
    }

    public PlayerStatisticsResponse generateGameStatistics(int playerId, String season) {
        return PlayerStatisticsResponse.newBuilder()
                .setPlayerId(String.valueOf(playerId))
                .addAllGames(IntStream.rangeClosed(1, 5)
                        .mapToObj(gameId -> GameStatistics.newBuilder()
                                .setGameId("Game" + gameId)
                                .setDate(season + "-0" + gameId)
                                .setOpponent("Team" + (gameId + 1))
                                .setOutcome(random.nextBoolean() ? GameOutcome.WIN : GameOutcome.LOSS)
                                .setGamePerformanceGrade(GamePerformance.AVERAGE)
                                .setStats(generateDetailedStatistics())
                                .build())
                        .toList())
                .build();
    }

    private DetailedStatistics generateDetailedStatistics() {
        float fieldGoalPercentage = random.nextFloat();
        float threePointPercentage = random.nextFloat();
        float freeThrowPercentage = random.nextFloat();

        return DetailedStatistics.newBuilder()
                .setMinutes(random.nextInt(40) + 5)
                .setPoints(random.nextInt(30))
                .setFieldGoals(FieldGoalStats.newBuilder()
                        .setAttempts(random.nextInt(20))
                        .setMade(random.nextInt(10))
                        .setPercentage(fieldGoalPercentage)
                        .build())
                .setThreePointers(FieldGoalStats.newBuilder()
                        .setAttempts(random.nextInt(15))
                        .setMade(random.nextInt(7))
                        .setPercentage(threePointPercentage)
                        .build())
                .setFreeThrows(FreeThrowStats.newBuilder()
                        .setAttempts(random.nextInt(10))
                        .setMade(random.nextInt(5))
                        .setPercentage(freeThrowPercentage)
                        .build())
                .setRebounds(random.nextInt(15))
                .setAssists(random.nextInt(10))
                .setSteals(random.nextInt(5))
                .setBlocks(random.nextInt(3))
                .setPersonalFouls(random.nextInt(6))
                .setTurnovers(random.nextInt(5))
                .build();
    }

    public SeasonAveragesResponse generateSeasonAverages(int playerId, String season) {
        List<DetailedStatistics> gamesStats = IntStream.range(0, 5)
                .mapToObj(i -> generateDetailedStatistics())
                .toList();

        DetailedStatistics averageStats = calculateAverageStatistics(gamesStats);

        return SeasonAveragesResponse.newBuilder()
                .setAverages(SeasonStatistics.newBuilder()
                        .setSeason(season)
                        .setAverageStats(averageStats)
                        .build())
                .build();
    }

    private DetailedStatistics calculateAverageStatistics(List<DetailedStatistics> gamesStats) {
        return gamesStats.get(0);
    }
}
