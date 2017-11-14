
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class LoginServlet extends HttpServlet{
	int usersearch=0;
	//ArrayList<Pojo_user> list = new ArrayList<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    	String emailId = request.getParameter("emailId");
    	String password = request.getParameter("password");
    	String role = request.getParameter("role");

    	

    	MySqlDataStoreUtilities msdsu = new MySqlDataStoreUtilities();
    	//list = msdsu.selectUser();
    	boolean check = msdsu.checkUser(emailId,password,role);
       
      PrintWriter out = response.getWriter();
     //String filePath = "../webapps/csj/Users/Pojo_user.txt";

       if(check==true){
        response.sendRedirect("home.jsp");
        
       }
       else{
        out.println("U r not registered");
       }

       HttpSession session = request.getSession();      
       
       response.setContentType("text/html");
   }
}