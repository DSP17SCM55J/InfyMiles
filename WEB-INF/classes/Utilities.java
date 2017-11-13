import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class Utilities extends HttpServlet{
	
public String printHtml(String file) throws IOException {
String result = HtmlToString(file);
return result;
}

private String HtmlToString(String file) {
	
	String key = "";
	{
	    FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
		}
	    BufferedReader reader = new BufferedReader(fr);
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
	return key;
}
}