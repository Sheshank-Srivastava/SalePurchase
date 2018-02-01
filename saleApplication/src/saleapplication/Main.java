/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author TANSU
 */
public class Main extends JFrame{
    JLabel titleL, usernameL, passwordL;
    JTextField rollTf, passwordTf;
    JButton loginB, RegB;
    
    /**
     * frame objects
     */
    
    
    public Main(){
        titleL = new JLabel("STUDENT MANAGEMENT SYSTEM");
        titleL.setBounds(10, 10, 500, 60);
        titleL.setFont(new Font("Serif", Font.BOLD, 27));
        titleL.setForeground(Color.GREEN);
        add(titleL);
        
        usernameL = new JLabel("Roll No.");
        usernameL.setBounds(80, 150, 100, 20);
        usernameL.setFont(new Font("Serif", Font.BOLD, 21));
        add(usernameL);
        
        rollTf = new JTextField();
        rollTf.setBounds(200, 150, 200, 30);
        add(rollTf);
        
        passwordL = new JLabel("Password");
        passwordL.setBounds(80, 200, 100, 20);
        passwordL.setFont(new Font("Serif", Font.BOLD, 21));
        add(passwordL);
        passwordTf = new JTextField();
        passwordTf.setBounds(200, 190, 200, 30);
        add(passwordTf);
        
        loginB = new JButton("Login");
        loginB.setBounds(200, 250, 80, 40);
        loginB.setForeground(Color.YELLOW);
        loginB.setBackground(Color.BLACK);
        add(loginB);
        
        loginB.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                SaleApplication sa =new SaleApplication();
                sa.firstFrame();
                this.setVisibile(false);
            }
            private void setVisibile(boolean b) {
                Main m = new Main();
                m.setVisible(b);
            }
            
        });
        setLayout(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public static void main(String[] args){
        SaleApplication sa = new SaleApplication();
        sa.firstFrame();
//        Itementry itementry = new Itementry();
//        itementry.itemFrame();
    }
}
