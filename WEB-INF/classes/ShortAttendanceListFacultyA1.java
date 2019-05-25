import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class ShortAttendanceListFacultyA1 extends HttpServlet
{
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);
		String ll=req.getParameter("ll");
	    String ul=req.getParameter("ul");
		     session.setAttribute("ll",ll);
			 session.setAttribute("ul",ul);
			 System.out.println(ul+"::"+ll);
			 
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		if(session!=null)
		{
			pw.println("<br><br><br><br><a href=ShortAttendanceListFacultyA?pageno=1>Get details</a>");
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