package com.rocknroll.product.service;

import com.rocknroll.product.db.entity.ProductEntity;

import java.time.Instant;

/**
 * @author mfedechko
 */
public class ProductMapper {

    public ProductEntity mapDtoToEntity(final ProductDto productDto) {
        final var now = Instant.now();
        final var productEntity = new ProductEntity();
        productEntity.name = productDto.getName();
        productEntity.description = productDto.getDescription();
        productEntity.quantity = productDto.getQuantity();
        productEntity.originPrice = productDto.getOriginPrice();
        productEntity.salePrice = productDto.getSalePrice();
        productEntity.categories = productDto.getCategories();
        productEntity.createdAt = now;
        productEntity.updatedAt = now;
        return productEntity;
    }

    public ProductDto mapEntityToDto(final ProductEntity productEntity) {
        final var productDto = new ProductDto();
        productDto.setId(productDto.getId());
        productDto.setName(productDto.getName());
        productDto.setDescription(productDto.getDescription());
        productDto.setQuantity(productDto.getQuantity());
        productDto.setOriginPrice(productDto.getOriginPrice());
        productDto.setSalePrice(productDto.getSalePrice());
        productDto.setCategories(productDto.getCategories());
        return productDto;
    }
}
