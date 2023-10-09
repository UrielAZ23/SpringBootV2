package com.platzi.market99.web.controller;

import com.platzi.market99.domain.Product;
import com.platzi.market99.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{CategoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("CategoryId") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId) {
        return productService.delete(productId);
    }
}
