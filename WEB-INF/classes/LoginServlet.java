
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 

public class LoginServlet extends HttpServlet {
   
    /** 
     * Creating Hashmap using customer data
    */  
	


//Map<String, String> map = new HashMap<String, String>();
	
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	
    */
	/*protected void userdata (String username, String Password){
	
try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = username.toLowerCase();
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
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

}
else {
showPage(response, "Login Failure! Username or password is incorrect");
}
con.close();  
}catch(Exception e){ System.out.println("Error Occured Please try again");
}  
}
	}
	*/
	
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {

		String lname = request.getParameter("id");
		String userid = request.getParameter("userid");
        String password = request.getParameter("password");
		if(userid != null &&
            password != null) {
		if (lname.equals("customer")){
		MySQLDataStoreUtilities mysql = new MySQLDataStoreUtilities();
		boolean res = mysql.LoginCheckUser(userid,password);
		if (res){
			        HttpSession session = request.getSession();
					session.setAttribute("username", userid);
					String redirectURL = "/csj/HomeServlet";
					response.sendRedirect(redirectURL);
		}else {
			showPage(response, "Login Failure! Username or password is incorrect" + userid + password);
		}
		
		}
		else if (lname.equals("manager")){
		MySQLDataStoreUtilities mysqlmgr = new MySQLDataStoreUtilities();
		boolean resmgr = mysqlmgr.LoginCheckManager(userid,password);
		if (resmgr){
			        HttpSession session = request.getSession();
					session.setAttribute("username", userid);
					String redirectURL = "/csj/AddProductServlet";
					response.sendRedirect(redirectURL);
		}else {
			showPage(response, "Login Failure! Username or password is incorrect" );
		}
		}
		else if (lname.equals("salesman")){
		MySQLDataStoreUtilities mysqlsm = new MySQLDataStoreUtilities();
		boolean ressm = mysqlsm.LoginCheckSalesMan(userid,password);
		if (ressm){
			        HttpSession session = request.getSession();
					session.setAttribute("username", userid);
					String redirectURL = "/csj/SalesManServlet";
					response.sendRedirect(redirectURL);
		}else {
			showPage(response, "Login Failure! Username or password is incorrect" );
		}
		}
			}else {
            showPage(response, "Login Failure!  You must supply a username and password");
        }
		
	
	/*
        if(userid != null &&
            password != null) {
                String realpassword = (String)map.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", userid);
					String redirectURL = "/csj/HomeServlet";
					response.sendRedirect(redirectURL);
					
                } else {
                    showPage(response, "Login Failure! Username or password is incorrect");
                }
        }  else {
            showPage(response, "Login Failure!  You must supply a username and password");
        }*/
    } 
    
	
	
	
	
	
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
