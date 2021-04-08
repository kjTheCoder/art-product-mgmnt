package org.example.arts.product.management.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.arts.product.management.constants.ProductShorthandUrls;
import org.example.arts.product.management.data.access.ProductDataService;
import org.example.arts.product.management.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/product-mgmnt")
@RequiredArgsConstructor
public class ProductManagementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductManagementService.class);

    @Autowired
    private ProductDataService productDataService;

    @GetMapping(path = ProductShorthandUrls.PRODUCTS)
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productDataService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping(path = ProductShorthandUrls.PRODUCT)
    public ResponseEntity<?> getProduct(@PathVariable("id") String id) {
        try {
            LOGGER.info("Id: " + id);
            Optional<Product> product = productDataService.getProduct(id);
            if (product.isPresent())
                return ResponseEntity.ok(product.get());
            throw new RuntimeException();
        }catch (RuntimeException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found");
        }
    }

    @PostMapping(path = ProductShorthandUrls.ADD_PRODUCT)
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        LOGGER.info("To be added product: " + product);
        Product addedProduct = productDataService.addProduct(product);

        return ResponseEntity.ok(addedProduct);
    }

    @PutMapping(path = ProductShorthandUrls.UPDATE_PRODUCT)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        LOGGER.info("To be updated product: " + product);
        Product updatedProduct = productDataService.updateProduct(product);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping(path = ProductShorthandUrls.DELETE_PRODUCT)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        LOGGER.info("To be deleted id: " + id);
        String result = productDataService.deleteProduct(id);

        return ResponseEntity.ok(result);
    }

}
