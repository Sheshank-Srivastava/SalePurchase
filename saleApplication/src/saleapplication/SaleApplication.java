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
public class SaleApplication extends JFrame{
    
    JMenuBar mbr = new JMenuBar();
    JMenu item,customer,supplier,orderReceive,order,sale,purchase ;
    JMenuItem addItem,deleteItem,updateItem,query;
    public SaleApplication(){
        
    }
    public  void firstFrame(){
        item = new JMenu("Item");
        addItem= new JMenuItem("Add Item");
        item.add(addItem);
        deleteItem= new JMenuItem("Delete Item");
        item.add(deleteItem);
        updateItem= new JMenuItem("updateItem");
        item.add(updateItem);
        query= new JMenuItem("Query");
        item.add(query);
        mbr.add(item);
        
        customer = new JMenu("Customer");
        mbr.add(customer);
        
        supplier = new JMenu("Supplier");
        mbr.add(supplier);
        
        orderReceive = new JMenu("Order Receive");
        mbr.add(orderReceive);
        
        order = new JMenu("Order");
        mbr.add(order);
        
        sale = new JMenu("Sale");
        mbr.add(sale);
        
        purchase = new JMenu("Purchase");
        mbr.add(purchase);
        
        setJMenuBar(mbr);
        addItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
              new Itementry();
            }
        
        });
        /**
         * frame attribute
         *
         */
        pack();
        setResizable(true);
        setLayout(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
