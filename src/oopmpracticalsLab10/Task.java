/* Liny Mathew SE Comps B 8950 */


package oopmpracticalsLab10;

import java.util.Date;

public class Task {
	
	/**
	 * private instance variables taskName, employee, deadline & isDone
	 * 
	 */
	private String taskName;
	private String employee;
	private Date deadline;
	private boolean isDone;
	
	/**
	 * Task Constructor is created with null parameters
	 */
	public Task() {
		super();
	}
	
	
	/**
	 * Task Constructor is created with four parameters
	 * @param taskName Name of the Task
	 * @param employee Name of the employee
	 * @param deadline Deadline
	 * @param isDone  Completion Status
	 */
	public Task(String taskName, String employee, Date deadline, boolean isDone) {
		super();
		this.taskName = taskName;
		this.employee = employee;
		this.deadline = deadline;
		this.isDone = isDone;
	}
	
	/**
	 * This method is to return the taskName
	 * @return name of the task
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * This method is to set the taskName
	 * @param taskName Name of the task
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * This method is to get the Name of the employee
	 * @return the name of employee 
	 */
	public String getEmployee() {
		return employee;
	}
	
	/**
	 * This method is to set the Name of the employee
	 * @param employee Name of the employee
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	/**
	 * This method is to get the deadline of the task
	 * @return Deadline of task
	 */
	public Date getDeadline() {
		return deadline;
	}
	
	/**
	 * This method is to set the Name of the employee
	 * @param deadline Deadline of the task
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	/**
	 * This method is to get the status of the task
	 * @return Completion of the task
	 */
	public boolean isDone() {
		return isDone;
	}
	
	
	/**
	 * This method is to set the status of the task
	 * @param isDone Completion of the task
	 */
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", employee=" + employee + ", deadline=" + deadline + ", isDone=" + isDone
				+ "]";
	}
	
}
