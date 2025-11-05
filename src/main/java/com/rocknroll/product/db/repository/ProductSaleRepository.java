package com.rocknroll.product.db.repository;

import com.rocknroll.product.db.entity.ProductSaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mfedechko
 */
@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSaleEntity, Long> {
}
