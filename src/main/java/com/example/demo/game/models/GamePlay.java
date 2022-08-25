package com.example.demo.game.models;

import lombok.Data;

@Data
public class GamePlay {
    private Color type;
    private Integer coordinateX, coordinateY;
    private String gameID;

}
