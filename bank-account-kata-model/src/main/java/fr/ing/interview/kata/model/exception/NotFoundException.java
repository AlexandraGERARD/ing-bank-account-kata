package fr.ing.interview.kata.model.exception;

/**
 * Exception thrown when an object is not found
 */
public class NotFoundException extends Exception {

    public NotFoundException() {
    }

    public NotFoundException(String pMessage) {
        super(pMessage);
    }

    public NotFoundException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
