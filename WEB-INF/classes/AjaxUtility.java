import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.*;

public class AjaxUtility{

	public static HashMap<String,Car> getData(){
		HashMap<String,Car> productsMap = new HashMap<String,Car>();
		try
			{ 
				MySqlDataStoreUtilities utility = new MySqlDataStoreUtilities();				
				productsMap = utility.readCars();
				
			}
			catch(Exception e){
				e.printStackTrace();
				

			}
		return productsMap;
		}

	public StringBuffer readData(String model) {
		HashMap<String,Car> data; 
		
		data = getData();
		StringBuffer sb = new StringBuffer();
		Iterator it = data.entrySet().iterator(); 
		while (it.hasNext())
		{
			Map.Entry entry = (Map.Entry)it.next();
			Car product = (Car)entry.getValue();
			
			if (product.getcarName().toLowerCase().startsWith(model)) {
				sb.append("<Car>");
				sb.append("<id>" + product.getId() + "</id>"); 
				sb.append("<carBrandName>" + product.getcarBrandName() + "</carBrandName>"); 
				sb.append("<carName>" + product.getcarName() + "</carName>"); 
				sb.append("</Car>");
			} 
		}
		return sb; 
	}
}

/*

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AjaxUtility
{
	
	public List<List> Fetchproductbytargetid(String targetid) 
	 {
        List<List> CategoryItems = new ArrayList<List>();
           
        try {
              Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");
            String fetchproductcategory = "SELECT productId, retailer, name, price, discount, rebate, quantity,image, type FROM Cars where productId=?";
            PreparedStatement pst = conn.prepareStatement(fetchproductcategory);
            pst.setString(1, targetid);
            ResultSet resultSet = pst.executeQuery();
            
              int count2=-1;
              
            
            while(resultSet.next())
            {   
                
                count2++;
                ArrayList CatItems = new ArrayList();
                for(int i=0;i<5;i++)    
                {
                 CatItems.add(i, resultSet.getString(i+1));
                }
                
                CategoryItems.add(CatItems);
                
            }
			
        } catch (Exception e) {
            e.printStackTrace();
           
        }
        
        return CategoryItems;
    }
	
	

public static HashMap<String,Car> getData(String targetId)
{
	HashMap<String,Car> CategoryItems = new HashMap<String,Car>();
    
    try {
          Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestdeal", "root", "root");
        String fetchproductcategory = "SELECT * FROM Cars where name LIKE ?";
        
        PreparedStatement pst = conn.prepareStatement(fetchproductcategory);
        targetId=targetId+"%";
        System.out.println(targetId);
        pst.setString(1, targetId);
        System.out.println(pst);
        ResultSet resultSet = pst.executeQuery();
        
        while(resultSet.next())
        {   
            
         Car product = new Car(resultSet.getInt("productId"),resultSet.getString("brandName"), resultSet.getString("model"), resultSet.getDouble("price"), resultSet.getDouble("discount"), resultSet.getDouble("rebate"), resultSet.getInt("quantity"), 
												resultSet.getString("imageName"), resultSet.getString("category"));
				
          CategoryItems.put(resultSet.getString("productId"),product);
        }
       

    } catch (Exception e) {
        e.printStackTrace();
       
    }
    
    return CategoryItems;
 }


/*public StringBuffer readdata(String targetId)
{
	StringBuffer sb=new StringBuffer();
	HashMap<String,CarBean> data= getData(targetId);
	Iterator it = data.entrySet().iterator();
    while(it.hasNext())
     {
	   Map.Entry pi=(Map.Entry)it.next();
	   CarBean p=(CarBean)pi.getValue();
	   
	   if (p.getproductname().toLowerCase().startsWith(targetId))
	   {
		   sb.append("<composer>");
		   sb.append("<id>" + p.getproductcode() + "</id>");
           sb.append("<firesultSetName>" + p.getproductname() + "</firesultSetName>");
           sb.append("<lastName>" + p.getcategory() + "</lastName>");
           sb.append("</composer>");
           System.out.println(sb);
	   }
       
	   
   }
	return sb;
}*/
/*

public StringBuffer readData(String targetId) {
		HashMap<String,Car> data; 
		
		data = getData();
		StringBuffer sb = new StringBuffer();
		Iterator it = data.entrySet().iterator(); 
		while (it.hasNext())
		{
			Map.Entry entry = (Map.Entry)it.next();
			Car product = (Car)entry.getValue();
			
			if (product.getModel().toLowerCase().startsWith(targetId)) {
				sb.append("<product>");
				sb.append("<id>" + product.getCarId() + "</id>"); 
				sb.append("<brandName>" + product.getBrandName() + "</brandName>"); 
				sb.append("<model>" + product.getModel() + "</model>"); 
				sb.append("</product>");
			} 
		}
		return sb; 
	}



}
*/