import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AdminEC extends HttpServlet
{
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		   PrintWriter pw=res.getWriter();  
		   HttpSession session=req.getSession(false);	
		   
		  pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i></i> to CSE branch</i> </h1><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		   {
		   pw.println("<h1>Admin page</h1>");
		   pw.println("<Welcome "+session.getAttribute("un"));
		   pw.println("<br><br><br><br><a href=AdminAttendanceListEC?pageno=1>Students attendance sheet</a>");
		   pw.println("<a href=../ShortAttendanceAdminEC.html><h6>Attendance Report </h6></a><br><br>");
		   pw.println("<a href=../StudentRegistrationEC.html><h6>Add Student</h6></a><br><br>");
		   pw.println("<br><a href=../AddfacultyEC.html>Add faculty</a>");
		   pw.println("<br><a href=RemoveFacultyEC>Remove faculty</a>");	
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