package app.controller;

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
import app.domain.Recipe;
import app.mongo.repository.IngredientRepository;
import app.mongo.repository.RecipeRepository;
import app.util.AjaxUtils;

@Controller
@RequestMapping
public class RecipeController {
	protected static Logger logger = Logger.getLogger(RecipeController.class);

	private RecipeRepository recipeRepository;
	private IngredientRepository ingredientRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        //this.ingredientRepository = recipeRepository.getIngredients();
    }
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping("/")
    public String showCookbook(Model model) {
		logger.debug("Received request to show cookbook page with all recipes.");
		
		List<String> categories = recipeRepository.findAllCategory();
		model.addAttribute("categories", categories);
		
		List<Recipe> recipes = recipeRepository.findAll();
		model.addAttribute("recipes", recipes);
		
        return "cookbook";
    }
	
	@RequestMapping(value = "/recipe_edit")
    public String createRecipe(Model model) {
		logger.debug("Received request to show addrecipe page.");
		
        return "recipe_edit";
    }
	
	@RequestMapping(value = "/recipe_edit", method = RequestMethod.POST)
    public String saveRecipe(Model model, Recipe recipe) {
		logger.debug("Received request to save new recipe.");
		
		recipeRepository.save(recipe);
        return "redirect:/";
    }

	@RequestMapping(value = "/recipe/{id}")
    public String showRecipe(@PathVariable("id") String id, Model model) {
		logger.debug("");
		
		Recipe recipe = recipeRepository.findOne(id);
		model.addAttribute(recipe);
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit")
	public String editRecipe(@PathVariable("id") String id, Model model) {
		logger.debug("");
		
		Recipe recipe = recipeRepository.findOne(id);
		model.addAttribute(recipe);
		return "recipe_edit";
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