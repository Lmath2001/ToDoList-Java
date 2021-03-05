/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab12;

import java.util.Date;

public class Task {
	
	private String taskName;
	private String employee;
	private Date deadline;
	private boolean isDone;
	
	public Task() {
		super();
	}
	
	public Task(String taskName, String employee, Date deadline, boolean isDone) {
		super();
		this.taskName = taskName;
		this.employee = employee;
		this.deadline = deadline;
		this.isDone = isDone;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", employee=" + employee + ", deadline=" + deadline + ", isDone=" + isDone
				+ "]";
	}
	

}

