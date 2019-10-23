package com.vicky.prodsandcats.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicky.prodsandcats.models.Category;
import com.vicky.prodsandcats.models.Product;
import com.vicky.prodsandcats.services.CategoryService;
import com.vicky.prodsandcats.services.ProductService;

@Controller
@RequestMapping("/")
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService,ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
//	@RequestMapping("")
//	public List<Category> index() {
//		return (List<Category>)categoryService.findAllCategories();
//	}
	
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.findAllCategories());
		model.addAttribute("products", productService.getAll());
		return "index.jsp";
	}
	
	
	@RequestMapping("/categories/new")
	public String newCategory(Model model, @ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/categories/new";
		} else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	
	// Show category
	@RequestMapping("/categories/{id}")
	public String showCat(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.getOne(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.availableProductsForCategory(category));
		return "showCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String addProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
		Category category = categoryService.getOne(categoryId);
		Product product = productService.getOne(productId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryService.updateCategory(category);
		return "redirect:/categories/"+categoryId;
	}
	
}

	


