
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class RegisterServlet extends HttpServlet {

	
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		showPage(response, "Welcome");
	}  
	
    protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
		
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
		Utilities utility = new Utilities();
		String header = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
		String footer = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
		String LeftNav = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");		
        out.println(header);
		out.println("<form action=\"DataStoreServlet\" method=\"post\"> ");
out.println(" <table align=\"center\"><b>");
out.println("<br/><br/><tr><td></td></tr> ");
out.println("<tr><td><input type=\"text\"required onkeypress=\"return onlyAlphabets()\" placeholder=\"First Name\" name=\"First\" maxlength=\"19\">");
out.println("<input type=\"text\"required  placeholder=\"Last Name\" name=\"Last\" maxlength=\"19\"></td></tr> ");
out.println("<tr><td><input id=\"username\"required  placeholder=\"Username\" type=\"text\" name=\"username\" maxlength=\"10\">");
out.println("<input type=\"password\"required placeholder=\"Password\" pattern=\".{6,}\" title=\"Password must have atleast 6 characters\" name=\"password\"  maxlength=\"32\"><div id=\"status\"></div></td></tr> ");
out.println("<tr><td><input type=\"text\"required placeholder=\"Address Line1\"  name=\"AL1\" maxlength=\"49\">");
out.println("<input type=\"text\"required  placeholder=\"Address Line2\"  name=\"AL2\" maxlength=\"49\">  </td></tr> ");
out.println("<tr><td><input type=\"text\"required placeholder=\"City\" name=\"City\" maxlength=\"19\">");
out.println("<tr><td><input type=\"text\"required placeholder=\"Zip\"  name=\"Zip\"  pattern=\".{5,}\" title=\"XXXXX - Invalid Zip\" maxlength=\"5\" >");
out.println("<input type=\"email\"required placeholder=\"EmailID\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\" title=\"abc@xyz.com\" name=\"EmailID\" id=\"EmailID\" maxlength=\"49\">");
out.println("</td></tr>");
out.println("<tr><td><input type=\"text\"required placeholder=\"Phone\"  name=\"Phone\"  pattern=\".{10,}\" title=\"XXXXXXXXXX - Phone must be 10 Digit\"  maxlength=\"10\" onkeypress=\"return onlyNumbers()\">");
out.println("<input type=\"text\"  placeholder=\"AlternatePhone\"  pattern=\".{10,}\" title=\"XXXXXXXXXX - Phone must be 10 Digit\"  name=\"ALPhone\"  maxlength=\"10\"></td></tr> ");
out.println("<tr><td><input type=\"submit\" id=\"submit\" value=\"SignUp\"></td></tr> ");
out.println("</table></form>");
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
