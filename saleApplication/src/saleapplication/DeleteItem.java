/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class DeleteItem extends JFrame{
    
    JLabel itemCode,itemName,rate,stockAvail,minLevel,maxLevel,preOrderLevel;
    JLabel itemNameT,rateT,stockAvailT,minLevelT,maxLevelT,preOrderLevelT;
    JTextField itemCodetf;
    JButton action;
    String query=null;
    
    int xAxies =10,yAxies=10,click=0;
    MakeConnection mc = new MakeConnection();
       Connection con;
    public DeleteItem(){
        yAxies+=50;
        itemCode =new JLabel("Item Code");
        itemCode.setBounds(xAxies, yAxies, 60, 30);
        add(itemCode);
        itemCodetf = new JTextField();
        itemCodetf.setBounds(xAxies+100,yAxies, 100, 30);
        add(itemCodetf);
        action = new JButton("Show");
        action.setBounds(xAxies+230, yAxies, 80, 30);
        add(action);
//------------------------------------------------------------------------------
        yAxies+=50;
        itemName =new JLabel("Item Name");
        itemName.setBounds(xAxies, yAxies, 60, 30);
        add(itemName);
        itemNameT = new JLabel();
        itemNameT.setBounds(xAxies+100,yAxies, 100, 30);
        add(itemNameT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        rate =new JLabel("Rate");
        rate.setBounds(xAxies, yAxies, 60, 30);
        add(rate);
        rateT = new JLabel();
        rateT.setBounds(xAxies+100,yAxies, 100, 30);
        add(rateT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        stockAvail =new JLabel("Stock Available");
        stockAvail.setBounds(xAxies, yAxies, 100, 30);
        add(stockAvail);
        stockAvailT = new JLabel();
        stockAvailT.setBounds(xAxies+100,yAxies, 100, 30);
        add(stockAvailT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        minLevel =new JLabel("Min Level");
        minLevel.setBounds(xAxies, yAxies, 60, 30);
        add(minLevel);
        minLevelT = new JLabel();
        minLevelT.setBounds(xAxies+100,yAxies, 100, 30);
        add(minLevelT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        maxLevel =new JLabel("Max Level");
        maxLevel.setBounds(xAxies, yAxies, 60, 30);
        add(maxLevel);
        maxLevelT = new JLabel();
        maxLevelT.setBounds(xAxies+100,yAxies, 100, 30);
        add(maxLevelT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        preOrderLevel =new JLabel("Pre-Order Level");
        preOrderLevel.setBounds(xAxies, yAxies, 100, 30);
        add(preOrderLevel);
        preOrderLevelT = new JLabel();
        preOrderLevelT.setBounds(xAxies+100,yAxies, 100, 30);
        add(preOrderLevelT);
        /**
         * Action to the Button is Defined here
         * On First click All the Remaining Fields Are Filled from the database
         * And change the button Text to Delete
         */
        action.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                click++;
                int p=0;
                if(click==1){
                    query ="select itemName,rate,stockAvail,minLevel,maxLevel,preOrderLevel from salepurchase.itemdetail where itemCode=?";
                    System.out.println(itemCodetf.getText());
                    if(!"".equals(itemCodetf.getText())){
                        p=1;
                        System.out.println(p);
                    }
                    if(p==1){
                        try{
                            System.out.println("in execution");
                            con = mc.getConnection();
                            PreparedStatement ps = con.prepareStatement(query);
                            ps.setString(1, itemCodetf.getText());
                            ResultSet rs = ps.executeQuery();
                            
                            if(rs.next()){
                                System.out.println("hola");
                                itemNameT.setText(rs.getString(1));
                                rateT.setText(rs.getString(2));
                                stockAvailT.setText(rs.getString(3));
                                minLevelT.setText(rs.getString(4));
                                maxLevelT.setText(rs.getString(5));
                                preOrderLevelT.setText(rs.getString(6));
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
                    query ="delete from itemdetail where itemCode=?";
                    if(x==0){
                        try{
                            con = mc.getConnection();
                            PreparedStatement ps =con.prepareStatement(query);
                            ps.setString(1, itemCodetf.getText());
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
        /**
         * Frame Attributes
         */
        setTitle("Delete Item");
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
