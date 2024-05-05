package org.agh.edu.pl.model;

import lombok.Getter;
import lombok.Setter;
import org.agh.edu.pl.gen.PlayerStatisticsResponse;
import org.agh.edu.pl.gen.SeasonAveragesResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NbaPlayer {
    private int id;
    private List<String> seasons;
    private volatile List<PlayerStatisticsResponse> playerStatisticsResponse;
    private volatile PlayerStatisticsResponse gameStatisticsResponse;
    private volatile SeasonAveragesResponse seasonAveragesResponse;

    private List<StatsSubscriber> statsSubscribers = new ArrayList<>();

    public NbaPlayer(int id, List<String> seasons) {
        this.id = id;
        this.seasons = seasons;
    }

    public void addSubscriber(StatsSubscriber statsSubscriber) {
        if (!statsSubscribers.contains(statsSubscriber)) {
            this.statsSubscribers.add(statsSubscriber);
        }
    }
}
