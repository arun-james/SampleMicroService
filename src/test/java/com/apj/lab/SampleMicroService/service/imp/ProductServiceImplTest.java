package com.apj.lab.SampleMicroService.service.imp;

import com.apj.lab.SampleMicroService.data.ProductRepository;
import com.apj.lab.SampleMicroService.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository repository;

    Product productMockEntity;

    @BeforeEach
    public void init() {
        productMockEntity = new Product(1L, "P001", "TestProduct", 252D);
    }

    @Test
    public void TestCreateProduct() {
        Mockito.when(repository.save(ArgumentMatchers.any(Product.class))).thenReturn(productMockEntity);
        Product product = productService.createProduct(productMockEntity);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("P001", product.getProductCode());
        Assertions.assertEquals("TestProduct", product.getProductName());
        Assertions.assertEquals(252D, product.getPrice());
    }

    @Test
    public void TestFetchProductByCode() {
        Mockito.when(repository.findByProductCode(ArgumentMatchers.anyString())).thenReturn(productMockEntity);
        Product product = productService.fetchProductByCode("P001");
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("P001", product.getProductCode());
        Assertions.assertEquals("TestProduct", product.getProductName());
        Assertions.assertEquals(252D, product.getPrice());
    }

    @Test
    public void TestFetchProducts() {
        Mockito.when(repository.findAll()).thenReturn(List.of(productMockEntity));
        List<Product> products = productService.fetchProducts();
        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertEquals("P001", products.get(0).getProductCode());
        Assertions.assertEquals("TestProduct", products.get(0).getProductName());
        Assertions.assertEquals(252D, products.get(0).getPrice());
    }

}