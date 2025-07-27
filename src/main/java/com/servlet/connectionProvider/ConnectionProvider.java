package com.servlet.connectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionProvider class is a utility class for creating a database connection.
 * It follows the Singleton design pattern by having a private constructor and providing a static method to get the connection.
 */
public class ConnectionProvider {

    // Private constructor to prevent instantiation
    private ConnectionProvider() {}

    public static Connection getConnection() {
        // Database connection URL for Oracle DB
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";  // Replace "orcl" with your actual service name/SID if different

        // Database username and password
        String userName = "advjava";
        String password = "abhi";

        try {
            // Load Oracle JDBC Driver (required for older versions of Java; optional in newer JDBC versions if using JDBC 4.0+)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded successfully.");

            // Establishing the database connection
            Connection con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection created successfully.");

            return con;  // Return the connection object
        } catch (ClassNotFoundException e) {
            // Handles the case where JDBC driver class is not found in the classpath
            System.err.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handles SQL-related exceptions (e.g., wrong credentials, network issues, invalid URL)
            System.err.println("SQL Exception while connecting:");
            e.printStackTrace();
        }

        // Return null if connection failed
        return null;
    }
}
