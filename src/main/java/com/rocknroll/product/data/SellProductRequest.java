package com.rocknroll.product.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author mfedechko
 */
@Data
public class SellProductRequest {

    private long userId;
    private long productId;
    private int quantity;
    private BigDecimal price;
}
