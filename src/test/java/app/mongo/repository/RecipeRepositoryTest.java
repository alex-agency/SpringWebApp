package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Ingredient;
import app.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/webapp/WEB-INF/spring-mongodb-context.xml")
public class RecipeRepositoryTest {
    
	@Autowired
    private RecipeRepository recipeRepository;
    
    @Autowired
    private IngredientRepository ingredientRepository;
    
    @After
    public void cleanUp() {
    	recipeRepository.deleteAll();
    	ingredientRepository.deleteAll();
    }
    
    @Test
    public void testSaveAndRead() {
    	Ingredient ingredient1 = new Ingredient("Ingredient1");
    	Ingredient ingredient2 = new Ingredient("Ingredient2");
    	ingredientRepository.save(ingredient1);
    	ingredientRepository.save(ingredient2);
        
        Recipe recipe1 = new Recipe();
        recipe1.setTitle("Recipe1");
        recipe1.setIngredients(Arrays.asList(ingredient1, ingredient2));
        
        Ingredient ingredient3 = new Ingredient("Ingredient3");
        Ingredient ingredient4 = new Ingredient("Ingredient4");
        ingredientRepository.save(ingredient3);
        ingredientRepository.save(ingredient4);
        
        Recipe recipe2 = new Recipe();
        recipe2.setTitle("Recipe2");
        recipe2.setIngredients(Arrays.asList(ingredient3, ingredient4));
        
        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        assertNotNull(recipe1.getId());
        assertNotNull(recipe2.getId());
        
        Recipe recipe1FromDB = recipeRepository.findOne(recipe1.getId());
        Recipe recipe2FromDB = recipeRepository.findOne(recipe2.getId());
        assertEquals(recipe1, recipe1FromDB);
        assertEquals(recipe2, recipe2FromDB);
    }
    
    @Test
    public void testFindByName() {
        Recipe recipe1 = new Recipe();
        recipe1.setTitle("Recipe1");
        
        Recipe recipe2 = new Recipe();
        recipe2.setTitle("Recipe2");
        
        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        
        Recipe recipe1FromDB = recipeRepository.findByTitle(recipe1.getTitle());
        Recipe recipe2FromDB = recipeRepository.findByTitle(recipe2.getTitle());
        assertEquals(recipe1, recipe1FromDB);
        assertEquals(recipe2, recipe2FromDB);
    }
}
