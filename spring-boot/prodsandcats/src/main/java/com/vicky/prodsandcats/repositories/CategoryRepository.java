package com.vicky.prodsandcats.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vicky.prodsandcats.models.Category;
import com.vicky.prodsandcats.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();

	List<Category> findByProductsNotContains(Product product);
	

}
