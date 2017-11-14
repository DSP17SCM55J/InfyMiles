import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import java.io.*;

import com.mongodb.AggregationOutput;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class WriteReviewServlet {
	MongoClient mongo = new MongoClient("localhost", 27017);
	DBCollection myReviews=null;
	
	
	public void reviewadd(HashMap<String,BeanReviewAdd> beanvalue) throws ClassNotFoundException
	{
	
	BeanReviewAdd addBean =  new BeanReviewAdd();
	Set set = beanvalue.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext())
		{
			Map.Entry entry = (Map.Entry)iterator.next();
			addBean = (BeanReviewAdd)entry.getValue();
		}
	        String productModelName = addBean.getProductModelName();
			String productCategory = addBean.getProductCategory();
			String productPrice = addBean.getProductPrice();
			String retailerName = addBean.getRetailerName();
			String retailerZip = addBean.getRetailerZip();
			String retailerCity = addBean.getRetailerCity();
			String retailerState = addBean.getRetailerState();
			String productOnSale=addBean.getProductOnSale();
			String manufacturerName = addBean.getManufacturerName();
			String manufacturerRebate = addBean.getManufacturerRebate();
			String userID = addBean.getUserID();
			String userAge = addBean.getUserAge();
			String userGender = addBean.getUserGender();
			String userOccupation = addBean.getUserOccupation();
			String reviewRating = addBean.getReviewRating();	
			String reviewDate = addBean.getReviewDate();
			String reviewText = addBean.getReviewText();
			
			try
			{
				DB db = mongo.getDB("InfyMiles");
				myReviews = db.getCollection("Reviews");
				
				BasicDBObject bobj = new BasicDBObject("title", "Reviews").
			
				append("productModelNameDB", productModelName).
				append("productCategoryDB", productCategory).
				append("productPriceDB", productPrice).
				append("retailerNameDB", retailerName).
				append("retailerZipDB", retailerZip).
				append("retailerCityDB", retailerCity).
				append("productretailerStateDB", retailerState).
				append("productOnSaleDB", productOnSale).
				append("manufacturerNameDB", manufacturerName).
				append("manufacturerRebateDB", manufacturerRebate).
				append("userIDDB", userID).
				append("userAgeDB", userAge).
				append("userGenderDB", userGender).
				append("userOccupationDB", userOccupation).
				append("reviewRatingDB", reviewRating).
				append("reviewDateDB", reviewDate).
				append("reviewTextDB", reviewText);
			    myReviews.insert(bobj);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
	}
	

	public HashMap<String,ArrayList<BeanReviewAdd>> viewreview(String product_id)
	{
		HashMap<String,ArrayList<BeanReviewAdd>> entriesadd = new HashMap<String, ArrayList<BeanReviewAdd>>();
			ArrayList<BeanReviewAdd> beanreviews = new  ArrayList<BeanReviewAdd>();
	
	    DB db = mongo.getDB("InfyMiles");
	    myReviews = db.getCollection("Reviews");
			
	    BasicDBObject bobj = new BasicDBObject();
		bobj.put("productModelNameDB", product_id);

		DBCursor cursor = myReviews.find(bobj);
	        
		try{
				
			while (cursor.hasNext())
			{
			    BasicDBObject bobj2 = (BasicDBObject) cursor.next();
				BeanReviewAdd addproducts = new BeanReviewAdd();
				addproducts.setProductModelName(bobj2.getString("productModelNameDB"));
				addproducts.setProductCategory(bobj2.getString("productCategoryDB"));
				addproducts.setProductPrice(bobj2.getString("productPriceDB"));
				addproducts.setRetailerName(bobj2.getString("retailerNameDB"));
				addproducts.setRetailerZip(bobj2.getString("retailerZipDB"));
				addproducts.setRetailerCity(bobj2.getString("retailerCityDB"));
				addproducts.setRetailerState(bobj2.getString("productretailerStateDB"));
				addproducts.setProductOnSale(bobj2.getString("productOnSaleDB"));
				addproducts.setManufacturerName(bobj2.getString("manufacturerNameDB"));
				addproducts.setManufacturerRebate(bobj2.getString("manufacturerRebateDB"));
				addproducts.setUserID(bobj2.getString("userIDDB"));
				addproducts.setUserAge(bobj2.getString("userAgeDB"));
				addproducts.setUserGender(bobj2.getString("userGenderDB"));
				addproducts.setUserOccupation(bobj2.getString("userOccupationDB"));
				addproducts.setReviewRating(bobj2.getString("reviewRatingDB"));
				addproducts.setReviewDate(bobj2.getString("reviewDateDB"));
				addproducts.setReviewText(bobj2.getString("reviewTextDB"));
					 
				beanreviews.add(addproducts);
									 
				entriesadd.put("Reviews",beanreviews);
			}
		}
		
        catch(Exception e)
		{			
			e.printStackTrace();
		}
					 
		return entriesadd;
	
	}
}
