import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import java.util.Map;

public class XMLParserSAX extends HttpServlet {

   public void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        
        
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("C:\\apache-tomcat-7.0.34\\webapps\\csj\\WEB-INF\\classes\\ProductCatalog.xml"), handler);
        //Get Employees list
        Map<String, Product> prodList = handler.getprodList();
        //print employee information
		java.io.PrintWriter out = response.getWriter();
		out.println(prodList);
		out.close();
    } catch (ParserConfigurationException | SAXException | IOException e) {
    }
    }
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processReq(request, response);
		  
    } 
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
         processReq(request, response);
    }
	

}