import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Admin extends HttpServlet
{
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		   PrintWriter pw=res.getWriter();  
		   HttpSession session=req.getSession(false);	
		   
		   pw.println("<html>");
		   pw.println("<body bgcolor='yellow'>");
		   pw.println("<center>");
		   if(session!=null)
		   {
		   pw.println("<h1>Admin page</h1>");
		   pw.println("<Welcome "+session.getAttribute("un"));
		   pw.println("<br><br><br><br><a href=AdminAttendanceList?pageno=1>Students attendance sheet</a>");
		   pw.println("<br><a href=../Addfaculty.html>Add faculty</a>");
		   pw.println("<br><a href=RemoveFaculty>Remove faculty</a>");	
		   pw.println("<br><a href=ShortAttendanceList?pageno=1><i>Short attendance list</i></a>");
		    pw.println("<br><br><br><br><br><br><br><br><a href=LogoutServlet>Logout</a>");
           }	
        else
		{
		  res.sendRedirect("../Error.html");
		 
		 }		   
		   pw.println("</center></body></html>");
		   pw.close();
	   }  
}