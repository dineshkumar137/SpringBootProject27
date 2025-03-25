package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductDto;
import com.example.demo.service.ServiceImplement;

@RestController
public class ProductController {

//	@RequestMapping(value="/sayHello")
//	public String sayHello()
//	{
//		return "Hey, Hello";
//		
//	}
	
	//
	
	
//	
//	public ProductController()
//	{
//		dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
//		dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
//		dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
//		
//	}
	
	
//	@GetMapping(value="/products" )
//	public List<ProductDto> getProducts()
//	{
//		return dtos;
//		
//	}
//	
//	
//	@PostMapping(value="/addProduct")
//	public ProductDto setProduct(@RequestBody ProductDto product) {
//		
//		dtos.add(product);
//		return product;
//	}
//	
//	
//	@GetMapping("/product/{productId}")
//	public ProductDto getProductById(@PathVariable("productId") int productId )
//	{
//		for(ProductDto product : dtos)
//		{
//			if(product.getProductId() == productId)
//			{
//				return product;
//			}
//		}
//		
//		return null;
//	}
//	
//	
//	@PutMapping(value="/updateProduct/{productId}")
//	public List<ProductDto> updateProduct(@PathVariable("productId") int productId , @RequestBody ProductDto product)
//	{
//	ProductDto updateProduct = getProductById(productId);
//	if(updateProduct != null) {
//		updateProduct.setProductName(product.getProductName());
//		updateProduct.setProductPrice(product.getProductPrice());
//		updateProduct.setProductCatagory(product.getProductCatagory());
//		return dtos;
//	}
//	return null;
//	}
//	
//	
//	@DeleteMapping(value="/delete/{productId}")
//	public String deleteProductById(@PathVariable("productId") int productId) {
//		for(int i=0 ; i<dtos.size(); i++) {
//			if(dtos.get(i).getProductId()==productId) {
//				dtos.remove(i);
//				return "Product has been delete";
//			}
//		}
//		return null;
//	}
	
	@Autowired
	ServiceImplement serviceImplement;
//	List<ProductDto> dtos = new ArrayList<>();
	
	@GetMapping(value="/products" )
	public List<ProductDto> getProducts()
	{
		return serviceImplement.getProducts();
		
	}
	
	@GetMapping(value="/product/{productId}")
	public ProductDto getProductById(@PathVariable("productId") int productId)
	{
		
		
		return serviceImplement.getProductById(productId);
		
	}
	
	
	@PostMapping(value="/addProduct")
	public ProductDto setProduct(@RequestBody ProductDto product)
	{
		return serviceImplement.setProduct(product);	
	}
	
	
	@PutMapping(value="/updateProduct/{productId}")
	public ProductDto updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto product) {    
		return serviceImplement.updateProduct(productId, product);
	}
	
	
	@DeleteMapping(value="/delete/{productId}")
	public String deleteProductById(@PathVariable("productId") int productId)
	{
		return serviceImplement.deleteProductById(productId);
	}
	
	
	@GetMapping("/getByName")
	public List<ProductDto> getProductByName(@RequestParam("productName") String productName)
	{
		return serviceImplement.getProductByName(productName);
	}
	
	
}
