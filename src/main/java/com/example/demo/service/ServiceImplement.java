package com.example.demo.service;
import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductexistsAlready;
import com.example.demo.model.ProductDto;
import com.example.demo.repo.ProductRepo;

@Service
public class ServiceImplement implements Service {
	
	?//Demo extened
//	List<ProductDto> dtos = new ArrayList<>();
//	
//	
//	public ServiceImplement()
//	{
//		dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
//		dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
//		dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
//		
//	}
//	
//	
//	public List<ProductDto> getProducts() {
//		// TODO Auto-generated method stub
//		return dtos;
//	}
//
//	public ProductDto getProductById(int productId) {
//		for(ProductDto product: dtos)
//		{
//			if(product.getProductId()== productId)
//			{
//				return product;
//			}
//		}
//		return null;
//	}
//	
//	public ProductDto setProduct(ProductDto product) {
//		
//		dtos.add(product);
//		return product;
//	}
//
//	public List<ProductDto> updateProduct(int productId, ProductDto product) {
//		ProductDto updateProduct = getProductById(productId);
//	    if (updateProduct != null) { 
//	        updateProduct.setProductName(product.getProductName());
//	        updateProduct.setProductPrice(product.getProductPrice());
//	        updateProduct.setProductCatagory(product.getProductCatagory());
//	        dtos.add(updateProduct);
//	        return dtos;
//	        
//	    }
//		return null;
//	}
//
//	public String deleteProductById(int productId) {
//		for(int i=0 ; i< dtos.size() ; i++)
//		{
//			if(dtos.get(i).getProductId() == productId)
//			{
//				dtos.remove(i);
//				return "Product has been deleted";
//			}
//		}
//		
//		return null;
//	}
	
	
	@Autowired
	ProductRepo productRepository;
	
	public List<ProductDto> getProducts(){
		return productRepository.findAll();
	}
	
	public ProductDto getProductById(int productId) {
		return productRepository.findById(productId).get();
	}
	
	public ProductDto setProduct(ProductDto product) {
		ProductDto productDto = productRepository.findById(product.getProductId()).orElse(null);
		
		if(product != null)
		{
			throw new ProductexistsAlready("Product with productId: "+product.getProductId()+" already exists.");
			
		}
		return productRepository.save(product);
	}
	
	public ProductDto updateProduct(int productId , ProductDto product) {
		ProductDto updateproduct = getProductById(productId);
		if(updateproduct != null) {
			updateproduct.setProductName(product.getProductName());
			updateproduct.setProductCatagory(product.getProductCatagory());
		}
		return productRepository.save(updateproduct);
	}
	
	public String deleteProductById(int productId) {
		productRepository.deleteById(productId);
		return "Product with product id : "+productId+ " is deleted ";
	}

	public List<ProductDto> getProductByName(String productName) {
		try {
			checkResult();
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		return productRepository.findByProductName(productName);
	}
	
	public void checkResult()
	{
		int result = 14/0;
	}

//	@Override
//	public Class<? extends Annotation> annotationType() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String value() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
	
}
