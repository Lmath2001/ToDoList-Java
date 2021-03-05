package com.crce.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import oopmpracticalsLab12.ToDoListController;
import oopmpracticalsLab12.ToDoListDao;

public class SignIn extends JFrame implements ActionListener
{
    JLabel lblUsername,lblPassword;
    JTextField jUsername;
    JPasswordField jPassword;
    JButton btnBack,btnSignIn;
    public SignIn()
    {

        
        //Label for Username
        lblUsername=new JLabel("Username: ");
        lblUsername.setBounds(20,20,100,25);
        add(lblUsername);
        
        //TextField for Username
        jUsername=new JTextField();
        jUsername.setBounds(120,22,150,23);
        add(jUsername);
        
        //Label for Password
        lblPassword=new JLabel("Password: ");
        lblPassword.setBounds(20,50,100,25);
        add(lblPassword);
        
        //TextField for Password
        jPassword=new JPasswordField();
        jPassword.setBounds(120,52,150,23);
        add(jPassword);    
        
        //Button to go back
        btnBack=new JButton("Back");
        btnBack.setBounds(160,102,80,20);
        btnBack.addActionListener(this);
        add(btnBack);
        
        //Button to Sign-In
        btnSignIn=new JButton("Sign In");
        btnSignIn.setBounds(50,102,80,20);
        btnSignIn.addActionListener(this);
        add(btnSignIn);
        
        //Frame details
        setTitle("Sign In");
        setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null);
        setLocation(300,200);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnBack)
        {
            dispose();
            new Login();
        }
        if(ae.getSource()==btnSignIn)
        {
            dispose();
            ToDoListDao dao=new ToDoListDao();
            int x=dao.signIn(jUsername.getText(),jPassword.getText());
            if(x==1)
            {
            	JOptionPane.showMessageDialog(btnSignIn,"You have successfully logged in");
            	dispose();
            	new ToDoListController();
            }
            else
            {
            	JOptionPane.showMessageDialog(btnSignIn,"Invalid Username or Password");
            }
        }
    }
    public static void main(String args[])
    {
        SignIn s=new SignIn();
    }
}

