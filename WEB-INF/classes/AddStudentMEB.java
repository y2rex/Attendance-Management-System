import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddStudentMEB extends HttpServlet
{
 
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
   PrintWriter pw=res.getWriter();
   pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
   pw.println("<body><CENTER><div class='container'>");
   
    String s1=req.getParameter("roll");
    String s2=req.getParameter("uname");
    String s3=req.getParameter("sem");
	String s4=req.getParameter("mbl");
    String s5=req.getParameter("att");
    String s6="edit";
    String s7="remove";	
	int i=0;
	try
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_management_system","root","rat");
         String query="insert into attendance_sheet_ME values(?,?,?,?,?,?,?)";
		 
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1, s1);
	     ps.setString(2, s2);
         ps.setString(3, s3);
		 ps.setString(4, s4);
	     ps.setString(5, s5);	
         ps.setString(6, s6);
	     ps.setString(7, s7);		 
		 i=ps.executeUpdate();
    }
	
	catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  if(i !=0)
		  {
		  pw.println("<h1>Student details added successfully...</h1>");
		  pw.println("<br><a href='FacultyMEB'>BACK</a>");
		   }
		   else
		   {
		   pw.println("<h1><font color='red'> failed!!!</font></h1>");
		   pw.println("<br><a href='../StudentRegistrationMEB.html'>Retry</a>");
		   }

		   pw.println("</CENTER></body></html>");
	 
		   }
   }
