import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ShortAttendanceStudentsList extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);
			System.out.println("Hello...");
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		{
		pw.println("<form class='bg-light' method='post'>");
        pw.println("<div class='form-group'>");
					pw.println("<hr><label> Branch : </label><span></span>");
					pw.println("<select name='branch'>");
						  pw.println("<option value='a'>CSE</option>");
						  pw.println("<option value='b'>EC</option>");
						  pw.println("<option value='c'>EEE</option>");
						    pw.println("<option value='d'>ME</option>");
						   pw.println(" </select></div>");
						  
					    pw.println("<hr><label> Section : </label><span></span>");
					    pw.println("<select name='section'>");
						  pw.println("<option value='aa'>A</option>");
						  pw.println("<option value='bb'>B</option>");
						  pw.println("<option value='cc'>C</option>");
			       pw.println(" </select></div>	");
				   
				pw.println("<hr><input type='submit' name='submit' value='Submit' class='btn btn-success'>");
			pw.println("</form></div></div>");
		}
		else
		{
		  res.sendRedirect("../Error.html");	 
		 }
		pw.println("</body>");
		pw.println("</html>");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
   { 
	    PrintWriter pw=res.getWriter();
	    String s1=req.getParameter("section");
	    String s2=req.getParameter("branch");
	     HttpSession session=req.getSession();	   
	   
	                pw.println("<html><head><style>");
					pw.println("table {font-family: arial, sans-serif;border-collapse: collapse;width: 80%;}");
					pw.println("td, th {border: 2px solid #53c68c;text-align: left;padding: 8px;}");
					pw.println("tr:nth-child(even) {background-color: #dddddd;}");
					pw.println("</style>");
					pw.println("</head>");
			        pw.println("<body style='background-color:#b3ffff;'><center>");	
					
					pw.println("<table border=1 px solid black>");
						pw.println("<caption style='font-size:200%;font-family:verdana;color:blue;'>ALL STUDENT LIST</caption>");
					    pw.println("<tr>");
							 pw.println("<th>ROLL NO</th>");
						     pw.println("<th>NAME</th>");
						     pw.println("<th>ATTENDANCE</th>");
					    pw.println("</tr>");

   if(s2.equalsIgnoreCase("cse"))
		{
				  if(s1.equalsIgnoreCase("a"))
				  {
				    	try
							{ 
							     Connection con=DBInfo.con;
								 String query="select * from short_attendance_cse where where roll_no between '14egjcs001' and '14egjcs050' ;";
								 PreparedStatement ps=con.prepareStatement(query);		 
								 ResultSet rs=ps.executeQuery();
								 
								 while(rs.next())
									{
										String str1 = rs.getString(1);
										String str2 = rs.getString(2);
										String str3 = rs.getString(3);
										
										pw.println("<tr>");
										pw.println("<td>"+str1+"</td>");
										pw.println("<td>"+str2+"</td>");
										pw.println("<td>"+str3+"</td>");
										pw.println("</tr>");
						                pw.println("</table></body></html>");				
									 }
							 }
								 
							catch(Exception e)
							{
								e.printStackTrace();
							}
					}		
				    
					else if(s1.equalsIgnoreCase("b"))
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_cse where where roll_no between '14egjcs051' and '14egjcs100' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
						     catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }
						   
				    else 
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_cse where where roll_no between '14egjcs101' and '14egjcs150' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
					    catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }			  
				  
		}
		
	    else if(s2.equalsIgnoreCase("ec"))
		{
				  if(s1.equalsIgnoreCase("a"))
				  {
				    	try
							{ 
							     Connection con=DBInfo.con;
								 String query="select * from short_attendance_ec where where roll_no between '14egjcs001' and '14egjcs050' ;";
								 PreparedStatement ps=con.prepareStatement(query);		 
								 ResultSet rs=ps.executeQuery();
							 }
								 
							catch(Exception e)
							{
								e.printStackTrace();
							}
					}		
				    
					else if(s1.equalsIgnoreCase("b"))
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_ec where where roll_no between '14egjcs051' and '14egjcs100' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
						catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }
						   
				    else 
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_ec where where roll_no between '14egjcs101' and '14egjcs150' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
					    catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }			  
				  
		}	
		
		
		
		else if(s2.equalsIgnoreCase("eee"))
		{
				  if(s1.equalsIgnoreCase("a"))
				  {
				    	try
							{ 
							     Connection con=DBInfo.con;
								 String query="select * from short_attendance_eee where where roll_no between '14egjcs001' and '14egjcs050' ;";
								 PreparedStatement ps=con.prepareStatement(query);		 
								 ResultSet rs=ps.executeQuery();
							 }
								 
							catch(Exception e)
							{
								e.printStackTrace();
							}
					}		
				    
					else if(s1.equalsIgnoreCase("b"))
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_eee where where roll_no between '14egjcs051' and '14egjcs100' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
						catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }
					   
				    else 
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_eee where where roll_no between '14egjcs101' and '14egjcs150' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
					    catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }			  
				  
		}
		
		
	 else
		{
				  if(s1.equalsIgnoreCase("a"))
				  {
				    	try
							{ 
							     Connection con=DBInfo.con;
								 String query="select * from short_attendance_me where where roll_no between '14egjcs001' and '14egjcs050' ;";
								 PreparedStatement ps=con.prepareStatement(query);		 
								 ResultSet rs=ps.executeQuery();
							 }
								 
							catch(Exception e)
							{
								e.printStackTrace();
							}
					}		
				    
					else if(s1.equalsIgnoreCase("b"))
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_me where where roll_no between '14egjcs051' and '14egjcs100' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
						catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }
						   
				    else 
					{
						 try
							{ 
									     Connection con=DBInfo.con;
										 String query="select * from short_attendance_me where where roll_no between '14egjcs101' and '14egjcs150' ;";
										 PreparedStatement ps=con.prepareStatement(query);		 
										 ResultSet rs=ps.executeQuery();
							}
										 
					    catch(Exception e)
						   {
										e.printStackTrace();
							}
				    }			  
				  
		}
		  
      }	
  }