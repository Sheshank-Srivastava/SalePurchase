/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package saleapplication;

import java.sql.*;
/**
 *
 * @author TANSU
 */
public class MakeConnection {
    public static String url = "jdbc:mysql://localhost:3306/salepurchase";
    public static String uname = "root";
    public static String password = "root";
    public MakeConnection(){}
    Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;
        con = DriverManager.getConnection(url,uname,password);
        return con;
    }
}
