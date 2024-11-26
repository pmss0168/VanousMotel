/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class DBO {
    final String HOST = "localhost:3306";
    final String DB = "project_j2ee";
    final String DB_USER = "root";
    final String DB_PASS = "Vajl0nchjmen@";
    public DBO() {
    }
    
    public Connection getConnection() throws Exception {
        String url = "jdbc:mysql://" + HOST + "/" + DB + "?autoReconnect=true&useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,DB_USER,DB_PASS);
    }
    
}
