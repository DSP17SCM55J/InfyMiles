
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

public class ProductStoreServlet extends HttpServlet {

	
	

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    */
    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		
		
		 
		showPage(response, request,  "Welcome");
	}  
	
    protected void showPage(HttpServletResponse response, HttpServletRequest request, String message)
    throws ServletException, java.io.IOException {
		//PrintWriter out = response.getWriter();
		
				File file = new File("C:\\apache-tomcat-7.0.34\\webapps\\csj\\WEB-INF\\classes\\ProductCatalog.xml");
		File temp = File.createTempFile("file", ".txt", file.getParentFile());
		String charset = "UTF-8";
		String delete = "</ProductCatalog>";
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
		
		for (String line; (line = reader.readLine()) != null;) {
            line = line.replace(delete, "");
			writer.println(line);
			}
		reader.close();
		writer.close();
		file.delete();
		temp.renameTo(file);
		String pid = request.getParameter("pid");
		String type = request.getParameter("type");
		String pname = request.getParameter("pname");
		String pprice = request.getParameter("pprice");
		String img = request.getParameter("img");
		String manu = request.getParameter("manu");
		String cond = request.getParameter("cond");
		String disc = request.getParameter("disc");
		String acc = request.getParameter("acc");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	//	PrintWriter pw = new PrintWriter(new File("C:/apache-tomcat-7.0.34/webapps/csj/data/customers.txt"));
		FileWriter fw = new FileWriter("C:\\apache-tomcat-7.0.34\\webapps\\csj\\WEB-INF\\classes\\ProductCatalog.xml", true);
		BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
		/*StringBuilder sb = new StringBuilder();
		sb.append(usern);
        sb.append(',');
        sb.append(passw);
		pw.write(sb.toString());*/
		pw.println("<Product id=\"" + pid + "\">" +
"<type>" + type + "</type>" +
"<name>" + pname + "</name>" +
"<price>" + pprice +"</price>" +
"<image>" + img + "</image>" +
"<manufacturer>" + manu + "</manufacturer>" +
"<condition>" + cond + "</condition>" +
"<discount>" + disc + "</discount>" +
"<accessories><accessory>" + acc + "</accessory></accessories></Product></ProductCatalog>");




        pw.close();
		

		
		
		out.println("<h6> Product added Successfully</h6>");
		Utilities utility = new Utilities();
		String header = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
		String footer = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
		String LeftNav = utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");		
        out.println(header);
		
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
