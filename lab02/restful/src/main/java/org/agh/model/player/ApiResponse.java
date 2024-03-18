package org.agh.model.player;

import lombok.Getter;
import lombok.Setter;
import org.agh.model.Meta;

import java.util.List;

@Setter
@Getter
public class ApiResponse {
    private List<Player> data;
    private Meta meta;
}
