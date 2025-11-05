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
import java.util.List;

/**
 * @author mfedechko
 */
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    private Long id;

    public String name;
    public String description;
    public int quantity;
    public BigDecimal originPrice;
    public BigDecimal salePrice;
    public List<Integer> categories;
    public Instant createdAt;
    public Instant updatedAt;

}
