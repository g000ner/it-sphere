package main.webapp.dao.impl;

import main.webapp.dao.api.ConnectionBuilder;
import main.webapp.dao.api.PostLikeDao;

import java.sql.Connection;
import java.sql.SQLException;

public class PostLikeDaoImpl implements PostLikeDao {
    private ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        return connectionBuilder.getConnection();
    }
}
