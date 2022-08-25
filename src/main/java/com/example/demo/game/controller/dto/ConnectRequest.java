package com.example.demo.game.controller.dto;

import com.example.demo.game.models.Player;
import lombok.Data;

@Data
public class ConnectRequest {

    private Player player;
    private String GameID;
}
