package Airlinemanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton reset, close, submit;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login ()
    {
        getContentPane().setBackground(Color.gray);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);
        
        tfusername= new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        
        tfpassword= new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setBounds(40, 120, 120, 20);
        submit = new JButton("Submit");
        submit.addActionListener(this);
        submit.setBounds(190, 120, 120, 20);
        add(submit);
        
        close = new JButton("Close");
        close.addActionListener(this);
        add(reset);
        
        close.setBounds(140, 160, 120, 20);
        add(close);     
        
        setSize(350,250);
        setLocation(500,250);
        setVisible(true);
        
    }
    
//    public static void main(String [] args){
//        new Login();        
//    }

    //@Override 
    public void actionPerformed(ActionEvent ae) 
    {
        String username=tfusername.getText();
        String password=tfpassword.getText();
        try
        {
            Conn c = new Conn();
            String query="select * from login where username = '"+username +"'and password = '"+password+"'";
            ResultSet rs =c.S.executeQuery(query);
            if (rs.next()){
                new Home();
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if (ae.getSource() == submit)
        {
            
        }
        else if (ae.getSource() == reset)
        {
            tfpassword.setText("");
            tfusername.setText("");
            
        }
        else if (ae.getSource() == close)
        {
            setVisible(false);
        }
    }    
}
