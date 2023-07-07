package com.apj.lab.SampleMicroService.service;

import com.apj.lab.SampleMicroService.domain.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product fetchProductByCode(String code);
    List<Product> fetchProducts();
}
