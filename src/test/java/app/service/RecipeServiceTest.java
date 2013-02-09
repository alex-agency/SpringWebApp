package app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
public class RecipeServiceTest {
	
	@Autowired
	private RecipeService recipeService;
	@Autowired
	private CategoryService categoryService;
	
	@Before
	public void clear() {
		recipeService.deleteAll();
		categoryService.deleteAll();
	}
	
	@Test
    public void grudTest() throws Exception {
		
		// CREATE
		
		Category categoryTest = new Category();
		categoryTest.setName("category.name");
		
		categoryService.create(categoryTest);
		
		Recipe recipeTest = new Recipe();
		recipeTest.setTitle("recipe.title");
		recipeTest.setCategory(categoryTest.getId());
		
		recipeService.create(recipeTest);
		
		// READ
		
		Recipe recipeDoc = recipeService.read(recipeTest.getId());
		
		assertNotNull(recipeDoc);
		assertEquals(recipeDoc, recipeTest);
		
		// UPDATE
		
		Recipe recipeNew = new Recipe();
		recipeNew.setTitle("New title");
		recipeNew.setId(recipeDoc.getId());
		recipeNew.setCategory(recipeDoc.getCategory());
		
		recipeService.update(recipeNew);
		
		Recipe recipeDocUpdated = recipeService.read(recipeDoc.getId());
		
		assertEquals(recipeDocUpdated, recipeNew);
		
		// DELETE
		
		recipeService.delete(recipeDocUpdated);
		assertTrue(recipeService.readAll().isEmpty());
	}
	
}
