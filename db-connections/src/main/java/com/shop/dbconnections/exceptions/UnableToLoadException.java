package com.shop.dbconnections.exceptions;

import com.shop.customexceptions.CustomException;

/**
 * Unable to load exception.
 *
 * @author SathishKumarS
 */
public class UnableToLoadException extends CustomException {

    public UnableToLoadException(String message) {
        super(message);
    }
}
