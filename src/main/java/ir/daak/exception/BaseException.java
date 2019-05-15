package ir.daak.exception;

import org.slf4j.Logger;

public class BaseException extends Exception {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Logger logger, String key, String description) {
        super(key);

        logger.error(description);
    }

    public BaseException(Logger logger, String key, String description, Throwable throwable) {
        super(key);

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
