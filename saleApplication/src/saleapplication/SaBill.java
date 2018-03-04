/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class SaBill extends JFrame{
    JLabel billCode,orderNo,quantity,tax,billAmount,billPin,billStatus,billCodetf;
    JTextField orderNotf,quantitytf,billAmounttf,taxtf,billPintf;
    JComboBox status;
    JButton saveb;
    int xAxies=10,yAxies=30;
    String   sta[] ={"Excellent","Good","Annoying"};
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    public SaBill(){
        yAxies+=20;
        billCode = new JLabel("Bill id");
        billCode.setBounds(xAxies, yAxies, 120, 30);
        add(billCode);
        billCodetf = new JLabel("--");
        billCodetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(billCodetf);
        yAxies+=40;
        orderNo = new JLabel("Order no");
        orderNo.setBounds(xAxies, yAxies, 120, 30);
        add(orderNo);
        orderNotf = new JTextField();
        orderNotf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderNotf);
        
        yAxies+=40;
        quantity = new JLabel("Quantity Dispatch");
        quantity.setBounds(xAxies, yAxies, 120, 30);
        add(quantity);
        quantitytf = new JTextField();
        quantitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(quantitytf);
        
        yAxies+=40;
        billAmount = new JLabel("Amount");
        billAmount.setBounds(xAxies, yAxies, 120, 30);
        add(billAmount);
        billAmounttf = new JTextField();
        billAmounttf.setBounds(xAxies+130, yAxies, 120, 30);
        add(billAmounttf);
        
        yAxies+=40;
        tax = new JLabel("Tax");
        tax.setBounds(xAxies, yAxies, 120, 30);
        add(tax);
        taxtf = new JTextField();
        taxtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(taxtf);
      
        /**
         * frame attributes
         */
        setLayout(null);
        setTitle("Rate Order");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
