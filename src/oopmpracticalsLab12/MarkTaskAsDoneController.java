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

	public class MarkTaskAsDoneController extends JFrame{

		JLabel lblTaskName;
		JTextField jTaskName;
		JButton btnMarkAsDoneTask, btnBack;
		
		public MarkTaskAsDoneController()
		{
			lblTaskName=new JLabel("Enter Task Name:");
			lblTaskName.setBounds(20, 20, 150, 20);
			
			jTaskName=new JTextField(20);
			jTaskName.setBounds(200, 20, 150, 20);
			
			btnMarkAsDoneTask=new JButton("Mark As Done");
			btnMarkAsDoneTask.setBounds(20,50,200,20);
			
			btnBack=new JButton("Go Back");
			btnBack.setBounds(250,50,200,20);
			
			add(lblTaskName);
			add(jTaskName);
			add(btnMarkAsDoneTask);
			add(btnBack);
			
			btnMarkAsDoneTask.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("Marking as Done");
					ToDoListDao list=new ToDoListDao();
					list.markAsDone(jTaskName.getText());
					JOptionPane.showMessageDialog(btnMarkAsDoneTask, "Marked Successfully");
					
				}
			});
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ToDoListController();
					
				}
			});
			
			setTitle("Mark As Done ToDoList Controller");
			setSize(500, 300);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			}
			public static void main(String[] args)
			{
				MarkTaskAsDoneController obj=new MarkTaskAsDoneController();
			}

			
			
			
}


