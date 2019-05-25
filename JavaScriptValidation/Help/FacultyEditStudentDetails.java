import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class FacultyEditStudentDetails extends HttpServlet 
 {
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
   { 
    PrintWriter pw=res.getWriter();   
    String sname="", semester="",mobile_no="",attendance="";  
/*
	pw.println("<html><head>");
	pw.println("<title></title><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
	pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
	pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script>");
	pw.println("</head>");
	pw.println("<body>"); 
	 */  
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
		  
		  pw.println("<html><head><title></title><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head><body><div class='container'><br><h1 class='text-center text-success'> Student Edit Page </h1><br><div class=' col-lg-8 m-auto d-block'><form class='bg-light' method='post' onsubmit=' return validation()'><div class='form-group'><label> Rollno: </label><input type='text' name='roll' id='roll1' class='form-control' value="+s1+" autocomplete='off'><span id='roll2' class='text-danger font-weight-bold'> </span></div><div class='form-group'><label> Name: </label><input type='text' name='uname' id='uname1' class='form-control' value="+sname+" autocomplete='off'><span id='uname2' class='text-danger font-weight-bold'> </span></div><div class='form-group'><label> Semester: </label><input type='text' name='sem' id='sem1' class='form-control' value="+semester+" autocomplete='off'><span id='sem2' class='text-danger font-weight-bold'>  </span></div><div class='form-group'><label> Mobile Number: </label><input type='text' name='mbl' id='mbl1' class='form-control' value="+mobile_no+" autocomplete='off'><span id='mbl2' class='text-danger font-weight-bold'></span></div><div class='form-group'><label> Attendance : </label><input type='text' name='att' id='att1' class='form-control' value="+attendance+" autocomplete='off'><span id='att2' class='text-danger font-weight-bold'> </span></div><input type='submit' name='submit' value='Submit' class='btn btn-success'></form></div></div><script type='text/javascript'>function validation(){document.getElementById('roll1').disabled = true;}</script></body></html>");
		  	/*	  				  
				pw.println("<div class='container'><br>");
				pw.println("<h1 class='text-center text-success'> Student Edit Page </h1><br>");
				pw.println("<div class=' col-lg-8 m-auto d-block'><form class='bg-light' method='post' onsubmit=' return validation()'>");
				
				pw.println("<div class='form-group'><label> Rollno: </label><input type='text' name='roll' id='roll1' class='form-control' value="+s1+" autocomplete='off'><span id='roll2' class='text-danger font-weight-bold'> </span></div>");
				pw.println("<div class='form-group'><label> Name: </label><input type='text' name='uname' id='uname1' class='form-control' value="+sname+" autocomplete='off'><span id='uname2' class='text-danger font-weight-bold'> </span></div>");
				pw.println("<div class='form-group'><label> Semester: </label><input type='text' name='sem' id='sem1' class='form-control' value="+semester+" autocomplete='off'><span id='sem2' class='text-danger font-weight-bold'>  </span></div>");
				pw.println("<div class='form-group'><label> Mobile Number: </label><input type='text' name='mbl' id='mbl1' class='form-control' value="+mobile_no+" autocomplete='off'><span id='mbl2' class='text-danger font-weight-bold'> </span></div>");
				pw.println("<div class='form-group'><label> Attendance : </label><input type='text' name='att' id='att1' class='form-control' value="+attendance+" autocomplete='off'><span id='att2' class='text-danger font-weight-bold'> </span></div>");				
				pw.println("<input type='submit' name='submit' value='Submit' class='btn btn-success'></form></div></div>");
pw.println("<script type='text/javascript'>function validation(){document.getElementById('roll1').disabled = true;}</script>");
pw.println("</body></html>");				  
				  */
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
			pw.println("<a href='FacultyAttendanceList'>BACK</a>");
   pw.println("</center>");
   pw.println("</body>");
   pw.println("</html>");
   }
  }