import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class AllUser extends HttpServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
   {
	     PrintWriter pw= res.getWriter();
	     pw.println("<html>");
	     pw.println("<center><h1>All users list</h1><br><br>");
		 pw.println("<br> <table border=1 px solid black>");
	     pw.println("<tr>");
			 pw.println("<th>UserID</th>");
		     pw.println("<th>UserType</th>");
		     pw.println("<th>Remove</th>");
	     pw.println("</tr>");
	     try 
		 {
			Connection con=DBInfo.con;
			String str ="select * from login";
			PreparedStatement ps =con.prepareStatement(str);
						
			 ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String s1 = rs.getString(1);
				String s2 = rs.getString(3);
				String s3 = rs.getString(4);
				pw.println("<tr>");
					pw.println("<td>"+s1+"</td>");
					pw.println("<td>"+s2+"</td>");
					pw.println("<td><a href=DeleteValues?id="+s1+">remove</a></td>");
				pw.println("</tr>");		
			 }
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		 }		
	   pw.println("</table>");
	   
	   pw.println("<br><a href='../AddFaculty.html'>Add User</a><br><br>");
	   
	   pw.println("<br><a href='Admin'>BACK</a><br><br>");
	   pw.println("</center>");
	   pw.println("</body>");
	   pw.println("</html>");
	}


  }
  