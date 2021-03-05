/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveTaskController extends JFrame{

	JLabel lblTaskName;
	JTextField jTaskName;
	JButton btnRemoveTask, btnBack;
	
	public RemoveTaskController()
	{
		lblTaskName=new JLabel("Enter Task Name:");
		lblTaskName.setBounds(20, 20, 150, 20);
		
		jTaskName=new JTextField(20);
		jTaskName.setBounds(200, 20, 150, 20);
		
		btnRemoveTask=new JButton("Remove Task");
		btnRemoveTask.setBounds(20,50,200,20);
		
		btnBack=new JButton("Go Back");
		btnBack.setBounds(250,50,200,20);
		
		add(lblTaskName);
		add(jTaskName);
		add(btnRemoveTask);
		add(btnBack);
		
		btnRemoveTask.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Removing Task");
				ToDoListDao list=new ToDoListDao();
				list.removeTask(jTaskName.getText());
				JOptionPane.showMessageDialog(btnRemoveTask, "Removed Task Successfully");
				
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ToDoListController();
				
			}
		});
		
		setTitle("Remove ToDoList Controller");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		}
		public static void main(String[] args)
		{
			RemoveTaskController obj=new RemoveTaskController();
		}

		
		
		
		
	}

