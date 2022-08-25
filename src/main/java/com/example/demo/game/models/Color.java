package com.example.demo.game.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    RED(1), BLUE(2);

    private Integer value;
}
