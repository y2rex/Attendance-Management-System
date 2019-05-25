import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class SearchStudent extends HttpServlet
{ 
 public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
    PrintWriter pw= res.getWriter();
	String str=(String)req.getParameter("text");
	System.out.println(str);
	     pw.println("<html>");
	     pw.println("<center><h1>Student Details</h1><br><br>");
		 pw.println("<br> <table border=1 px solid black>");
	     pw.println("<tr>");
		 pw.println("<th>Roll_No</th>");
	     pw.println("<th>Sname</th>");
	     pw.println("<th>semester</th>");
	     pw.println("<th>mobile no</th>");
	     pw.println("<th>attendance</th>");
	     pw.println("</tr>");
	     try 
		 {
	
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_management_system","root","rat");
         String query="select roll_no,sname,semester,mobile_no,attendance from attendance_sheet_cse where roll_no=?";		 
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1, str);	 
		 
		  ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String s1 = rs.getString(1);
				String s2 = rs.getString(2);
				String s3 = rs.getString(3);
				String s4 = rs.getString(4);
				String s5 = rs.getString(5);
				System.out.println(s1+":::"+s2+":::"+s3+":::"+s4+":::"+s5);
				pw.println("<tr>");
				pw.println("<td>"+s1+"</td>");
				pw.println("<td>"+s2+"</td>");
				pw.println("<td>"+s3+"</td>");
				pw.println("<td>"+s4+"</td>");
				pw.println("<td>"+s5+"</td>");
				pw.println("</tr>");		
			 }
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		 }		
	   
	   pw.println("</table>");
	   pw.println("</center>");
	   pw.println("</body>");
	   pw.println("</html>");
	}


  }
  