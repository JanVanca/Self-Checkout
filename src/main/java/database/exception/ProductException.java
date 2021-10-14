package database.exception;

public class ProductException extends Exception {

    /**
     * Own Login Exception.
     *
     * @param message Exception message.
     */
    public ProductException(String message) {
        super(message);
    }

    /**
     * Own Login Exception.
     *
     * @param message Exception message.
     * @param cause   Cause of exception.
     */
    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
