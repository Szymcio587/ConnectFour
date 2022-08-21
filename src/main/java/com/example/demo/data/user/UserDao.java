package com.example.demo.data.user;

import com.example.demo.config.DataSourceProvider;

import java.sql.*;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveUser(User user) {
        String query = " INSERT INTO user (username, email, password, registration_date) VALUES (?, ?, ?, ?) ";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(2, user.getEmail());
            statement.setObject(4, user.getRegistrationDate());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUserRole(User user) {
        String query = "INSERT INTO user_role (username) VALUES (?)";
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUser(User user) {
        String query = String.format("SELECT COUNT(*) AS 'result' FROM user WHERE username = '%s' AND password = '%s'", user.getUsername(), user.getPassword());
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int result = resultSet.getInt("result");
            return result > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}