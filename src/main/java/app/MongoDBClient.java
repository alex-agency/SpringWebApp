package app;

import java.net.UnknownHostException;
import org.apache.log4j.Logger;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoDBClient {
	private static Logger logger = Logger.getLogger(MongoDBClient.class);
	
	private MongoClient mongoClient;
	
	/**
	 * Constants
	 */
	private static final String HOST_NAME = "localhost";
	private static final int HOST_PORT = 27017;
	private static final String DB_NAME = "mydb";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	public MongoDBClient() {
		logger.debug("Making connection to MongoDB database");
		
		try {
			mongoClient = new MongoClient(HOST_NAME, HOST_PORT);
		} catch (MongoException e) {
			logger.error(e);
		} catch (UnknownHostException e) {
			logger.error(e);
		}
	}
	
	/**
	 * Retrieve a db
	 */
	public DB getDB(String dbname, String username, String password) {
		logger.debug("Retrieving db: " + dbname);
		
		DB db = null;
		try {
			db = mongoClient.getDB(dbname);
			// Authenticate
			db.authenticate(username, password.toCharArray());
		} catch (MongoException e) {
			logger.error(e);
		}
		
		return db;
	}
	
	/**
	 * Retrieve a collection
	 */
	public DBCollection getCollection(String collection) {
		logger.debug("Retrieving collection: " + collection);
		
		DBCollection col = null;
		try {
			DB db = this.getDB(DB_NAME, DB_USER, DB_PASSWORD);
			col = db.getCollection(collection);
		} catch (MongoException e) {
			logger.error(e);
		}
		
		return col;
	}
	
}
