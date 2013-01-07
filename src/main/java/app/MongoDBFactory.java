package app;

import java.net.UnknownHostException;
import org.apache.log4j.Logger;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public final class MongoDBFactory {

	private static Logger logger = Logger.getLogger(MongoDBFactory.class);
	private static final String HOST_NAME = "localhost";
	private static final int HOST_PORT = 27017;
	
	private static Mongo mongo;
	
	private MongoDBFactory() {}
	
	// Get Singelton for Mongo instance
	public static Mongo getMongo() {
		logger.debug("Retrieving MongoDB");
		if (mongo == null) {
			try {
				mongo = new Mongo( HOST_NAME, HOST_PORT );
			} catch (UnknownHostException e) {
				logger.error(e);
			} catch (MongoException e) {
				logger.error(e);
			}
		}
		return mongo;
	}
	
	// Retrieve a db
	public static DB getDB(String dbname) {
		logger.debug("Retrieving db: " + dbname);
		return getMongo().getDB(dbname);
	}
	
	// Retrieve a collection
	public static DBCollection getCollection(String dbname, String collection) {
		logger.debug("Retrieving collection: " + collection);
		return getDB(dbname).getCollection(collection);
	}
	
}
