package app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service("recipeService")
@Transactional
public class RecipeService {
	private static Logger logger = Logger.getLogger(RecipeService.class);
	
	private static final String COLLECTION = "recipes";
	
	public boolean create(Recipe recipe) {
		logger.debug("Adding a new recipe");
		
		try {
			// Create a new db object
			BasicDBObject doc = new BasicDBObject(recipe.getMap());
			
			DB db = MongoDBClient.INSTANCE.getDB(DBNAME, username, password)
			
			
	        // Retrieve collection. If not existing, create a new one
	     	DBCollection coll = MongoDBClient.INSTANCE.getCollection(null, COLLECTION);
	        // Save new recipe
	        coll.insert(doc);
	        
			return true;
		} catch (Exception e) {
			logger.error("An error has occurred while trying to add new recipe", e);
			return false;
		}
	}
	
	public Recipe read(String id) {
		logger.debug("Retrieving an existing recipe");
		
		DBObject dbObject = new BasicDBObject("id", id);
		// Retrieve collection
		DBCollection coll = MongoDBClient.getCollection(database, collection);
		// Find and return the recipe with the given id
        DBObject doc = coll.findOne(dbObject);
        
        Recipe recipe = new Recipe();
        recipe.setId(doc.get("id").toString());
        recipe.setTitle(doc.get("title").toString());
        recipe.setCategory(doc.get("category").toString());
        recipe.setIngredients((List)doc.get("ingredients"));
        recipe.setRecipe(doc.get("recipe").toString());
		
        // Return recipe
		return recipe;
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
}
