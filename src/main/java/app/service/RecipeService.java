package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.Category;
import app.domain.Recipe;
import app.mongo.repository.CategoryRepository;
import app.mongo.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	public void save(Recipe recipe) {
		
		Recipe recipeDocument = recipeRepo.findByIdOrTitle(recipe.getId(), recipe.getTitle());
		
		if(recipeDocument != null) {
			recipe.setId(recipeDocument.getId());
			
			System.out.println("Nothing");
			
		} else {
			Category categoryDocument = categoryRepo.findOne(recipe.getCategory());
			List<Recipe> recipes = categoryDocument.getRecipes();
			recipes.add(recipe);
			categoryDocument.setRecipes(recipes);
			
			// cascade save
			categoryRepo.save(categoryDocument);
		}

		
	}
	
	public List<Recipe> getAll() {
		return recipeRepo.findAll();
	}
	
	public Recipe get(String id) {
		return recipeRepo.findOne(id);
	}
	
	public void delete(Recipe recipe) {
		recipeRepo.delete(recipe);
	}
	
	public void deleteAll() {
		recipeRepo.deleteAll();
	}
}
