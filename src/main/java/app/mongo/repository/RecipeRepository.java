package app.mongo.repository;

import java.util.List;

import app.domain.Recipe;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RecipeRepository extends MongoRepository<Recipe, String> {

	List<Recipe> findByCategoryAll();
}
