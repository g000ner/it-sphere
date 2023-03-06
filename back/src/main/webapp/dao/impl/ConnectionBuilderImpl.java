package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Реализация строителя соединения к БД
public class ConnectionBuilderImpl implements ConnectionBuilder {
    private static ConnectionBuilderImpl instance;

    private String driverName;
    private String url;
    private String login;
    private String password;

    private ConnectionBuilderImpl() {
        this.driverName = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://localhost:5432/it-sphere";
        this.login = "postgres";
        this.password = "00023";
    }

    public static synchronized ConnectionBuilderImpl getInstance() {
        if (instance == null) {
            instance = new ConnectionBuilderImpl();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
}
