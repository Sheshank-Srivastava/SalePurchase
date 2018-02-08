/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author TANSU
 */
public class AddCustomer  extends JFrame{
    JLabel custCode,custName,custAdd,custCity,custState,custPin,custStatus,custCodetf;
    JTextField custNametf,custAddtf,custStatetf,custCitytf,custPintf;
    JComboBox status;
    JButton saveb;
    int xAxies=10,yAxies=30;
    String sta[] ={"Excellent","Good","Annoying"};
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public AddCustomer(){
        yAxies+=20;
        custCode = new JLabel("Customer Id");
        custCode.setBounds(xAxies, yAxies, 120, 30);
        add(custCode);
        custCodetf = new JLabel("--");
        custCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custCodetf);
        yAxies+=40;
        custName = new JLabel("Customer Name");
        custName.setBounds(xAxies, yAxies, 120, 30);
        add(custName);
        custNametf = new JTextField();
        custNametf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custNametf);
        
        yAxies+=40;
        custAdd = new JLabel("Customer Address");
        custAdd.setBounds(xAxies, yAxies, 120, 30);
        add(custAdd);
        custAddtf = new JTextField();
        custAddtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custAddtf);
        
        yAxies+=40;
        custState = new JLabel("State");
        custState.setBounds(xAxies, yAxies, 120, 30);
        add(custState);
        custStatetf = new JTextField();
        custStatetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custStatetf);
        
        yAxies+=40;
        custCity = new JLabel("City");
        custCity.setBounds(xAxies, yAxies, 120, 30);
        add(custCity);
        custCitytf = new JTextField();
        custCitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custCitytf);
        
        yAxies+=40;
        custPin= new JLabel("Pin");
        custPin.setBounds(xAxies, yAxies, 120, 30);
        add(custPin);
        custPintf = new JTextField();
        custPintf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custPintf);
        
        yAxies+=40;
        custStatus= new JLabel("Status");
        custStatus.setBounds(xAxies, yAxies, 120, 30);
        add(custStatus);
        status = new JComboBox(sta);
        status.setBounds(xAxies+130, yAxies, 120, 30);
        add(status);
        
        yAxies+=40;
        saveb = new JButton("Save");
        saveb.setBounds(xAxies,yAxies,100,30);
        add(saveb);
        
        /**
         * Genetrating Customer Code
         */
        try{
            String custCode = null;
            query="select custCode from customer";
            con = mc.getConnection();
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                custCode =rs.getString(1);
            }
            int newCode = Integer.parseInt(custCode)+1;
            custCodetf.setText(Integer.toString(newCode));
        }catch(ClassNotFoundException | SQLException e){
            
        }
        /**
         * Define Action to the save Button
         */
        saveb.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    System.out.println("hello");
                    query ="insert into customer values(?,?,?,?,?,?,?)";
                    con = mc.getConnection();
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1,custCodetf.getText());
                    ps.setString(2, custNametf.getText());
                    ps.setString(3, custAddtf.getText());
                    ps.setString(4, custStatetf.getText());
                    ps.setString(5,custCitytf.getText());
                    ps.setString(6, custPintf.getText());
                    ps.setString(7, status.getSelectedItem().toString());
                    int p =ps.executeUpdate();
                    if(p==1){
                        JOptionPane.showMessageDialog(saveb, "update Successfull");
                    }
                    else{
                        JOptionPane.showMessageDialog(saveb, "update unSuccessfull");
                    }
                }catch(SQLException | HeadlessException e){
                    System.out.println(e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        /**
         * panel attribute
         */
        setLayout(null);
        setVisible(true);
        setTitle("Add Customer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
