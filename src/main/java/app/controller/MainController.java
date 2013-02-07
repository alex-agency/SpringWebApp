package app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import app.domain.Category;
import app.domain.Recipe;
import app.service.CategoryService;
import app.service.RecipeService;
import app.util.AjaxUtils;

@Controller
public class MainController {
	protected static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	RecipeService recipeService;
	
	// Invoked on every request
	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}
	
	@RequestMapping("/")
    public String showCookbook(Model model) {
		logger.debug("Received request to show cookbook page with all categories and recipes.");
		// get all categories which already have own recipes
		List<Category> categories = categoryService.getAll();
		// add list of categories to model of cookbook
		model.addAttribute("categories", categories);
		
		//----temp-----
		List<Recipe> recipes = recipeService.getAll();
		model.addAttribute("recipes", recipes);
		//----temp-----
		
		// show main page
        return "cookbook";
    }
	
	@RequestMapping(value = "/clear")
	public String clear() {
		logger.debug("");
		// delete all recipes
		recipeService.deleteAll();
		// delete all categories
		categoryService.deleteAll();
		// redirect to main page
		return "redirect:/";
    }
}
