package com.example.demo.menu.api;

import lombok.AllArgsConstructor;
import lombok.*;

@Data
@AllArgsConstructor
public class UserRegistration {

    private String username, password, passwordRepeated, email;

    public UserRegistration(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
