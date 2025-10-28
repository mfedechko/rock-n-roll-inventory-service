package com.rocknroll.product.exception;

import com.rocknroll.product.data.ApiConstants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * @author mfedechko
 */
@UtilityClass
public class ErrorResponseUtils {
    public static ApiError createNotFoundException(final String errorMessage,
                                                   final Exception exc,
                                                   final HttpServletRequest request) {
        return ApiError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.NOT_FOUND)
                .message(errorMessage)
                .path(request.getRequestURI())
                .serviceName(exc.getClass().getSimpleName())
                .traceId(request.getHeader(ApiConstants.TRACE_ID_HEADER))
                .build();
    }

    public static ApiError createBadRequestException(final String errorMessage,
                                                     final Exception exc,
                                                     final HttpServletRequest request) {
        return ApiError.builder()
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST)
                .message(errorMessage)
                .path(request.getRequestURI())
                .serviceName(exc.getClass().getSimpleName())
                .traceId(request.getHeader(ApiConstants.TRACE_ID_HEADER))
                .build();
    }
}
