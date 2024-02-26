package Database;

import java.sql.*;

public class Create {
    static final String DB_URL = "jdbc:mysql://127.0.0.2:3306/";
    static final String USER = "root";
    static final String PASS = "Alberto06";
    
    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()
        ) {
            String sql = "CREATE DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}