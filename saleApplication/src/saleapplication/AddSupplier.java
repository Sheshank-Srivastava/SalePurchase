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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class AddSupplier extends JFrame {
    JLabel supplierId,suppilerName,suppilerAdd,suppilerState,suppilerPin,suppilerCity,suppilerStatus,suppilerIdtf;
    JTextField suppilerNametf,suppilerAddtf,suppilerStatetf,suppilerCitytf,suppilerPintf;
    JButton action;
    JComboBox status;
    int xAxies,yAxies;
    String sta[] ={"Excellent","Good","Annoying"};
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public AddSupplier(){
        yAxies+=20;
        supplierId = new JLabel("Suppiler Id");
        supplierId.setBounds(xAxies, yAxies, 120, 30);
        add(supplierId);
        suppilerIdtf = new JLabel("");
        suppilerIdtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerIdtf);
        yAxies+=40;
        suppilerName = new JLabel("Suppiler Name");
        suppilerName.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerName);
        suppilerNametf = new JTextField();
        suppilerNametf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerNametf);
        
        yAxies+=40;
        suppilerAdd = new JLabel("Suppiler Address");
        suppilerAdd.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerAdd);
        suppilerAddtf = new JTextField();
        suppilerAddtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerAddtf);
        
        yAxies+=40;
        suppilerState = new JLabel("Suppiler State");
        suppilerState.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerState);
        suppilerStatetf = new JTextField();
        suppilerStatetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerStatetf);
        
        yAxies+=40;
        suppilerCity = new JLabel("Suppiler City");
        suppilerCity.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerCity);
        suppilerCitytf = new JTextField();
        suppilerCitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerCitytf);
        
        yAxies+=40;
        suppilerPin= new JLabel("Supplier Pin");
        suppilerPin.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerPin);
        suppilerPintf = new JTextField();
        suppilerPintf.setBounds(xAxies+130, yAxies, 120, 30);
        add(suppilerPintf);
         
        yAxies+=40;
        suppilerStatus= new JLabel("Status");
        suppilerStatus.setBounds(xAxies, yAxies, 120, 30);
        add(suppilerStatus);
        status = new JComboBox(sta);
        status.setBounds(xAxies+130, yAxies, 120, 30);
        add(status);
        
        yAxies+=40;
        action = new JButton("Save");
        action.setBounds(xAxies,yAxies,100,30);
        add(action);
        try{
            String custCode = "";
            int newCode;
            query="select suppilerid from salepurchase.suppiler";
            con = mc.getConnection();
            PreparedStatement ps= con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                custCode =rs.getString(1);
                System.out.println(custCode);
            }
            if(custCode==""){
               newCode = Integer.parseInt(custCode)+1;
               suppilerIdtf.setText(Integer.toString(newCode));
               System.out.println(newCode);
            }
            else{
                custCode ="991";
                newCode = Integer.parseInt(custCode)+1;
                System.out.println(newCode);
            }
           suppilerIdtf.setText(Integer.toString(newCode));
        }catch(ClassNotFoundException | SQLException e){
            
        }
        action.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    System.out.println("hello");
                    query ="insert into salepurchase.suppiler values(?,?,?,?,?,?,?)";
                    con = mc.getConnection();
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1,suppilerIdtf.getText());
                    ps.setString(2, suppilerNametf.getText());
                    ps.setString(3, suppilerAddtf.getText());
                    ps.setString(4, suppilerStatetf.getText());
                    ps.setString(5,suppilerCitytf.getText());
                    ps.setString(6, suppilerPintf.getText());
                    ps.setString(7, status.getSelectedItem().toString());
                    int p =ps.executeUpdate();
                    if(p==1){
                        JOptionPane.showMessageDialog(action, "update Successfull");
                    }
                    else{
                        JOptionPane.showMessageDialog(action, "update unSuccessfull");
                    }
                }catch(SQLException | HeadlessException e){
                    System.out.println(e);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        /**
         * Frame Attribute
         */
        setLayout(null);
        setTitle("Add Supplier");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
