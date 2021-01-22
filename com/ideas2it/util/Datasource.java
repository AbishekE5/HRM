package com.ideas2it.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Datasource {
    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmain", "adminuser", "element5@123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
