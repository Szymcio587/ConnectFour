package com.example.demo.game.exceptions;

public class InvalidGameException extends Exception{

    private String message;

    public InvalidGameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
