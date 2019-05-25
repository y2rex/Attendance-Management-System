import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class FacultyEditStudentDetails extends HttpServlet 
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
   PrintWriter pw=res.getWriter();   
   String sname=" ", semester=" ",mobile_no=" ",attendance=" ";  
   
   pw.println("<html><head><style>");

pw.println("table {font-family: arial, sans-serif;border-collapse: collapse;width: 50%;}");
pw.println("td, th {border: 1px solid #dddddd;text-align: left;padding: 12px;}");
pw.println("tr:nth-child(even) {background-color: #dddddd;}");
pw.println("</style>");
pw.println("</head>");
pw.println("<body><center>"); 
	   
   String s1=req.getParameter("id1");  
   System.out.println(s1);
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
		  		  

pw.println("<br><br><br><br><br><table>");
pw.println("<form method=post>");
  pw.println("<tr><th>Roll Number is</th><td><input type='text' name='roll_no' value="+s1+" disabled></td></tr>");
  
  pw.println("<tr><th>Enter new Name</th><td><input type='text' name='NewName' value="+sname+" autocomplete='off' reruired></td></tr>");
  
  pw.println("<tr><th>Enter new Semester</th><td><input type='text' name='NewSem' value="+semester+" autocomplete='off' reruired></td></tr>");
  
  pw.println("<tr><th>Enter new Mobile Number</th><td><input type='text' name='NewNumber' value="+mobile_no+" autocomplete='off' reruired></td></tr>");

  pw.println("<tr><th>Enter Current Attendnace</th><td><input type='text' name='NewAttendance' value="+attendance+" autocomplete='off' reruired></td></tr>");
  
    pw.println("<tr><td colspan='2' text-align: center> <input type=submit></td></tr> </form></table>");

pw.println("</center></body>");
pw.println("</html>");
   }
   
   
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
	   PrintWriter pw=res.getWriter();
	   String s1=req.getParameter("id1"); 
	   HttpSession session=req.getSession();
	   int id=Integer.parseInt((String)session.getAttribute("k"));
	   System.out.println(id);
	   
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
		  
		  if(i!=0)
		  {
           res.sendRedirect("FacultyAttendanceListA?pageno=1");
          }
   else
           res.sendRedirect("../Error.html");	
   }
  }