package Airlinemanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
    
    public Home ()
    {
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("javaapplication40/icons/999.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(-130 , -50, 1600, 800);
        add(image);
                    
        JLabel imageLabel = new JLabel(i1);
        imageLabel.setBounds(-130, -50, 1600, 600);
        add(imageLabel);
        
        JLabel heading = new JLabel ("911 Air Welcomes You");
        heading.setBounds(630, 90, 1000, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahome", Font.PLAIN, 38));
        image.add(heading);
        
        //JMenuBar menubar= new JMenuBar();
        //setJMenuBar(menubar);
        
        //JMenu details= new JMenu("Details");
        //menubar.add(details);
        
        //JMenuItem flightdetails= new JMenuItem("Flight Details");
        //flightdetails.addActionListener(this);
        //details.add(flightdetails);
        
        JButton flightdetails= new JButton("Flight Details");
        flightdetails.setBackground(Color.black);
        flightdetails.setForeground(Color.white);
        flightdetails.setBounds(200, 150, 160, 30);
        flightdetails.addActionListener(this);
        add(flightdetails);
        
        JButton costumerdetails= new JButton("Add Costumer Details");
        costumerdetails.setBackground(Color.black);
        costumerdetails.setForeground(Color.white);
        costumerdetails.setBounds(200, 200, 160, 30);
        costumerdetails.addActionListener(this);
        add(costumerdetails);
        
        JButton bookfight= new JButton("Book Flight");
        bookfight.setBackground(Color.black);
        bookfight.setForeground(Color.white);
        bookfight.setBounds(200, 250, 160, 30);
        bookfight.addActionListener(this);
        add(bookfight);
        
        JButton journeydetails= new JButton("Journey Details");
        journeydetails.setBackground(Color.black);
        journeydetails.setForeground(Color.white);
        journeydetails.setBounds(200, 300, 160, 30);
        journeydetails.addActionListener(this);
        add(journeydetails);
        
        JButton ticketcancel= new JButton("Cancel Ticket");
        ticketcancel.setBackground(Color.black);
        ticketcancel.setForeground(Color.white);
        ticketcancel.setBounds(200, 350, 160, 30);
        ticketcancel.addActionListener(this);
        add(ticketcancel);
        
        JButton boardingpass= new JButton("Boarding Pass");
        boardingpass.setBackground(Color.black);
        boardingpass.setForeground(Color.white);
        boardingpass.setBounds(200, 400, 160, 30);
        boardingpass.addActionListener(this);
        add(boardingpass);
        
        /*JMenuItem costumerdetails= new JMenuItem("Add Costumer Details");
        costumerdetails.addActionListener(this);
        details.add(costumerdetails);
        
        JMenuItem bookfight= new JMenuItem("Book Flight");
        bookfight.addActionListener(this);
        details.add(bookfight);
        
        JMenuItem journeydetails= new JMenuItem("Journey Details");
        journeydetails.addActionListener(this);
        details.add(journeydetails);
        
        JMenuItem ticketcancel= new JMenuItem("Cancel Ticket");
        details.add(ticketcancel);
        
        JMenu ticket= new JMenu("Your Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingpass= new JMenuItem("Boarding Pass");
        ticket.add(boardingpass);*/
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(500,250);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) 
    {
        String text = ae.getActionCommand();
        
        if (text.equals("Add Costumer Details")){
            new AddCostumer();
        }
        else if (text.equals("Flight Details")){
            new FlightInfo();            
        }
        else if (text.equals("Book Flight")){
            new BookFlight();
        }
        else if (text.equals("Journey Details")){
            new JourneyDetails();
        }
        else if (text.equals("Cancel Ticket")){
            new Cancel();
        }
        else if (text.equals("Boarding Pass")){
            new Boarding();
        }
    }
    
}
