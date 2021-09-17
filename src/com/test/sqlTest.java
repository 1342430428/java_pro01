package com.test;

import java.sql.*;
import java.util.ResourceBundle;

public class sqlTest {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String className = bundle.getString("classname");
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class driverClass = Class.forName(className);
            Driver driver = (Driver) driverClass.newInstance();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate("update t_user set create_time = now() where id = 2");
            System.out.println(count == 2 ? "更新成功" : "更新失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
