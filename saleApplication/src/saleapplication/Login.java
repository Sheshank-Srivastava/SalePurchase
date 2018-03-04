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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame {
    
    
    
    /**
     * Elements Declaration
     */
    JLabel titleL, usernameL, passwordL;
    JTextField userTf, passwordTf;
    JButton loginB, RegB;
   
    MakeConnection mc = new MakeConnection();
    Connection con;
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
               
               try{ 
                   String query ="select username from login where username=? and password=?";
                   con = mc.getConnection();
                   PreparedStatement ps =  con.prepareStatement(query);
                   ps.setString(1,userTf.getText());
                   ps.setString(2, passwordTf.getText());
                   ResultSet rs = ps.executeQuery();
                   if(rs.next()){
                       
                       setVisible(false);  
                       SaleApplication sa = new SaleApplication();
                       sa.firstFrame();
                       sa.setTitle("Sale-Purchase");
                   }   
                   else{
                       JOptionPane.showMessageDialog(loginB, "Invalid user name or Password");
                   }
               }catch(Exception e){
                    System.out.println(e); 
               }
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