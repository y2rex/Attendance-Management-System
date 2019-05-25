import java.sql.*;
public class DBInfo
{
  static Connection con;
  static
   {
	try
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Driver loaded!!!");
		 System.out.println();
		 
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_management_system","root","rat");
     }
	 catch(Exception e)
	 {
	  e.printStackTrace();	  
	 }
	 
    }
 }