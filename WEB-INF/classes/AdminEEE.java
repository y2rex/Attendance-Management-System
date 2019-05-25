import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminEEE extends HttpServlet
{
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		   PrintWriter pw=res.getWriter();  
		   HttpSession session=req.getSession(false);	
		   
		  pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		   {
		   pw.println("<h1>Admin page</h1>");
		    pw.println("<br><br><br><br><a href=AdminAttendanceListEEE?pageno=1>Students attendance sheet</a>");
		   pw.println("<a href=../ShortAttendanceAdminEEE.html><h6>Attendance Report </h6></a><br><br>");
		   pw.println("<a href=../StudentRegistrationEEE.html><h6>Add Student</h6></a><br><br>");
		   pw.println("<br><a href=../AddfacultyEEE.html>Add faculty</a>");
		   pw.println("<br><a href=RemoveFacultyEEE>Remove faculty</a>");	
		    pw.println("<br><br><br><br><br><a href=LogoutServlet>Logout</a>");
           }	
        else
		{
		  res.sendRedirect("../Error.html");
		 
		 }		   
		   pw.println("</center></body></html>");
		   pw.close();
	   }  
}