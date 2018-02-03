/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapplication;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class UpdateItem extends JFrame {
    JLabel itemCode,itemName,rate,stockAvail,minLevel,maxLevel,preOrderLevel;
    JTextField itemNameT,rateT,stockAvailT,minLevelT,maxLevelT,preOrderLevelT;
    JTextField itemCodetf;
    JButton action;
    int xAxies =10,yAxies=10,click=0;
      public UpdateItem(){
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
        itemNameT = new JTextField("--");
        itemNameT.setBounds(xAxies+100,yAxies, 100, 30);
        add(itemNameT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        rate =new JLabel("Rate");
        rate.setBounds(xAxies, yAxies, 60, 30);
        add(rate);
        rateT = new JTextField("--");
        rateT.setBounds(xAxies+100,yAxies, 100, 30);
        add(rateT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        stockAvail =new JLabel("Stock Available");
        stockAvail.setBounds(xAxies, yAxies, 100, 30);
        add(stockAvail);
        stockAvailT = new JTextField("--");
        stockAvailT.setBounds(xAxies+100,yAxies, 100, 30);
        add(stockAvailT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        minLevel =new JLabel("Min Level");
        minLevel.setBounds(xAxies, yAxies, 60, 30);
        add(minLevel);
        minLevelT = new JTextField("--");
        minLevelT.setBounds(xAxies+100,yAxies, 100, 30);
        add(minLevelT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        maxLevel =new JLabel("Max Level");
        maxLevel.setBounds(xAxies, yAxies, 60, 30);
        add(maxLevel);
        maxLevelT = new JTextField("--");
        maxLevelT.setBounds(xAxies+100,yAxies, 100, 30);
        add(maxLevelT);
//-----------------------------------------------------------------------------
        yAxies+=50;
        preOrderLevel =new JLabel("Pre-Order Level");
        preOrderLevel.setBounds(xAxies, yAxies, 100, 30);
        add(preOrderLevel);
        preOrderLevelT = new JTextField("--");
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
                if(click==1){
                    action.setText("Update");
                    
                }
                if(click==2){
                    JOptionPane.showConfirmDialog(action, "Confirm Want to Update");
                }
            }
            
        });
        /**
         * Frame Attributes
         */
        setTitle("Update-Item");
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
