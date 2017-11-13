import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.sql.*;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;


public class testServlet extends HttpServlet  {
	
//boolean out = true;	
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		String Uname="";
		String user = "milind";
String Password = "Atos@123";
String PWD ="";
try{  
Class.forName("com.mysql.jdbc.Driver");  

Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "SELECT lower(username) username,password FROM userinfo where lower(username)=?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
ResultSet rs=st.executeQuery();  

while(rs.next()){
	Uname=rs.getString(1);
	PWD = rs.getString(2);
}  
if(user.equals(Uname) && Password.equals(PWD)){	
con.close();
showPage(response, "if" + Uname + "=" + user + "-----" + Password + "=" + PWD);
}
else {
con.close();
showPage(response, "else" + Uname + "=" + user + "-----" + Password + "=" + PWD);
}
}catch(Exception e){ 
showPage(response, "Exception" + Uname + "=" + user + "-----" + Password + "=" + PWD + e);
}
	}
			

	
	
	
	
	
	
	/*
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
String sql = "SELECT lower(username_mgr) username,password FROM salesman where lower(username_mgr)=?";
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
String sql = "SELECT lower(username_sm) username,password FROM manager where lower(username_sm)=?";
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
*/


 protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
		out.println("<a href=\"login.html\"> Click here to go to login page </a>");
		out.println("</body>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }



}
	
	
