package app.mongo.repository;

import java.util.List;

import app.domain.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
	
	public Recipe findByIdOrTitle(String id, String title);
	
	public List<Recipe> findByTitleLike(String title);
}
