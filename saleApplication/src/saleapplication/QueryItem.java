/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author TANSU
 */
public class QueryItem  extends JFrame{
    JComboBox select;
    JTextField textfield;
    JButton action;
    String choise[]={"Item Code","Item Name","Rate","Stock"};
    public QueryItem(){
//        select = new JComboBox(choise);
//        select.setBounds(10,10,90,30);
//        add(select);
//        select.addActionListener(new ActionListener(){
//            
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                show();
//            }
//            
//        });
        /**
         * Frame Details
         */
        setLayout(null);
        setTitle("Query-Item");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
