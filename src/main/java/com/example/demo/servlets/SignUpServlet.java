package com.example.demo.servlets;

import com.example.demo.filters.RegistrationDataFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.demo.api.UserRegistration;
import com.example.demo.api.UserService;

import java.io.IOException;

@WebServlet("/confirm.jsp")
public class SignUpServlet extends HttpServlet {
    private final UserService userService = new UserService();
    private final RegistrationDataFilter filter = new RegistrationDataFilter();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRegistration userRegistration = getUserData(request);
        userService.register(userRegistration);
        response.sendRedirect(request.getContextPath() + "/confirm.jsp");
    }

    private UserRegistration getUserData(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeated = request.getParameter("password2");
        boolean isLegit = filter.Filter(username, password, passwordRepeated, email);
        return new UserRegistration(username, email, password, passwordRepeated);
    }
}
