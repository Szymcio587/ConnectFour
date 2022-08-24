package com.example.demo.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Colors {
    RED(1), BLUE(2);

    private Integer value;
}
