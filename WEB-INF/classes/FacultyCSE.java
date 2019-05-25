import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class FacultyCSE extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
   {
		PrintWriter pw= res.getWriter();
		HttpSession session=req.getSession(false);
		
		String s1="";
		
		pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><i>Welcome <i>"+s1+"</i> to CSE branch</i> </h1><br><div class='col-lg-6 m-auto d-block'>");
		if(session!=null)
		{
		s1=(String)session.getAttribute("un");
		pw.println("<form class='bg-light' method='post'>");
        pw.println("<div class='form-group'>");
					pw.println("<label> Section : </label><span></span>");
					  pw.println("<select name='section'>");
						  pw.println("<option value='a'>A</option>");
						  pw.println("<option value='b'>B</option>");
						  pw.println("<option value='c'>C</option>");
			       pw.println(" </select></div>	");		
				pw.println("<input type='submit' name='submit' value='Submit' class='btn btn-success'>");
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
	   String s3=req.getParameter("section");
	   
	   HttpSession session=req.getSession();
	   String s1=(String)session.getAttribute("un");
       String s2=(String)session.getAttribute("ps");	   
	  
	    pw.println("<html><head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'><script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script></head>");
        pw.println("<body><div class='container'>");
		pw.println("<br><h1 class='text-center text-success'><div class='col-lg-6 m-auto d-block'></div></div>");
	
        int flag=0;
		String section=" ";
		
	try
	{ 
	     Connection con=DBInfo.con;
		 String query="select * from login where userID=? and password=? ;";
		 PreparedStatement ps=con.prepareStatement(query);
	     ps.setString(1, s1);
	     ps.setString(2, s2);		 
		 ResultSet rs=ps.executeQuery();
		 
		 while(rs.next())
		 {
		    flag=1;
		    section=rs.getString(6);
		 break;
		 }
	}
		 
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 if(flag==1 && section.equalsIgnoreCase(s3))
			  {	  		
                    if(section.equalsIgnoreCase("a"))			  
					  res.sendRedirect("FacultyCSEA");
					  
					 else if(section.equalsIgnoreCase("b"))			  
					  res.sendRedirect("FacultyCSEB");
					  
					 else if(section.equalsIgnoreCase("c"))			  
					  res.sendRedirect("FacultyCSEC");
					  
				}
					  
		else
					{
					pw.println("<center><h1>error :</h1><i>you haven't permission to enter other section</i>");
					pw.println("<a href='FacultyCSE'> Select section </a>");
					}	  
					pw.println("</center></body></html>");
      }	
  }