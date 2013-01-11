package app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.domain.Recipe;
import app.mongo.repository.IngredientRepository;
import app.mongo.repository.RecipeRepository;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
	protected static Logger logger = Logger.getLogger(RecipeController.class);
	
	@Resource(name="recipeRepository")
	private RecipeRepository recipeRepository;
	
	@Resource(name="ingredientRepository")
	private IngredientRepository ingredientRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddPage() {
		logger.debug("Received request to show add page.");
      
     	// This will resolve to /WEB-INF/jsp/add-recipe.jsp
     	return "add-recipe";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Recipe add(@RequestBody Recipe recipe) {
		logger.debug("Received request to save recipe");
		
		// We must save both separately since there is no cascading feature
		// in Spring Data MongoDB (for now)
		ingredientRepository.save(recipe.getIngredients());
		return recipeRepository.save(recipe);
	}
	
	@RequestMapping
	public @ResponseBody List<Recipe> getAll() {
		return recipeRepository.findAll();
	}
	
	@RequestMapping
	public @ResponseBody Recipe get(@RequestBody Recipe recipe) {		
		return recipeRepository.findOne(recipe.getId());
	}
}