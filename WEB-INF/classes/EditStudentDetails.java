import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditStudentDetails extends HttpServlet 
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw=res.getWriter();   
   String sname="", semester="",mobile_no="",attendance="";  
	   pw.println("<html>");
	   pw.println("<head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><scrpt src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
	   pw.println("<body>");
	   
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
			 System.out.println(sname+":::"+semester+":::"+mobile_no+":::"+attendance);		 
	    }
		
		catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  		  
   pw.println("<div class='container'><br>");
   pw.println("<h1 class='text-center text-success'> Student Registration </h1><br>");
   pw.println("<div class='col-lg-8 m-auto d-block'>");
   pw.println("<form class='bg-light' method='post'>");
   pw.println("<div class='form-group'><label> Roll No: </label><input type='text' name='roll_no' value="+s1+" disable></div>");
    
	     pw.println("<div class='form-group'><label> Enter New Name : </label><input type='text' name='NewName' value="+sname+"></div>");
	
	     pw.println("<div class='form-group'><label> Enter New Semester : </label><input type='text' name='NewSem' value="+semester+"></div>");
	   
	     pw.println("<div class='form-group'><label> Enter New Mobile No : </label><input type='text' name='NewNumber' value="+mobile_no+"></div>");
		 
		 pw.println("<div class='form-group'><label> Enter Current Attendance :</label><input type='text' name='NewAttendance' value="+attendance+"></div>");
  
   pw.println("<input type='submit' name='submit' value='Submit' class='btn btn-success'>");
   pw.println("</form></div></div></body></html>");
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
	   
       System.out.println(s2+":::"+s3+"::::"+s4+":::"+s5);
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
   pw.println("<body bgcolor='yellow' >");
   pw.println("<center><h1>Updated successfully!!!</h1>");
			pw.println("<a href='AdminAttendanceList'>BACK</a>");
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }