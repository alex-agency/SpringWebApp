package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.mongo.repository.CategoryRepository;

@Controller
public class CategoryController {
	protected static Logger logger = Logger.getLogger(CategoryController.class);
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
}
