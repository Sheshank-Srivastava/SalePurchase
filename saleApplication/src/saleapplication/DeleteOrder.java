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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author TANSU
 */
public class DeleteOrder extends JFrame{
    JLabel orderCode,orderItemId,orderItemIdtf,orderQuantitytf,orderPintf,orderRate,orderTotal,orderQuantity,orderPin,orderStatus,orderRatetf,orderTotaltf;
    JTextField orderCodetf;
    int xAxies=10,yAxies=30,focus=0,click=0;
    JButton saveb;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public DeleteOrder(){
        yAxies+=20;
        orderCode = new JLabel("Order Id");     //orderCode
        orderCode.setBounds(xAxies, yAxies, 120, 30);
        add(orderCode);
        orderCodetf = new JTextField();
        orderCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderCodetf);
        saveb = new JButton("Show");
        saveb.setBounds(xAxies+260,yAxies,100,30);
        add(saveb);
        
        yAxies+=40;
        orderItemId = new JLabel("Item Id");      //ItemId
        orderItemId.setBounds(xAxies, yAxies, 120, 30);
        add(orderItemId);
        orderItemIdtf = new JLabel();
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
        orderQuantitytf = new JLabel();
        orderQuantitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderQuantitytf);
        
        yAxies+=40;
        orderTotal = new JLabel("Total");     //Total
        orderTotal.setBounds(xAxies, yAxies, 120, 30);
        add(orderTotal);
        orderTotaltf = new JLabel();
        orderTotaltf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderTotaltf);
       
        saveb.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                click++;
                if(click==1){
                    saveb.setText("Delete");
                    try{
                        String query ="select itemid,rate,quantity,total from orders where orderno =?";
                        con = mc.getConnection();
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, orderCodetf.getText());
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            orderItemIdtf.setText(rs.getString(1));
                            orderRatetf.setText(rs.getString(2));
                            orderQuantitytf.setText(rs.getString(3));
                            orderTotaltf.setText(rs.getString(4));
                        }
                        else{
                            JOptionPane.showMessageDialog(orderItemIdtf, "Order doesn't Exist");
                        }
                    }catch(ClassNotFoundException | SQLException e){
                        System.out.println(e);
                    }
                }
                if(click==2){
                
                }
            }
        });
        /**
         * Frame Attribute
         */
        setLayout(null);
        setTitle("Delete Order");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
