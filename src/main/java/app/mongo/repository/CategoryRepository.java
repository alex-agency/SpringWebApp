package app.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import app.domain.Category;

@Transactional
public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public Category findByName(String name);
}
