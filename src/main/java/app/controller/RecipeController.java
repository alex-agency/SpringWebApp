package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.domain.Recipe;

@Controller
//@RequestMapping("/recipe")
@SessionAttributes
public class RecipeController {
	//protected static Logger logger = Logger.getLogger(RecipeController.class);
	
	//@Resource(name="recipeRepository")
	//private RecipeRepository recipeRepository;
	
	//@Resource(name="ingredientRepository")
	//private IngredientRepository ingredientRepository;
	
	// Invoked on every request
	//@ModelAttribute
	//public void ajaxAttribute(WebRequest request, Model model) {
	//	model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	//}
	
    @RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
    public String addRecipe(@ModelAttribute("recipe")
                            Recipe recipe, BindingResult result) {
         
        System.out.println("Title:" + recipe.getTitle() + 
                    "Category:" + recipe.getCategory());
         
        return "redirect:recipes.html";
    }
     
    @RequestMapping("/recipes")
    public ModelAndView showRecipes() {
         
        return new ModelAndView("recipe", "command", new Recipe());
    }
    
    @RequestMapping("/cookbook")
    public ModelAndView showCookbook() {
         
        return new ModelAndView("cookbook", "command", new Recipe());
    }
	
	
    
/*	@RequestMapping(value = "/add", method = RequestMethod.GET)
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
	}*/
}