/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
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
public class DeleteCustomer  extends JFrame{
    JTextField custCodetf;
    JLabel custCode,custName,custAdd,custCity,custState,custPin,custStatus;
    JLabel custNametf,custAddtf,custStatetf,custCitytf,custPintf;
    JLabel status;
    JButton action;
    int xAxies=10,yAxies=30;
    String sta[] ={"Excellent","Good","Annoying"};
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    int click=0;
    public DeleteCustomer(){
        yAxies+=20;
        custCode = new JLabel("Customer Id");
        custCode.setBounds(xAxies, yAxies, 120, 30);
        add(custCode);
        custCodetf = new JTextField("");
        custCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custCodetf);
        action= new JButton("Show");
        action.setBounds(xAxies+260,yAxies,120,30);
        add(action);
        
        yAxies+=40;
        custName = new JLabel("Customer Name");
        custName.setBounds(xAxies, yAxies, 120, 30);
        custName.setVisible(false);
        add(custName);
        custNametf = new JLabel();
        custNametf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custNametf);
        
        yAxies+=40;
        custAdd = new JLabel("Customer Address");
        custAdd.setBounds(xAxies, yAxies, 120, 30);
        custAdd.setVisible(false);
        add(custAdd);
        custAddtf = new JLabel();
        custAddtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custAddtf);
        
        yAxies+=40;
        custState = new JLabel("State");
        custState.setBounds(xAxies, yAxies, 120, 30);
        custState.setVisible(false);
        add(custState);
        custStatetf = new JLabel();
        custStatetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custStatetf);
        
        yAxies+=40;
        custCity = new JLabel("City");
        custCity.setBounds(xAxies, yAxies, 120, 30);
        custCity.setVisible(false);
        add(custCity);
        custCitytf = new JLabel();
        custCitytf.setBounds(xAxies+130, yAxies, 120, 30);
        
        add(custCitytf);
        
        yAxies+=40;
        custPin= new JLabel("Pin");
        custPin.setBounds(xAxies, yAxies, 120, 30);
        custPin.setVisible(false);
        add(custPin);
        custPintf = new JLabel();
        custPintf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custPintf);
        
        yAxies+=40;
        custStatus= new JLabel("status");
        custStatus.setBounds(xAxies, yAxies, 120, 30);
        custStatus.setVisible(false);
        add(custStatus);
        status = new JLabel();
        status.setBounds(xAxies+130, yAxies, 120, 30);
        add(status);
       action.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                click++;
                int p=0;
                if(click==1){
                String query ="Select custName,custAdd,city,custState,custPin,custStatus from customer where custCode=?";
                    if(!"".equals(custCodetf.getText())){
                        p=1;
                        System.out.println(p);
                    }
                    if(p==1){
                        try {
                            con = mc.getConnection();
                            PreparedStatement ps = con.prepareStatement(query);
                            ps.setString(1, custCodetf.getText());
                            ResultSet rs = ps.executeQuery();
                            if(rs.next()){
                                custName.setVisible(true);
                                custAdd.setVisible(true);
                                custCity.setVisible(true);
                                custState.setVisible(true);
                                custPin.setVisible(true);
                                custStatus.setVisible(true); 
                               
                                custNametf.setText(rs.getString(1));
                                custAddtf.setText(rs.getString(2));
                                custCitytf.setText(rs.getString(3));
                                custStatetf.setText(rs.getString(4));
                                custPintf.setText(rs.getString(5));
                                status.setText(rs.getString(6));
                                action.setText("Delete");
                            }
                            else{
                                click=0;
                                JOptionPane.showMessageDialog(action, "Item Doesn't Exsist");
                            }
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                        click--;
                        JOptionPane.showMessageDialog(action, "Fill the Item Code");
                    }
                }
                if(click==2){
                    int x= JOptionPane.showConfirmDialog(action, "Confirm Want to Delete");
                    query ="delete from customer where custCode=?";
                    if(x==0){
                        try{
                            con = mc.getConnection();
                            PreparedStatement ps =con.prepareStatement(query);
                            ps.setString(1, custCodetf.getText());
                            p= ps.executeUpdate();
                            if(p==1){
                                JOptionPane.showMessageDialog(action,"data is deleted");
                              
                                click=0;
                            }
                        } catch (SQLException | ClassNotFoundException ex) {
                            Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
                    
                    
       });
        setLayout(null);
        setTitle("Delete Customer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
