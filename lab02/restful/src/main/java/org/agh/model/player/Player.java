package org.agh.model.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.agh.model.team.Team;

@Setter
@Getter
@AllArgsConstructor
public class Player {
    private Integer id;
    private String first_name;
    private String last_name;
    private String position;
    private String height;
    private String weight;
    private String jersey_number;
    private String college;
    private String country;
    private Integer draft_year;
    private Integer draft_round;
    private Integer draft_number;
    private Team team;
}
