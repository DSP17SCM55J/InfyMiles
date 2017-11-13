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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.xml.sax.SAXException;
import java.util.Map;
import java.util.HashMap;

public class addCart extends HttpServlet {

	
	Map<Integer, String> map = new HashMap<Integer, String>();
	Map<String, Integer> newmap = new HashMap<String, Integer>();
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("username")!=null)
		showPage(response, "Welcome   ",request.getParameter("prid"), (String) session.getAttribute("username"), request.getParameter("quantity"),request.getParameter("page"));
		else 
		showPage(response, "Welcome  to Smart Portables", request.getParameter("prid"),null,null,null); 
    }     
	
    protected void showPage(HttpServletResponse response, String message, String prodid , String uname, String qty,String page)
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
out.println("<li><a href=\"HomeServlet?log=out\">Logout</a></li>");
}else {
out.println("<li><a href=\"login.html\">Login</a></li>");
out.println("<li><a href=\"RegisterServlet\">Register</a></li>");
}
out.println("      </ul>");
out.println("    </div>");
out.println("  </div>");
out.println(" </nav>");
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
		if(prodid!=null || qty!=null){
		int x = 0;
		int y = 0;
		int count = 0;
		
		while(x < partsmap.length){
			  // System.out.println(partsmap[x]);
			   map.put(x, partsmap[x]);
			   if(partsmap[x].equals(prodid) && count == 0){
				   y = x;
			   		count = 5;
			   		}
			   x++;
			}
			out.println(y);
		 
		 
		 
		 
		 String prid = (String)map.get(y+20);
		 FileWriter fw = new FileWriter("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
		/*StringBuilder sb = new StringBuilder();
		sb.append(usern);
        sb.append(',');
        sb.append(passw);
		pw.write(sb.toString());*/
		pw.println(prodid + "," + qty);
        pw.close();
		/*************************************************************************************/
				BufferedReader bfin = null;
	try {
		bfin = new BufferedReader(new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt"));
	} catch (FileNotFoundException F) {
	}
	String bfline = "";

	//System.out.println(newmap.get("smartwatch"));

		int bfy = 0;
		int bfcount = 0;
		  int counter=1;
		String bfparts[] = null;
		String bfmapparts[] = null;
		while ((bfline = bfin.readLine()) != null) {
			   bfparts = bfline.split(",");
			   int pa = Integer.parseInt(bfparts[1]);
			 
		//	  System.out.println(pa);
				int bfx = 0;
				newmap.put(bfparts[0],pa);
				}
		String mapstring = newmap.toString();
		String newsplit[] = mapstring.split(",");
		int strcnt = 0;
		String w = null;
		
		while(strcnt< newsplit.length){
			if (strcnt==0)
				w= newsplit[0].substring(1,newsplit[0].length()).trim() + "\n";
			else if(strcnt==newsplit.length-1)
				w = w + newsplit[strcnt].substring(0, newsplit[strcnt].length()-1).trim() + "\n";
			else w = w + newsplit[strcnt].trim() + "\n";
			w = w.replaceAll("=", ",");
			strcnt++;
		}
		bfin.close();
		
	/*FileWriter fwnew = new FileWriter("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt",true);
			BufferedWriter bwnew = new BufferedWriter(fwnew);
	        PrintWriter pwnew = new PrintWriter(bwnew);
			pwnew.print(w);
	        pwnew.close();*/
			PrintWriter pwnew = new PrintWriter(new File("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt"));
			StringBuilder sb = new StringBuilder();
			sb.append(w);
			pwnew.write(sb.toString());
			pwnew.close();
		}
			
			if(page!=null){
				
				File src = new File("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt");
		File target = new File("C:/apache-tomcat-7.0.34/webapps/csj/data/orders.txt");
		Files.copy(src.toPath(),target.toPath(),StandardCopyOption.REPLACE_EXISTING);
		response.sendRedirect("ProcessOrderServlet");
			}
		else{
	/*****************************************************************************************/
	out.println("<div class=\"container\"><input type=\"button\" value=\"Check Out\" id=\"check\" name=\"check\" onclick=\"window.location.href='CheckoutServlet'\"/>");
		BufferedReader bfinnew = null;
	try {
		bfinnew = new BufferedReader(new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/data/cart.txt"));
	} catch (FileNotFoundException F) {
	}
	String bflinenew = "";

	//System.out.println(newmap.get("smartwatch"));

		int bfynew = 0;
		int bfcountnew = 0;
		  int counternew=1;
		String bfpartsnew[] = null;
		
			while ((bflinenew = bfinnew.readLine()) != null) {
				   bfpartsnew = bflinenew.split(",");
				 
				 
					int bfxnew = 0;
					
				  while(bfxnew < partsmap.length){
			   if(partsmap[bfxnew].equals(bfpartsnew[0].trim()) && bfcountnew<counternew){
				     bfynew = bfxnew;
				    bfcountnew++;
				    
					 String productid = (String)map.get(bfynew);
				     String pname = (String)map.get(bfynew+2);
					 String pprice = (String)map.get(bfynew+4);
					 String img = (String)map.get(bfynew+3);
					 String manu = (String)map.get(bfynew+5);
					 String condition = (String)map.get(bfynew+6);
					 String discount = (String)map.get(bfynew+7);
					 String Accessories = (String)map.get(bfynew+8);
					 int quant = Integer.parseInt(bfpartsnew[1].trim());
					 Double totprice =  Double.parseDouble(pprice.substring(1));
					 Double amt = quant*totprice;
					 
					 MySQLDataStoreUtilities mysqlsm = new MySQLDataStoreUtilities();
					 mysqlsm.InsertCart(productid,pname,pprice,img,manu,condition,discount,Accessories,quant);
					 
					 if(amt>0){
out.println("<table border=\"1\">");
		out.println("<col width=\"300\">");
  out.println("<col width=\"200\"><col width=\"200\"><col width=\"200\"><col width=\"200\">");
		out.println("<tr>");
  out.println("<th></th>");
    out.println("<th>Quantity</th>");
    out.println("<th>Amount</th>");
  out.println("</tr>");
  out.println("<tr><td>");
out.println("<img width=\"200\" height = \"200\" src=\"template/images/" + img + "\" />");
out.println("<center><p>" + pname + "</center></td>");
out.println("<td><center><font size=\"5\"><b><p>" + quant +"</p></b></font></center></td>");
out.println("<td><center><font size=\"5\"><b><p>$" + amt +"</p></b></font></center></td>");
out.println("<td><center><input type=\"button\" id=\"cartbutton" + pname + "\" name=\"cartbutton" + pname + "\" value=\"Update\" onclick=\"window.location.href='ProdDetailServlet?id=" + productid + "'\"/></center></td>");				     
//out.println("<td><center><input type=\"button\" value=\"Check Out\" id=\"check\" name=\"check\" onclick=\"window.location.href='CheckoutServlet?id=prod'\"/></");
					 }
				     }
			   
			  			    
			   bfxnew++;
			}
			
	   		counternew++;
			}
		
		 bfinnew.close();

		//out.println(footer);

		}
		} catch (ParserConfigurationException | SAXException | IOException |NullPointerException e ) {
			out.println("<h3>Cart is EMPTY </h3>");
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
