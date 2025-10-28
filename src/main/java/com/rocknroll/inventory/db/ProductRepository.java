package com.rocknroll.inventory.db;

import com.rocknroll.inventory.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author mfedechko
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
