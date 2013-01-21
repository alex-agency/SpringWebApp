package app.mongo.repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/spring/app-servlet.xml")
public class IngredientRepositoryTest {
	
	@Autowired
    private IngredientRepository ingredientRepository;
	
	@After
    public void cleanUp() {
		ingredientRepository.deleteAll();
    }
    
/*    @Test
    public void testFindByName() {
    	Ingredient ingredient1 = new Ingredient("Ingredient1");
    	Ingredient ingredient2 = new Ingredient("Ingredient2");
        
    	ingredientRepository.save(ingredient1);
    	ingredientRepository.save(ingredient2);
        // verify id was generated
        assertNotNull(ingredient1.getId());
        assertNotNull(ingredient2.getId());
        
        Ingredient ingredient1FromDB = ingredientRepository.findByName(ingredient1.getName());
        Ingredient ingredient2FromDB = ingredientRepository.findByName(ingredient2.getName());
        assertEquals(ingredient1, ingredient1FromDB);
        assertEquals(ingredient2, ingredient2FromDB);
    }*/
}
