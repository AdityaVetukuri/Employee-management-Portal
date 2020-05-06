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

@WebServlet("/employeeServlet")
public class employeeServlet extends HttpServlet{
	public String firstName;
	public String middleinit;
	public String lastName;
	public String ssn;
	public String dob;
	public String address;
	public String gender;
	public float salary;
	public String superssn;
	public int depnum;
	public String email;
	public int project_num1;
	public int project_num2;
	public int project_num3;
	public int project_hours1;
	public int project_hours2;
	public int project_hours3;
	public String checkboxvalue;
	public String dependent_name;
	public String dependent_gender;
	public String dependent_dob;
	public String dependent_relation;
	public int[] projects = new int[3];
	public int[] hours    = new int[3];
	String getName()
	{
		return firstName;
	}
	public void setFirstName(String firstName, HttpServletRequest request)
	{
		this.firstName = request.getParameter("firstname");
	}
	
	String getMiddleInitial()
	{
		return middleinit;
	}
	
	public void setMiddleint(String middleinit, HttpServletRequest request)
	{
		this.middleinit = request.getParameter("middleinitial");
		
	}
	String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName, HttpServletRequest request)
	{
		this.lastName = request.getParameter("lastname");
		
	}
	
	String getSsn()
	{
		return ssn;
	}
	
	public void setSsn(String ssn, HttpServletRequest request)
	{
		this.ssn = request.getParameter("ssn");
	}
	
	String getDob()
	{
		return dob;
	}
	public void setDob(String dob, HttpServletRequest request)
	{
		this.dob = request.getParameter("dob");
	}
	public void setAddress(String address, HttpServletRequest request)
	{
		this.address = request.getParameter("address");
	}
	
	String getAddress()
	{
		return address;
	}
	public void setGender(String gender,HttpServletRequest request)
	{
		this.gender = request.getParameter("gender");
	}
	String getGender()
	{
		return gender;
	}
	float getSalary()
	{
		return salary;
	}
	public void setSalary(float salary,HttpServletRequest request)
	{
		this.salary = Float.parseFloat(request.getParameter("salary"));
	}
	String getSuperssn()
	{
		return superssn;
	}
	public void setSuperssn(String superssn,HttpServletRequest request)
	{
		this.superssn = request.getParameter("superssn");
	}
	int getDepnum()
	{
		return depnum;
	}
	public void setDepnum(int depnum,HttpServletRequest request)
	{
		this.depnum = Integer.parseInt(request.getParameter("departmentnumber"));
	}
	String getEmail()
	{
		return email;
	}
	public void setEmail(String email,HttpServletRequest request)
	{
		this.email = request.getParameter("email");
	}
	public void setProject1(int project1, HttpServletRequest request)
	{
		if(request.getParameter("project1")!="")
		{
		this.projects[0] = Integer.parseInt(request.getParameter("project1"));
		}
		
	}
	int getProject1()
	{
		return projects[0];
	}
	public void setProject2(int project2, HttpServletRequest request)
	{
		if(request.getParameter("project2")!="")
		{
			this.projects[1] = Integer.parseInt(request.getParameter("project2"));
		}
		
	}
	int getProject2()
	{
		return projects[1];
	}
	int getProject3()
	{
		return projects[2];
	}
	public void setProject3(int project3, HttpServletRequest request)
	{
		
		if(request.getParameter("project3")!="")
		{
		this.projects[2] = Integer.parseInt(request.getParameter("project3"));
		}
	}
	
	public void setHours1(int hours1, HttpServletRequest request)
	
	{
		if(request.getParameter("hours1")!="")
		{
		this.hours[0] = Integer.parseInt(request.getParameter("hours1"));
		}
	}
	public void setHours2(int hours2, HttpServletRequest request)
	{
		if(request.getParameter("hours2")!="")
		{
		this.hours[1] = Integer.parseInt(request.getParameter("hours2"));
		}
	}
	public void setHours3(int hours3, HttpServletRequest request)
	{
		if(request.getParameter("hours3")!="")
		{
		this.hours[2] = Integer.parseInt(request.getParameter("hours3"));
		}
	}
	
	public void setDependentName(String dependent_name, HttpServletRequest request)
	{
		this.dependent_name = request.getParameter("depname");;
	}
	String getDependentName()
	{
		return dependent_name;
	}
	public void setDependentDob(String dependent_dob,HttpServletRequest request)
	{
		this.dependent_dob =  request.getParameter("dob"); 
	}
	String getDependentdob()
	{
		return dependent_dob;
	}
	public void setDependentGender(String dependent_gender,HttpServletRequest request)
	{
		this.dependent_gender = request.getParameter("depgender"); 
	}
	String getDependentRelation()
	{
		return dependent_relation;
	}
	public void setDependentRelation(String dependent_relation,HttpServletRequest request)
	{
		this.dependent_relation = request.getParameter("deprelation"); 
	}
		

	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
	{
		setFirstName(firstName,request);
		setMiddleint(middleinit,request);
		setLastName(lastName, request);
		setSsn(ssn,request);
		setDob(dob, request);
		setAddress(address,request);
		setGender(gender,request);
		setSalary(salary,request);
		setSuperssn(superssn, request);
		setDepnum(depnum,request);
		setEmail(email,request);
		setProject1(projects[0],request);
		setProject2(projects[1],request);
		setProject3(projects[2],request);
		setHours1(hours[0],request);
		setHours2(hours[1],request);
		setHours3(hours[2],request);
		
		
		 if(request.getParameter("dependent") != null)
		 {
		  checkboxvalue = request.getParameter("dependent");
		 setDependentName(dependent_name,request);
		 setDependentGender(gender,request);
		 setDependentDob(dependent_dob,request);
		 setDependentRelation(dependent_relation,request);
		 }
			
		try {
	 		Class.forName("oracle.jdbc.OracleDriver"); 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu","avetukur","loobysha");
			if (con != null) {
                System.out.println("Conneted to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
			PreparedStatement ps = null;
			ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, firstName);
			ps.setString(2, middleinit);
			ps.setString(3, lastName);
			ps.setString(4, ssn);
			ps.setString(5, dob);
			ps.setString(6, address);
			ps.setString(7, gender);
			ps.setFloat(8, salary);
			ps.setString(9, superssn);
			ps.setInt(10, depnum);
			ps.setString(11, email);
			ps.execute();
			
			if(hours[0] + hours[1] + hours[2] <= 40)
			{
			for(int i = 0; i < projects.length; i++)
			{
			PreparedStatement ps2 = null;
			ps2 = con.prepareStatement("INSERT INTO works_on VALUES (?, ?, ?)");
			ps2.setString(1, ssn);
			if(projects[i]!=0 && hours[i]!=0)
			{
			ps2.setInt(2, projects[i]);
			ps2.setFloat(3, hours[i]);
			
			ps2.execute();
			}
			}
			
			 if(request.getParameter("dependent") != null)
			 {
			PreparedStatement ps3 = null;
			ps3 = con.prepareStatement("INSERT INTO dependent VALUES (?,?,?,?,?)");
			ps3.setString(1, ssn);
			ps3.setString(2, dependent_name);
			ps3.setString(3, dependent_gender);
			ps3.setString(4, dependent_dob);
			ps3.setString(5, dependent_relation);
			ps3.execute();
			 }
		
			
			HttpSession session = request.getSession();
			
		
			
			session.setAttribute("firstname", firstName);
			session.setAttribute("lastname", lastName);
			session.setAttribute("ssn", ssn);
			session.setAttribute("email", email);
			session.setAttribute("dob", dob);
			session.setAttribute("address", address);
			session.setAttribute("sex", gender);
			session.setAttribute("salary", salary);
			session.setAttribute("superssn", superssn);
			session.setAttribute("departmentnum", depnum);
			
			session.setAttribute("checkboxvalue", checkboxvalue);
			
			if(request.getParameter("dependent") != null)
			{
			
			session.setAttribute("dependentname", dependent_name);
			session.setAttribute("dependentgender", dependent_gender);
			session.setAttribute("dependentdob", dependent_dob);
			session.setAttribute("dependentrelation",dependent_relation);
			}
			
			
			session.setAttribute("project1", projects[0]);
			session.setAttribute("project2", projects[1]);
			session.setAttribute("project3", projects[2]);
			
			session.setAttribute("hours1", hours[0]);
			session.setAttribute("hours2", hours[1]);
			session.setAttribute("hours3", hours[2]);
			
			
			
			
			
			
			response.sendRedirect("feedback.jsp");
			
			
			
			
			
			
			
			}
			
			
		
			else
			{
				HttpSession session = request.getSession();
				response.sendRedirect("error.html");
				
		        
			}
			
			
			
					
		
	}
		
		
		
		catch (SQLException e) {
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}	

}
}
