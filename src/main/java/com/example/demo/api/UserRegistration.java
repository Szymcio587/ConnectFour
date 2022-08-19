package com.example.demo.api;

public class UserRegistration {

    private String username, password, passwordRepeated, email;

    public UserRegistration() {}

    public UserRegistration(String username, String password, String passwordRepeated, String email) {
        this.username = username;
        this.password = password;
        this.passwordRepeated = passwordRepeated;
        this.email = email;
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

    public String getPassword_repeated() {
        return passwordRepeated;
    }

    public void setPassword_repeated(String password_repeated) {
        this.passwordRepeated = password_repeated;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
