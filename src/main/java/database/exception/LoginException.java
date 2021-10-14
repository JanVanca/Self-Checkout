package database.exception;

public class LoginException extends Exception {

    /**
     * Own Login Exception.
     *
     * @param message Exception message.
     */
    public LoginException(String message) {
        super(message);
    }

    /**
     * Own Login Exception.
     *
     * @param message Exception message.
     * @param cause   Cause of exception.
     */
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
