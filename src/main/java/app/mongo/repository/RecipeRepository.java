package app.mongo.repository;

import app.domain.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {

	Recipe findByTitle(String title);
}
