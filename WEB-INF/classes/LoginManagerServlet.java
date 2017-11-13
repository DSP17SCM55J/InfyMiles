
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class LoginManagerServlet extends HttpServlet {
   
    /** 
     * Creating Hashmap using customer data
    */  
	


Map<String, String> map = new HashMap<String, String>();
	
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
			BufferedReader in = null;
	try {
		
		in = new BufferedReader(new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/data/manager.txt"));
	
	} catch (FileNotFoundException F) {
	}
	
	String line = "";
	try {
	while ((line = in.readLine()) != null) {
	   String parts[] = line.split(",");
	   map.put(parts[0], parts[1]);
	}
	}
	catch (IOException io) {
	}
	try {
	in.close();
	} catch (IOException io) {
	}
		
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
		
        if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
        if(userid != null &&
            password != null) {
                String realpassword = (String)map.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", userid);
					String redirectURL = "/csj/AddProductServlet";
					response.sendRedirect(redirectURL);
					
                } else {
                    showPage(response, "Login Failure! Username or password is incorrect");
                }
        }  else {
            showPage(response, "Login Failure!  You must supply a username and password");
        }
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
