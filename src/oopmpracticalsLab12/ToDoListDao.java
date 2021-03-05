/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ToDoListDao {
	
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	
	public void addTask(Task task)
	{
		System.out.println("Adding Task into database");
		
		connection=DBUtil.getConnection();
		String sql="insert into oopmlab11.taskstable values (?,?,?,?)";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, task.getTaskName());
			preparedStatement.setString(2, task.getEmployee());
			preparedStatement.setDate(3, new java.sql.Date(task.getDeadline().getTime()));
			preparedStatement.setBoolean(4, task.isDone());
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Added Successfully");
			}
			else
			{
				System.out.println("Insertion Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void renameTask(Task task)
	{
		System.out.println("Renaming Task");
		connection=DBUtil.getConnection();
		String sql="update oopmlab11.taskstable set employeeName=?,deadline=?,isDone=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(4, task.getTaskName());
			preparedStatement.setString(1, task.getEmployee());
			preparedStatement.setDate(2, new java.sql.Date(task.getDeadline().getTime()));
			preparedStatement.setBoolean(3, task.isDone());
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Renamed Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void removeTask(String removeTask)
	{
		System.out.println("Removing Task");
		connection=DBUtil.getConnection();
		String sql="delete from oopmlab11.taskstable where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, removeTask);
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Deleted Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
		
	
	public void markAsDone(String taskName)
	{
		System.out.println("Marking as Done");
		connection=DBUtil.getConnection();
		String sql="update oopmlab11.taskstable set isDone=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			preparedStatement.setBoolean(1, true);
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Marked done Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void assignDeadline(String deadline, String taskName)
	{
		System.out.println("Assigning Deadline Task");
		connection=DBUtil.getConnection();
		String sql="update oopmlab11.taskstable set deadline=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			try {
			preparedStatement.setDate(1, new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(deadline).getTime()));
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			int count=preparedStatement.executeUpdate();
			if(count>0)
			{
				System.out.println("DeadLine Modified Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	public void assignTask(String employeeName, String taskName)
	{
		System.out.println("Assigning Task");
		connection=DBUtil.getConnection();
		String sql="update oopmlab11.taskstable set employeeName=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			preparedStatement.setString(1, employeeName);
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Assigned Task Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}

	public void signUp(String name, String username, String password) 
	{
			System.out.println("Signing Up");
			
			connection=DBUtil.getLoginConnection();
			String sql="insert into oopmlab11.loginTable values (?,?,?)";
			
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, username);
				preparedStatement.setString(3, password);
				int count=preparedStatement.executeUpdate();
				
				if(count>0)
				{
					System.out.println("Successfully Logged In");
				}
				else
				{
					System.out.println("Unsuccessful");
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
				Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
			}
		}

	public int signIn(String username, String password) {
		
		System.out.println("Signing In");

		try {
        	
			connection=DBUtil.getLoginConnection();
        	String sql="select * from oopmlab11.loginTable";
       		PreparedStatement ps=connection.prepareStatement(sql);
       		ResultSet rs=ps.executeQuery();
       		
           	if(rs.next())
            {
           		return 1;
           	}
           	else
           	{
           		return 0;
           	}
           
			}catch(SQLException e)
			{
				e.printStackTrace();
				Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
			}
		
			return 0;
        	
		}
		
		
		
	}
		


	




