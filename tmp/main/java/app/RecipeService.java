package app;

/*import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;*/

//@Service("recipeService")
//@Transactional
public class RecipeService {
/*	private static Logger logger = Logger.getLogger(RecipeService.class);
	
	private static final String COLLECTION = "recipes";
	
	*//**
	 * GRUD methods
	 *//*
	
	public boolean create(Recipe recipe) {
		logger.debug("Adding a new recipe");
		
		try {
			// Create a new db object from map
			BasicDBObject doc = new BasicDBObject(recipe.getMap());
	        // Retrieve collection. If not existing, create a new one
	     	DBCollection coll = new MongoDBClient().getCollection(COLLECTION);
	        // Save new object
	        coll.insert(doc);
	        
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	public Recipe read(String id) {
		logger.debug("Retrieving an existing recipe");
		
		Recipe recipe = null;
		try {
			DBCollection coll = new MongoDBClient().getCollection(COLLECTION);
			
			BasicDBObject query = new BasicDBObject(Recipe.ID, id);
			// Find and return document with the given id
			DBObject doc = coll.findOne(query);
			
			recipe = new Recipe();
			// Read document and store to recipe
			for (String key: doc.keySet()) {
				Object value = doc.get(key);
				recipe.setProperty(key, value);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		
		return recipe;
	}
	
	public boolean update(Recipe recipe) {
		logger.debug("Updating an existing recipe");
		
		try {
			DBCollection coll = new MongoDBClient().getCollection(COLLECTION);
			// Get id from recipe
			String id = (String) recipe.getProperty(Recipe.ID);
			
			BasicDBObject query = new BasicDBObject(Recipe.ID, id);
			// Find and return an existing document to modify
			DBObject docExist = coll.findOne(query);
			
			// Create a new db object from map
			BasicDBObject docNew = new BasicDBObject(recipe.getMap());
			
	        // Remove old document and put new one
	        coll.update(docExist, docNew);
	        
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public boolean delete(String id) {
		logger.debug("Deleting recipe");
		
		try {
			DBCollection coll = new MongoDBClient().getCollection(COLLECTION);
			
			BasicDBObject query = new BasicDBObject(Recipe.ID, id);
			// Remove document with the given id
			coll.remove(query);
			
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}
	
	*//**
	 * Retrieving all recipes
	 *//*
	public List<Recipe> readAll() {
		logger.debug("Retrieving all recipes");
		
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			DBCollection coll = new MongoDBClient().getCollection(COLLECTION);
			// Retrieve all documents from collection
			DBCursor cursor = coll.find();
	        for (DBObject doc : cursor) {
	        	Recipe recipe = new Recipe();
				// Read document and store to recipe
				for (String key: doc.keySet()) {
					Object value = doc.get(key);
					recipe.setProperty(key, value);
				}
	        	// Add recipe to list
				recipes.add(recipe);
	        }
	        cursor.close();
			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return recipes;
	}*/
	
}
