package com.vicky.prodsandcats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicky.prodsandcats.models.Category;
import com.vicky.prodsandcats.models.Product;
import com.vicky.prodsandcats.repositories.CategoryRepository;
import com.vicky.prodsandcats.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	public List<Product> getAll(){
		return (List<Product>) productRepository.findAll();
	}
	public Product getOne(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
	public void update(Product product) {
		productRepository.save(product);
	}
		
	public Iterable<Product> availableProductsForCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}

}

