package com.senzmate.m2m.mysql;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnector {
    private static Connection connection = null;

    /**
     * Get a JDBC connection.
     *
     * @return connection or null
     */
    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                System.out.println("JDBC connection is null and connection now");
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/t_box", "root", "root");
                connection.setAutoReconnect(true);
            } else {
                System.out.println("Returning existing JDBC connection ");
                return connection;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?" + e);
            connection = null;
        } catch (SQLException e) {
            System.out.println("Connection Failed!" + e);
            connection = null;
        }
        return connection;
    }

    /**
     *
     * @param con
     */
    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception in closing JDBC connection!" + e);
        }
    }
}
