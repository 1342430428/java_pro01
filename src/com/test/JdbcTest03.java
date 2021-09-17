package com.test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JdbcTest03 {
    public static void main(String[] args) {
        Map<String, String> userLoginInfo = initUI();
        boolean loginSuccess = login(userLoginInfo);
        System.out.println(loginSuccess ? "登陆成功" : "登陆失败");
    }

    private static boolean login(Map<String, String> userLoginInfo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loginSuccess = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode", "root", "123456");
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userLoginInfo.get("username"));
            stmt.setString(2, userLoginInfo.get("password"));
            rs = stmt.executeQuery();
            if (rs.next()) {
                loginSuccess = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {

                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return loginSuccess;
    }

    /**
     * 初始化用户界面
     *
     * @return用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String username = s.nextLine();
        System.out.print("请输入用户密码");
        String password = s.nextLine();
        Map<String, String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("username", username);
        userLoginInfo.put("password", password);
        return userLoginInfo;
    }
}
