import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class RemoveFaculty extends HttpServlet
{
 
 public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
   {
	     PrintWriter pw= res.getWriter();
	     pw.println("<html>");
	     pw.println("<center><h1>Faculty list</h1><br><br>");
		 pw.println("<br> <table border=1 px solid black>");
	     pw.println("<tr>");
		 pw.println("<th>UserId</th>");
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
				String s2 = rs.getString(4);
			
				pw.println("<tr>");
					pw.println("<td>"+s1+"</td>");
					pw.println("<td><a href=DeleteValues?id="+s1+">Remove</a></td>");
				pw.println("</tr>");		
			  }
			}
		   catch(Exception e)
			{
			  e.printStackTrace();
			}
		
	   pw.println("</table>");
	   pw.println("<br><a href=Admin>BACK</a>");
	   pw.println("</center>");
	   pw.println("</body>");
	   pw.println("</html>");
	}


  }
  