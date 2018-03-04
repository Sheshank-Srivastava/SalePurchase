/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapplication;

/**
 *
 * @author TANSU
 */
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame {
    
    
    
    /**
     * Elements Declaration
     */
    JLabel titleL, usernameL, passwordL;
    JTextField userTf, passwordTf;
    JButton loginB, RegB;
   

    public Login() {

        titleL = new JLabel("Sale Purchase");
        titleL.setBounds(90, 10, 500, 60);
        titleL.setFont(new Font("Serif", Font.BOLD, 27));
        titleL.setForeground(Color.GREEN);
        add(titleL);

        usernameL = new JLabel("User name");
        usernameL.setBounds(80, 150, 100, 20);
        usernameL.setFont(new Font("Serif", Font.BOLD, 21));
        add(usernameL);

        userTf = new JTextField();
        userTf.setBounds(200, 150, 200, 30);
        add(userTf);

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

      

        setBackground(Color.GRAY);
      
        loginB.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
               
            }
            
        });
        setLayout(null);
        setBounds(0,0,500,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new Login();
    }
}