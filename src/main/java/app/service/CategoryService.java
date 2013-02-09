package app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.Category;
import app.mongo.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	public void create(Category category) throws Exception {
		Category categoryDoc = categoryRepo.findByIdOrName(category.getId(), category.getName());
		
		if(categoryDoc != null) {
			throw new Exception("category exists");
		}
		
		categoryRepo.save(category);
	}
	
	public Category read(String id) {
		return categoryRepo.findOne(id);
	}
	
	public List<Category> readAll() {
		return categoryRepo.findAll();
	}
	
	public void update(Category category) throws Exception {
		Category categoryDoc = categoryRepo.findByIdOrName(category.getId(), category.getName());
		
		if(categoryDoc == null) {
			throw new Exception("can't found category");
		}
		
		category.setId(categoryDoc.getId());
		category.setRecipes(categoryDoc.getRecipes());
		
		categoryRepo.save(category);
	}
	
	public void delete(Category category) {
		categoryRepo.delete(category);
	}
	
	public void deleteAll() {
		categoryRepo.deleteAll();
	}
	
}
