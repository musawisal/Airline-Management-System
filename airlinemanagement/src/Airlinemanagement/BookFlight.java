package Airlinemanagement;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfcnic;
    JLabel tfname,tfnationality,tfaddress,labelgender,labelfname,labelfcode;
    JButton bookflight,fetchbutton,flights;
    Choice source, destination;
    JDateChooser dcdate;
         
    public BookFlight()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblCNIC = new JLabel("CNIC #");
        lblCNIC.setBounds(60, 80, 150, 25);
        lblCNIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblCNIC);
        
        tfcnic = new JTextField();
        tfcnic.setBounds(220, 80, 150, 25);
        add(tfcnic);
        
        fetchbutton= new JButton("Fetch User");
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
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 180, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
                
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60, 280, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);
        
                
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);
        
        try{
            Conn c= new Conn();
            String query = "select * from flight";
            ResultSet rs = c.S.executeQuery(query);
            
            while (rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        flights = new JButton("Fetch Flights");
        flights.setBackground(Color.black);
        flights.setForeground(Color.white);
        flights.setBounds(380, 379, 120, 23);
        flights.addActionListener(this);
        add(flights);
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("javaapplication40/icons/details.jpg"));
        Image i2=  i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 550, 80, 500, 410);
        add(lblimage);
             
        bookflight= new JButton("Book Flight");
        bookflight.setBackground(Color.black);
        bookflight.setForeground(Color.white);
        bookflight.setBounds(380, 580, 120, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setSize(1060,655);
        setLocation(85,20);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource()== fetchbutton)
        {
            
        String cnic = tfcnic.getText();
        
        try{
            Conn conn = new Conn();
            
            String query = "select * from passenger where cnic = '"+cnic+"'";
            conn.S.executeQuery(query);
            
            ResultSet rs = conn.S.executeQuery(query);
            
            if (rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
                
            }
            else{
                JOptionPane.showMessageDialog(null, "The CNIC entered is Invalid");
                
            }
        }
        
        catch (Exception e)
        {
            e.printStackTrace();            
        }
        }
        
        else if (ae.getSource()== flights){
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        
        try{
            Conn conn = new Conn();            
            String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";
            conn.S.executeQuery(query);            
            ResultSet rs = conn.S.executeQuery(query);
            
            if (rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));                
            }
            else{
                JOptionPane.showMessageDialog(null, "No Flights found");                
            }
        }
        catch (Exception e) {
            e.printStackTrace();            
            }
        } 
        else if(ae.getSource()==bookflight){
            Random random = new Random();            
            String cnic=tfcnic.getText();
            String name=tfname.getText();
            String nationality=tfnationality.getText();
            String flightname=labelfname.getText();
            String flightcode=labelfcode.getText();
            String src=source.getSelectedItem();
            String des=destination.getSelectedItem();
            String ddate= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into reservation values ('PNR- "+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+cnic+"', '"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"','"+ddate+"')";
                
                System.out.println("Executing query: " + query);  // Debug statement
                conn.S.executeUpdate(query);
                                
            
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);
                }
            
            catch (Exception e){
                e.printStackTrace();                
            }            
        }
        }
}

