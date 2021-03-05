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

	public class AssignTaskController  extends JFrame{

		JLabel lblTaskName, lblEmployeeName;
		JTextField jTaskName, jEmployeeName;
		JButton btnEmployeeName, btnBack;
		
		public AssignTaskController()
		{
			lblTaskName=new JLabel("Enter Task Name:");
			lblTaskName.setBounds(20, 20, 150, 20);
			
			lblEmployeeName=new JLabel("Enter Employee Name:");
			lblEmployeeName.setBounds(20, 50, 150, 20);
			
			jTaskName=new JTextField(20);
			jTaskName.setBounds(200, 20, 150, 20);
			
			jEmployeeName=new JTextField(20);
			jEmployeeName.setBounds(200, 50, 150, 20);
			
			
			btnEmployeeName=new JButton("Assign Task To Employee");
			btnEmployeeName.setBounds(20,80,200,20);
			
			btnBack=new JButton("Go Back");
			btnBack.setBounds(250,80,200,20);
			
			add(lblTaskName);
			add(lblEmployeeName);
			add(jTaskName);
			add(jEmployeeName);
			add(btnEmployeeName);
			add(btnBack);
			
			btnEmployeeName.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Assigning Task");
					ToDoListDao list=new ToDoListDao();
					list.assignTask(jEmployeeName.getText(), jTaskName.getText());
					JOptionPane.showMessageDialog(btnEmployeeName, "Assigned Task Successfully");
					
				}
			});
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ToDoListController();
					
				}
			});
			
			setTitle("Assign Task ToDoList Controller");
			setSize(500, 300);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			}
			public static void main(String[] args)
			{
				AssignTaskController  obj=new AssignTaskController();
			}

			
			
			
}








