/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ToDoList {
	
	/**
	 * private instance variable topic
	 */
	private String topic;
	
	/**
	 * ArrayList of Object Task is created statically
	 */
	static ArrayList<Task> toDoList=new ArrayList<Task>();

	/**
	 * This method is to get the topic 
	 * @return Topic of the task
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * This method is to set the topic 
	 * @param topic Topic of the task
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * This method return the ArrayList of object Task
	 * @return return the ArrayList of object Task
	 */
	public static ArrayList<Task> getToDoList() {
		return toDoList;
	}
	
	/**
	 * This method is for inputting the details of the task
	 * @return Object Task
	 */
	public Task inputTaskDetails()
	{
		//Entering the details of the task
		System.out.println("Enter your Task Details");
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Task Name: ");
		String taskName=scan.nextLine();
		System.out.println("Enter the employee name:");
		String employee=scan.nextLine();
		System.out.println("Enter the deadline date (Please enter in dd/MM/yyyy format) :");
		Date date=null;
		try {
			date=new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
		}catch(ParseException e)
		{
			e.printStackTrace();
		}
		
		//Setting the details of the task
		Task task=new Task();
		task.setTaskName(taskName);
		task.setEmployee(employee);
		task.setDeadline(date);
		
		return task;
	}

	
	/**
	 * This method is to create the task and add it to the arrayList
	 */
	public void createTask()
	{
		System.out.println("Creating a New Task");
		Task task=inputTaskDetails();
		toDoList.add(task);
		
		System.out.println(toDoList);
	}
	
	/**
	 * This method is to rename/update the task
	 * @param renametask
	 */
	public void renameTask(String renametask)
	{
		System.out.println("Renaming an existing Task:");
		Task newTask=inputTaskDetails();
		int count=0;
		for(Task t : toDoList)
		{
			if(t.getTaskName().equals(renametask))
			{
				//setting the updating details
				t.setTaskName(newTask.getTaskName());
				t.setEmployee(newTask.getEmployee());
				t.setDeadline(newTask.getDeadline());
				t.setDone(newTask.isDone());
				
				toDoList.set(count, t);
			}
			count++;
		}
		
	}
	
	/**
	 * This method is to remove the task 
	 * @param removeTask the task to be removed
	 */
	public void removeTask(String removeTask)
	{
		System.out.println("Removing an existing Task:");
		int count=0;
		Task deleteTask=null;
		for(Task t:toDoList)
		{
			if(t.getTaskName().equals(removeTask))
			{
				//removing the task
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
	}
		
	
	/**
	 * This method is to mark the task done 
	 * @param taskName the name of the task
	 */
	public void markAsDone(String taskName)
	{
		int count=0;
		for(Task task: toDoList)
		{
			if(task.getTaskName().equals(taskName))
			{
				//setting the task done
				task.setDone(true);
				toDoList.set(count, task);
			}
			count++;
		}
	}
	
	/**
	 * This method is to assign the deadline to the task
	 * @param deadline Deadline of the task
	 * @param taskName Name of the task
	 */
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
	}
	
	/**
	 * This method is to assigning the task with respect to the employee name
	 * @param employeeName name of the employee
	 * @param taskName name of the task
	 */
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
	}
	
	
	/**
	 * This method is to display the task
	 */
	public void display()
	{
		System.out.println("Displaying all the tasks");
		for(Task task:toDoList)
		{
			System.out.println("The Task "+task.getTaskName()+" is assigned to "+task.getEmployee()+" on given deadline "+task.getDeadline()+" having status as "+task.isDone());
		}
	}
	
	

}
