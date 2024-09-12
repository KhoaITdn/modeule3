package org.example.demo2.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// kết nối với DB
public class BaseRepository {
    private final Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/c0324i";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "codegym";

    public BaseRepository() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        //DriverManager quản lí những database mà ta connect tới, nó đang quản lí
        // 3 thông tin url, username , password
        System.out.println("Kết nối thành công");
    }
    public Connection getConnection(){
        return connection;
    }
}
