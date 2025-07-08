package com.lucas.ms1.Controller;

import com.lucas.ms1.Model.Products;
import com.lucas.ms1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
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
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        System.out.println("Creating product: " + product.getName());
        productService.createProduct(product);
        return ResponseEntity.ok(product);
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
