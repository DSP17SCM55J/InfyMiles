import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.sql.*;


public class MySQLDataStoreUtilities  {
	
//boolean out = true;	
	
public boolean LoginCheckUser(String username, String Password)
{
try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = username.toLowerCase();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "SELECT lower(username) username,password FROM userinfo where lower(username)=?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
ResultSet rs=st.executeQuery();  
String Uname="";
String PWD ="";
while(rs.next()){
	Uname=rs.getString(1);
	PWD = rs.getString(2);
}  
if(user.equals(Uname) && Password.equals(PWD)){	
con.close();
return true;
}
else {
con.close();
return false;
}
}catch(Exception e){ 
return false;
}

}


	
public boolean LoginCheckManager(String username, String Password)
{
try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = username.toLowerCase();
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "SELECT lower(username_mgr) username,password_mgr FROM manager where lower(username_mgr)=?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
ResultSet rs=st.executeQuery();  
String Uname="";
String PWD ="";
while(rs.next()){
	Uname=rs.getString(1);
	PWD = rs.getString(2);
}  
if(user.equals(Uname) && Password.equals(PWD)){	
con.close(); 
return true;
}
else {
	con.close(); 
return false;
}
}catch(Exception e){ System.out.println("Error Occured Please try again");
}  
return false;
}


	
public boolean LoginCheckSalesMan(String username, String Password)
{
try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = username.toLowerCase();
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "SELECT lower(username_sm) username,password_sm FROM salesman where lower(username_sm)=?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
ResultSet rs=st.executeQuery();  
String Uname="";
String PWD ="";
while(rs.next()){
	Uname=rs.getString(1);
	PWD = rs.getString(2);
}  
if(user.equals(Uname) && Password.equals(PWD)){	
con.close(); 
return true;
}
else {
	con.close(); 
return false;
}
}catch(Exception e){
}  
return false;
}



	
public boolean LoginStore(String username, String Password)
{
try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = username.toLowerCase();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "Insert into userinfo values(?,?)";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
st.setString(2,Password);
st.executeUpdate(); 
return true;
}catch(Exception e){ 
return false;
}
}

public void InsertCart(String pid,String pname,String pprice,String img,String manu,String cond,String disc,String acc,int qty){
	try{  
Class.forName("com.mysql.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "Insert into cart values(?,?,?,?,?,?,?,?,?,current_date())";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,pid);
st.setString(2,pname);
st.setString(3,pprice);
st.setString(4,img);
st.setString(5,manu);
st.setString(6,cond);
st.setString(7,disc);
st.setString(8,acc);
st.setInt(9,qty);
st.executeUpdate();
}catch(Exception e){
}
	
}

public void InsertOrder(int randomNum, String username,String Address, String Card){
	try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "Insert into orders select distinct null,null,pid,pnamr,pprice,img,manu,cond,disc,acc,qty,Date,null,null,'S' from cart where qty>0";
String sqlupd = "Update orders set CardDetail = ?, Address = ?,username = ?,orderconf = ? where username is null";
String sql2 = "delete from cart";
PreparedStatement st = con.prepareStatement(sql);
PreparedStatement st2 = con.prepareStatement(sql2);
PreparedStatement stupd = con.prepareStatement(sqlupd);
stupd.setString(1,Card);
stupd.setString(2,Address);
stupd.setString(3,username);

stupd.setInt(4,randomNum);
st.executeUpdate(); 
st2.executeUpdate();
stupd.executeUpdate();  
}catch(Exception e){ 
}	
}

}
	
	
