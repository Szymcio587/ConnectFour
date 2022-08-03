package com.example.demo.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter("/confirm.jsp")
public class RegistrationDataFilter implements Filter {

    private String errorMessage;
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if(CorrectUsername(request) && CorrectPassword(request) && CorrectEmail(request))
            chain.doFilter(request, response);
        else {
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

    public boolean CorrectUsername(ServletRequest request) {
        String username = request.getParameter("username");
        if (username.matches("[a-zA-Z0-9\\-_]{5,25}"))
            return true;
        else {
            String errorMessage = request.getParameter("error");
            if(username.length() < 5 || username.length() > 25)
                errorMessage = "Wrong username length. Should be between 5 and 25 characters.";
            else
                errorMessage = "Wrong characters type provided in username.";
            return false;
        }
    }

    public boolean CorrectPassword(ServletRequest request) {
        String password = request.getParameter("password");
        String password_repeated = request.getParameter("password2");
        if(password.equals(password_repeated))
            return true;
        else {
            if(!password.equals(password_repeated))
                SendError("Passwords are not equal.", request);
            else
                SendError("Password does not match the requirements.", request);
            return false;
        }
    }

    public boolean CorrectEmail(ServletRequest request) {
        String email = request.getParameter("email");
        if (email.matches("[a-zA-Z0-9.]+@[a-z]+.[a-z]+"))
            return true;
        else {
            SendError("Incorrect email.", request);
            return false;
        }
    }

    public void SendError(String message, ServletRequest request) {
        errorMessage = request.getParameter("error");
        errorMessage += message;
    }
}
