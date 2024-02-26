package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatbaseConnection {
    
    private String DB_URL;
    private String USER;
    private String PASS;
    
    public DatbaseConnection() {
        DB_URL = "jdbc:mysql://localhost/";
        USER = "root";
        PASS = "Alberto06";
    }
    
    public void create() {
        
        
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()
        ) {
            String sql = "CREATE DATABASE SQL_USERS";
            String query = "CREATE TABLE sql_users.users(" +
                    "idNo INT(64) NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(45)," +
                    "username VARCHAR(45)," +
                    "mail VARCHAR(45)," +
                    "password VARCHAR(45)," +
                    "PRIMARY KEY(idNO))";
            stmt.executeUpdate(sql);
            stmt.executeUpdate(query);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void connect(){
        System.out.println("Connecting to a selected database...");
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void add(){
        String query = "INSERT INTO sql_users.users (name, username, mail, password) VALUES (1, 'Alberto', 'Ambrosi', 'albertoambrosi6@gmail.com', 'Alberto06')";
    }
    
    public static void main(String[] args) {
        
        DatbaseConnection dbConnection = new DatbaseConnection();
//        dbConnection.create();
        dbConnection.connect();
        dbConnection.add();
//        dbConnection.initialization();
    }
    
}