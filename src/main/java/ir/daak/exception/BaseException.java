package ir.daak.exception;

import org.slf4j.Logger;

public class BaseException extends Exception {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Logger logger, Throwable cause) {
        super(cause);

        logger.error(cause.getMessage(), cause);
    }

    public BaseException(Logger logger, String message, Throwable cause) {
        super(message);

        logger.error(cause.getMessage() , cause);
    }

    public BaseException(Logger logger, String message, String description) {
        super(message);

        logger.error(description, this);
    }

    public BaseException(Logger logger, String message, String description, Throwable throwable) {
        super(message);

        logger.error(description, throwable);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
