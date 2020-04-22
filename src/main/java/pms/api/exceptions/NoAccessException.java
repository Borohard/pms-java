package pms.api.exceptions;

public class NoAccessException extends Exception {
    public NoAccessException(String msg, Throwable t) {
        super(msg, t);
    }

    public NoAccessException(String msg) {
        super(msg);
    }
}
