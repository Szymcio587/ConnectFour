package com.example.demo.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/confirm.jsp")
public class RegistrationDataFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_repeated = request.getParameter("password2");
        String email = request.getParameter("email");
        if(CorrectUsername(username) &&
                CorrectPassword(password, password_repeated) &&
                CorrectEmail(email)) {
            chain.doFilter(request, response);
        }

        else
            request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public boolean CorrectUsername(String username) {
        if (username.matches("[a-zA-Z0-9\\-_]{5,25}"))
            return true;
        else
            return false;
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
        else
            return false;

    }

    public boolean CorrectEmail(String email) {
        if (email.matches("[a-zA-Z0-9.]+@[a-z]+.[a-z]+"))
            return true;
        else
            return false;

    }
}
