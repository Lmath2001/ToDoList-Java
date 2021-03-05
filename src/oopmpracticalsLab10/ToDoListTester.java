/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab10;

import java.util.Scanner;

public class ToDoListTester {
	
	public static void testAssignTask()
	{
		ToDoList list=new ToDoList();
		System.out.println("Enter the taskname:");
		Scanner scan = new Scanner(System.in);
		String taskName=scan.nextLine();
		System.out.println("Enter the employee name:");
		String employee=scan.nextLine();
		
		list.assignTask(employee, taskName);

	}
	
	public static void testAssignDeadline()
	{
		ToDoList list=new ToDoList();
		System.out.println("Enter the taskname's deadline to be assigned");
		Scanner scan = new Scanner(System.in);
		String taskName=scan.nextLine();
		System.out.println("Enter the Deadline to be assigned");
		String deadline=scan.nextLine();
		
		list.assignDeadline(deadline, taskName);
	}
	
	public static void testMarkAsDone()
	{
		ToDoList list=new ToDoList();
		System.out.println("Enter the taskname to be marked");
		Scanner scan = new Scanner(System.in);
		String taskName=scan.nextLine();
		
		list.markAsDone(taskName);
	}
	
	public static void testRemoveTask()
	{
		ToDoList list=new ToDoList();
		System.out.println("Enter the taskname to be removed");
		Scanner scan = new Scanner(System.in);
		String removeTask=scan.nextLine();
		
		list.removeTask(removeTask);
		
	}
	
	public static void testRenameTask()
	{
		ToDoList list=new ToDoList();
		System.out.println("Enter the taskname to be renamed");
		Scanner scan = new Scanner(System.in);
		String renameTask=scan.nextLine();
		list.renameTask(renameTask);
		
	}
	
	public static void testCreateTask()
	{
		ToDoList list=new ToDoList();
		list.createTask();
		list.createTask();
		list.createTask();
	}
	
	
	public static void testDisplay()
	{
		ToDoList list=new ToDoList();
		list.display();
	}
	
	//Testing all the classes
	public static void testAll()
	{
		testCreateTask();
		testDisplay();
		System.out.println("");
		testRenameTask();
		testDisplay();
		System.out.println("");
		testRemoveTask();
		testDisplay();
		System.out.println("");
		testMarkAsDone();
		testDisplay();
		System.out.println("");
		testAssignDeadline();
		testDisplay();
		System.out.println("");
		testAssignTask();
		testDisplay();
		
	}
	
	
	
	public static void main(String[] args)
	{
		testAll();
	}

}
