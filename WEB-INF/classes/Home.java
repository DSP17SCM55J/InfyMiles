

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;


public class Home extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
header(response);
LeftNav(response);
footer(response);
headerFooterLeftNav(response);
}

public static void header(HttpServletResponse response) throws IOException {
	String key = "";
		{
		    FileReader file = null;
			try {
				file = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader = new BufferedReader(file);
		    String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
			}
		    while (line != null) {
		        key += line;
		        try {
					line = reader.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
		java.io.PrintWriter pw = response.getWriter();
        pw.println(key);
pw.close();		
}


public static void footer(HttpServletResponse response) throws IOException{
	String key = "";
		{
		    FileReader file = null;
			try {
				file = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader = new BufferedReader(file);
		    String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
			}
		    while (line != null) {
		        key += line;
		        try {
					line = reader.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
		java.io.PrintWriter pw = response.getWriter();
        pw.println(key);
pw.close();	
}


public static void LeftNav(HttpServletResponse response) throws IOException{
	String key = "";
		{
		    FileReader file = null;
			try {
				file = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader = new BufferedReader(file);
		    String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
			}
		    while (line != null) {
		        key += line;
		        try {
					line = reader.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
		java.io.PrintWriter pw = response.getWriter();
        pw.println(key);
		pw.close();	
}


public static void headerFooterLeftNav(HttpServletResponse response) throws IOException {
	String key = "";
		{
		    FileReader file = null;
			try {
				file = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/Header.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader = new BufferedReader(file);
		    String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
			}
		    while (line != null) {
		        key += line;
		        try {
					line = reader.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
		
		String key1 = "";
		{
		    FileReader file1 = null;
			try {
				file1 = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/LeftNav.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader1 = new BufferedReader(file1);
		    String line1 = null;
			try {
				line1 = reader1.readLine();
			} catch (IOException e) {
			}
		    while (line1 != null) {
		        key1 += line1;
		        try {
					line1 = reader1.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
		
		String key2 = "";
		{
		    FileReader file2 = null;
			try {
				file2 = new FileReader("C:/apache-tomcat-7.0.34/webapps/csj/Footer.html");
			} catch (FileNotFoundException e1) {
			}
		    BufferedReader reader2 = new BufferedReader(file2);
		    String line2 = null;
			try {
				line2 = reader2.readLine();
			} catch (IOException e) {
			}
		    while (line2 != null) {
		        key2 += line2;
		        try {
					line2 = reader2.readLine();
				} catch (IOException io) {
				}
		    }
		
		}
			java.io.PrintWriter pw = response.getWriter();
        pw.println(key + key1 + key2);
		pw.close();	
}

}