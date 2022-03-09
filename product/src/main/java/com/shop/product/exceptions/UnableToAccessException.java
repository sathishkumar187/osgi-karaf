package com.shop.product.exceptions;

import com.customexceptions.CustomException;

public class UnableToAccessException extends CustomException {

    public UnableToAccessException(final String message) {
        super(message);
    }
}
