import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 
import org.bson.Document; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;


public class MongoDbDatastoreUtility { 
   
   public static void InsertReview( String username , String pid,String pname,String pcategory,String rname,String rzip,String rcity,
							String rstate,String pprice,String img,String manu,String cond,String disc,String acc,String qty,String rating,String rtext) {  
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
      MongoDatabase database = mongo.getDatabase("CustomerReviews");  
      MongoCollection<Document> collection = database.getCollection("StoredReviews"); 
      Document document = new Document("pid", pid) 
			  .append("uname", username)  
    	      .append("pname", pname)
			  .append("pcategory", pcategory)
    	      .append("pprice", pprice) 
			  .append("rname", rname) 
			  .append("rzip", rzip) 
			  .append("rcity", rcity) 
			  .append("rstate", rstate) 
			  .append("img", img) 
			  .append("manu", manu) 
			  .append("cond", cond) 
			  .append("disc", disc) 
			  .append("acc", acc) 
    	      .append("qty", qty)
    	      .append("ReviewRating", rating)
			  .append("ReviewText", rtext);
    	      collection.insertOne(document); 
   
   }
   
   
   public static void ViewReview(String pid){

    	Map<String, Integer> map = new HashMap<String, Integer>();
    	Map<Integer, String> map2 = new HashMap<Integer, String>();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("CustomerReviews");
		MongoCollection<Document> col = database.getCollection("info");
      
        int cnt =1;
        List list = null;
        try (MongoCursor<Document> cur = col.find().iterator()) {
            while (cur.hasNext()) {
				Document doc = cur.next();
                list = new ArrayList(doc.values());
                map.put(list.get(1).toString(),cnt);
                map2.put(cnt++, list.get(1).toString());
                map.put(list.get(2).toString(),cnt);
                map2.put(cnt++, list.get(2).toString());
                map.put(list.get(3).toString(),cnt);
                map2.put(cnt++, list.get(3).toString());
				 map.put(list.get(4).toString(),cnt);
                map2.put(cnt++, list.get(4).toString());
                map.put(list.get(5).toString(),cnt);
                map2.put(cnt++, list.get(5).toString());
                map.put(list.get(6).toString(),cnt);
                map2.put(cnt++, list.get(6).toString()); 
				map.put(list.get(7).toString(),cnt);
                map2.put(cnt++, list.get(7).toString());
                map.put(list.get(8).toString(),cnt);
                map2.put(cnt++, list.get(8).toString());
                map.put(list.get(9).toString(),cnt);
                map2.put(cnt++, list.get(9).toString());
				map.put(list.get(10).toString(),cnt);
                map2.put(cnt++, list.get(10).toString());
                map.put(list.get(11).toString(),cnt);
                map2.put(cnt++, list.get(11).toString());
                map.put(list.get(12).toString(),cnt);
                map2.put(cnt++, list.get(12).toString()); 
				map.put(list.get(13).toString(),cnt);
                map2.put(cnt++, list.get(13).toString());
                map.put(list.get(14).toString(),cnt);
                map2.put(cnt++, list.get(14).toString());
                map.put(list.get(15).toString(),cnt);
                map2.put(cnt++, list.get(15).toString()); 
				map.put(list.get(16).toString(),cnt);
                map2.put(cnt++, list.get(16).toString());
                map.put(list.get(17).toString(),cnt);
                map2.put(cnt++, list.get(17).toString());            
            }
          
           int x = map.get(pid);
               
            	 System.out.println(map2.get(x));
                 System.out.println(map2.get(x+1));
                 System.out.println(map2.get(x+2));
              
        }

        mongoClient.close();
    }
}
   