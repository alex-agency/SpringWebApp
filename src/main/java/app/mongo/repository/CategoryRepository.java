package app.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import app.domain.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public Category findByName(String name);
	
	public List<Category> findByNameLike(String name);
}
