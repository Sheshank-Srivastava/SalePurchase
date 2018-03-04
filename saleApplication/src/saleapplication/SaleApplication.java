/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author TANSU
 */
public class SaleApplication extends JFrame{
    
    JMenuBar mbr = new JMenuBar();
    JMenu item,customer,supplier,orderReceive,order,sale,purchase ;
    JMenuItem addItem,deleteItem,updateItem,query;      //Item
    JMenuItem cAddItem,cDeleteItem,cUpdateItem,cQuery;  //customer
    JMenuItem sAddItem,sDeleteItem,sUpdateItem,sQuery;  //suppiler
    JMenuItem oAddItem,oDeleteItem,oUpdateItem,oQuery;  //order
    JMenuItem orAddItem,orDeleteItem,orUpdateItem,orQuery;//order Recived
    JMenuItem saBill,saDeleteItem,saUpdateItem,saQuery;//sale
    JMenuItem pAddItem,pUpdateItem,pQuery;              //purchase
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
        oAddItem= new JMenuItem("Add Order");
        order.add(oAddItem);
        oDeleteItem= new JMenuItem("Delete Order");
        order.add(oDeleteItem);
        oUpdateItem= new JMenuItem("Update Order");
        order.add(oUpdateItem);
        oQuery= new JMenuItem("Query");
        order.add(oQuery); 
        mbr.add(order);
     //---------------------------------------------------------------   
        sale = new JMenu("Sale");
         saBill= new JMenuItem("Bill");
        sale.add(saBill);
        mbr.add(sale);
     //---------------------------------------------------------------   
        purchase = new JMenu("Purchase");
        pAddItem= new JMenuItem("Add purchase");
        purchase.add(pAddItem);
     
        pUpdateItem= new JMenuItem("Update Purchase");
        purchase.add(pUpdateItem);
        pQuery= new JMenuItem("Query");
        purchase.add(pQuery); 
        mbr.add(purchase);
     //---------------------------------------------------------------   
        setJMenuBar(mbr);
        /**
         * Action set to the "ITEM" menu
         */
        addItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                Itementry itementry = new Itementry();
                itementry.itemFrame(itementry);
            }
        });
        
        deleteItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new DeleteItem();
            }
        });
        updateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdateItem();
            }
        });
        query.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                QueryItem queryItem = new QueryItem();
            }
        
        });
        /**
         * Action set to the "CUSTOMER" Menu
         */
        cAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                AddCustomer addCustomer = new AddCustomer();
            }
        
        });
        cDeleteItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                DeleteCustomer deleteCustomer = new DeleteCustomer();
            }
        });
       cUpdateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                UpdateCustomer updateCustomer = new UpdateCustomer();
            }
        });
        cQuery.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                QueryCustomer queryCustomer = new QueryCustomer();
            }
        
        });
        /**
         * Action set to the "SUPPLIER" Menu
         */
        sAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new AddSupplier();
            }
        
        });
        sDeleteItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new DeleteSupplier();
            }
        });
        sUpdateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdateSupplier();
            }
        });
        sQuery.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
               QuerySupplier qs= new QuerySupplier();
               
            }
        
        });
        /**
         * Action set to the "Order Recived" Menu
         */
        orAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new AddOrderRecived();
            }
        
        });
        orDeleteItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new DeleteOrderRecived();
            }
        });
        orUpdateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdateOrderRecived();
            }
        });
        orQuery.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new QueryOrderRecived();
            }
        
        });
        /**
         * Action set to the "Order" Menu
         */
        oAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new AddOrder();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(SaleApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        oDeleteItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new DeleteOrder();
            }
        });
        oUpdateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdateOrder();
            }
        });
        oQuery.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new QueryOrder();
            }
        
        });
        /**
         * Action set to the "Sale"
         */
        saBill.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new SaBill();
            }
        });
        /**
         * Action set to the "Purchase"
         */
          pAddItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new AddPurchase();
            }
        
        });
     
        pUpdateItem.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new UpdatePurchase();
            }
        });
        pQuery.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                new QueryPurchase();
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
