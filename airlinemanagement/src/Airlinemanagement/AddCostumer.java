package Airlinemanagement;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class AddCostumer extends JFrame implements ActionListener{
    
    JTextField tfname,tfnationality,tfcnic,tfaddress,tfphone;
    JRadioButton rbmale,rbfemale;
    
    public AddCostumer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Costumer Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(60, 80, 150, 25);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblName);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblNationality = new JLabel("Nationality");
        lblNationality.setBounds(60, 130, 150, 25);
        lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel lblCNIC = new JLabel("CNIC #");
        lblCNIC.setBounds(60, 180, 150, 25);
        lblCNIC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblCNIC);
        
        tfcnic = new JTextField();
        tfcnic.setBounds(220, 180, 150, 25);
        add(tfcnic);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(60, 230, 150, 25);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setBounds(60, 280, 150, 25);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 280, 150, 25);
        add(tfphone);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(60, 330, 150, 25);
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblGender);
        
        ButtonGroup  gendergroup= new  ButtonGroup();
                
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 327, 80, 25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 327, 80, 25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.black);
        save.setForeground(Color.white);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
                
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("javaapplication40/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds( 450, 80, 280, 400);
        add(lblimage);
        
       
        setSize(900,600);
        setLocation(180,70);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String phone = tfphone.getText();
        String name =  tfname.getText();
        String address = tfaddress.getText();
        String nationality = tfnationality.getText();
        String cnic = tfcnic.getText();
        String gender = null;
        if (rbmale.isSelected())
        {
            gender = "Male";
        }
        else
        {
            gender = "Female";
        }
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"','"+address+"','"+cnic+"','"+gender+"')";
            conn.S.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Costumer Details Added Succesfuly");
            setVisible(false);
        
        }
        
        catch (Exception e){
            e.printStackTrace();
            
        }
    }
    
    
    
    
}
