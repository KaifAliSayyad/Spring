package emp.storage;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;


public class DBConnection {
	private static MongoClient con = null;
	
	public static final MongoCollection<Document> getCollection(String dbName, String collectionName) {
		try {
			if(con == null) con = MongoClients.create("mongodb://localhost:27017");
			return con.getDatabase(dbName).getCollection(collectionName);			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static final void closeClient() {
		con.close();
	}
}
