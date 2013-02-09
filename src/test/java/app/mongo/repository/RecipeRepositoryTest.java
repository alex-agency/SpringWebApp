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
	private RecipeRepository recipeRepo;
	
	@Before
	public void clear() {
		recipeRepo.deleteAll();
	}
	
	@Test
    public void grudTest() {
		
		// CREATE
		
		Recipe recipeTest = new Recipe();
		recipeTest.setTitle("recipe.title");
		recipeTest.setCategory("category.id");
		recipeTest.setIngredients("recipe.ingredients");
		recipeTest.setBody("recipe.body");
		
		recipeRepo.save(recipeTest);
		
		// READ
		
		List<Recipe> recipesDocs = recipeRepo.findByTitleLike(recipeTest.getTitle());
		
		assertNotNull(recipesDocs);
		assertFalse(recipesDocs.isEmpty());
		assertTrue(recipesDocs.contains(recipeTest));
		
		Recipe recipeDoc = recipeRepo.findByIdOrTitle(null, recipeTest.getTitle());
		
		assertNotNull(recipeDoc);
		assertNotNull(recipeDoc.getId());
		assertEquals(recipeDoc, recipeTest);
		
		// UPDATE
		
		Recipe recipeNew = new Recipe();
		recipeNew.setTitle("new title");
		recipeNew.setId(recipeDoc.getId());
		
		recipeRepo.save(recipeNew);
		
		Recipe recipeDocUpdated = recipeRepo.findOne(recipeDoc.getId());
		
		assertEquals(recipeDocUpdated, recipeNew);
		
		// DELETE
		
		recipeRepo.delete(recipeDocUpdated);
		assertTrue(recipeRepo.count() == 0);
    }
}
