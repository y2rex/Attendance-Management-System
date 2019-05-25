import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
	   PrintWriter pw=res.getWriter();
	   pw.println("<html>");
	   pw.println("<body bgcolor='green'>");
	   
	    String s1=req.getParameter("uname");
	    String s2=req.getParameter("pass");
		String s3=req.getParameter("user");
		String s4=req.getParameter("branch");
		
		int flag=0;
		String usertype=" ";
		String branch=" ";
		
	try
	{
	 	 Connection con=DBInfo.con;
         String query="select * from login where userID=? and password=?" ;		 
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1, s1);
	     ps.setString(2, s2);		 
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
		 flag=1;
		    usertype=rs.getString(3);
			branch=rs.getString(5);
		 break;
		 }
	}
		 
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	         HttpSession session=req.getSession();
			 session.setAttribute("ut",usertype);
			 session.setAttribute("branch",branch);
			 session.setAttribute("un",s1);
			 session.setAttribute("ps",s2);

			 
			
			 if(flag==1 && usertype.equalsIgnoreCase(s3) && branch.equalsIgnoreCase(s4))
			  {	  		
                    if(usertype.equalsIgnoreCase("faculty"))	
					{			  
						 if(branch.equalsIgnoreCase("cse"))
						 {
					       res.sendRedirect("FacultyCSE");
						  }
						  else if(branch.equalsIgnoreCase("me"))
						  {
					       res.sendRedirect("FacultyME");
						   }
						  else if(branch.equalsIgnoreCase("eee"))
						  {
					       res.sendRedirect("FacultyEEE");
						   }
						  else
					       res.sendRedirect("FacultyEC");
					}
                    else
                    {					
						    if(branch.equalsIgnoreCase("cse"))
							res.sendRedirect("AdminCSE");
							
							else if(branch.equalsIgnoreCase("me"))
							res.sendRedirect("AdminME");	
							
							else if(branch.equalsIgnoreCase("eee"))
							res.sendRedirect("AdminEEE");	
							
							else
							res.sendRedirect("AdminEC");
                    }   
				}
			  else
			  {
				  res.sendRedirect("../UnauthorisedUser.html");
		          pw.println("<br><a href=../UnauthorisedUser.html>Retry</a>");
			   }
		   
	    pw.println("</center></body></html>");	 
		   }
   } 