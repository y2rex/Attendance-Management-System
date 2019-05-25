import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class FacultyCSEA extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw=res.getWriter();
        HttpSession session=req.getSession(false);
  

			
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		{
		    String s1=(String)session.getAttribute("un");
			pw.println("<center><br><br><br><a href=FacultyAttendanceListA?pageno=1><h5>Attendance list<h5></a><br>");
			pw.println("<br><a href=../StudentRegistrationA.html><h5>Add Student<h5></a><br>");
			pw.println("<br><a href=../ShortAttendanceListFacultyA.html><h5>Short attendance list<h5></a></center>");
			pw.println("<br><br><hr><br><a href=LogoutServlet><h3><i>Logout</i></h3></a><br><hr>");
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