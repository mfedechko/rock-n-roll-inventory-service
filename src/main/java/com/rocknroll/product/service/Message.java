package com.rocknroll.product.service;


import java.time.Instant;

/**
 * @author mfedechko
 */
public record Message(MessageType type, Instant createdAt, String payload) {

}
