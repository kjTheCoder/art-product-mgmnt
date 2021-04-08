package org.example.arts.product.management.data.access;

import lombok.extern.slf4j.Slf4j;
import org.example.arts.product.management.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductDataService {
    @Autowired
    private ProductRepository productRepository;

    public ProductDataService() { }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public String deleteProduct(String id) {
        productRepository.deleteById(id);
        return id;
    }
}
