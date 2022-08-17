package com.example.demo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/confirm.jsp")
public class ConnectServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String[] user_data = new String[3];
        user_data[0] = username;
        user_data[1] = password;
        user_data[2] = email;
        try {
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
