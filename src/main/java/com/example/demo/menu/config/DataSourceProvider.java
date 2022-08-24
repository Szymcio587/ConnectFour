package com.example.demo.menu.config;

import lombok.NoArgsConstructor;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@NoArgsConstructor
public class DataSourceProvider {
    private static DataSource dataSource;

    public static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env/");
            dataSource = (DataSource) envContext.lookup("jdbc/game_data");
        }
        return dataSource;
    }
}