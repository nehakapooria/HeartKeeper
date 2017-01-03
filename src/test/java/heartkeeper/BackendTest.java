package heartkeeper;

import java.util.ArrayList;

import javax.management.Query;

import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class BackendTest {
	
	public static void main(String[] args) {
		 // To connect to mongodb server
        MongoClient mongoClient = new MongoClient("localhost" , 27017);
			
        // Now connect to your databases
        DB db = mongoClient.getDB("heart-keeper");
        System.out.println("Connect to database successfully"); 
			
        DBCollection coll = db.getCollection("client");
        System.out.println("Collection mycol selected successfully");
			
        DBCursor cursor = coll.find();
        int i = 1;
			
        while (cursor.hasNext()) {     
    	 System.out.println("Inserted Document: "+i);
         System.out.println(cursor.next());
         i++;
        }
       System.out.println(cursor.one().get("otp"));
        
     

	}
}
