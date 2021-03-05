/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab12;

import java.sql.*;

public class DBUtil {
	
	public static Connection getConnection()
	{
		Connection con=null;
		
		String url="jdbc:mysql://localhost:3306/oopmlab11";
		String username="root";
		String password="";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connected Successfully");
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return con;
	}
	
	public static Connection getLoginConnection()
	{
		Connection loginCon=null;
		String urlLogin="jdbc:mysql://localhost:3306/oopmlab11";
		String usernameLogin="root";
		String passwordLogin="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			loginCon=DriverManager.getConnection(urlLogin, usernameLogin, passwordLogin);
			System.out.println("Connected Successfully");
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		return loginCon;
	}

	
}
