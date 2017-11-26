import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class DealMatches extends HttpServlet{

public void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
	response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
	Map<Integer,String> map = new HashMap<Integer,String>();
	MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
	map = mysql.SelectProducts();
	String key = "";
	
	//out.println(map);
	    FileReader fr = null;
		try {
			fr = new FileReader("C:\\apache-tomcat-7.0.34\\webapps\\csj\\DealMatches.txt");
		} catch (FileNotFoundException e1) {
		}
	    BufferedReader reader = new BufferedReader(fr);
	    String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
		}
		int cnt=0;
		out.print("<h3>We beat our competitors in all aspects. Price-Match Guaranteed</h3>");
		out.println("<br/><br/>");
	    while (line != null) {
			int i=0;
	        while(i<map.size()){
				if(line.toLowerCase().contains(map.get(i+2).toLowerCase()) && cnt<2){
					//out.println("Matched");
					out.println("<div style='float: left;padding-right:20px;padding-left:20px;border:1px solid'><h5>"+ line +"</h5><br/>");
					out.println("<h4><center>Deal Matches</center><h4>");
					out.println("<center><a href=\"ProdDetailServlet?id=" + map.get(i) + "\" ><img src=\"data/images/" + map.get(i+8)  + "\" " + "width=\"300\" " + "height = \"200\"" + "style=\"margin-left:50px;margin-top:50px\"  /></a></center>");
					out.println("<center><p style=\"margin-left:50px;margin-top:50px\">" + map.get(i+1)  + "</p><p style=\"margin-left:50px\"> Price: " + map.get(i+9)  + "</p></center></div>");
					cnt++;
				}
			i=i+12;
			}
			line = reader.readLine();
			
	    }
		
		if (cnt==0){
			out.println("<h4>No Offers</h4><br/>");
			out.println("<h3>Deal Matches<h3><br/>");
			out.println("<h4>No Deal Matches<h4><br/>");
					
		}
	//return key;
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