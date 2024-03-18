package org.agh.model.team;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Team {
    private Integer id;
    private String conference;
    private String division;
    private String city;
    private String name;
    private String full_name;
    private String abbreviation;
}
