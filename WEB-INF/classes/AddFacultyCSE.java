import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddFacultyCSE extends HttpServlet
{ 
 public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
    PrintWriter pw=res.getWriter();
    pw.println("<html>");
    pw.println("<body bgcolor='green'><center>");   
    String s1=req.getParameter("uname");
    String s2=req.getParameter("pass");
    String s3=req.getParameter("user");
	String s4="remove";
	String s5=req.getParameter("branch");
	String s6=req.getParameter("section");
	System.out.println(s1+":::"+s2+":::"+s3+":::"+s4+":::"+s5+":::"+s6);
	int i=0;
	try
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_management_system","root","rat");
         String query="insert into login values (?,?,?,?,?,?)";		 
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1, s1);
	     ps.setString(2, s2);
         ps.setString(3, s3); 
         ps.setString(4,s4);
			ps.setString(5,s5);
			ps.setString(6,s6);		 
		 i=ps.executeUpdate();
    }	
	catch(Exception e)
		  {
			  e.printStackTrace();
		  }		  
		  if(i !=0)
		  {
		   pw.println("<h1>Registration done!!!</h1>");
		   pw.println("<br><a href='AdminCSE'>Home PAge</a>");
		   }
		   else
		   {
		   pw.println("<h1><font color='red'>Error...!!</font></h1>");
		   pw.println("<br><a href=../AddfacultyCSE.html>Registration</a>");
		   }
		   pw.println(" </center></body></html>");	 
		   }
}