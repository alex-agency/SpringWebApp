package app;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	private static Logger logger = Logger.getLogger(RecipeController.class);
	
	@Resource(name="recipeService")
	private RecipeService recipeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllRecipes(ModelMap model) {
		logger.debug("Received request to show all recipe");
		
		//List<Recipe> recipes = recipeService.readAll();
		
		//model.addAttribute(recipes);
		
		return "recipes";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addRecipe(ModelMap model) {
		logger.debug("Received request to show add page");
		
		//model.addAttribute("recipe", new Recipe());
		
		return "addrecipe";
	}

}