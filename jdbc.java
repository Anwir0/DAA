/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cxt;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class jdbc {
   static String url = "jdbc:mysql://localhost:3306/db_levents";
   static String name = "root";
   static String pass = "178204";
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, name, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");
        }
    }
}
