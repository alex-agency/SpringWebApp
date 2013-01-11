package app.mongo.repository;

import app.domain.Ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

	Ingredient findByName(String name);
}
