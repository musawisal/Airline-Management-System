package Airlinemanagement;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class Boarding extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel labeldate,tfname,tfnationality,lblsrc,lbldest,labelfname,labelfcode;
    JButton fetchbutton,flights;
         
    public Boarding()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("911 AIR");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("BOARDING PASS");
        subheading.setBounds(325, 50, 290, 26);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblCNIC = new JLabel("PNR DETAILS");
        lblCNIC.setBounds(60, 100, 150, 25);
        lblCNIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblCNIC);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchbutton= new JButton("Enter");
        fetchbutton.setBackground(Color.black);
        fetchbutton.setForeground(Color.white);
        fetchbutton.addActionListener(this);
        fetchbutton.setBounds(380, 100, 120, 25);
        add(fetchbutton);
        
        
        
        JLabel lblName = new JLabel("NAME");
        lblName.setBounds(60, 140, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(220, 138, 150, 25);
        add(tfname);
        
        JLabel lblNationality = new JLabel("NATIONALITY");
        lblNationality.setBounds(60, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 178, 150, 25);
        add(tfnationality);
        
        
        
        JLabel lblAddress = new JLabel("SRC");
        lblAddress.setBounds(60, 220, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 218, 150, 25);
        add(lblsrc);
        
                
        JLabel lblGender = new JLabel("DEST");
        lblGender.setBounds(380, 220, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 298, 150, 25);
        add(labeldate);
        
                     
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javaapplication40/icons/real.png"));
        Image i2=  i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 620, 30, 300, 300);
        add(lblimage);
             
               
        setSize(1000,455);
        setLocation(200,130);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource()== fetchbutton)
        {
            
        String pnr = tfpnr.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from reservation where PNR = '"+pnr+"'";
            conn.S.executeQuery(query);
            
            ResultSet rs = conn.S.executeQuery(query);
            
            if (rs.next()){
                labeldate.setText(rs.getString("ddate"));
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));;
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please Enter Correct PNR");
                
            }
            
            
        }
        
        catch (Exception e)
        {
            e.printStackTrace();            
        }
        }
    }
}