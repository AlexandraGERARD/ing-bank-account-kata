package fr.ing.interview.kata.model.exception;

/**
 * Exception thrown when there are too many results returned
 */
public class TooManyResultsException extends Exception {

    public TooManyResultsException() {
    }

    public TooManyResultsException(String pMessage) {
        super(pMessage);
    }

    public TooManyResultsException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
