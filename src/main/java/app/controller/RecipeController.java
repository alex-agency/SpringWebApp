package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import app.domain.Category;
import app.domain.Recipe;
import app.mongo.repository.CategoryRepository;
import app.mongo.repository.IngredientRepository;
import app.mongo.repository.RecipeRepository;
import app.util.AjaxUtils;

@Controller
@RequestMapping
public class RecipeController {
	protected static Logger logger = Logger.getLogger(RecipeController.class);
	
	// Auto wired fields before create object
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping("/")
    public String showCookbook(Model model) {
		logger.debug("Received request to show cookbook page with all categories and recipes.");
		// get all categories which already has own recipes
		List<Category> categories = categoryRepository.findAll();
		// add list of categories to model of cookbook
		model.addAttribute("categories", categories);
		// show main page
        return "cookbook";
    }
	
	@RequestMapping(value = "/add-recipe")
    public String createRecipe(Model model) {
		logger.debug("Received request to show a page for create new recipe.");
		// show page for create recipe
        return "recipe-modify";
    }
	
	@RequestMapping(value = "/add-recipe", method = RequestMethod.POST)
    public String saveRecipe(Model model, Recipe recipe, Category category) {
		logger.debug("Received request to save new recipe.");
		
		Recipe existRecipe = recipeRepository.findByTitle(recipe.getTitle());
		if(existRecipe != null) {
			existRecipe.setRecipe(recipe.getRecipe());
			// update recipe
			recipeRepository.save(existRecipe);
		} else {
			// save new recipe
			recipeRepository.save(recipe);
		}
		
		Category existCategory = categoryRepository.findByName(category.getName());
		if(existCategory != null) {
			
			List<Recipe> recipes = existCategory.getRecipes();
			if(recipes == null) {
				recipes = new ArrayList<Recipe>();
			}
			recipes.add(recipe);
			
			existCategory.setRecipes(recipes);
			// update category
			categoryRepository.save(existCategory);
		} else {
			
			List<Recipe> recipes = new ArrayList<Recipe>();
			recipes.add(recipe);
			
			category.setRecipes(recipes);
			// save new recipe
			categoryRepository.save(category);
		}
		
		// redirect to main page
        return "redirect:/";
    }
	
	@RequestMapping(value = "/recipe/{id}")
    public String showRecipe(@PathVariable("id") String id, Model model) {
		logger.debug("Recived request to find recipe and to show it on the page.");
		// find recipe by id
		Recipe recipe = recipeRepository.findOne(id);
		// add recipe to model
		model.addAttribute(recipe);
		// show recipe
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit")
	public String updateRecipe(@PathVariable("id") String id, Model model) {
		logger.debug("Recived request");
		
		Recipe recipe = recipeRepository.findOne(id);
		model.addAttribute(recipe);
		return "recipe-modify";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit", method = RequestMethod.POST)
	public String saveRecipe(Recipe recipe) {
		logger.debug("");
		
		recipeRepository.save(recipe);
		return "redirect:/";
    }
	
	@RequestMapping(value = "/recipe/{id}/delete")
	public String deleteRecipe(Recipe recipe) {
		logger.debug("");
		
		recipeRepository.delete(recipe);
		return "redirect:/";
    }
}