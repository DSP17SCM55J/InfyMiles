import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ViewCarServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();    

		java.sql.Statement stm = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/InfyMiles", "root", "root");
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			PreparedStatement pst = conn.prepareStatement("Select * from cars  order by carPrice*1 desc limit 9");
			ResultSet rst;
			rst = pst.executeQuery();
			ArrayList<Car> cars=new ArrayList<Car>();
			while(rst.next())
			{	
				String id = Integer.toString(rst.getInt("carId"));
				String carReservationStatus = Integer.toString(rst.getInt("carReservationStatus"));
				Car car = new Car(id,rst.getString("carName"),rst.getString("carCategory"),rst.getString("carBrandName"),rst.getString("carMileage"),rst.getString("carModel"),rst.getString("carProductionYear"),rst.getString("carColor"),rst.getString("carImagePath"),rst.getString("carPrice"),carReservationStatus);

				cars.add(car);
			}
			req.setAttribute("carslist",cars);
			conn.close();

			RequestDispatcher rd=req.getRequestDispatcher("/home.jsp");
			rd.forward(req,res);

		}
		catch(Exception e)
		{
			out.println(e);
		}
	}
}