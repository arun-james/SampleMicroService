package com.apj.lab.SampleMicroService.service.imp;

import com.apj.lab.SampleMicroService.data.ProductRepository;
import com.apj.lab.SampleMicroService.domain.Product;
import com.apj.lab.SampleMicroService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product fetchProductByCode(String code) {
        return productRepository.findByProductCode(code);
    }

    @Override
    public List<Product> fetchProducts() {
        return productRepository.findAll();
    }
}
