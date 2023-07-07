package com.apj.lab.SampleMicroService.controller;


import com.apj.lab.SampleMicroService.domain.Product;
import com.apj.lab.SampleMicroService.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable String code) {
        return productService.fetchProductByCode(code);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.fetchProducts();
    }
}
