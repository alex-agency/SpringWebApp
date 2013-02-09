package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.Recipe;
import app.mongo.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepo;
	@Autowired
	private CategoryService categoryService;
	
	public void save(Recipe recipe) {
		
		Recipe recipeDocument = recipeRepo.findByIdOrTitle(recipe.getId(), recipe.getTitle());
		if(recipeDocument != null) {
			
			if(recipe.getCategory().equals(recipeDocument.getCategory())) {
				// update existing
				recipe.setId(recipeDocument.getId());
				recipeRepo.save(recipe);
				return;
			} else {
				// delete old
				this.delete(recipeDocument);
			}
		}
		// save new
		categoryService.putRecipe(recipe.getCategory(), recipe);
	}
	
	public List<Recipe> getAll() {
		return recipeRepo.findAll();
	}
	
	public Recipe get(String id) {
		return recipeRepo.findOne(id);
	}
	
	public void delete(Recipe recipe) {
		categoryService.deleteRecipe(recipe.getCategory(), recipe);
		recipeRepo.delete(recipe);
	}
	
	public void deleteAll() {
		recipeRepo.deleteAll();
	}
}
