package com.lucas.ms1.Service;

import com.lucas.ms1.Model.Products;
import com.lucas.ms1.Repositories.ProductRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepositorie productRepositorie;

    public List<Products> getAllProducts() {
        return productRepositorie.findAll();
    }
    public Products getProductById(Long id) {
        return productRepositorie.findById(id).orElse(null);
    }
    public Products createProduct(Products product) {
        return productRepositorie.save(product);
    }
    public Products updateProduct(Long id, Products product) {
        if (productRepositorie.existsById(id)) {
            product.setId(id);
            return productRepositorie.save(product);
        }
        return null;
    }
    public void deleteProduct(Long id) {
        productRepositorie.deleteById(id);
    }
}
