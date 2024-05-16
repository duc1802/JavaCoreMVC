package com.example.webapplication;

import  java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getMyConnection() throws SQLException {
        try {
            // Tải trình điều khiển JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }

        // Thông tin kết nối
        String url = "jdbc:mysql://localhost:3308/test2";
        String user = "root";
        String password = "";

        // Trả về kết nối
        return DriverManager.getConnection(url, user, password);
    }
}
