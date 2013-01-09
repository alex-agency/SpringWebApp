package app.mongo.repository;

import app.mongo.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

	Recipe findByTitle(String title);
}
