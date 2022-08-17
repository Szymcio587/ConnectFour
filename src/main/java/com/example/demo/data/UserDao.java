package com.example.demo.data;

import com.example.demo.config.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final DataSource dataSource;

    public UserDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        final String query = " SELECT id, username, password, email, registration_date FROM user d ";
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<User> allDiscoveries = new ArrayList<>();
            while (resultSet.next()) {
                User user = mapRow(resultSet);
                allDiscoveries.add(user);
            }
            return allDiscoveries;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static User mapRow(ResultSet set) throws SQLException {
        Long userId = set.getLong("id");
        String name = set.getString("name");
        String password = set.getString("password");
        String email = set.getString("email");
        LocalDateTime registrationDate = set.getTimestamp("date_added").toLocalDateTime();
        return new User(userId, name, password, email, registrationDate);
    }
}