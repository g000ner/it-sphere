package main.webapp.exception.dao;

public class PostCommentDaoException extends Exception {
    public PostCommentDaoException() {
        super();
    }

    public PostCommentDaoException(String message) {
        super(message);
    }

    public PostCommentDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostCommentDaoException(Throwable cause) {
        super(cause);
    }

    protected PostCommentDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
