package com.rocknroll.product.data;

import lombok.Getter;

/**
 * @author mfedechko
 */
@Getter
public enum ProductCategory {

    POWDER(1);

    private final int id;

    ProductCategory(final int id) {
        this.id = id;
    }
}
