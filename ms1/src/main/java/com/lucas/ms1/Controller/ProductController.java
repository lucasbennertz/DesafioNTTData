package com.lucas.ms1.Controller;

import com.lucas.ms1.Model.Products;
import com.lucas.ms1.Service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Products getProductById(Long id) {
        return productService.getProductById(id);
    }
    @PostMapping("/create")
    public Products createProduct(Products product) {
        return productService.createProduct(product);
    }
    @PostMapping("/update/{id}")
    public Products updateProduct(Long id, Products product) {
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
}
