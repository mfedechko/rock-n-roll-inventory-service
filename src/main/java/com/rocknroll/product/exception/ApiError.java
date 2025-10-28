package com.rocknroll.product.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * @author mfedechko
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiError {
    private Instant timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    private String serviceName;
    private String traceId;
}
