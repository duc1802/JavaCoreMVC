package com.example.webapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean {
    private Connection conn;

    public LoginBean() throws SQLException {
        // Khởi tạo kết nối tại constructor
        conn = MyConnection.getMyConnection();
    }

    public boolean checkLogin(String username, String password) throws SQLException {
        boolean isValid = false;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}


