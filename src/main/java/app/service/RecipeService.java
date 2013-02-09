package app.service;

import java.util.List;
import java.util.Set;

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
	
	public void create(Recipe recipe) throws Exception {
		Recipe recipeDoc = recipeRepo.findByIdOrTitle(recipe.getId(), recipe.getTitle());
		
		if(recipeDoc != null) {
			throw new Exception("recipe exists");
		}
		
		this.putCategoryRecipe(recipe);
	}
	
	public Recipe read(String id) {
		return recipeRepo.findOne(id);
	}
	
	public List<Recipe> readAll() {
		return recipeRepo.findAll();
	}
	
	public void update(Recipe recipe) throws Exception {
		Recipe recipeDoc = recipeRepo.findByIdOrTitle(recipe.getId(), recipe.getTitle());
		
		if(recipeDoc == null) {
			throw new Exception("can't found recipe");
		}
		
		String idCategoryOld = recipeDoc.getCategory();
		String idCategoryNew = recipe.getCategory();
		
		if(idCategoryOld.equals(idCategoryNew)) {
			// update existing
			recipe.setId(recipeDoc.getId());
			recipeRepo.save(recipe);
			return;
		}
		
		this.delete(recipeDoc);
		this.create(recipe);
	}
	
	public void delete(Recipe recipe) throws Exception {
		this.removeRecipe(recipe);
		recipeRepo.delete(recipe);
	}
	
	public void deleteAll() {
		recipeRepo.deleteAll();
	}
	
	public void putCategoryRecipe(Recipe recipe) throws Exception {
		Category category = categoryRepo.findOne(recipe.getCategory());
		Set<Recipe> recipes = category.getRecipes();
		
		if(recipes.contains(recipe)) {
			throw new Exception("recipe exists in the category");
		}
		
		recipes.add(recipe);
		
		category.setRecipes(recipes);
		// cascade save
		categoryRepo.save(category);
	}
	
	public void removeRecipe(Recipe recipe) throws Exception {
		Category category = categoryRepo.findOne(recipe.getCategory());
		Set<Recipe> recipes = category.getRecipes();
		
		if(recipes.contains(recipe) == false) {
			throw new Exception("can't found recipe in the category");
		}
		
		recipes.remove(recipe);
		
		category.setRecipes(recipes);
		// cascade save
		categoryRepo.save(category);
	}
	
}
