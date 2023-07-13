package com.apj.lab.SampleMicroService.controller;

import com.apj.lab.SampleMicroService.domain.Product;
import com.apj.lab.SampleMicroService.service.imp.ProductServiceImpl;
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
class ProductControllerTest {

    @InjectMocks
    ProductController controller;

    @Mock
    ProductServiceImpl productService;

    Product productMockEntity;

    @BeforeEach
    public void init() {
        productMockEntity = new Product(1L, "P001", "TestProduct", 252D);
    }

    @Test
    public void TestCreateProduct() {
        Mockito.when(productService.createProduct(ArgumentMatchers.any(Product.class))).thenReturn(productMockEntity);
        Product product = controller.createProduct(productMockEntity);
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("P001", product.getProductCode());
        Assertions.assertEquals("TestProduct", product.getProductName());
        Assertions.assertEquals(252D, product.getPrice());
    }

    @Test
    public void TestGetProduct() {
        Mockito.when(productService.fetchProductByCode(ArgumentMatchers.anyString())).thenReturn(productMockEntity);
        Product product = controller.getProduct("P001");
        Assertions.assertNotNull(product);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("P001", product.getProductCode());
        Assertions.assertEquals("TestProduct", product.getProductName());
        Assertions.assertEquals(252D, product.getPrice());
    }

    @Test
    public void TestFetchProducts() {
        Mockito.when(productService.fetchProducts()).thenReturn(List.of(productMockEntity));
        List<Product> products = controller.getAllProducts();
        Assertions.assertNotNull(products);
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertEquals("P001", products.get(0).getProductCode());
        Assertions.assertEquals("TestProduct", products.get(0).getProductName());
        Assertions.assertEquals(252D, products.get(0).getPrice());
    }

}