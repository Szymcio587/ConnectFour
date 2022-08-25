package com.example.demo.menu.user;

import lombok.*;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username, password, email;
    private LocalDateTime registrationDate;

    public User(String username, String email, String password, LocalDateTime registrationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }
}
