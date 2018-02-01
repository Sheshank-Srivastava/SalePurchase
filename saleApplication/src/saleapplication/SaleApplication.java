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
    JMenuItem oAddItem,oDeleteItem,oUpdateItem,oQuery;
    JMenuItem orAddItem,orDeleteItem,orUpdateItem,orQuery;
    JMenuItem saAddItem,saDeleteItem,saUpdateItem,saQuery;
    JMenuItem pAddItem,pUpdateItem,pQuery;
    public SaleApplication(){
        
    }
    public  void firstFrame(){
      //---------------------------------------------------------------
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
      //---------------------------------------------------------------  
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
      //---------------------------------------------------------------  
        supplier = new JMenu("Supplier");
        sAddItem= new JMenuItem("Add Supplier");
        supplier.add(sAddItem);
        sDeleteItem= new JMenuItem("Delete Supplier");
        supplier.add(sDeleteItem);
        sUpdateItem= new JMenuItem("Update Supplier");
        supplier.add(sUpdateItem);
        sQuery= new JMenuItem("Query");
        supplier.add(sQuery); 
        mbr.add(supplier);
       //--------------------------------------------------------------- 
        orderReceive = new JMenu("Order Receive");
        orAddItem= new JMenuItem("Add Order Receive");
        orderReceive.add(orAddItem);
        orDeleteItem= new JMenuItem("Delete Order Receive");
        orderReceive.add(orDeleteItem);
        orUpdateItem= new JMenuItem("Update Order Receive");
        orderReceive.add(orUpdateItem);
        orQuery= new JMenuItem("Query");
        orderReceive.add(orQuery); 
        mbr.add(orderReceive);
     //---------------------------------------------------------------   
        order = new JMenu("Order");
        oAddItem= new JMenuItem("Add Order Receive");
        order.add(oAddItem);
        oDeleteItem= new JMenuItem("Delete Order Receive");
        order.add(oDeleteItem);
        oUpdateItem= new JMenuItem("Update Order Receive");
        order.add(oUpdateItem);
        oQuery= new JMenuItem("Query");
        order.add(oQuery); 
        mbr.add(order);
     //---------------------------------------------------------------   
        sale = new JMenu("Sale");
        
        mbr.add(sale);
     //---------------------------------------------------------------   
        purchase = new JMenu("Purchase");
        pAddItem= new JMenuItem("Add Order Receive");
        purchase.add(pAddItem);
     
        pUpdateItem= new JMenuItem("Update Order Receive");
        purchase.add(pUpdateItem);
        pQuery= new JMenuItem("Query");
        purchase.add(pQuery); 
        mbr.add(purchase);
     //---------------------------------------------------------------   
        setJMenuBar(mbr);
        addItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                Itementry itementry = new Itementry();
                itementry.itemFrame(itementry);
            }
        });
        
        cAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
              
              
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
