package app.controller;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import app.mongo.repository.RecipeRepository;
import app.util.AjaxUtils;

@Controller
public class RecipeController {
	protected static Logger logger = Logger.getLogger(RecipeController.class);
	
	// Auto wired fields before create object
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping(value = "/add-recipe")
    public String createRecipe(Model model) {
		logger.debug("Received request to show a page for create new recipe.");
		// show page for create recipe
        return "recipe-modify";
    }
	
	@RequestMapping(value = "/add-recipe", method = RequestMethod.POST)
    public String saveRecipe(Recipe recipe, Category category) {
		logger.debug("Received request to save new recipe.");
		
		Recipe existRecipe = recipeRepository.findByTitle(recipe.getTitle());
		Category existCategory = categoryRepository.findByName(category.getName());
		
		if(existRecipe == null && existCategory == null) {
			category.setRecipes(Arrays.asList(recipe));
			// cascade save
			categoryRepository.save(category);
		} else {
			System.out.println("it exesits");
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
		logger.debug("Recived request to find recipe and to show page for modify.");
		// find recipe by id
		Recipe recipe = recipeRepository.findOne(id);
		// add recipe to model
		model.addAttribute(recipe);
		// show recipe
		return "recipe-modify";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit", method = RequestMethod.POST)
	public String saveRecipe(@PathVariable("id") String id, Recipe recipe) {
		logger.debug("");
		// set absent id
		recipe.setId(id);
		// update recipe
		recipeRepository.save(recipe);
		// redirect to recipe page
		return "redirect:/recipe/{id}";
    }
	
	@RequestMapping(value = "/recipe/{id}/delete")
	public String deleteRecipe(Recipe recipe) {
		logger.debug("");
		// delete recipe
		recipeRepository.delete(recipe);
		// redirect to main page
		return "redirect:/";
    }
}