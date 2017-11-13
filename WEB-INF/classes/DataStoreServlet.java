
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;


import javax.servlet.RequestDispatcher;

public class DataStoreServlet extends HttpServlet {

	
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		showPage(response, request,  "Welcome");
	}  
	
    protected void showPage(HttpServletResponse response, HttpServletRequest request, String message)
    throws ServletException, java.io.IOException {
		
		
		String usern = request.getParameter("username");
		String passw = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		Utilities utility = new Utilities();
		String header = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
		String footer = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
		String LeftNav = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");		
        out.println(header);
		MySQLDataStoreUtilities mysql = new MySQLDataStoreUtilities();
		boolean res = mysql.LoginStore(usern.trim(),passw.trim());
		if (res)
		out.println("<h3> Registration Successful<h3>");
		else 
		out.println("<h3> Registration not Successful<h3>");
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
