package com.example.demo.game.models;

import lombok.Data;

@Data
public class Game {
    private Player player1, player2;
    private String gameID;
    private GameStatus status;
    private int [][] board;
    private Color winner;
}
