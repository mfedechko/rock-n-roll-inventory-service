package com.rocknroll.product.controller;

import com.rocknroll.product.data.SellProductRequest;
import com.rocknroll.product.db.entity.ProductEntity;
import com.rocknroll.product.service.ProductDto;
import com.rocknroll.product.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mfedechko
 */
@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody final ProductDto product) {
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getProduct(@PathParam("id") final Long productId) {
        final var product = productService.getProduct(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity product) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/product")
    public ResponseEntity<?> deleteProduct(@PathParam("id") final Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sell")
    public ResponseEntity<?> sellProduct(@RequestBody final SellProductRequest request) {
        productService.sellProduct(request.getUserId(),
                                   request.getProductId(),
                                   request.getQuantity(),
                                   request.getPrice());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
