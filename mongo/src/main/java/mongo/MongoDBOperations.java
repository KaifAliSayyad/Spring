package mongo;


import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;
import java.io.*;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

public class MongoDBOperations {
	public static void main(String[] args) {

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");){
			
			System.out.println("***  MONGO DB OPERATIONS DEMO ***");
			
			MongoDatabase database = mongoClient.getDatabase("mydb");
			
			MongoCollection<Document> collection =  database.getCollection("employee");
						
//			Document doc = new Document();
//			
//			doc.append("name", "Pooja");
//			doc.append("age", 12);
//			doc.append("salary" , 60000);
//			doc.append("designation" , "PROGRAMMER");
//			
//			collection.insertOne(doc);
			
			printCollection(collection);
			
			List<Document> emps = new ArrayList<>();
			int choice = -1;
			do {
				System.out.println("0. Exit");
				System.out.println("1. Create");
				System.out.print("->");
				choice = Integer.parseInt(br.readLine());
				if(choice == 1) {
					int add = -1;
					Document emp = new Document();
					do {						
						System.out.println("0. Add");
						System.out.println("1. Append");
						System.out.print("->");
						add = Integer.parseInt(br.readLine());
						if(add == 1) {
							System.out.print("Enter key : ");
							String key = br.readLine();
							System.out.print("Enter value : ");
							String value = br.readLine();
							emp.append(key, value);
						}else if(add == 0) {
							if(emp.size()> 0) emps.add(emp);
							continue;
						}else {
							System.out.println("Invalid choice");
						}
					}while(add != 0);
					
				}else if(choice == 0) {
					if(emps.size() > 0) collection.insertMany(emps);
					continue;
				}
				else {
					System.out.println("Invalid Choice!!");
				}
			}while(choice != 0);
			
			
			
			//Updating records
			//updateRecords(collection);
			
			//Deleting Record
			deleteRecord(collection);
			
			printCollection(collection);
			
			System.out.println("Successfully did the operations on MongoDB");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printCollection(MongoCollection<Document> collection) {
		
		//Learning Projections
		System.out.println("Reading all records from "+collection.getNamespace());
		Bson projection = Projections.exclude("_id");
		Bson filter = Filters.gt("age", "23");
		Bson sort = Sorts.ascending("age");
		
//		FindIterable<Document> i = collection.find(filter).projection(projection).sort(sort);
		FindIterable<Document> i = collection.find();
		for(Document d : i) {
			System.out.println(d.toJson());
		}
	}
	
	public static void updateRecords(MongoCollection<Document> collection) {
		Bson update  = Updates.set("designation", "MANAGER");
		Bson filter = Filters.gt("age", "27");
		collection.updateMany(filter, update);
	}
	
	public static void deleteRecord(MongoCollection<Document> collection) {
		Bson filter = Filters.eq("Omkar", "0");
		collection.deleteOne(filter);
		
		
		
	}
}
