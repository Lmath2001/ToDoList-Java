package com.crce.login;

import oopmpracticalsLab12.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SignUp extends JFrame implements ActionListener
{
    JLabel lblName,lblUsername,lblPassword;
    JTextField jName,jUsername;
    JPasswordField jPassword;
    JButton btnBack,btnSignUp,btnSignIn;
    public SignUp()
    {
        //Label for Name
        lblName=new JLabel("Enter Name: ");        
        lblName.setBounds(20,20,170,25);
        //lblName.setFont(new Font("Times_New_Roman",Font.PLAIN,15));
        //lblName.setForeground(Color.BLACK);
        add(lblName);
        
        //TextField for Name
        jName=new JTextField(20);
        jName.setBounds(180,22,150,23);
        //jName.setFont(new Font("serif",Font.PLAIN,15));
        //jName.setForeground(Color.BLACK);
        add(jName);
        
        //Label for Username
        lblUsername=new JLabel("Enter Username: ");
        lblUsername.setBounds(20,50,170,25);
       // lblUsername.setFont(new Font("Times_New_Roman",Font.PLAIN,15));
        //lblUsername.setForeground(Color.BLACK);
        add(lblUsername);
        
        //TextField for Username
        jUsername=new JTextField(20);
        jUsername.setBounds(180,52,150,23);
      //  jUsername.setFont(new Font("serif",Font.PLAIN,15));
        //jUsername.setForeground(Color.BLACK);
        add(jUsername);
        
        //Label for Password
        lblPassword=new JLabel("Enter Password: ");
        lblPassword.setBounds(20,80,170,25);
        //lblPassword.setFont(new Font("Times_New_Roman",Font.PLAIN,15));
      //  lblPassword.setForeground(Color.BLACK);
        add(lblPassword);
        
        //TextField for Password
        jPassword=new JPasswordField(20);
        jPassword.setBounds(180,82,150,23);
   //     jPassword.setFont(new Font("serif",Font.PLAIN,15));
     //   jPassword.setForeground(Color.BLACK);
        add(jPassword);    
        
        //Button to signup
        btnSignUp=new JButton("Sign Up");
        btnSignUp.setBounds(80,122,80,20);
     //   btnSignUp.setForeground(Color.BLACK);
      //  btnSignUp.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,12));
        btnSignUp.addActionListener(this);
        add(btnSignUp);
        
        //Button to go back
        btnBack=new JButton("Back");
        btnBack.setBounds(320,122,80,20);
  //      btnBack.setForeground(Color.BLACK);
  //      btnBack.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,12));
        btnBack.addActionListener(this);
        add(btnBack);
        
        //Button to Sign-In
        btnSignIn=new JButton("Sign In");
        btnSignIn.setBounds(200,122,80,20);
    //    btnSignIn.setForeground(Color.BLACK);
    //    btnSignIn.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,12));
        btnSignIn.addActionListener(this);
        add(btnSignIn);
        
        //Frame details
        setTitle("Sign Up");
        setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null);
        setLocation(500,200);
        setVisible(true); 
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnBack)
        {
            dispose();
            new Login();
        }
        if(ae.getSource()==btnSignUp)
        {
            dispose();
            ToDoListDao dao=new ToDoListDao();
            dao.signUp(jName.getText(), jUsername.getText(), jPassword.getText());
            new SignUp();
        }
        if(ae.getSource()==btnSignIn)
        {
            dispose();
            new SignIn();
        }
    }
    public static void main(String args[])
    {
        SignUp s=new SignUp();
    }
}

