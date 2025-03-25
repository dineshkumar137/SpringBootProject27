package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ProductDto;

public interface Service {
	
	public List<ProductDto> getProducts();
	
	public ProductDto getProductById(int productId);
	
	public ProductDto setProduct(ProductDto product );
	
	public List<ProductDto> updateProduct(int productId , ProductDto product);
	
	public String deleteProductById(int productId);
	
	public List<ProductDto> getProductByName(String productName);
	
}
