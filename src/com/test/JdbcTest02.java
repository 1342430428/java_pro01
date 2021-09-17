package com.test;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcTest02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            String className = bundle.getString("classname");
            Class sqlClass = Class.forName(className);
            Driver driver = (Driver) sqlClass.newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection("jdbc:mysql:127.0.0.1:3306/bjpowernode", "root", "123456");
            stmt = conn.createStatement();
            String sql = "";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "成功" : "失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
