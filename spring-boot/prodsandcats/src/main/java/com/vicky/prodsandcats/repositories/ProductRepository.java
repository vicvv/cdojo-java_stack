package com.vicky.prodsandcats.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vicky.prodsandcats.models.Category;
import com.vicky.prodsandcats.models.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();

	List<Product> findByCategoriesNotContains(Category category);
 
}
