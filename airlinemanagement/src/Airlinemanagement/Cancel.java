package Airlinemanagement;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname,cancelnum,lblcode,lbldate;
    JButton fetchbutton,flights;
         
    public Cancel()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATIION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("javaapplication40/icons/cancel.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel (i3);
        image.setBounds(470, 120, 250, 250);
        add(image);
        
                       
        JLabel pnr = new JLabel("PNR Number");
        pnr.setBounds(60, 80, 150, 25);
        pnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchbutton= new JButton("Show Details");
        fetchbutton.setBackground(Color.black);
        fetchbutton.setForeground(Color.white);
        fetchbutton.addActionListener(this);
        fetchbutton.setBounds(380, 80, 120, 25);
        add(fetchbutton);
        
        
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 130, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel cn = new JLabel("Cancellation Number");
        cn.setBounds(60, 180, 150, 25);
        cn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(cn);
        
        cancelnum = new JLabel(""+random.nextInt(10000));
        cancelnum.setBounds(220, 180, 150, 25);
        add(cancelnum);
        
        
        
        JLabel fc = new JLabel("Flight Code");
        fc.setBounds(60, 230, 150, 25);
        fc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fc);
        
        lblcode = new JLabel();
        lblcode.setBounds(220, 230, 150, 25);
        add(lblcode);
        
                
        JLabel date = new JLabel("Date");
        date.setBounds(60, 280, 150, 25);
        date.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(date);
        
        lbldate = new JLabel();
        lbldate.setBounds(220, 280, 150, 25);
        add(lbldate);
        
        
        flights = new JButton("Cancel");
        flights.setBackground(Color.black);
        flights.setForeground(Color.white);
        flights.setBounds(220, 330, 120, 23);
        flights.addActionListener(this);
        add(flights);
        
        
        setSize(800,450);
        setLocation(350,150);
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
                tfname.setText(rs.getString("name"));
                lblcode.setText(rs.getString("flightcode"));
                lbldate.setText(rs.getString("ddate"));
                
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
        
        else if (ae.getSource()== flights){
        String name = tfname.getText();
        String pnr = tfpnr.getText();
        String cancelno = cancelnum.getText();
        String fcode = lblcode.getText();
        String date = lbldate.getText();
        
        try{
            Conn conn = new Conn();            
            String query = "insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            conn.S.executeUpdate(query);            
            conn.S.executeUpdate("delete from reservation where PNR ='"+pnr+"'"); 
            
            JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully");                
            setVisible(false);
        }
        catch (Exception e) {
            e.printStackTrace();            
            }
        } 
    }
}
