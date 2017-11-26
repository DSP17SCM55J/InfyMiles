import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.logging.*;
import java.util.*;

public class AutoCompleteServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String model = request.getParameter("searchId");
		String action = request.getParameter("action");	
		PrintWriter out = response.getWriter();
		//out.println(model+"..."+action);

	    try {
			StringBuffer sb = new StringBuffer(); 
			boolean namesAdded = false;
			if (action.equals("complete")) 
			{
				if (!model.equals(""))
				{
					AjaxUtility util = new AjaxUtility();
					
					sb = util.readData(model);
					
					if(sb!=null || !sb.equals(""))
					{
						namesAdded=true;
					}
					if (namesAdded)
					{
						response.setContentType("text/xml");
						response.getWriter().write("<Car>" + sb.toString() + "</Car>"); 
					}
				}
		        
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}




/*import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Iterator;


public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
    
    

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
    }

    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) 
            {
            	
            	AjaxUtility a = new AjaxUtility();
            	sb=a.readData(targetId);
            	System.out.println(sb);
            	if(sb!=null || !sb.equals(""))
            	{
            		namesAdded=true;
            		System.out.println(namesAdded);
            	}
            	
              
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }
        System.out.println(action);
        if (action.equals("lookup")) {

            // put the target composer in the request scope to display 
            if ((targetId != null) ) {
                context.setAttribute("tId",targetId);
                context.getRequestDispatcher("/pdp").forward(request, response);
            }
        }
    }
}
*/