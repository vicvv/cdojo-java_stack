package com.vicky.prodsandcats.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.vicky.prodsandcats.repositories.ProductRepository;
import com.vicky.prodsandcats.models.Category;
import com.vicky.prodsandcats.models.Product;
import com.vicky.prodsandcats.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final ProductService productService;
	
	
	public CategoryService(CategoryRepository categoryRepository,ProductRepository productRepository,ProductService productService) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.productService = productService;
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public List<Category> findAllCategories(){
		return (List<Category>)categoryRepository.findAll();
	}
	
	// retrieves a category
    public Category getOne(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public void deleteCategory(Long id) {
    	categoryRepository.deleteById(id);
    } 
    
    public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
    
    public List<Category> availableCategoriesForProduct(Product product) {
        return categoryRepository.findByProductsNotContains(product);  
    }

}
