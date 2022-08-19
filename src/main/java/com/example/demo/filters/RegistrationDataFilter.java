package com.example.demo.filters;

import jakarta.servlet.*;
import java.util.regex.Pattern;
public class RegistrationDataFilter{
    private String errorMessage;

    public boolean Filter(String username, String password, String password_repeated, String email) {
        if(CorrectUsername(username) &&
                CorrectPassword(password, password_repeated) &&
                CorrectEmail(email)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void SetErrorMessage(ServletRequest request) {
        request.setAttribute("error", errorMessage);
    }

    public boolean CorrectUsername(String username) {
        if (username.matches("[a-zA-Z0-9\\-_]{5,25}"))
            return true;
        else {
            errorMessage = "Username should be 5 to 25 characters long and do not contain special characters.";
            return false;
        }
    }

    public boolean CorrectPassword(String password, String password_repeated) {
        Pattern special_chars = Pattern.compile("[^A-Za-z0-9 ]");
        Pattern numbers = Pattern.compile("[0-9]");
        Pattern letters = Pattern.compile("[a-zA-Z]");
        if(password.equals(password_repeated) &&
                special_chars.matcher(password).find() &&
                numbers.matcher(password).find() &&
                letters.matcher(password).find() &&
                password.length() > 7)
            return true;
        else {
            errorMessage += "Passwords should be equal, have more than 7 characters, and contain at least " +
                    "one letter, one number and one special character.";
            return false;
        }
    }

    public boolean CorrectEmail(String email) {
        if (email.matches("[a-zA-Z0-9.]+@[a-z]+.[a-z]+"))
            return true;
        else {
            errorMessage += "Provided email is not correct.";
            return false;
        }
    }
}