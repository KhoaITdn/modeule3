package org.example.demo2.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// kết nối với DB
public class BaseRepository {
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/c0324i";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "codegym";

public BaseRepository(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("Ket noi thanh cong");
    } catch (ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }

}
public Connection getConnection(){
    return connection;
}
}