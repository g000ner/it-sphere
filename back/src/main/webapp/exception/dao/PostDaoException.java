package main.webapp.exception.dao;

public class PostDaoException extends Exception {
    public PostDaoException() {
    }

    public PostDaoException(String message) {
        super(message);
    }

    public PostDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostDaoException(Throwable cause) {
        super(cause);
    }

    public PostDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
