
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OracleDriver;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
	protected String Username;
	public String managerfname;
 	public String managerlname;
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		 	String ssn = request.getParameter("ssn");
		 	
		 	
		 	System.out.println(ssn);
		 	try {
		 		Class.forName("oracle.jdbc.OracleDriver"); 
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","avetukur","loobysha");
				if (con != null) {
	                System.out.println("Connected to the database!");
	            } else {
	                System.out.println("Failed to make connection!");
	            }
				
				String query = "SELECT FNAME,LNAME from employee e, department d WHERE e.ssn ="+ssn+" and d.mgrssn ="+ssn+"";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if(rs.next() == false)
				{
					System.out.println("Not a manager");
					
					
					
						PrintWriter writer = response.getWriter();
				        String htmlResponse = "<html>";
				        htmlResponse += "<h2>" + ssn + " is not a Manager<br/>";         
				        htmlResponse += "</html>";
				        htmlResponse += "<button onclick=\"window.location.href='index.html'\"> HOME </button>";
				        writer.println(htmlResponse);	
					
				}
				else
				{
					
					
						String managerfname = rs.getNString("FNAME");
						String managerlname = rs.getNString("LNAME");
						System.out.println(managerfname);
						System.out.println(managerlname);
						
					
					HttpSession session = request.getSession();
					session.setAttribute("managerfname",managerfname);
					session.setAttribute("managerlname", managerlname);
					  
					response.sendRedirect("manager.jsp");
				}
				con.close();
        // code to process the form...
		 	}
		 			 	
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
}
	public String setName(String Name)
	{
		this.Username = Name;
		return Username;
	}
	
}
