import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.servlet.*;
import javax.servlet.http.*;

import org.xml.sax.SAXException;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.sql.*;



public class LoadData extends HttpServlet {


    protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
			XMLParserSAX xml = new XMLParserSAX();
			String map = xml.processReq();
			String parts[] = map.split("=");
			int nw=1;
			String s = null;
			MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
			boolean check = mysql.checkData();
			if (check==false){
		while (nw < parts.length){
			s= parts[nw];
		s = s.replaceAll("\\w+$", "").trim();
		s = s.substring(0, s.length() - 1);
		s = s.replaceAll(",", "','");
		s= "'" + s + "'";
		mysql.InsertUser(s);
		out.print(s + "<br/>");
		nw=nw+1;
		}
		  

		/*java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Select * from cars  order by carPrice*1 desc limit 9");
			ResultSet rst;
			rst = pst.executeQuery();
			ArrayList<String> cars = new ArrayList<>();
			//ArrayList<Car> cars=new ArrayList<Car>();
			out.println("asfer");
			while(rst.next())
			{	
				String id = Integer.toString(rst.getInt("carId"));
				String carReservationStatus = Integer.toString(rst.getInt("carReservationStatus"));
				//Car car = new Car(id+rst.getString("carName"));
				out.println(""+rst.getString("carName") + rst.getString("carCategory")+rst.getString("carBrandName")+rst.getString("carMileage")+rst.getString("carModel")+rst.getString("carProductionYear")+rst.getString("carColor")+rst.getString("carImagePath")+rst.getString("carPrice")+carReservationStatus);
				cars.add(id);
				cars.add(rst.getString("carName"));
				cars.add(rst.getString("carCategory"));
				cars.add(rst.getString("carBrandName"));
				cars.add(rst.getString("carMileage"));
				cars.add(rst.getString("carModel"));
				cars.add(rst.getString("carProductionYear"));
				cars.add(rst.getString("carColor"));
				cars.add(rst.getString("carImagePath"));
				cars.add(rst.getString("carPrice"));				
				cars.add(carReservationStatus);
				//cars.add(car);
			}
			request.setAttribute("carslist",cars);
			
			conn.close();

			//RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
			//rd.forward(request,response);

		}
		catch(Exception e)
		{
			out.println(e);
		}
		*/	}
		response.sendRedirect("home.jsp?check=done");
		//	request.setAttribute("check","done");
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
