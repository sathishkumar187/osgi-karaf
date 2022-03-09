package com.shop.product.exceptions;

import com.customexceptions.CustomException;

public class InvalidProductException extends CustomException {

    public InvalidProductException(final String message) {
        super(message);
    }
}
