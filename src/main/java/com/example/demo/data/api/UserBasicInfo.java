package com.example.demo.data.api;

import java.time.LocalDateTime;

public class UserBasicInfo {
    String username, password, email;
    LocalDateTime registrationTime;

    public UserBasicInfo(String username, String password, String email, LocalDateTime registrationTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationTime = registrationTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
