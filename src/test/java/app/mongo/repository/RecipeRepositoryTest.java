package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Category;
import app.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:**/app-servlet.xml"})
@ContextConfiguration("/mongo-repositories-context.xml")
public class RecipeRepositoryTest {
    
	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private CategoryRepository categoryRepository;
    
    private Category categoryTest;
    private Recipe recipeTest;
        
    @Before
    @Test
    public void createTest() {
    	
    	recipeTest = new Recipe();
    	recipeTest.setTitle("recipeTest.title");
    	recipeTest.setRecipe("recipeTest.recipe");
    	
    	categoryTest = new Category();
    	categoryTest.setName("categoryTest.name");
    	
    	categoryTest.setRecipe(recipeTest);
    	
    	// Cascading save
    	categoryRepository.save(categoryTest);
    }
    
    @Test
    public void readTest() {
    	
    	List<Recipe> recipeFromDB = recipeRepository.findByTitleLike(recipeTest.getTitle());
    	
    	assertNotNull(recipeFromDB);    	
    	assertNotNull(recipeFromDB.getId());
    	assertEquals(recipeFromDB.getTitle(), recipeTest.getTitle());
    	assertEquals(recipeFromDB.getRecipe(), recipeTest.getRecipe());
    	
    	List<Category> categoryFromDB = categoryRepository.findByNameLike(categoryTest.getName());
    	
    	assertNotNull(categoryFromDB.getId());
    	assertEquals(categoryFromDB.getName(), categoryTest.getName());
    	
    	/*List<Recipe> recipesFromCategory = categoryFromDB.getRecipes();
    	assertNotNull(recipesFromCategory);
    	
    	for (Recipe recipe : recipesFromCategory) {
    		assertNotNull(recipe.getId());
    		
    		if(recipe.getId().equals(recipeTest.getId())) {
    			
    			assertEquals(recipe.getTitle(), recipeTest.getTitle());
    	    	assertEquals(recipe.getRecipe(), recipeTest.getRecipe());
    		}
		}*/
    	
    }
    
    @After
    @Test
    public void deleteTest() {
    	
    	Category category = categoryRepository.findByName(categoryTest.getName());
    	categoryRepository.delete(category);
    	
    	Recipe recipe = recipeRepository.findByTitle(recipeTest.getTitle());
    	recipeRepository.delete(recipe);
    }
}
