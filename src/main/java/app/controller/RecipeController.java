package app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.domain.Recipe;
import app.mongo.repository.RecipeRepository;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
	private static Logger logger = Logger.getLogger(RecipeController.class);
	
	@Resource(name="recipeRepository")
	private RecipeRepository recipeRepository;
	
	@RequestMapping(value="/get")
	public @ResponseBody Recipe get(@RequestBody Recipe recipe) {
		return recipeRepository.findOne(recipe.getId());
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody Recipe create(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam Integer role) {

		Role newRole = new Role();
		newRole.setRole(role);

		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setRole(newRole);

		return service.create(newUser);
	}
	
	
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