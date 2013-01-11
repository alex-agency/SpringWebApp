package app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.Ingredient;
import app.domain.Recipe;
import app.mongo.repository.IngredientRepository;
import app.mongo.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public Recipe create(Recipe recipe) {
		// set unique id
		recipe.setId(UUID.randomUUID().toString());
		
		List<Ingredient> ingredients = recipe.getIngredients();
		for (Ingredient ingredient : ingredients) {
			// set unique id
			ingredient.setId(UUID.randomUUID().toString());
		}
		
		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		ingredientRepository.save(ingredients);
		return recipeRepository.save(recipe);
	}
	
	public Recipe read(Recipe recipe) {
		return recipe;
	}
	
	public List<Recipe> readAll() {
		return recipeRepository.findAll();
	}
	
	public Recipe update(Recipe recipe) {
		Recipe existingRecipe = recipeRepository.findByTitle(recipe.getTitle());

		if (existingRecipe == null) {
			return null;
		}

		existingRecipe.setTitle(recipe.getTitle());
		existingRecipe.setCategory(recipe.getCategory());
		existingRecipe.getIngredients()).setIngredients(recipe.getIngredients());

		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		roleRepository.save(existingUser.getRole());
		return userRepository.save(existingUser);
	}
	
	
	
}
