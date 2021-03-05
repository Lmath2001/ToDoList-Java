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

	public class ViewToDoListController extends JFrame{

		JLabel lblTaskName, lblEmployeeName, lblTaskDeadline, lblCompleteStatus;
		JButton btnBack, btnView;
		
		public ViewToDoListController()
		{
			ToDoList list=new ToDoList();

			for(Task t:ToDoList.toDoList)
			{
			lblTaskName=new JLabel("Task Name : "+t.getTaskName());
			lblEmployeeName=new JLabel("Employee Name: "+t.getEmployee());
			lblTaskDeadline=new JLabel("Task Deadline: "+t.getDeadline());
			lblCompleteStatus=new JLabel("Complete Status "+t.isDone());
			}
			
			lblTaskName.setBounds(20, 20, 150, 20);
			lblEmployeeName.setBounds(20, 50, 150, 20);
			lblTaskDeadline.setBounds(20, 80, 150, 20);
			lblCompleteStatus.setBounds(20, 110, 150, 20);
			
			
			btnView=new JButton("View ToDoList");
			btnView.setBounds(20,50,200,20);
			btnBack=new JButton("Go Back");
			btnBack.setBounds(250,50,200,20);

			add(btnView);
			add(btnBack);

			btnView.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Viewing To Do List");
					ToDoList list=new ToDoList();
					JOptionPane.showMessageDialog(btnView, list.toDoList);
					
				}
			});
			
			btnBack.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ToDoListController();
					
				}
			});
			
			setTitle("View ToDoList Controller");
			setSize(500, 500);
			setLocationRelativeTo(null);
			setLayout(null);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			}
			public static void main(String[] args)
			{
				ViewToDoListController obj=new ViewToDoListController();
			}

			
			
			
			
		}




