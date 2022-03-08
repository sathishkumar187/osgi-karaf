package com.exceptions;

import com.customexceptions.CustomException;

public class UnableToConnectException extends CustomException {

    public UnableToConnectException(final String message) {
        super(message);
    }
}
