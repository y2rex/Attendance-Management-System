import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AdminEditStudentDetailsCSE extends HttpServlet 
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw=res.getWriter();   
   String sname="", semester="",mobile_no="",attendance="";  
	   pw.println("<html>");
	   pw.println("<body bgcolor='#3333ff'>");
	   pw.println("<center>");
	   pw.println("<b1>Update page</b1>");
 
   String s1=req.getParameter("id1");  
	   try
		{
		 	 Connection con=DBInfo.con;
	         String query="select * from attendance_sheet where roll_no=?";
			 PreparedStatement ps=con.prepareStatement(query);
		     ps.setString(1,s1);
			 ResultSet rs=ps.executeQuery();
			 rs.next();
			 
			 sname=rs.getString(2);
			 semester=rs.getString(3);
			 mobile_no=rs.getString(4); 
			 attendance=rs.getString(5); 
			 System.out.println(s1+":::"+sname+":::"+semester+":::"+mobile_no+":::"+attendance);		 
	    }
		
		catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  		  
   pw.println("<form method=post>");
	   pw.println("<br>Roll Number is<input type='text' name='roll_no' value="+s1+" disabled>");
	   pw.println("<br><br><br>Enter new Name<input type='text' name='NewName' value="+sname+">");
	   pw.println("<br><br><br>Enter new Semester<input type='text' name='NewSem' value="+semester+">");
	   pw.println("<br><br><br>Enter new Mobile Number<input type='text' name='NewNumber' value="+mobile_no+">");
	   pw.println("<br><br><br>Enter Current Attendnace<input type='text' name='NewAttendance' value="+attendance+">");
   pw.println("<br><br><input type=submit>");
   pw.println("</form></center></body></html>");
   }
   
   
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
	   PrintWriter pw=res.getWriter();
	   String s1=req.getParameter("id1"); 
	  
	   pw.println("<html>");
	   pw.println("<body bgcolor='cyan'>");
	   pw.println("<center>");
	  // String s1=req.getParameter("fname");
	   String s2=req.getParameter("NewName");
	   String s3=req.getParameter("NewSem");
	   String s4=req.getParameter("NewNumber");
	   String s5=req.getParameter("NewAttendance");
	   
       System.out.println(s1+":::"+s2+":::"+s3+"::::"+s4+":::"+s5);
       String query="update attendance_sheet set sname=?,semester=?,mobile_no=?,attendance=? where roll_no=?";
       int i=0;  
       try
	     {
	 	 Connection con=DBInfo.con;
		 PreparedStatement ps=con.prepareStatement(query);
		     ps.setString(1,s2);
	         ps.setString(2,s3);
			 ps.setString(3,s4);
			 ps.setString(4,s5);
			 ps.setString(5,s1);
		 i=ps.executeUpdate();
         }
	
	     catch(Exception e)
		 {
			  e.printStackTrace();
		 }
		  
   pw.println("<html>");
   pw.println("<body bgcolor='#3333ff'>");
   pw.println("<center><h1>Updated successfully!!!</h1>");
			pw.println("<a href='AdminAttendanceListCSE?pageno=1'>BACK</a>");
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }