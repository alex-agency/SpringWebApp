package app.mongo.repository;

import app.domain.Recipe;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

	Recipe findByTitle(String title);
}
