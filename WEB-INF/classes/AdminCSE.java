import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AdminCSE extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);
		String s1=(String)session.getAttribute("un");	
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i>"+s1+"</i> to CSE branch</i> </h1><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		{
			pw.println("<center><br><br><br><a href=AdminAttendanceListCSE?pageno=1><h6>Attendance list</h6></a><br><br>");
			pw.println("<a href=../ShortAttendanceAdminCSE.html><h6>Attendance Report </h6></a><br><br>");
			pw.println("<a href=../StudentRegistrationCSE.html><h6>Add Student</h6></a><br><br>");
			
		    pw.println("<a href=../AddfacultyCSE.html><h6>Add faculty</h6></a><br><br>");
			   pw.println("<a href=../SearchStudent.html><h6>Search</h6></a><br><br>");
		    pw.println("<a href=RemoveFacultyCSE><h6>Remove faculty</h6></a>");	
			pw.println("<hr></center><br><a href=LogoutServlet><h3><i>Logout</i></h3></a><br><hr>");
			pw.println("</div></div>");
		}
		else
		{
		  res.sendRedirect("../Error.html");	 
		 }
		pw.println("</body>");
		pw.println("</html>");
	}
}