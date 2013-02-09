package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.Set;

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
	private RecipeRepository recipeRepo;
	@Autowired
	private CategoryRepository categoryRepo;
    
    @Before
    public void clear() {
    	recipeRepo.deleteAll();
    	categoryRepo.deleteAll();
    }
    
    @Test
    public void cascadeSaveTest()
    {
    	// CREATE
    	
    	Category categoryTest = new Category();
    	categoryTest.setName("category.name");
    	
    	categoryRepo.save(categoryTest);
    	
    	Recipe recipeTest1 = new Recipe();
    	recipeTest1.setTitle("recipe1.title");
    	recipeTest1.setCategory(categoryTest.getId());
    	
    	Recipe recipeTest2 = new Recipe();
    	recipeTest2.setTitle("recipe2.title");
    	recipeTest2.setCategory(categoryTest.getId());
    	
    	Set<Recipe> recipesCategory = categoryTest.getRecipes();
    	recipesCategory.add(recipeTest1);
    	recipesCategory.add(recipeTest2);
    	
    	categoryTest.setRecipes(recipesCategory);
    	
    	// cascade save
    	categoryRepo.save(categoryTest);
    	
    	// READ
    	
    	Category categoryDoc = categoryRepo.findByIdOrName(null, categoryTest.getName());
    	
    	assertNotNull(categoryDoc);

    	Recipe recipeDoc1 = recipeRepo.findByIdOrTitle(null, recipeTest1.getTitle());
    	
    	assertNotNull(recipeDoc1);
    	
    	Recipe recipeDoc2 = recipeRepo.findByIdOrTitle(null, recipeTest2.getTitle());
    	
    	assertNotNull(recipeDoc2);
    }
}
