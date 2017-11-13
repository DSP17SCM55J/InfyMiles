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

public class ProdDetailServlet extends HttpServlet {

	
	Map<Integer, String> map = new HashMap<Integer, String>();
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("username")!=null)
		showPage(response, "Welcome   ",request.getParameter("id"), (String) session.getAttribute("username"), request.getParameter("page"));
		else 
		showPage(response, "Welcome  to Smart Portables", request.getParameter("id"),null,null); 
    }     
	
    protected void showPage(HttpServletResponse response, String message, String prodid , String uname, String page)
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
		out.println(LeftNav);
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("C:\\apache-tomcat-7.0.34\\webapps\\csj\\WEB-INF\\classes\\ProductCatalog.xml"), handler);
        Map<String, Product> prodList = handler.getprodList();
		String i = prodList.toString();
		String parts[] = i.split("=");
		//map.put(parts[0], parts[1]);
		int nw = 0;
		String z=null;
		while (nw < parts.length){
		z = z + parts[nw] + "," ;
		nw++;
		}
		String partsmap[] = null;
		partsmap = z.split(",");
		int x = 0;
		int y = 0;
		int count = 0;
		while(x < partsmap.length){
			  // System.out.println(partsmap[x]);
			   map.put(x, partsmap[x]);
			   if(partsmap[x].equals(prodid) && count ==0){
				   y = x;
			   		count = 5;
			   		}
			   x++;
			}
			//out.println(map);
		 String prid = (String)map.get(y);
		 String pname = (String)map.get(y+2);
		 String pprice = (String)map.get(y+4);
		 String img = (String)map.get(y+3);
		 String manu = (String)map.get(y+5);
		 String condition = (String)map.get(y+6);
		 String discount = (String)map.get(y+7);
		 String Accessories = (String)map.get(y+8);
		//	   out.println("<a href=#><div class=\"floated_img\"><img src=\"template/images/" + value + "\" " + "width=\"300\" " + "height = \"200\"" + "style=\"margin-left:50px;margin-top:50px\"  /></a>");
		//	   out.println("<center><p style=\"margin-left:50px;margin-top:50px\">" + pname + "</p><p style=\"margin-left:50px\"> Price: " + pprice + "</p></center></div>");
			   
if(page!=null){
	out.println("<div class=\"floated_img\">");
out.println("<img src=\"template/images/" + img + "\" " + " width=\"500\" height = \"300\" style=\"margin-left:50px;margin-top:50px\"/>");
out.println("</div>");
out.println("<div style=\"margin-top:100px;display:inline-block;margin-left:30px\">");
out.println("<font size=\"6\">" + pname + "</font><br/><br/> " + "<font size=\"6\"> Price: " + pprice + "</font><br/><br/>");
out.println("<a ><font size=\"5\"> Details:</font></a><br/><br/>");
out.println("Manufacturer: " + manu +"<br/> Condition: " + condition + "<br/> Discount Applied:" + discount +"</div>");
out.println("<div style=\"margin-left:100px:margin-top:100px;display:inline-block\"><center>");
out.println("<br/><br/><br/><br/><div style=\"float:right\"><input type='button' onclick=\"window.location.href='ViewReviewServlet?prodid="  + prid + "'\"  value=\"View Review\"> </div>");
out.println("<input type='button' onclick=\"window.location.href='ProductReviewServlet?prodid="  + prid + "'\"  value=\"Submit Review\"> </div>");
out.println("<br/><br/><a class=\"floated_img\" style=\"margin-left:100px\"> Type in Quantity: </a><br/>");
out.println("<form action=\"addCart?prid=" +prid + "&page=order\" method=\"post\"> ");
out.println("<input type=\"number\"required maxlength=\"3\" name=\"quantity\" id=\"quantity\" style=\"margin-left:100px\">");
out.println("<input type=\"submit\" id=\"cart\" name=\"cart\" value=\"Update Order\" ></form></div><br/><br/> <h3 align=\"center\"> Accessories</h3>");
			 
}else {			   
out.println("<div class=\"floated_img\">");
out.println("<img src=\"template/images/" + img + "\" " + " width=\"500\" height = \"300\" style=\"margin-left:50px;margin-top:50px\"/>");
out.println("</div>");
out.println("<div style=\"margin-top:100px;display:inline-block;margin-left:30px\">");
out.println("<font size=\"6\">" + pname + "</font><br/><br/> " + "<font size=\"6\"> Price: " + pprice + "</font><br/><br/>");
out.println("<a ><font size=\"5\"> Details:</font></a><br/><br/>");
out.println("Manufacturer: " + manu +"<br/> Condition: " + condition + "<br/> Discount Applied:" + discount +"</div>");
out.println("<br/><br/><br/><br/><div style=\"float:right\"><input type='button' onclick=\"window.location.href='ViewReviewServlet?prodid="  + prid + "'\"  value=\"View Review\">");
out.println("<input type='button' onclick=\"window.location.href='ProductReviewServlet?prodid="  + prid + "'\"  value=\"Submit Review\"> </div>");
out.println("<br/><br/><div style=\"margin-left:100px:margin-top:100px;display:inline-block\"><center>");
out.println("<a class=\"floated_img\" style=\"margin-left:100px\"> Type in Quantity: </a><br/>");
out.println("<form action=\"addCart?prid=" +prid + "\" method=\"post\"> ");
out.println("<input type=\"number\"required maxlength=\"3\" name=\"quantity\" id=\"quantity\" style=\"margin-left:100px\">");
out.println("<input type=\"submit\" id=\"cart\" name=\"cart\" value=\"Add to Cart\" ></form></div><br/><br/> <h3 align=\"center\"> Accessories</h3>");
}			 
//Accessories Carousel			 

out.println("<div align=\"center\"><div class=\"container\" > ");
  out.println("<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">");
    out.println("<ol class=\"carousel-indicators\">");
      out.println("<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>");
      out.println("<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>");
      out.println("<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>");
    out.println("</ol>");
    out.println("<div class=\"carousel-inner\">");
      out.println("<div class=\"item active\">");
        out.println("<img src=\"template/images/" + Accessories + "\" alt=\"macpro\" style=\"width:35%;height:200;\">");
      out.println("</div>");
	   out.println("</div>");

     out.println("<div class=\"item\"><a href=\"ProductServlet\">");
        out.println("<img src=\"template/images/accessories.jpg\" alt=\"skull\" style=\"width:100%;height:400;\"></a>");
		out.println("<div class=\"carousel-caption\">");
         out.println("<h3>Accessories</h3>");
		out.println("</div>");
      out.println("</div>");
  /*  
out.println("      <div class=\"item\"><a href=\"ProductServlet\">");
        out.println("<img src=\"template/images/wd.jpg\" alt=\"wd\" style=\"width:100%;height:400;\"></a>");
		out.println("<div class=\"carousel-caption\">");
         out.println("<a href=\"ProductServlet\"> <h3>WD-My Passport </h3></a>");
		out.println("</div>");*/
      out.println("</div>");
    out.println("</div>");

			
			 
		} catch (ParserConfigurationException | SAXException | IOException e) {
		}
		out.println(footer);
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
