package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Recipe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repositories-test-context.xml")
public class RecipeRepositoryTest {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Before
	public void clear() {
		recipeRepository.deleteAll();
	}
	
	@Test
    public void grudTest() {
		
		// CREATE
		
		Recipe testRecipe = new Recipe("recipe.title");
		testRecipe.setBody("recipe.body");
		
		recipeRepository.save(testRecipe);
		
		// READ
		
		List<Recipe> mongoRecipeList = recipeRepository.findByTitleLike(testRecipe.getTitle());
		
		assertNotNull(mongoRecipeList);
		assertFalse(mongoRecipeList.isEmpty());
		assertTrue(mongoRecipeList.contains(testRecipe));
		
		Recipe mongoRecipe = mongoRecipeList.get(mongoRecipeList.indexOf(testRecipe));
		
		assertNotNull(mongoRecipe.getId());
		
		// UPDATE
		
		Recipe newRecipe = new Recipe("New title");
		newRecipe.setId(mongoRecipe.getId());
		
		recipeRepository.save(newRecipe);
		
		Recipe mongoRecipeUpdated = recipeRepository.findOne(mongoRecipe.getId());
		
		assertEquals(mongoRecipeUpdated, newRecipe);
		
		// DELETE
		
		recipeRepository.delete(mongoRecipeUpdated);
		assertTrue(recipeRepository.count() == 0);
    }
}
