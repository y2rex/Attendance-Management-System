import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FacultyECA extends HttpServlet
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
			pw.println("<br><br><br><a href=FacultyAttendanceListECA?pageno=1>Attendance list</a><br><br>");
			pw.println("<br><br><a href=../StudentRegistrationECA.html>Add Student</a><br><br>");
			pw.println("<br><br><br><a href=../ShortAttendanceListFacultyECA.html><i>Short attendance list</i></a>");
			
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