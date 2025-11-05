package com.rocknroll.product.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author mfedechko
 */
@Entity
@Table(name = "product_sales")
public class ProductSaleEntity {

    @Id
    private Long id;

    public Long productId;
    public long userId;
    public int quantity;
    public BigDecimal price;
    public Instant timestamp;
}
