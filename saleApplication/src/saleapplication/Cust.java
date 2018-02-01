/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapplication;

import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class Cust extends JFrame {
    JLabel custName,custAdd,custCity,custState,custPin,custStatus;
    JTextField custNametf,custAddtf,custStatetf,custCitytf;
    JButton saveb;
    int xAxies=10,yAxies=30;
    public Cust(){
        yAxies+=20;
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
        saveb = new JButton("Save");
        saveb.setBounds(xAxies,yAxies,100,30);
        add(saveb);
        
        /**
         * panel attribute
         */
        setLayout(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
