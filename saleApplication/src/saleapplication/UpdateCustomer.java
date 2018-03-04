/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class UpdateCustomer extends JFrame{
    JLabel custCode,custName,custAdd,custCity,custState,custPin,custStatus;
    JTextField custNametf,custAddtf,custStatetf,custCitytf,custPintf,custCodetf;
    JComboBox status;
    JButton saveb;
    int xAxies=10,yAxies=30,click=0;
    String sta[] ={"Excellent","Good","Annoying"};
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public UpdateCustomer(){
        yAxies+=20;
        custCode = new JLabel("Customer Id");
        custCode.setBounds(xAxies, yAxies, 120, 30);
        add(custCode);
        custCodetf = new JTextField("");
        custCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custCodetf);
        saveb = new JButton("Find");
        saveb.setBounds(xAxies+260,yAxies,100,30);
        add(saveb);
        yAxies+=40;
        custName = new JLabel("Customer Name");
        custName.setBounds(xAxies, yAxies, 120, 30);
        custName.setVisible(false);
        add(custName);
        custNametf = new JTextField();
        custNametf.setBounds(xAxies+130, yAxies, 120, 30);
        custNametf.setVisible(false);
        add(custNametf);
        
        yAxies+=40;
        custAdd = new JLabel("Customer Address");
        custAdd.setBounds(xAxies, yAxies, 120, 30);
        custAdd.setVisible(false);
        add(custAdd);
        custAddtf = new JTextField();
        custAddtf.setBounds(xAxies+130, yAxies, 120, 30);
        custAddtf.setVisible(false);
        add(custAddtf);
        
        yAxies+=40;
        custState = new JLabel("State");
        custState.setBounds(xAxies, yAxies, 120, 30);
        custState.setVisible(false);
        add(custState);
        custStatetf = new JTextField();
        custStatetf.setBounds(xAxies+130, yAxies, 120, 30);
        custStatetf.setVisible(false);
        add(custStatetf);
        
        yAxies+=40;
        custCity = new JLabel("City");
        custCity.setBounds(xAxies, yAxies, 120, 30);
        custCity.setVisible(false);
        add(custCity);
        custCitytf = new JTextField();
        custCitytf.setBounds(xAxies+130, yAxies, 120, 30);
        custCitytf.setVisible(false);
        add(custCitytf);
        
        yAxies+=40;
        custPin= new JLabel("Pin");
        custPin.setBounds(xAxies, yAxies, 120, 30);
        custPin.setVisible(false);
        add(custPin);
        custPintf = new JTextField();
        custPintf.setBounds(xAxies+130, yAxies, 120, 30);
        custPintf.setVisible(false);
        add(custPintf);
        
        yAxies+=40;
        custStatus= new JLabel("Status");
        custStatus.setBounds(xAxies, yAxies, 120, 30);
        custStatus.setVisible(false);
        add(custStatus);
        status = new JComboBox(sta);
        status.setBounds(xAxies+130, yAxies, 120, 30);
        status.setVisible(false);
        add(status);
        saveb.addActionListener(new ActionListener(){
         
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
                                custNametf.setVisible(true);
                                custAddtf.setVisible(true);
                                custCitytf.setVisible(true);
                                custStatetf.setVisible(true);
                                custPintf.setVisible(true);
                                status.setVisible(true);
                                
                                custNametf.setText(rs.getString(1));
                                custAddtf.setText(rs.getString(2));
                                custCitytf.setText(rs.getString(3));
                                custStatetf.setText(rs.getString(4));
                                custPintf.setText(rs.getString(5));
                                status.setSelectedItem(rs.getString(6));
                                saveb.setText("Update");
                             }
                            else{
                                click=0;
                                JOptionPane.showMessageDialog(saveb, "Item Doesn't Exsist");
                            }
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(DeleteItem.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                        click--;
                        JOptionPane.showMessageDialog(saveb, "Fill the Item Code");
                    }
                }
                if(click==2){
                    int x= JOptionPane.showConfirmDialog(saveb, "Confirm Want to Delete");
                    query ="UPDATE customer SET custName=?,custAdd=?,city=?,custState=?,custPin=?,custStatus=? where custCode=?";
                    if(x==0){
                        try{
                            con = mc.getConnection();
                            PreparedStatement ps =con.prepareStatement(query);
                            ps.setString(1, custNametf.getText());
                            ps.setString(2, custAddtf.getText());
                            ps.setString(3, custCitytf.getText());
                            ps.setString(4, custStatetf.getText());
                            ps.setString(5, custPintf.getText());
                            ps.setString(6, status.getSelectedItem().toString());
                            ps.setString(7, custCodetf.getText());
                            int pp= ps.executeUpdate();
                            if(pp==1){
                                JOptionPane.showMessageDialog(saveb,"data is updated");
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
        setTitle("Update Customer");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
