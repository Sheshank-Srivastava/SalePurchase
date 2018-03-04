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
public class UpdateOrder extends JFrame{
    JLabel orderCode,orderItemId,orderRate,orderTotal,orderQuantity,orderPin,orderStatus,orderCodetf,orderRatetf,orderTotaltf;
    JTextField orderItemIdtf,orderQuantitytf,orderPintf;
    JComboBox status;
    String   sta[] ={"Excellent","Good","Annoying"},query;
    JButton saveb;
    int xAxies=10,yAxies=30,focus=0,click=0;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public UpdateOrder(){
        
        yAxies+=20;
        orderCode = new JLabel("Order Id");     //orderCode
        orderCode.setBounds(xAxies, yAxies, 120, 30);
        add(orderCode);
        orderCodetf = new JLabel("7011");
        orderCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderCodetf);
        yAxies+=40;
        orderItemId = new JLabel("Item Id");      //ItemId
        orderItemId.setBounds(xAxies, yAxies, 120, 30);
        add(orderItemId);
        orderItemIdtf = new JTextField();
        orderItemIdtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderItemIdtf);
        
        yAxies+=40;
        orderRate = new JLabel("Rate");          //Rate
        orderRate.setBounds(xAxies, yAxies, 120, 30);
        add(orderRate);
        orderRatetf = new JLabel();
        orderRatetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderRatetf);
        
        yAxies+=40;
        orderQuantity = new JLabel("Quantity");    //quantity
        orderQuantity.setBounds(xAxies, yAxies, 120, 30);
        add(orderQuantity);
        orderQuantitytf = new JTextField();
        orderQuantitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderQuantitytf);
        
        yAxies+=40;
        orderTotal = new JLabel("Total");     //Total
        orderTotal.setBounds(xAxies, yAxies, 120, 30);
        add(orderTotal);
        orderTotaltf = new JLabel();
        orderTotaltf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderTotaltf);
        
        yAxies+=40;
        saveb = new JButton("Show");
        saveb.setBounds(xAxies,yAxies,100,30);
        add(saveb);
        saveb.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                click++;
                if(click==1){
                    try{
                        query ="select itemid,rate,quantity,total from orders where orderno =?";
                        con = mc.getConnection();
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, orderCodetf.getText());
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            orderItemIdtf.setText(rs.getString(1));
                            orderRatetf.setText(rs.getString(2));
                            orderQuantitytf.setText(rs.getString(3));
                            orderTotaltf.setText(rs.getString(4));
                            saveb.setText("Delete");
                        }
                        else{
                            JOptionPane.showMessageDialog(orderItemIdtf, "Order doesn't Exist");
                            click=0;
                        }
                        if(click==2){
                            
                        }
                    }catch(ClassNotFoundException | SQLException e){
                        System.out.println(e);
                    }
                }
                if(click==2){
                    query ="delete from orders where orderno =?";
                    try {
                        con = mc.getConnection();
                        PreparedStatement ps = con.prepareStatement(query);
                        int rs = ps.executeUpdate(query);
                        if(rs==1){
                            JOptionPane.showMessageDialog(saveb,"order has been delete");
                        }
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(UpdateOrder.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
            }
        });
        /**
         * Frame Attributee
         */
        setLayout(null);
        setTitle("Update Order");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
