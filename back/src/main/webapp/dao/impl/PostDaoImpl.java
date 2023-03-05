package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.PostDao;

import java.sql.Connection;
import java.sql.SQLException;

public class PostDaoImpl implements PostDao {
    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }
}
