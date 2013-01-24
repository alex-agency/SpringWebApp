package app.mongo.repository;

import app.domain.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RecipeRepository extends MongoRepository<Recipe, String> {
	
	public Recipe findByTitle(String name);
}
