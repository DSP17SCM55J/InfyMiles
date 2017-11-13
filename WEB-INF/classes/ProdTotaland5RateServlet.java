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

import org.xml.sax.SAXException;
import java.util.Map;
import java.util.HashMap;

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

public class ProdTotaland5RateServlet extends HttpServlet {

	
	Map<Integer, String> map = new HashMap<Integer, String>();
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("username")!=null)
		showPage(response, "Welcome   ", (String) session.getAttribute("username"));
		else 
		showPage(response, "Welcome  to Smart Portables",null); 
		
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
out.println("		<a href=\"addCart\">	<img src=\"template/images/cart.jpg\" align = \"right\" width=\"100\" height = \"100\" style=\"margin-right:30px;margin-top:150px\" /></a>");
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
out.println("<li><a href=\"OrderViewServlet\">View Orders</a></li>");
out.println("<li><a href=\"HomeServlet?log=out\">Logout</a></li>");
}else {
out.println("<li><a href=\"login.html\">Login</a></li>");
out.println("<li><a href=\"RegisterServlet\">Register</a></li>");
}
out.println("      </ul>");
out.println("    </div>");
out.println("  </div>");

out.println(" </nav>");

		Map<String, Integer> map = new HashMap<String, Integer>();
    	Map<Integer, String> map2 = new HashMap<Integer, String>();
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("CustomerReviews");
		MongoCollection<Document> col = database.getCollection("StoredReviews");
      
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
		int z=1;
out.println("<table border=\"1\">");
out.println("		<col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("  <col width=\"70\">");
out.println("   <col width=\"70\">");
out.println("   <col width=\"70\">");
out.println("   <col width=\"70\">");
out.println("		<tr>");
out.println("    <th>Username</th>");
out.println("    <th>Productname</th>");
out.println("	<th>Category</th>");
//out.println("	<th>Price</th>");
out.println("	<th>Retailer</th>  ");
out.println("	<th>Manufacturer</th>  ");
out.println("	<th>Condition</th>  ");
//out.println("	<th>Quantity</th>  ");
out.println("	<th> Rating</th>    ");
out.println("	<th> Review</th>    ");
out.println("  </tr>");		
while (z < cnt){
out.println("  <tr>");
out.println("<td><center><font size=\"3\">"    + map2.get(z+1)+"</font></center></td>");
out.println("<td><center><font size=\"3\">"    + map2.get(z+2) +"</font></center></td>");
out.println("<td><center><font size=\"3\"><p>"+ map2.get(z+3) + "</p></font></center></td>");
//out.println("<td><center><font size=\"3\"><p>$" + map2.get(z+4) + "</p></font></center></td>");
out.println("<td><center><font size=\"3\"><p>" + map2.get(z+5)+ "</p></font></center></td>");
out.println("<td><center><font size=\"3\"><p>" + map2.get(z+10) + "</p></font></center></td>");
out.println("<td><center><font size=\"3\"><p>" + map2.get(z+11) + "</p></font></center></td>");
//out.println("<td><center><font size=\"3\"><p>" + map2.get(z+14) + "</p></font></center></td>");
out.println("<td><center><font size=\"3\"><p>" + map2.get(z+15) + "</p></font></center></td>");
out.println("<td><center><font size=\"3\"><p>" + map2.get(z+16) + "</p></font></center></td>");
z=z+17;	
}
		
}		
              

		
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
