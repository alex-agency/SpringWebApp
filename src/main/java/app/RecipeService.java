package app;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import mongo.MongoDBFactory;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import domain.Person;

@Service("recipeService")
@Transactional
public class RecipeService {
	
	protected static Logger logger = Logger.getLogger("service");
	protected String database = "mydb";
	protected String collection = "recipes";
	
	
	
	public RecipeService() {
	}
	
	public Boolean add(Recipe recipe) {
		logger.debug("Adding a new recipe");
		
		try {
			// Retrieve collection. If not existing, create a new one
			DBCollection coll = MongoDBFactory.getCollection(database,collection);
			// Create a new db object
			BasicDBObject doc = new BasicDBObject();
			// Generate random id using UUID type 4
	        doc.put("id", UUID.randomUUID().toString() ); 
	        doc.put("firstName", person.getFirstName());
	        doc.put("lastName", person.getLastName());
	        doc.put("money", person.getMoney());
	        // Save new person
	        coll.insert(doc);
	        
			return true;
			
		} catch (Exception e) {
			logger.error("An error has occurred while trying to add new user", e);
			return false;
		}
	}
	
	
}
