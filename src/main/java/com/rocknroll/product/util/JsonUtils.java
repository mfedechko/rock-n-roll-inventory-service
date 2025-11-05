package com.rocknroll.product.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.type.SerializationException;
import org.springframework.stereotype.Component;

/**
 * @author mfedechko
 */
@Component
public class JsonUtils {

    private final ObjectMapper objectMapper;

    public JsonUtils(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String convertToString(final Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Failed to serialize object to JSON", e);
        }
    }

    public <T> T convertToObject(final String json, final Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Failed to deserialize JSON", e);
        }
    }
}
