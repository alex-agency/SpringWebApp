package app.mongo.repository;

import app.domain.Ingredient;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

	Ingredient findByName(String name);
}
