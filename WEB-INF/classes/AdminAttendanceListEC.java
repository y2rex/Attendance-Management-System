import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class AdminAttendanceListEC extends HttpServlet
{
 Connection con;
 Statement stmt;
 
  public AdminAttendanceListEC()
  {
   super();
  }
 
 public void init() throws ServletException
 {
 try
	{
		 Class.forName("com.mysql.jdbc.Driver");
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_management_system","root","rat");
		 stmt=con.createStatement(1005,1007);
     }
	 catch(Exception e)
	 {
	  e.printStackTrace();	  
	 }
  }
 
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
    PrintWriter pw= res.getWriter();
    HttpSession session=req.getSession(false);
	if(session!=null)
   {
			int pageNumber=0;
			int totalNumberOfRecord=0;
			int recordPerPage=12;
			int startIndex=0;
			int numberOfPages=0;
			
			/*
			read pageNumber parameter warp it into integer store it in pageNumber variable	
			*/
			
			String sPageNo=req.getParameter("pageno");
			pageNumber=Integer.parseInt(sPageNo);
			try
			{
			/*
			try starting point to display the records select from employees table
			move the cursor to starting point use loop and display employees on browser (5 employees)	
			*/
			startIndex=(pageNumber*recordPerPage)-recordPerPage+1;
			ResultSet rs1=stmt.executeQuery("select * from attendance_sheet_ec order by roll_no asc");
			
			
			        pw.println("<html><head><style>");
					pw.println("table {font-family: arial, sans-serif;border-collapse: collapse;width: 80%;}");
					pw.println("td, th {border: 2px solid #53c68c;text-align: left;padding: 8px;}");
					pw.println("tr:nth-child(even) {background-color: #dddddd;}");
					pw.println("</style>");
					pw.println("</head>");
			        pw.println("<body style='background-color:#b3ffff;'><center>");	 
					pw.println("<table>");
						pw.println("<caption style='font-size:200%;font-family:verdana;color:blue;'>ALL STUDENT LIST</caption>");
					    pw.println("<tr>");
							 pw.println("<th>ROLL NO</th>");
						     pw.println("<th>NAME</th>");
						     pw.println("<th>SEMESTER</th>");
						     pw.println("<th>MOBILE NUMBER</th>");
						     pw.println("<th>ATTENDANCE</th>");
							 pw.println("<th>EDIT</th>");
							 pw.println("<th>REMOVE</th>");
					     pw.println("</tr>");
					 
					rs1.absolute(startIndex);
					int i=0;
					do
					{
					 i++;
					    String s1 = rs1.getString(1);
						String s2 = rs1.getString(2);
						String s3 = rs1.getString(3);
						String s4 = rs1.getString(4);
						String s5 = rs1.getString(5);
					
						 pw.println("<tr>");
							  pw.println("<td>"+s1+"</td>");
							  pw.println("<td>"+s2+"</td>");
							  pw.println("<td>"+s3+"</td>");
							  pw.println("<td>"+s4+"</td>");
							  pw.println("<td>"+s5+"</td>");
							  pw.println("<td><a href=AdminEditStudentDetailsCSE?id1="+s1+">Edit</a></td>");
							  pw.println("<td><a href=DeleteStudentCSE?id="+s1+">Remove</a></td>");
						 pw.println("</tr>");	
						 
					 }while(rs1.next()&& i!=recordPerPage);
					  pw.println("/<table>");
					  rs1.close();
					  
					  /*
					       find the number of recorde in employee table and store it into totalNumberOfRecord variable
					  */
					 ResultSet rs2=stmt.executeQuery("select count(*) from attendance_sheet_ec");
					 rs2.next();
					 totalNumberOfRecord=rs2.getInt(1);
					 rs2.close();
					 
					 /*
					  find number of pages if total number of records is not exactly divisible then increment the number of page by 1
					 */
					 numberOfPages=totalNumberOfRecord/recordPerPage;
					 if(totalNumberOfRecord > numberOfPages*recordPerPage)
					 {
					 numberOfPages=numberOfPages+1;
					 }
					 pw.println("</center><br>");
					 //displaying hyperlink for each pages
					 for(int k=1;k<=numberOfPages;k++)
					 {
					 pw.print("<a href=AdminAttendanceListEC?pageno="+k+" style='font-size:100%;font-family:verdana;color:blue;'>"+k+"</a>&nbsp&nbsp&nbsp");
					 }
				   pw.print("<br><br><br><a href=AdminEC style='font-size:120%;font-family:verdana;color: #000033;'>HOME PAGE</a>&nbsp&nbsp");
				   pw.println("</body>");
				   pw.println("</html>");			 
			   }
			    catch(Exception e)
			    {
				 e.printStackTrace();
			     }	
	}
	else
		{
		res.sendRedirect("../Error.html");
		 
		 }
}	
	public void distroy()
	{
		try
		{
		stmt.close();
		con.close();
		 }
		 catch(Exception e)
		 {
		 e.printStackTrace();
		 }
	}
  }