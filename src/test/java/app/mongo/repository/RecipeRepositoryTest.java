package app.mongo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Category;
import app.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/webapp/WEB-INF/spring/app-servlet.xml")
public class RecipeRepositoryTest {
    
	@Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    private Category categoryTest;
    private Recipe recipeTest;
    
    @Test
    public void createTest() {
    	
    	categoryTest = new Category();
    	categoryTest.setName("categoryTest.name");
    	
    	Recipe recipeTest = new Recipe();
    	recipeTest.setTitle("recipeTest.title");
    	recipeTest.setCategory(categoryTest);
    	recipeTest.setRecipe("recipeTest.recipe");
    	
    	categoryRepository.save(categoryTest);
    	recipeRepository.save(recipeTest);
    }
    
    @Test
    public void readTest() {
    	
    	Recipe recipeFromDB = recipeRepository.findByTitle(recipeTest.getTitle());
    	
    	assertNotNull(recipeFromDB.getId());
    	assertEquals(recipeFromDB.getTitle(), recipeTest.getTitle());
    	assertEquals(recipeFromDB.getRecipe(), recipeTest.getRecipe());
    	
    	Category categoryFromDB = categoryRepository.findByName(categoryTest.getName());
    	
    	assertNotNull(categoryFromDB.getId());
    	assertEquals(categoryFromDB.getName(), categoryTest.getName());
    	
    	Category categoryFromRecipe = recipeFromDB.getCategory();
    	
    	assertNotNull(categoryFromRecipe.getId());
    	assertEquals(categoryFromRecipe.getName(), categoryTest.getName());
    }
    
    @Test
    public void deleteTest() {
    	
    	categoryRepository.delete(categoryTest);
    	recipeRepository.delete(recipeTest);
    }
}
