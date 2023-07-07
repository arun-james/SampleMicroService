package com.apj.lab.SampleMicroService.data;

import com.apj.lab.SampleMicroService.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findByProductCode(String code);
}
