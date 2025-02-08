package lebron;

/**
 * Exception class for errors related to LeBron chatbot
 */
public class LebronException extends Exception {
    /**
     * Constructor for LeBronException
     *
     * @param message Error message to be shown
     */
    public LebronException(String message) {
        super(message);
    }
}
