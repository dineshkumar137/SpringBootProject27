package com.example.demo.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ProductDto;

@Repository
public interface ProductRepo extends JpaRepository<ProductDto , Integer> {

	public List<ProductDto> findByProductName(String productName);

}
