/**
 * Provide the class necessary information to create database class
 */
package com.ideas2it.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * To create class providing connection instance
 */
public class Datasource {

    static Datasource datasource = null;

    private Datasource() {
    }

    /**
     * Method to connect with the jdbc connector
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmain", "adminuser", "element5@123");
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return connection;
    }

    /**
     * Method to get the instance of the private object
     */
    public static Datasource getInstance() {
        if (datasource == null) {
            datasource = new Datasource();
        }
        return datasource;
    }
}
