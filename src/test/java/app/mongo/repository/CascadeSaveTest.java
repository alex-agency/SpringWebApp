package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import app.domain.Category;
import app.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repositories-test-context.xml")
public class CascadeSaveTest {
    
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
    
    @Before
    public void clear() {
    	recipeRepository.deleteAll();
    	categoryRepository.deleteAll();
    }
    
    @Test
    public void cascadeSaveTest()
    {
    	// CREATE
    	
    	Category testCategory = new Category("category.name");
    	Recipe testRecipe1 = new Recipe("recipe1.title");
    	Recipe testRecipe2 = new Recipe("recipe2.title");
    	
    	testCategory.setRecipes(Arrays.asList(testRecipe1, testRecipe2));
    	
    	// cascade save
    	categoryRepository.save(testCategory);
    	
    	// READ
    	
    	Category mongoCategory = categoryRepository.findOne(testCategory.getId());
    	
    	List<Recipe> categoryRecipeList = mongoCategory.getRecipes();
    	
    	assertFalse(categoryRecipeList.isEmpty());
    	assertTrue(categoryRecipeList.contains(testRecipe1));
    	assertTrue(categoryRecipeList.contains(testRecipe2));
    	
    }
}
