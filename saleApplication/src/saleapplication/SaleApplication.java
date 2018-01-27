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
    JMenu file,search,edit ;
    public SaleApplication(){
        
    }
    public  void firstFrame(){
        JMenuItem item = new JMenuItem("Item");
        file =new JMenu("file");
        file.add(item);
        mbr.add(file);
        edit =new JMenu("edit");
        mbr.add(edit);
        search =new JMenu("search");
        mbr.add(search);
        setJMenuBar(mbr);
        item.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                Itementry ie = new Itementry();
                ie.itemFrame();
                
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
