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
    JMenuItem cAddItem,cDeleteItem,cUpdateItem,cQuery;
    JMenuItem sAddItem,sDeleteItem,sUpdateItem,sQuery;
    JMenuItem orAddItem,orDeleteItem,orUpdateItem,orQuery;
    JMenuItem saAddItem,saDeleteItem,saUpdateItem,saQuery;
    JMenuItem pAddItem,pDeleteItem,pUpdateItem,pQuery;
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
        cAddItem= new JMenuItem("Add Customer");
        customer.add(cAddItem);
        cDeleteItem= new JMenuItem("Delete Customer");
        customer.add(cDeleteItem);
        cUpdateItem= new JMenuItem("Update Customer");
        customer.add(cUpdateItem);
        cQuery= new JMenuItem("Query");
        customer.add(cQuery); 
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
                Itementry itementry = new Itementry();
                itementry.itemFrame();
            }
        });
        
        cAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
              
               new Cust();
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
    }
    
}
