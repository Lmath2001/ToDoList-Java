/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ToDoList {
	
	private String topic;
	
	static ArrayList<Task> toDoList=new ArrayList<Task>();

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public static ArrayList<Task> getToDoList() {
		return toDoList;
	}
	
	public void addTask(Task task)
	{
		toDoList.add(task);
		
		display();
	}
	
	public void renameTask(Task renameTask)
	{
		int count=0;
		for(Task t : toDoList)
		{
			if(t.getTaskName().equals(renameTask.getTaskName()))
			{
				t.setTaskName(renameTask.getTaskName());
				t.setEmployee(renameTask.getEmployee());
				t.setDeadline(renameTask.getDeadline());
				t.setDone(renameTask.isDone());	
				toDoList.set(count, t);
			}
			count++;
		}
		display();
	}
	
	public void removeTask(String removeTask)
	{
		int count=0;
		Task deleteTask=null;
		for(Task t:toDoList)
		{
			if(t.getTaskName().equals(removeTask))
			{
				deleteTask=toDoList.remove(count);
			}
			count++;
		}
		
		if(deleteTask!=null)
		{
			System.out.println("Task deleted successfully");
		}
		else
		{
			System.out.println("Task not Found");
		}
		display();
	}
		
	
	public void markAsDone(String taskName)
	{
		int count=0;
		for(Task task: toDoList)
		{
			if(task.getTaskName().equals(taskName))
			{
				task.setDone(true);
				toDoList.set(count, task);
			}
			count++;
		}
		display();
	}
	
	public void assignDeadline(String deadline, String taskName)
	{
		int count=0;
		for(Task task:toDoList)
		{
			if(task.getTaskName().equals(taskName))
			{
				try {
					task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(deadline));
				}catch(ParseException e)
				{
					e.printStackTrace();
				}
				toDoList.set(count, task);
			}
			count++;
		}
		System.out.println("Task DeadLine Assigned Successfully");
		display();
	}
	
	public void assignTask(String employeeName, String taskName)
	{
		int count=0;
		for(Task task: toDoList)
		{
			if(task.getTaskName().equals(taskName))
			{
				task.setEmployee(employeeName);
				toDoList.set(count, task);
			}
			count++;
		}
		System.out.println("Task Assigned Successfully");
		display();
	}
		
	
	public void display()
	{
		System.out.println("Displaying all the tasks");
		for(Task task:toDoList)
		{
			System.out.println("The Task "+task.getTaskName()+" is assigned to "+task.getEmployee()+" on given deadline "+task.getDeadline()+" having status as "+task.isDone());
		}
	}
	
	

}



