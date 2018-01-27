/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class Itementry extends JFrame{
    JLabel itemCode,itemName,rate,StockAv,minLevel,maxLevel,preOrderLevel;
    JTextField itemCodetf,itemNametf,ratetf,StockAvtf,minLeveltf,maxLeveltf,preOrderLeveltf;
    JButton insert,update,delete;
    int xaxis =20,yaxis=50;
    
    String query;
    MakeConnection mc = new MakeConnection();
    Connection con;
    
    public void itemFrame(){
        
//------------------------------------------------------------------------------     itemCode
        itemCode= new JLabel("ItemCode");
        itemCode.setBounds(xaxis, yaxis, 60, 30);
        add(itemCode);
        itemCodetf = new JTextField();
        itemCodetf.setBounds(xaxis+80, yaxis, 100, 30);
        add(itemCodetf);
//------------------------------------------------------------------------------      itemName
        yaxis+=60;
        itemName = new JLabel("ItemName");
        itemName.setBounds(xaxis, yaxis, 60, 30);
        add(itemName);
        itemNametf = new JTextField();
        itemNametf.setBounds(xaxis+80, yaxis, 100, 30);
        add(itemNametf);
//------------------------------------------------------------------------------      rate
        yaxis+=60;
        rate = new JLabel("Rate");
        rate.setBounds(xaxis, yaxis, 60, 30);
        add(rate);
        ratetf = new JTextField();
        ratetf.setBounds(xaxis+80, yaxis, 100, 30);
        add(ratetf);
//------------------------------------------------------------------------------     StockAv
        yaxis+=60;
        StockAv = new JLabel("Stock Available");
        StockAv.setBounds(xaxis, yaxis, 100, 30);
        add(StockAv);
        StockAvtf = new JTextField();
        StockAvtf.setBounds(xaxis+80, yaxis, 100, 30);
        add(StockAvtf);
//------------------------------------------------------------------------------   minLevel
        yaxis+=60;
        minLevel = new JLabel("Min Level");
        minLevel.setBounds(xaxis, yaxis, 100, 30);
        add(minLevel);
        minLeveltf = new JTextField();
        minLeveltf.setBounds(xaxis+80, yaxis, 100, 30);
        add(minLeveltf);
//------------------------------------------------------------------------------        maxLevel
        yaxis+=60;
        maxLevel = new JLabel("Max Level");
        maxLevel.setBounds(xaxis, yaxis, 100, 30);
        add(maxLevel);
        maxLeveltf = new JTextField();
        maxLeveltf.setBounds(xaxis+80, yaxis, 100, 30);
        add(maxLeveltf);
//------------------------------------------------------------------------------     preOrderLevel
        yaxis+=60;
        preOrderLevel = new JLabel("PreOrder Level");
        preOrderLevel.setBounds(xaxis, yaxis, 100, 30);
        add(preOrderLevel);
        preOrderLeveltf = new JTextField();
        preOrderLeveltf.setBounds(xaxis+80, yaxis, 100, 30);
        add(preOrderLeveltf);
//------------------------------------------------------------------------------
        insert = new JButton("INSERT");
        insert.setBounds(250,50,100,40);
        add(insert);
        update = new JButton("UPDATE");
        update.setBounds(250,100,100,40);
        add(update);
        delete = new JButton("DELETE");
        delete.setBounds(250,150,100,40);
        add(delete);
        /**
         * Button Action
         */
         
        insert.addActionListener(new ActionListener(){
           String iCode=itemCodetf.getText(),iName=itemNametf.getText(),rat=ratetf.getText();
        String stockAvail=StockAvtf.getText(),minLev=minLeveltf.getText(),maxLev=maxLeveltf.getText();
        String preor=preOrderLeveltf.getText();
            @Override
            public void actionPerformed(ActionEvent ae) {
                query ="select itemCode from itemdetail where itemCode=?";
                try{
                    con = mc.getConnection();
                    PreparedStatement ps =con.prepareStatement(query);
                    ps.setString(1, itemCodetf.getText());
                    ResultSet p = ps.executeQuery();
                    if(p.next()){
                        JOptionPane.showMessageDialog(insert, "Item already exist");
                    }
                    else{
                        System.out.println("executing insert query");
                        query ="insert into itemdetail values(?,?,?,?,?,?,?)";
                        
                        PreparedStatement ps2 = con.prepareStatement(query);
                        ps2.setString(1, iCode);
                        ps2.setString(2, iName);
                        ps2.setString(3, rat);
                        ps2.setString(4, stockAvail);
                        ps2.setString(5, minLev);
                        ps2.setString(6, maxLev);
                        ps2.setString(7, preor);
                        int p2=ps2.executeUpdate();
                        if(p2==1){
                            System.out.println("successfull");                            
                        }
                        else{
                            System.out.println("not");
                        }
                              
                    }
                }catch(ClassNotFoundException | SQLException e){
                    System.out.println(e);
                }
            }
        });
        /**
         * Frame Attributes
         */
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
