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
public class DeleteItem extends JFrame{
    
    JLabel itemCode,itemName,rate,stockAvail,minLevel,maxLevel,preOrderLevel;
    JLabel itemNameT,rateT,stockAvailT,minLevelT,maxLevelT,preOrderLevelT;
    JTextField itemCodetf;
    public void DeleteItem(){
       itemCode =new JLabel("Item Code");
       itemCode.setBounds(10, 10, 60, 30);
       add(itemCode);
       /**
        * Frame Attributes
        */
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setVisible(true);
    }
}
