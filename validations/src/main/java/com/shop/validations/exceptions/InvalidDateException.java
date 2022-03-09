package com.shop.validations.exceptions;

import com.shop.customexceptions.CustomException;

public class InvalidDateException extends CustomException {

    public InvalidDateException(final String message) {
        super(message);
    }
}
