package com.example.demo.game.exceptions;

public class InvalidParameterException extends Exception{

    private String message;

    public InvalidParameterException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
