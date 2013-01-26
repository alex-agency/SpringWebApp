package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import app.domain.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repositories-test-context.xml")
public class IngredientRepositoryTest {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Before
	public void clear() {
		ingredientRepository.deleteAll();
	}
	
	@Test
    public void grudTest() {
		
		// CREATE
		
		Ingredient testIngredient = new Ingredient("ingredient.name");
		
		ingredientRepository.save(testIngredient);
		
		// READ
		
		List<Ingredient> mongoIngredientList = ingredientRepository.findByNameLike(testIngredient.getName());
		
		assertNotNull(mongoIngredientList);
		assertFalse(mongoIngredientList.isEmpty());
		assertTrue(mongoIngredientList.contains(testIngredient));
		
		Ingredient mongoIngredient = mongoIngredientList.get(mongoIngredientList.indexOf(testIngredient));
		
		assertNotNull(mongoIngredient.getId());
		
		// UPDATE
		
		Ingredient newIngredient = new Ingredient("New name");
		newIngredient.setId(mongoIngredient.getId());
		
		ingredientRepository.save(newIngredient);
		
		Ingredient mongoIngredientUpdated = ingredientRepository.findOne(mongoIngredient.getId());
		
		assertEquals(mongoIngredientUpdated, newIngredient);
		
		// DELETE
		
		ingredientRepository.delete(mongoIngredientUpdated);
		assertTrue(ingredientRepository.count() == 0);
    }
}
