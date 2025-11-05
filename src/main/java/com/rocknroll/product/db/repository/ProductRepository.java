package com.rocknroll.product.db.repository;

import com.rocknroll.product.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mfedechko
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
