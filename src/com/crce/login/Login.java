package com.crce.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Login extends JFrame implements ActionListener
{
    JButton btnSignUp,btnSignIn;
    JLabel title;
    public Login()
    {
    	//Title Label
        title=new JLabel("To Do List Application");
        title.setBounds(40,20,200,50);
        title.setFont(new Font("Times_New_Roman",Font.PLAIN,15));
        add(title);
        
        //Button to signup
        btnSignUp=new JButton("Sign Up");
        btnSignUp.setBounds(50,100,80,20);
        btnSignUp.addActionListener(this);
        add(btnSignUp);
        
        //Button to go back
        btnSignIn=new JButton("Sign In");
        btnSignIn.setBounds(160,100,80,20);
        btnSignIn.addActionListener(this);
        add(btnSignIn);
        
        //Frame details
        setTitle("To Do List Controller");
        setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        setSize(300,200);
        setLayout(null);
        setLocation(500,500);
        setVisible(true); 
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnSignUp)
        {
            dispose();
            new SignUp();
        }
        if(e.getSource()==btnSignIn)
        {
            dispose();
            new SignIn();
        }
    }
    public static void main(String args[])
    {
        Login login=new Login();
    }
}
