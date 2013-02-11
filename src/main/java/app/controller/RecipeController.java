package app.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

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
	
	@ExceptionHandler
	public @ResponseBody String handle(Exception e) {
		return e.getMessage();
	}
	
	@RequestMapping(value = "/add-recipe")
    public String createRecipe(Model model) {
		logger.debug("Received request to show a page for create new recipe.");
		
		model.addAttribute(new Recipe());
		model.addAttribute("categories", categoryService.readAll());
		// show jsp page
        return "recipe-modify";
    }
	
	@RequestMapping(value = "/add-recipe", method = RequestMethod.POST)
    public String saveRecipe(Model model,
    							@Valid Recipe recipe,
    							BindingResult result,
    							@ModelAttribute("ajaxRequest") boolean ajaxRequest) throws Exception {
		logger.debug("Received request to save new recipe.");
		
		if (result.hasErrors()) {
			model.addAttribute("categories", categoryService.readAll());
			return "recipe-modify";
		}
		
		recipeService.create(recipe);
		// redirect to main page
        return "redirect:/";
    }
	
	@RequestMapping(value = "/recipe/{id}")
    public String showRecipe(@PathVariable("id") String id, 
    							Model model) {
		logger.debug("Recived request to find recipe and to show it on the page.");
		
		model.addAttribute(recipeService.read(id));
		// show jsp page
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit")
	public String editRecipe(@PathVariable("id") String id, 
								Model model) {
		logger.debug("Recived request to find recipe and to show page for modify.");
		
		model.addAttribute(recipeService.read(id));
		model.addAttribute("categories", categoryService.readAll());
		// show jsp page
		return "recipe-modify";
    }
	
	@RequestMapping(value = "/recipe/{id}/edit", method = RequestMethod.POST)
	public String updateRecipe(Model model,
								@Valid Recipe recipe,
								BindingResult result) throws Exception {
		logger.debug("Recived request to find recipe and to show page for modify.");
		
		if (result.hasErrors()) {
			model.addAttribute("categories", categoryService.readAll());
			return "recipe-modify";
		}
		
		recipeService.update(recipe);
		// show jsp page
		return "recipe";
    }
	
	@RequestMapping(value = "/recipe/{id}/delete")
	public String deleteRecipe(Recipe recipe) throws Exception {
		logger.debug("Recived request to delete recipe.");
		
		recipeService.delete(recipe);
		// redirect to main page
		return "redirect:/";
    }
}