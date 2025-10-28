package com.rocknroll.product.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mfedechko
 */
@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ApiError> handleUserNotFound(final ProductNotFoundException exc,
                                                       final HttpServletRequest request) {

        final var apiError = ErrorResponseUtils.createNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND,
                                                                        exc,
                                                                        request);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(final HttpMessageNotReadableException exc,
                                                                          final HttpServletRequest request) {

        final var apiError = ErrorResponseUtils.createBadRequestException(ErrorMessages.NO_VALID_JSON,
                                                                          exc,
                                                                          request);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ExceptionHandler(NotAllowedPriceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ApiError> handleNotAllowedPriceException(final NotAllowedPriceException exc,
                                                                   final HttpServletRequest request) {
        final var apiError = ErrorResponseUtils.createBadRequestException(ErrorMessages.NOT_ALLOWED_PRICE,
                                                                          exc,
                                                                          request);
        return ResponseEntity.badRequest().body(apiError);
    }

}
