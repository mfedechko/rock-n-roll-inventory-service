package com.rocknroll.product.service;

import com.rocknroll.product.data.AuditType;
import com.rocknroll.product.db.entity.ProductSaleEntity;
import com.rocknroll.product.db.repository.AuditLogRepository;
import com.rocknroll.product.db.repository.ProductRepository;
import com.rocknroll.product.db.repository.ProductSaleRepository;
import com.rocknroll.product.exception.NegativeProductQuantityException;
import com.rocknroll.product.exception.ProductNotFoundException;
import com.rocknroll.product.util.JsonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;

import static com.rocknroll.product.data.AuditType.PRODUCT_DELETED;

/**
 * @author mfedechko
 */
@Service
public class ProductService {

    private final JsonUtils jsonUtils;
    private final ProductRepository productRepository;
    private final ProductSaleRepository productSaleRepository;
    private final AuditLogRepository auditLogRepository;
    private final ProductMapper productMapper;
    private final AuditLogHelper auditLogHelper;

    public ProductService(final JsonUtils jsonUtils,
                          final ProductRepository productRepository,
                          final ProductSaleRepository productSaleRepository,
                          final AuditLogRepository auditLogRepository) {
        this.jsonUtils = jsonUtils;
        this.productRepository = productRepository;
        this.productSaleRepository = productSaleRepository;
        this.auditLogRepository = auditLogRepository;
        this.productMapper = new ProductMapper();
        this.auditLogHelper = new AuditLogHelper();
    }

    public ProductDto getProduct(final long id) {
        final var productOpt = productRepository.findById(id);
        if (productOpt.isEmpty()) {
            throw new ProductNotFoundException();
        }

        return productMapper.mapEntityToDto(productOpt.get());

    }

    @Transactional
    public void addProduct(final ProductDto product) {
        final var productEntity = productMapper.mapDtoToEntity(product);

        productRepository.save(productEntity);
        final var details = new HashMap<String, Object>();
        details.put("productId", 1);
        final var detailsStr = jsonUtils.convertToString(details);
        final var auditLogEntity = auditLogHelper.buildAuditLogEntity(AuditType.PRODUCT_ADDED, detailsStr);
        auditLogRepository.save(auditLogEntity);

    }

    public void updateProduct(final ProductDto product) {
        final var productEntity = productRepository.findById(product.getId())
                .orElseThrow(ProductNotFoundException::new);
        productRepository.save(productEntity);
    }

    @Transactional
    public void sellProduct(final long userId,
                            final long productId,
                            final int quantity,
                            final BigDecimal price) {
        final var productEntityOpt = productRepository.findById(productId);
        if (productEntityOpt.isPresent()) {
            final var productEntity = productEntityOpt.get();
            if (productEntity.quantity - quantity < 0) {
                throw new NegativeProductQuantityException();
            }
            productEntity.quantity = productEntity.quantity - quantity;
            productRepository.save(productEntity);

            final var productSaleEntity = new ProductSaleEntity();
            productSaleEntity.productId = productId;
            productSaleEntity.userId = userId;
            productEntity.quantity = quantity;
            productEntity.salePrice = price;
            productSaleEntity.timestamp = Instant.now();
            productSaleRepository.save(productSaleEntity);



        } else {
            throw new ProductNotFoundException();
        }

    }

    @Transactional
    public void deleteProduct(final long productId) {
        final var productEntity = productRepository.findById(productId);
        if (productEntity.isEmpty()) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(productId);
        final var details = new HashMap<String, Object>();
        details.put("productId", 1);
        final var detailsStr = jsonUtils.convertToString(details);
        final var auditLogEntity = auditLogHelper.buildAuditLogEntity(PRODUCT_DELETED, detailsStr);
        auditLogRepository.save(auditLogEntity);
    }

}
