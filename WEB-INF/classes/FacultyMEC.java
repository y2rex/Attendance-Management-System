import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FacultyMEC extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);	
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i></i> to CSE branch</i> </h1><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		{
		String s1=(String)session.getAttribute("un");
			pw.println("<br><br><br><a href=FacultyAttendanceListMEC?pageno=1>Attendance list</a><br><br>");
			pw.println("<br><br><a href=../StudentRegistrationMEC.html>Add Student</a><br><br>");
			pw.println("<br><br><br><a href=../ShortAttendanceListFacultyMEC.html><i>Short attendance list</i></a>");
			//pw.println("<br><br><a href=SentMessage>Message</a>");
			pw.println("<br><br><br><br><a href=LogoutServlet>Logout</a>");
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