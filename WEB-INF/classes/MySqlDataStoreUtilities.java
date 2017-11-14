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
	
	
}

