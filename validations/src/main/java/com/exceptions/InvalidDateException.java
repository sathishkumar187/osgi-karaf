package com.exceptions;

import com.customexceptions.CustomException;

public class InvalidDateException extends CustomException {

    public InvalidDateException(final String message) {
        super(message);
    }
}
