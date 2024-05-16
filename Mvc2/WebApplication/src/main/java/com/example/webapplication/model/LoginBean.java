package com.example.webapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() throws SQLException {
        boolean status = false;
        try (Connection con = MyConnection.getMyConnection()) {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, this.username);
            ps.setString(2, this.password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        }
        return status;
    }
}
