
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class CarListservlet extends HttpServlet {

  protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String locarr[] = location.split(",");
		out.println(request.getParameter("location") + request.getParameter("date"));
		
		
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
