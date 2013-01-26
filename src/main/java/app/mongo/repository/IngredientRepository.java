package app.mongo.repository;

import java.util.List;

import app.domain.Ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
	
	public List<Ingredient> findByNameLike(String name);
}
