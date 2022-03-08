package com.customexceptions;

public class InvalidProductException extends CustomException {

    public InvalidProductException(final String message) {
        super(message);
    }
}
