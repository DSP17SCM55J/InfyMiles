import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

public class MySqlDataStoreUtilities {

	private Connection conn = null;
	private PreparedStatement pst = null;
	//Utilities utility = new Utilities();

			//PrintWriter out = response.getWriter();
	public boolean insertUser(String emailId,String name, String password, String role, String address, String phoneNumber, String city, String state, String zipcode) {/*, String fName, String lName, String email, String cnumber,String usertype)*/ 
		boolean addSuccess = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");

//			String insertIntoCustomerRegisterQuery = "INSERT INTO Register values(fName,lName,email,cNumber,uname,password,usertype) "
			
			String query = "INSERT INTO Register VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, emailId);
			pst.setString(2, name);
			pst.setString(3, password);						
			pst.setString(4, role);
			pst.setString(5, address);
			pst.setString(6, phoneNumber);
			pst.setString(7, city);						
			pst.setString(8, state);
			pst.setString(9, zipcode);
			pst.executeUpdate();			
			conn.close();			
			return true;
		} 
		catch (Exception e) {
			return false;
		}

	}

	public boolean checkUser(String emailId, String password,String role){


		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			PreparedStatement pst = conn.prepareStatement("Select emailId,password,userType from Register where emailId=? and password=? and userType=?");
			pst.setString(1, emailId);
			pst.setString(2, password);
			pst.setString(3, role);

			ResultSet rst;
			rst = pst.executeQuery();
			if(rst.next()){
				return true;	
			}

			else{
			//check = false;
				return false;
			}
		
		}
		catch(Exception e){
			return false;
		}

	}
	
	
		public void InsertUser(String data){

		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Insert into Cars values("+ data+")");
			pst.executeUpdate();
			pst.close();
			conn.close();	
		}
		catch(Exception e){
			}

	}
	
	
	
	
	public boolean checkData(){


		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Select * from cars");
			ResultSet rst;
			rst = pst.executeQuery();
			if(rst.next()){
				return true;	
			}

			else{
				return false;
			}
		
		}
		catch(Exception e){
			return false;
		}

	}
	
	
	
		public boolean selectCarDetail(){


		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Select * from cars");
			ResultSet rst;
			rst = pst.executeQuery();
			if(rst.next()){
				return true;	
			}

			else{
				return false;
			}
		
		}
		catch(Exception e){
			return false;
		}

	}


public HashMap<String,Car> readCars(){
		HashMap<String, Car> productList = new HashMap<>();
		java.sql.Statement stm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");

			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String getCarData = "SELECT carId, carCategory, carBrandName, carMileage, carModel, carProductionYear, carColor,carImagePath, carReservationStatus FROM Cars";

			ResultSet rst;
			rst = stm.executeQuery(getCarData);
			productList = new HashMap<>();
			while (rst.next()) {
				String id = Integer.toString(rst.getInt("carId"));
				String carReservationStatus = Integer.toString(rst.getInt("carReservationStatus"));
				Car product = new Car(id,rst.getString("carName"),rst.getString("carCategory"),rst.getString("carBrandName"),rst.getString("carMileage"),rst.getString("carModel"),rst.getString("carProductionYear"),rst.getString("carColor"),rst.getString("carImagePath"),rst.getString("carPrice"),carReservationStatus);
				//Car product = new Car(rst.getInt("productId"),rst.getString("retailer"), rst.getString("name"), rst.getDouble("price"), rst.getDouble("discount"), rst.getDouble("rebate"), rst.getInt("quantity"), 
				//								rst.getString("image"), rst.getString("type"));
				Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE,
						product.toString() + "read from db");
				productList.put(product.getcarName(), product);
			}

			stm.close();
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage()+"error while reading from db",
					e.getStackTrace());
		}

		
		return productList;
	}


	public ArrayList<String> graphGenration(){
		ArrayList<String> list = new ArrayList<String>();
		try{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select location, count(*) as counting  from cars group by location;");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				//String name = rs.getString(1);
				//String quantity = rs.getString(2);
				list.add(rs.getString(1));
				list.add(rs.getString(2));
			}
			
			return list;

		}
		catch(Exception e)
		{

			//out.println(e);
		}
		return list;
	}


	public ArrayList<String> changeProducts(){
		ArrayList<String> list = new ArrayList<String>();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			String sql = "SELECT * from Cars";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rst=pst.executeQuery(); 
			while(rst.next()){
				list.add(rst.getString("carid"));
				list.add(rst.getString("carname"));
				list.add(rst.getString("carCategory"));
				list.add(rst.getString("carBrandName"));
				list.add(rst.getString("carModel"));
				list.add(rst.getString("carMileage"));
				list.add(rst.getString("carProductionYear"));
				list.add(rst.getString("carColor"));
				list.add(rst.getString("carImagePath"));
				list.add(rst.getString("carPrice"));	
				list.add(rst.getString("carReservationStatus"));
				list.add(rst.getString("location"));
			}
			return list; 

		}
		catch(Exception e){
				return null;
		}
		
	}

	public String updateDeleteProducts(String task,int productId, String carName, String carCategory,String carBrandName, String carModel, String carMileage, String carProductionYear, String carColor, String carImagePath, String carPrice, int carReservationStatus, String location){
		//boolean check = false;
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			String sql = "Update Cars set carId = ?,carName = ?, carCategory = ?,carBrandName = ?,carModel = ?,carMileage = ?,carProductionYear = ?,carColor = ?, carImagePath = ?, carPrice = ?,carReservationStatus = ?,location = ? where carId= ?";
			String sql2 = "Delete from Cars where carId = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setInt(1, productId);
			pst.setString(2, carName);
			pst.setString(3, carCategory);
			pst.setString(4, carBrandName);
			pst.setString(5, carModel);
			pst.setString(6, carMileage);
			pst.setString(7, carProductionYear);
			pst.setString(8, carColor);
			pst.setString(9, carImagePath);
			pst.setString(10, carPrice);
			pst.setInt(11, carReservationStatus);
			pst.setString(12, location);
			pst.setInt(13,productId);
			/*if(task.equals("delete")){
				pst2.executeUpdate(); 
				 return true;
			}
			else {*/
				pst.executeUpdate();
				return "true";
			//}
		}catch(Exception e){
			//return false;
			String error = "this:"+e;
			return error;
		}	
	}

	public boolean deleteCars(int productId){

		boolean check = false;
		try{  

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root");  
			
			String sql = "Delete from Cars where carId = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, productId);
			pst.executeUpdate();
				return true;	

		}
		catch(Exception e){
				return false;
		}
	}


	public ArrayList<String> userDetails(String username){
		ArrayList<String> userdetails = new ArrayList<String>();
		try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles","root","root"); 
				String sql = "Select name,emailId, address,phoneNumber,city,state,zipcode from Register where name ="+username ; 
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rst = pst.executeQuery();
				while(rst.next()){
				userdetails.add(rst.getString(1));
				userdetails.add(rst.getString(2));
				userdetails.add(rst.getString(3));
				userdetails.add(rst.getString(4));
				userdetails.add(rst.getString(5));
				userdetails.add(rst.getString(6));
				userdetails.add(rst.getString(7));
			}
			return userdetails;
		}
		catch(Exception e){
			return null;
		}
	}
	
		
}

