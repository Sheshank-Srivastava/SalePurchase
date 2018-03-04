/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.*;
import java.text.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.Date;



/**
 *
 * @author TANSU
 */
public class AddOrder extends JFrame {
    JLabel orderCode,orderItemId,orderRate,orderTotal,orderQuantity,orderPin,orderStatus,orderCodetf,orderRatetf,orderTotaltf,custId,custName,custNametf,orderDate,orderDatetf,orderDel,orderDeltf;
    JTextField orderItemIdtf,orderQuantitytf,orderPintf,custIdtf;
    JComboBox status;
    String   sta[] ={"Excellent","Good","Annoying"};
    JButton saveb;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    JComboBox date,mon,year;
    String dat[]=new String[31],month[]={"January","Februrary","March","April","May","June","July","Augest","September","October","November","December"};
    Date da = new Date();
    int xAxies=10,yAxies=30,focus=0;
    MakeConnection mc = new MakeConnection();
    Connection con;
   
    public AddOrder() throws ClassNotFoundException, SQLException{
         for(int i=0;i<31;i++){
             dat[i]=Integer.toString(i+1);
         }
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
        
        orderRate = new JLabel("Rate");          //Rate
        orderRate.setBounds(xAxies+280, yAxies, 120, 30);
        add(orderRate);
        orderRatetf = new JLabel("aa");
        orderRatetf.setBounds(xAxies+350, yAxies, 120, 30);
        add(orderRatetf);
        
        yAxies+=40;
        custId = new JLabel("Customer Id"); //CUstomerId
        custId.setBounds(xAxies, yAxies, 120, 30);
        add(custId);
        custIdtf = new JTextField();
        custIdtf.setBounds(xAxies+130, yAxies, 120, 30);
        add(custIdtf);
        custName = new JLabel("Customer Name");          //name
        custName.setBounds(xAxies+280, yAxies, 120, 30);
        add(custName);
        custNametf = new JLabel("bb");
        custNametf.setBounds(xAxies+400, yAxies, 120, 30);
        add(custNametf);
        
        yAxies+=40;
        orderQuantity = new JLabel("Quantity");    //quantity
        orderQuantity.setBounds(xAxies, yAxies, 120, 30);
        add(orderQuantity);
        orderQuantitytf = new JTextField();
        orderQuantitytf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderQuantitytf);
        
        yAxies+=40;
        orderDate = new JLabel("Date Of order");    //Order date
        orderDate.setBounds(xAxies, yAxies, 120, 30);
        add(orderDate);
        orderDatetf = new JLabel("bb");
        orderDatetf.setText(df.format(da));
        orderDatetf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderDatetf);
        
        yAxies+=40;
        orderDel = new JLabel("Date Of Delivery");    //Delivery date
        orderDel.setBounds(xAxies, yAxies, 120, 30);
        add(orderDel);
       
        date = new JComboBox(dat);
        date.setBounds(xAxies+130, yAxies, 50, 30);
        add(date);
        yAxies+=40;
        orderTotal = new JLabel("Total");     //Total
        orderTotal.setBounds(xAxies, yAxies, 120, 30);
        add(orderTotal);
        orderTotaltf = new JLabel("cc");
        orderTotaltf.setBounds(xAxies+130, yAxies, 120, 30);
        add(orderTotaltf);
        
        yAxies+=40;
        saveb = new JButton("Save");
        saveb.setBounds(xAxies,yAxies,100,30);
        add(saveb);
        try{
            
            String code=null,query="select orderno from orders";
            con =mc.getConnection();
            PreparedStatement ps =con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while(rs.next()){
                code = rs.getString(1);
            }
            int newCode = Integer.parseInt(code);
            newCode= newCode+1;
            code = Integer.toString(newCode);
            orderCodetf.setText(code);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        
        orderItemIdtf.addFocusListener(new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent fe) {
                
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                if(!"".equals(orderItemIdtf.getText())){
                    try{
                        String query ="select rate from itemdetail where itemCode =?";
                        con = mc.getConnection();
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, orderItemIdtf.getText());
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            orderRatetf.setText(rs.getString(1));
                        }
                        else{
                            JOptionPane.showMessageDialog(orderItemIdtf, "Item doesn't Exist");
                        }
                    }catch(ClassNotFoundException | SQLException e){
                        System.out.println(e);
                    }
                }
            }
        });
        custIdtf.addFocusListener(new FocusListener(){
            
            @Override
            public void focusGained(FocusEvent fe) {
                
            }
            
            @Override
            public void focusLost(FocusEvent fe) {
                if(!"".equals(custIdtf.getText())){
                    try{
                        String query ="select custname from customer where custCode =?";
                        con = mc.getConnection();
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, custIdtf.getText());
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            custNametf.setText(rs.getString(1));
                        }
                        else{
                            JOptionPane.showMessageDialog(orderItemIdtf, "Item doesn't Exist");
                        }
                    }catch(ClassNotFoundException | SQLException e){
                        System.out.println(e);
                    }
                }
            }
        });
        saveb.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                long total;
                total = (long) Integer.parseInt(orderRatetf.getText())*Integer.parseInt(orderQuantitytf.getText());
                String pp= String.valueOf(total);
                orderTotaltf.setText(pp);
                try{
                    String query ="insert into orders values(?,?,?,?,?)";
                    String query2 ="select stockAvail from itemdetail where itemcode=?";
                    con = mc.getConnection();
                    PreparedStatement ps2= con.prepareStatement(query2);
                    ps2.setString(1, orderItemIdtf.getText());
                    ResultSet rs = ps2.executeQuery();
                    if(rs.next()){
                        int qty=Integer.parseInt(rs.getString(1));
                        if(qty<=Integer.parseInt(orderQuantitytf.getText())){
                           
                        }
                         PreparedStatement ps = con.prepareStatement(query);
                            ps.setString(1, orderCodetf.getText());
                            ps.setString(2, orderItemIdtf.getText());
                            ps.setString(3, orderRatetf.getText());
                            ps.setString(4, orderQuantitytf.getText());
                            ps.setString(5, orderTotaltf.getText());
                            int p =ps.executeUpdate();
                            if(p==1){
                                JOptionPane.showMessageDialog(saveb, "Order is saved");
                            }
                            else{
                                System.out.println("xghjkl");
                            }
                    }
                }catch(ClassNotFoundException | SQLException ex){
                    System.out.println(ex);
                }
            }
            
        });
        /**
         * frame attributes
         */
        setLayout(null);
        setTitle("Rate Order");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}


