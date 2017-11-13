import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import org.xml.sax.SAXException;
import java.util.Map;
import java.util.*;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
import java.sql.*;



public class OrderViewServlet extends HttpServlet {

	
	//Map<Integer, String> map = new HashMap<Integer, String>();
	//Map<String, Integer> newmap = new HashMap<String, Integer>();
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("username")!=null)
		showPage(response, "Welcome   ",(String) session.getAttribute("username"));
		else 
		showPage(response, "Welcome  to Smart Portables", null); 
    }     
	
    protected void showPage(HttpServletResponse response, String message, String uname)
    throws ServletException, java.io.IOException {
		
		
       response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
		Utilities utility = new Utilities();
		String header = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
		String footer = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
		String LeftNav = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");	
				 out.println("<html>");
out.println("<head>");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
out.println("<title></title>");
out.println("<meta name=\"keywords\" content=\"\" />");
out.println("<meta name=\"description\" content=\"\" />");
out.println("<link href=\"http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900\" rel=\"stylesheet\" />");
out.println("<link href=\"template/default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
out.println("<link href=\"template/fonts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
out.println("	<meta charset=\"utf-8\">");
out.println("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
out.println("<title></title>");
out.println("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
out.println("	<meta name=\"keywords\" content=\"footer, address, phone, icons\" />");
out.println("	<link rel=\"stylesheet\" href=\"template/demo.css\">");
out.println("	<link rel=\"stylesheet\" href=\"template/footer.css\">");
out.println("	<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\">");
out.println("	<link href=\"http://fonts.googleapis.com/css?family=Cookie\" rel=\"stylesheet\" type=\"text/css\">");
out.println("	<meta name=\"keywords\" content=\"\" />");
out.println("<meta name=\"description\" content=\"\" />");
out.println("<link href=\"http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900\" rel=\"stylesheet\" />");
out.println("<link href=\"template/default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
out.println("<link href=\"template/fonts.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
out.println("<link href=\"template/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />");
out.println(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
out.println(" </head>");
out.println("<body>");
out.println("<div id=\"page\" class=\"container\">");
out.println("<div id=\"logo\">");
out.println("		<a href=#>	<img src=\"template/images/logo.jpg\" align = \"left\" width=\"300\" height = \"250\" style=\"margin-left:30px;margin-top:30px\" /></a>");
if (uname==null)
out.println("<h3 align=\"center\">" + message + "</h3>");
else 
out.println("<h3 align=\"center\">" + message + uname + "</h3>");
out.println("		<a href=#>	<img src=\"template/images/cart.jpg\" align = \"right\" width=\"100\" height = \"100\" style=\"margin-right:30px;margin-top:150px\" /></a>");
out.println("		</div>");
out.println("			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
out.println("			<nav class=\"navbar navbar-inverse\">");
out.println("  <div class=\"container-fluid\">");
out.println("    <div class=\"navbar-header\">");
out.println("      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\">");
out.println("        <span class=\"sr-only\">Toggle navigation</span>");
out.println("        <span class=\"icon-bar\"></span>");
out.println("        <span class=\"icon-bar\"></span>");
out.println("        <span class=\"icon-bar\"></span>");
out.println("      </button>");
out.println("      <a class=\"navbar-brand\" href=\"#\">Smart Portables &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>");
out.println("    </div>");
out.println("    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
out.println("      <ul class=\"nav navbar-nav\">");
out.println("        <li ><a href=\"HomeServlet\"> Home &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class=\"sr-only\">(current) </span></a></li>");
out.println("        <li><a href=\"ProductServlet\"> Products &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></li>");
out.println("		<li><a href=\"#\"> About us &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></li>" +
		"<li><a href=\"#\"> F.A.Qs &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></li>");
out.println("       </ul>");
out.println("       <ul class=\"nav navbar-nav navbar-right\">");
if (uname!=null){
out.println("<li><a href=\"HomeServlet?log=out\">Logout</a></li>");
}else {
out.println("<li><a href=\"login.html\">Login</a></li>");
out.println("<li><a href=\"RegisterServlet\">Register</a></li>");
}
out.println("      </ul>");
out.println("    </div>");
out.println("  </div>");
out.println(" </nav>");
		//SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	try{  
Class.forName("com.mysql.jdbc.Driver");  
String user = uname.toLowerCase();
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/CSP584","root","Atos@123");  
String sql = "SELECT *,current_date()+7 ExDate FROM orders_view where lower(username)=?";
PreparedStatement st = con.prepareStatement(sql);
st.setString(1,user);
ResultSet rs=st.executeQuery();
out.println("<table border=\"1\">");
out.println("		<col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("  <col width=\"100\">");
out.println("   <col width=\"100\">");
out.println("   <col width=\"100\">");
out.println("		<tr>");
out.println("    <th>PRODUCT</th>");
out.println("    <th>QUANTITY</th>");
out.println("	<th>AMOUNT</th>");
out.println("	<th>ORDER_DATE_TIME</th>");
out.println("	<th>STATUS</th>  ");
out.println("	<th>Card Details</th>  ");
out.println("	<th>Address</th>  ");
out.println("	<th> Expected Delivery DATE</th>    ");
out.println("  </tr>");
while(rs.next()){
out.println("  <tr>");
out.println("<td><img width=\"100\" height = \"100\" src=\"template/images/" +  rs.getString("img") + "\" /></td>");
out.println("<td><center><font size=\"3\"><b>" + rs.getString("qty") +"</b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>$" + rs.getString("amt") + "</p></b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>" + rs.getString("Date") + "</p></b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>Order Placed</p></b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>" + rs.getString("CardDetail") + "</p></b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>" + rs.getString("Address") + "</p></b></font></center></td>");
out.println("<td><center><font size=\"3\"><b><p>" + rs.getString("ExDate") + "</p></b></font></center></td>");
if(rs.getString("status").equals("C"))
out.println("<td><center><font size=\"3\"><b><p>" + "Order Cancelled" + "</p></b></font></center></td>");
else if(rs.getString("status").equals("P"))
out.println("<td><center><font size=\"3\"><b><p>" + "Order Processed" + "</p></b></font></center></td>");
else
out.println("<td><center><input type=\"button\" id=\"cartbutton" + rs.getString("pid") + "\" name=\"cartbutton" + rs.getString("pid") + "\" value=\"Cancel Order\" onclick=\"window.location.href='CancelOrderServlet?id=" + rs.getString("pid")+ "&conf=" + rs.getString("orderconf") + "'\"/></center></td></tr>");				     

}


	}catch(Exception e){ 
}
		//out.println(footer);
        out.close();
		 
		
		}
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processReq(request, response);
		  
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
         processReq(request, response);
    }
}
