package main.webapp.exception.dao;

public class PostLikeDaoException extends Exception {
    public PostLikeDaoException() {

    }

    public PostLikeDaoException(String message) {
        super(message);
    }

    public PostLikeDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostLikeDaoException(Throwable cause) {
        super(cause);
    }

    protected PostLikeDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
