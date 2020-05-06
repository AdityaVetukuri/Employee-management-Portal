import javax.servlet.annotation.WebServlet;


import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleDriver;
@WebServlet("/reportServlet")
public class reportServlet extends HttpServlet{
	protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
	{
		try {
	 		Class.forName("oracle.jdbc.OracleDriver"); 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","avetukur","loobysha");
			if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			String query = "SELECT *from employee";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int n = rs.getFetchSize()+2;
			ResultSet[] rs_array = new ResultSet[20];
			
			HttpSession session = request.getSession();
			ArrayList<String> fname = new ArrayList<String>();
			ArrayList<String> lname = new ArrayList<String>();
			ArrayList<String> ssns = new ArrayList<String>();
			ArrayList<String> emails = new ArrayList<String>();
			ArrayList<String> bdays = new ArrayList<String>();
			ArrayList<String> address = new ArrayList<String>();
			ArrayList<String> sex = new ArrayList<String>();
			ArrayList <Float> salaries = new ArrayList<Float>();
			ArrayList<String> superssns = new ArrayList<String>();
			
			while(rs.next())
			{
				fname.add(rs.getNString("FNAME"));
				lname.add(rs.getNString("LNAME"));
				ssns.add(rs.getNString("SSN"));
				bdays.add(rs.getNString("BDATE"));
				address.add(rs.getNString("ADDRESS"));
				sex.add(rs.getNString("SEX"));
				salaries.add(rs.getFloat("SALARY"));
				superssns.add(rs.getNString("SUPERSSN"));
				
			
				if(rs.getNString("EMAIL") != null)
				{
				emails.add(rs.getNString("EMAIL"));
				}
				else
				{
					emails.add("null");
				}
				
			}
			
			session.setAttribute("fnames", fname);
			session.setAttribute("lnames", lname);
			session.setAttribute("ssns", ssns);
			session.setAttribute("emails", emails);
			session.setAttribute("bdays", bdays);
			session.setAttribute("address", address);
			session.setAttribute("sex", sex);
			session.setAttribute("salaries", salaries);
			session.setAttribute("superssns", superssns);
			session.setAttribute("number", n);
			response.sendRedirect("report.jsp");
			
			
			
			
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
