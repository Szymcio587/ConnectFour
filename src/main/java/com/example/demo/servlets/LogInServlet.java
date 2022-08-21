package com.example.demo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.demo.api.UserRegistration;
import com.example.demo.api.UserService;

import java.io.IOException;

@WebServlet("/menu.jsp")
public class LogInServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserRegistration userRegistration = new UserRegistration(username, password);
        boolean toLogin = userService.login(userRegistration);
        if(toLogin)
            request.getRequestDispatcher("/menu2.jsp").forward(request, response);
        else
            request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
