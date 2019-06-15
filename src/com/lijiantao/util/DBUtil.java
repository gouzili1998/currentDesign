package com.lijiantao.util;

import java.sql.*;

public class DBUtil {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/staff";
    private final String username = "root";
    private final String password = "12345678";
    private static DBUtil dbUtil;

    private Connection conn;

    private DBUtil() {

    }

    static {

    }
    public static DBUtil getInstance(){
        if(null == dbUtil) {
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(null == conn || conn.isClosed()) {
            Class.forName(driver);
            conn = DriverManager.getConnection(
                    url, username, password);
        }
        return conn;

    }


    public  void closeConnection(){
        try {
            if(null != conn || !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
