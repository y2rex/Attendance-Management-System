import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateValues extends HttpServlet  //akash folder
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw=res.getWriter();   
   String un="", pass="",ut="";  
   pw.println("<html>");
   pw.println("<body bgcolor='#3333ff'>");
   pw.println("<center>");
   pw.println("<b1>Update page</b1>");
 
   String s1=req.getParameter("id");  
   try
	{
	 	 Connection con=DBInfo.con;
         String query="select * from login where id=?";
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1,s1);
		 ResultSet rs=ps.executeQuery();
		 rs.next();
		 
		 un=rs.getString(2);
		 pass=rs.getString(3);
		 ut=rs.getString(4); 
		 System.out.println(un+":::"+pass+"::::"+ut);
		 
    }
	
	catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  		  
   pw.println("<form method=post>");
   pw.println("<br>Username is<input type='text' name='fname' value="+un+" disabled>");
   pw.println("<br>Enter new password<input type='password' name='pass' value="+pass+">");
   pw.println("<br>Enter new email<input type='text' name='usertype'  value="+ut+">");  
   pw.println("<input type=submit>");
   pw.println("</form></center></body></html>");
   }
   
   
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
	   PrintWriter pw=res.getWriter();
	   String s1=req.getParameter("id"); 
	  
	   pw.println("<html>");
	   pw.println("<body bgcolor='cyan'>");
	   pw.println("<center>");
	  // String s1=req.getParameter("fname");
	   String s2=req.getParameter("pass");
	   String s3=req.getParameter("usertype");
	   
       System.out.println(s1+":::"+s2+"::::"+s3);
       String query="update login set password=?,usertype=? where id=?";
       int i=0;  
       try
	     {
	 	 Connection con=DBInfo.con;
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1,s2);
         ps.setString(2,s3);
		 ps.setString(3,s1);
		 i=ps.executeUpdate();
         }
	
	     catch(Exception e)
		 {
			  e.printStackTrace();
		 }
		  
   pw.println("<html>");
   pw.println("<body bgcolor='yellow' >");
   pw.println("<center><h1>Updated successfully!!!</h1>");
   pw.println("<a href='ViewAll'>BACK</a>");
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }