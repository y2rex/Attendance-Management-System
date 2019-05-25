import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewStudent extends HttpServlet
{
 
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
     PrintWriter pw= res.getWriter();
     pw.println("<html>");
     pw.println("<center><h1>All students list</h1><br><br>");
	 pw.println("<br> <table border=1 px solid black>");
     pw.println("<tr>");
	 pw.println("<th>Roll_No</th>");
     pw.println("<th>Sname</th>");
     pw.println("<th>semester</th>");
     pw.println("<th>mobile no</th>");
     pw.println("<th>attendance</th>");
     pw.println("</tr>");
     try {
		Connection con=DBInfo.con;
		String str ="select * from admin";
		PreparedStatement ps =con.prepareStatement(str);
		
		
		 ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		String s1 = rs.getString(1);
		String s2 = rs.getString(2);
		String s3 = rs.getString(3);
		String s4 = rs.getString(4);
		String s5 = rs.getString(5);
		String s6 = rs.getString(6);
		pw.println("<tr>");
		pw.println("<td>"+s1+"</td>");
		pw.println("<td>"+s2+"</td>");
		pw.println("<td>"+s3+"</td>");
		pw.println("<td>"+s4+"</td>");
		pw.println("<td>"+s5+"</td>");
		//pw.println("<td><a href=DeleteValues?id="+s1+">Remove</a></td>");
		pw.println("</tr>");
		
		}
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
	
   pw.println("</table>");

pw.println("<br><br>");
 pw.println("<form method='post'>");
   pw.println("<input type='submit' value='short Attendance list'></form>");	   
   
   
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
	}

public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw= res.getWriter();
     pw.println("<html>");
     pw.println("<center><h1>Short Attendance students list</h1><br><br>");
	 pw.println("<br> <table border=1 px solid black>");
     pw.println("<tr>");
	 pw.println("<th>Roll_No</th>");
     pw.println("<th>attendance</th>");
     pw.println("</tr>");
     try {
		Connection con=DBInfo.con;
		String str ="select * from short_attendance_list";
		PreparedStatement ps =con.prepareStatement(str);
		
		
		 ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
		String s1 = rs.getString(1);
		String s2 = rs.getString(2);

		pw.println("<tr>");
		pw.println("<td>"+s1+"</td>");
		pw.println("<td>"+s2+"</td>");
		pw.println("</tr>");
		
		}
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
	
     pw.println("</table>");
   
     pw.println("<br><a href='../AddFaculty.html'>Send Message</a>");
   
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }
  