package com.apj.lab.SampleMicroService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith( SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SampleMicroServiceApplicationIT {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getsAllProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getsProductByCode() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product/1")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void addsNewProduct() throws Exception {
		String newProduct = "{\"productCode\" : \"P002\", \"productName\" : \"Product 2\", \"price\" : 25.25}";
		mockMvc.perform(MockMvcRequestBuilders.post("/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newProduct)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
}
