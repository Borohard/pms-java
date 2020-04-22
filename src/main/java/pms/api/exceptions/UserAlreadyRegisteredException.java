package pms.api.exceptions;

public class UserAlreadyRegisteredException extends Exception {
    public UserAlreadyRegisteredException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
