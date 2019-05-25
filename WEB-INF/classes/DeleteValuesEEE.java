import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteValuesEEE extends HttpServlet
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw=res.getWriter();
   
   pw.println("<html>");
   
   String i=req.getParameter("id");
   
   pw.println("<body bgcolor='magenda'>");
   pw.println("<center>");
   pw.println("<b1>Delete page</b1>");
   
   
   int flag=0;
   try
	{
	 	 Connection con=DBInfo.con;
         String query="delete from login where userid=?";
		 PreparedStatement ps=con.prepareStatement(query);		 
	     ps.setString(1,i);
		 flag=ps.executeUpdate();
    }
	
	catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  
	if(flag!=0)
    {
	pw.println("<h1>Record deleted!!!!</h1>");
	}
    else
    {
     pw.println("<h1><font color='red'>NO record deleted!!!</font></h1>");
	}	
   pw.println("Remove successful...");	
   pw.println("<br><a href=RemoveFacultyEEE>BACK</a>");
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }