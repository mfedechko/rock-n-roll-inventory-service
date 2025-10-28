package com.rocknroll.product.exception;

import lombok.experimental.UtilityClass;

/**
 * @author mfedechko
 */
@UtilityClass
public class ErrorMessages {
    public static final String PRODUCT_NOT_FOUND = "Product can not be found.";
    public static final String NO_VALID_JSON = "Supplied payload is not valid JSON message.";
    public static final String NOT_ALLOWED_PRICE = "Price must be greater than 0.";
}
