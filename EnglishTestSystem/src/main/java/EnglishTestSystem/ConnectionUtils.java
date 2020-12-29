/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnglishTestSystem;

import java.sql.*;

/**
 *  hàm lấy connection
 * @author Admin
 */
public class ConnectionUtils {
    private static final String hostName = "localhost";
    private static final String dbName = "englishtest";
    private static final String userName = "host";
    private static final String password = "12345678";
    private static final String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
    
    //   try { 
    //       Class.forName("com.mysql.cj.jdbc.Driver");
    //     Connection conn = DriverManager
    //     .getConnection("jdbc:mysql://localhost:3306/englishtest", "root", "12345678");

    //     if (conn != null) {
    //         System.out.println("Connected to the database!");
    //     } else {
    //         System.out.println("Failed to make connection!");
    //     }

    //     } catch (SQLException e) {
    //         System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
 
    public static Connection openConnection() throws SQLException {
        // 1. Load Driver
        // Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
 
        // 2. Open connection
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
