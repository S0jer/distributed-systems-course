package org.agh.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
    private double pts;
    private double ast;
    private double turnover;
    private double pf;
    private double fga;
    private double fgm;
    private double fta;
    private double ftm;
    private double fg3a;
    private double fg3m;
    private double reb;
    private double oreb;
    private double dreb;
    private double stl;
    private double blk;
    private double fg_pct;
    private double fg3_pct;
    private double ft_pct;
    private String min;
    private int games_played;
    private int player_id;
    private int season;

}
