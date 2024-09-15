package edu.school21.Exception;

public class AlreadyAuthenticatedException extends RuntimeException {
    public AlreadyAuthenticatedException(String message) {
        super(message);
    }
}
