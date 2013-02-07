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
	
	public void save(Recipe recipe) {
		
		Recipe recipeDocument = recipeRepo.findByTitle(recipe.getTitle());
		
		if(recipeDocument != null) {
			// copy data
			recipeDocument.setTitle(recipe.getTitle());
			recipeDocument.setIngredients(recipe.getIngredients());
			recipeDocument.setBody(recipe.getBody());
			// update existing recipe
			recipeRepo.save(recipeDocument);
		} else {
			// save new recipe
			recipeRepo.save(recipe);
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
