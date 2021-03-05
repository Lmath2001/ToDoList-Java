/* Liny Mathew SE Comps B 8950 */

package oopmpracticalsLab12;


import java.awt.BorderLayout;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewToDoListController 
{
    JFrame frame;
    JTable table;
    String columnNames[]={"Task Name","Employee Name","Deadline Date","Completion Status"};
    Connection c;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    int k=0;
    public ViewToDoListController()
    {
        frame = new JFrame("View ToDoList");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        String taskName,employeeName;
        boolean isDone;
        Date deadline;
        try {
            Connection c=DBUtil.getConnection();
            String sql="select * from oopmlab11.taskstable";
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) 
            {
                System.out.println("Inside");
                taskName = rs.getString("taskName");
                employeeName = rs.getString("employeeName");
                deadline = rs.getDate("deadline");
                isDone = rs.getBoolean("isDone");
                model.addRow(new Object[]{taskName,employeeName,deadline,isDone});
                k++;
            }
            if(k!=0)
            {
                frame.add(scroll);
                frame.setResizable(false);
                frame.setSize(1160,350);    
                frame.setVisible(true);
            }
            if(k==0)
            {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            frame.setVisible(true);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public static void main(String[] args)
    {
    	ViewToDoListController obj = new ViewToDoListController();
    }
}
