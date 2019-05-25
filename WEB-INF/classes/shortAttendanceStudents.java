import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ShortAttendanceStudents extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);
			
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i>"+s1+"</i> to CSE branch</i> </h1><br><div class='col-lg-6 m-auto d-block'>");
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
	   
	    pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><div class='col-lg-6 m-auto d-block'></div></div>");
	
        if(s2.equalIgnoreCase("cse"))
		{
				  if(s1.equalIgnoreCase("a"))
				  {
				    	try
							{ 
							     Connection con=DBInfo.con;
								 String query="select * from short_attendance_cse where where roll_no between '14egjcs001' and '14egjcs050' ;";
								 PreparedStatement ps=con.prepareStatement(query);		 
								 ResultSet rs=ps.executeQuery();
							 }
								 
							catch(Exception e)
							{
								e.printStackTrace();
							}
					}		
				    
					else if(s1.equalIgnoreCase("b"))
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
		
	    else if(s2.equalIgnoreCase("ec"))
		{
				  if(s1.equalIgnoreCase("a"))
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
				    
					else if(s1.equalIgnoreCase("b"))
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
		
		
		
		else if(s2.equalIgnoreCase("eee"))
		{
				  if(s1.equalIgnoreCase("a"))
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
				    
					else if(s1.equalIgnoreCase("b"))
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
				  if(s1.equalIgnoreCase("a"))
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
				    
					else if(s1.equalIgnoreCase("b"))
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
		  
					pw.println("</center></body></html>");
      }	
  }