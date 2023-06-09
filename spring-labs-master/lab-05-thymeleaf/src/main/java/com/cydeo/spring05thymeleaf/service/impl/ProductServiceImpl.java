package com.cydeo.spring05thymeleaf.service.impl;


import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean productCreate(Product product){
        //use repository to save it.
        //ID field must be set(must be provided)
        product.setId(UUID.randomUUID());
        return productRepository.save(product);

        // todo implement method

    }

    @Override
    public List<Product> listProduct() {

        return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
        return productRepository.findProductById(uuid);
        // todo implement method
        //return new Product();
    }

}
