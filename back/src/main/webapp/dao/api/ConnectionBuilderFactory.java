package main.webapp.dao.api;

import main.webapp.dao.impl.ConnectionBuilderImpl;

public class ConnectionBuilderFactory {
    public static ConnectionBuilderImpl getConnectionBuilder() {
        return ConnectionBuilderImpl.getInstance();
    }
}
