package app.mongo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.domain.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mongo-repositories-test-context.xml")
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Before
	public void clear() {
		categoryRepository.deleteAll();
	}
	
	@Test
    public void grudTest() {
		
		// CREATE
		
		Category testCategory = new Category("category.name");
		
		categoryRepository.save(testCategory);
		
		// READ
		
		List<Category> mongoCategoryList = categoryRepository.findByNameLike(testCategory.getName());
		
		assertNotNull(mongoCategoryList);
		assertFalse(mongoCategoryList.isEmpty());
		assertTrue(mongoCategoryList.contains(testCategory));
		
		Category mongoCategory = mongoCategoryList.get(mongoCategoryList.indexOf(testCategory));
		
		assertNotNull(mongoCategory.getId());
		
		// UPDATE
		
		Category newCategory = new Category("New name");
		newCategory.setId(mongoCategory.getId());
		
		categoryRepository.save(newCategory);
		
		Category mongoCategoryUpdated = categoryRepository.findOne(mongoCategory.getId());
		
		assertEquals(mongoCategoryUpdated, newCategory);
		
		// DELETE
		
		categoryRepository.delete(mongoCategoryUpdated);
		assertTrue(categoryRepository.count() == 0);
    }
}
