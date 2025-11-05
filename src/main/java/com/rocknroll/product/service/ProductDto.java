package com.rocknroll.product.service;

import com.rocknroll.product.data.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author mfedechko
 */
@Data
public class ProductDto {

    private long id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal originPrice;
    private BigDecimal salePrice;
    private List<Integer> categories;
}
