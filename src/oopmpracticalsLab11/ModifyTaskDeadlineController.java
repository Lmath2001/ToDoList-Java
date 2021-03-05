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

	public class ModifyTaskDeadlineController extends JFrame{

		JLabel lblTaskName, lblModifiedDeadline;
		JTextField jTaskName, jModifiedDeadline;
		JButton btnModifiedDeadline, btnBack;
		
		public ModifyTaskDeadlineController()
		{
			lblTaskName=new JLabel("Enter Task Name:");
			lblTaskName.setBounds(20, 20, 150, 20);
			
			lblModifiedDeadline=new JLabel("Enter Modified Deadline:");
			lblModifiedDeadline.setBounds(20, 50, 150, 20);
			
			jTaskName=new JTextField(20);
			jTaskName.setBounds(200, 20, 150, 20);
			
			jModifiedDeadline=new JTextField(20);
			jModifiedDeadline.setBounds(200, 50, 150, 20);
			
			
			btnModifiedDeadline=new JButton("Modify Deadline");
			btnModifiedDeadline.setBounds(20,80,200,20);
			
			btnBack=new JButton("Go Back");
			btnBack.setBounds(250,80,200,20);
			
			add(lblTaskName);
			add(lblModifiedDeadline);
			add(jTaskName);
			add(jModifiedDeadline);
			add(btnModifiedDeadline);
			add(btnBack);
			
			btnModifiedDeadline.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Modifying Deadline");
					ToDoList list=new ToDoList();
					list.assignDeadline(jModifiedDeadline.getText(),jTaskName.getText());
					JOptionPane.showMessageDialog(btnModifiedDeadline, "Modified Deadline Successfully");
					
				}
			});
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new ToDoListController();
					
				}
			});
			
			setTitle("Modify Deadline ToDoList Controller");
			setSize(500, 300);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			}
			public static void main(String[] args)
			{
				ModifyTaskDeadlineController obj=new ModifyTaskDeadlineController();
			}

			
			
			
}





