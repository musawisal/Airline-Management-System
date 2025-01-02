package Airlinemanagement;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class JourneyDetails extends JFrame implements ActionListener{
    
    JTable table;  
    JLabel lblpnr;
    JTextField pnr;
    JButton show;
        public JourneyDetails(){
                        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(50, 50, 100, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show= new JButton("Show Details");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(280, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable ();
        
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 150);
        jsp.setBackground(Color.white);
        
        add(jsp);
       
        setSize(800, 600);
        setLocation(290, 55);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Conn conn = new Conn();
            ResultSet rs=conn.S.executeQuery("Select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            } else {
                
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception ae){
            ae.printStackTrace();
        }
    }
}

    

