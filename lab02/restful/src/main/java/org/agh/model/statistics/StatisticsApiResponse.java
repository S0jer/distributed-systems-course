package org.agh.model.statistics;

import lombok.Getter;
import lombok.Setter;
import org.agh.model.Meta;

import java.util.List;

@Setter
@Getter
public class StatisticsApiResponse {
    private List<Statistics> data;
    private Meta meta;
}