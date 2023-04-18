package edu.itsphere.back.exception;

public class UserLoginTakenException extends Exception {
    public UserLoginTakenException() {
    }

    public UserLoginTakenException(String message) {
        super(message);
    }

    public UserLoginTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginTakenException(Throwable cause) {
        super(cause);
    }

    public UserLoginTakenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
