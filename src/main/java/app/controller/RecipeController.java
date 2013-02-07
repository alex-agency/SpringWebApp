package app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import app.domain.Category;
import app.domain.Recipe;
import app.service.CategoryService;
import app.service.RecipeService;
import app.util.AjaxUtils;

@Controller
public class RecipeController {
	protected static Logger logger = Logger.getLogger(RecipeController.class);
	
	@Autowired
	RecipeService recipeService;
	@Autowired
	CategoryService categoryService;
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping(value = "/add-recipe")
    public String createRecipe(Model model) {
		logger.debug("Received request to show a page for create new recipe.");
		
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("category", new Category());
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		// show jsp page
        return "recipe-modify";
    }
	
	@RequestMapping(value = "/add-recipe", method = RequestMethod.POST)
    public String saveRecipe(@Valid Recipe recipe, 
    							@Valid Category category, 
    							BindingResult result,
    							@ModelAttribute("ajaxRequest") boolean ajaxRequest) {
		logger.debug("Received request to save new recipe.");
		
		System.out.println(recipe);
		System.out.println(category);
		
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "recipe-modify";
		}
		
		recipeService.save(recipe);
		categoryService.save(category);
		
		// redirect to main page
        return "redirect:/";
    }
	
	@RequestMapping(value = "/recipe/{id}")
    public String showRecipe(@PathVariable("id") String id, 
    							Model model) {
		logger.debug("Recived request to find recipe and to show it on the page.");
		
		Recipe recipe = recipeService.get(id);
		model.addAttribute(recipe);
		// show jsp page
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit")
	public String editRecipe(@PathVariable("id") String id, 
								Model model) {
		logger.debug("Recived request to find recipe and to show page for modify.");
		
		Recipe recipe = recipeService.get(id);
		model.addAttribute(recipe);
		// show jsp page
		return "recipe-modify";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit", method = RequestMethod.POST)
	public String updateRecipe(@Valid Recipe recipe,
								@Valid Category category,
								BindingResult result) {
		logger.debug("Recived request to find recipe and to show page for modify.");
		
		if (result.hasErrors()) {
			System.out.println("has errors");
			return "recipe-modify";
		}
		
		recipeService.save(recipe);
		categoryService.save(category);
		
		// show jsp page
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/delete")
	public String deleteRecipe(Recipe recipe) {
		logger.debug("Recived request to delete recipe.");
		
		recipeService.delete(recipe);
		// redirect to main page
		return "redirect:/";
    }
}