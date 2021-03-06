package ir.daak.base.exception;

/**
 * @author Davood Akbari - 1398
 * daak1365@gmail.com
 * daak1365@yahoo.com
 * 09125188694
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseException extends Exception {
    public BaseException() {
        log.error("Agent Error!", this);
    }

    public BaseException(String message) {
        super(message);

        log.error(message, this);
    }

    public BaseException(Throwable cause) {
        super(cause);

        log.error(cause.getMessage(), cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message);

        log.error(cause.getMessage(), cause);
    }

    public BaseException(String message, String description) {
        super(message);

        log.error(description, this);
    }

    public BaseException(String message, String description, Throwable throwable) {
        super(message);

        log.error(description, throwable);
    }


    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

        log.error(cause.getMessage(), cause);
    }
}
