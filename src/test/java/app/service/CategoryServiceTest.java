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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repositories-test-context.xml")
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService categoryService;
	
	@Before
	public void clear() {
		categoryService.deleteAll();
	}
	
	@Test
    public void grudTest() throws Exception {
		
		// CREATE
		
		Category categoryTest = new Category();
		categoryTest.setName("category.name");
		
		categoryService.create(categoryTest);
		
		// READ
		
		Category categoryDoc = categoryService.read(categoryTest.getId());
		
		assertNotNull(categoryDoc);
		assertEquals(categoryDoc, categoryTest);
		
		// UPDATE
		
		Category categoryNew = new Category();
		categoryNew.setName("New name");
		categoryNew.setId(categoryDoc.getId());
		
		categoryService.update(categoryNew);
		
		Category categoryDocUpdated = categoryService.read(categoryDoc.getId());
		
		assertEquals(categoryDocUpdated, categoryNew);
		
		// DELETE
		
		categoryService.delete(categoryDocUpdated);
		assertTrue(categoryService.readAll().isEmpty());
	}

}
