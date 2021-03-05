/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ToDoListController extends JFrame {
	
	    JLabel lblTaskName, lblEmployeeName, lblTaskDeadline, lblCompleteStatus;
		JTextField jTaskName, jEmployeeName, jTaskDeadline, jCompleteStatus;
		JButton btnAddTask, btnRenameTask, btnRemoveTask, btnModifyTaskDeadline, btnAssignTask, btnMarkAsDoneTask, btnViewToDoList, btnclear;

		
		public ToDoListController()
		{
			//Initializing the labels
			lblTaskName=new JLabel("Enter Task Name:");
			lblEmployeeName=new JLabel("Enter Employee Name:");
			lblTaskDeadline=new JLabel("Enter Task Deadline:");
			lblCompleteStatus=new JLabel("Status of Completion");
			//Setting bounds for labels
			
			lblTaskName.setBounds(20, 20, 150, 20);
			lblEmployeeName.setBounds(20, 50, 150, 20);
			lblTaskDeadline.setBounds(20, 80, 150, 20);
			lblCompleteStatus.setBounds(20, 110, 150, 20);

			
			//Initializing the textFields
			jTaskName=new JTextField(20);
			jEmployeeName=new JTextField(20);
			jTaskDeadline=new JTextField(20);
			jCompleteStatus=new JTextField(20);

			
			//Setting Bounds for TextFields
			jTaskName.setBounds(170, 20, 150, 20);
			jEmployeeName.setBounds(170,50,150,20);
			jTaskDeadline.setBounds(170,80,150,20);
			jCompleteStatus.setBounds(170,110,150,20);

			
		
			//Buttons created
			btnAddTask=new JButton("Add Task");
			btnAddTask.setBounds(350,20,300,20);
			btnRenameTask=new JButton("Rename/Updating Existing Task");
			btnRenameTask.setBounds(350,50,300,20);
			btnRemoveTask=new JButton("Remove Task");
			btnRemoveTask.setBounds(350,80,300,20);
			btnModifyTaskDeadline=new JButton("Modify Task Deadline");
			btnModifyTaskDeadline.setBounds(350,110,300,20);
			btnAssignTask=new JButton("Assign Task");
			btnAssignTask.setBounds(350,140,300,20);
			btnMarkAsDoneTask=new JButton("Mark as Done");
			btnMarkAsDoneTask.setBounds(350,170,300,20);
			btnViewToDoList=new JButton("View To Do List");
			btnViewToDoList.setBounds(350,210,300,20);
			
			btnclear=new JButton("Clear");
			btnclear.setBounds(350,240,300,20);
			

			
			//Adding all the elements to the frame
			add(lblTaskName); 
			add(lblEmployeeName); 
			add(lblTaskDeadline); 
			add(lblCompleteStatus); 
			
			add(jTaskName); 
			add(jEmployeeName); 
			add(jTaskDeadline); 
			//add(jCompleteStatus); 
			
			
			
			add(btnAddTask);
			add(btnRenameTask);
			add(btnRemoveTask);
			add(btnModifyTaskDeadline);
			add(btnAssignTask);
			add(btnMarkAsDoneTask);
			add(btnViewToDoList);
			add(btnclear);
			
			
			
			btnAddTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Creating a New Task");
					
					if(jTaskName.getText().isEmpty() || jEmployeeName.getText().isEmpty() || jTaskDeadline.getText().isEmpty())
					{
						JOptionPane.showConfirmDialog(btnAddTask, "Fill in the details");
					}
					else
					{
					Task task=new Task();
					task.setTaskName(jTaskName.getText());
					task.setEmployee(jEmployeeName.getText());
					
					
					try {
						task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(jTaskDeadline.getText()));
					}catch(ParseException e1)
					{
						e1.printStackTrace();
					}
					ToDoList list=new ToDoList();
					list.addTask(task);
					
					JOptionPane.showMessageDialog(btnAddTask, "Added Task Successfully \n"+task.toString());
					}
				}
			});
			
			btnRenameTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Renaming a New Task");
					Task task=new Task();
					task.setTaskName(jTaskName.getText());
					task.setEmployee(jEmployeeName.getText());
					
					try {
						task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(jTaskDeadline.getText()));
					}catch(ParseException e1)
					{
						e1.printStackTrace();
					}
					
					ToDoList list=new ToDoList();
					list.renameTask(task);
					JOptionPane.showMessageDialog(btnRenameTask, "Renamed Task Successfully");
					
					
				}
			});
			
			btnRemoveTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new RemoveTaskController();
					
				}
			});
			
			btnModifyTaskDeadline.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ModifyTaskDeadlineController();
					
				}
			});
			
			btnAssignTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new AssignTaskController();
					
				}
			});
			
			btnMarkAsDoneTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new MarkTaskAsDoneController();
				}
			});
			
			btnViewToDoList.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ViewToDoListController();
				}
			});
			
			btnclear.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String text="";
					jTaskName.setText(text);
					jEmployeeName.setText(text); 
					jTaskDeadline.setText(text); 
					jCompleteStatus.setText(text);
					JOptionPane.showConfirmDialog(btnclear, "Cleared ");
					
				}
			});
			
							
			setTitle("To Do List Controller");
			setSize(700, 500);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

			

		}
		public static void main(String[] args)
		{
			ToDoListController obj=new ToDoListController();
		}
		
		
		
		
		
		
		
		
}
