import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
 
public class LogoutServlet extends HttpServlet
 {  
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{  
        PrintWriter pw=res.getWriter();
        HttpSession session=req.getSession(false);
        session.invalidate();
		res.sendRedirect("../Logout.html");
		pw.close();
    }  
}