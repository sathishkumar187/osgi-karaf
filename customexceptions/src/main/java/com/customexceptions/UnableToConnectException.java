package com.customexceptions;

public class UnableToConnectException extends CustomException {

    public UnableToConnectException(final String message) {
        super(message);
    }
}
