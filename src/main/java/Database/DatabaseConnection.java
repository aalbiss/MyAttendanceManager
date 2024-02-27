package Database;

import java.sql.*;

public class DatabaseConnection {
    
    private final String DB_URL;
    private final String USER;
    private final String PASS;
    
    public DatabaseConnection() {
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
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void add(String name, String username, String mail, String password){
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "'";
        
        
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind)
        ) {
            if (rs.next()) {
                id = rs.getInt("idNo");
            }
            if(id == 0){
                String query = "INSERT INTO sql_users.users (name, username, mail, password) VALUES ('" + name + "', '" + username + "', '" + mail + "', '" + password + "')";
                stmt.executeUpdate(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        if(id == 0){
            System.out.println("Non esiste");
        }else{
            System.out.println("Esiste");
        }
        
    }
    
    public void remove(String name, String username, String mail, String password){
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "'";
        
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind)
        ) {
            if (rs.next()) {
                id = rs.getInt("idNo");
            }
            if(id != 0) {
                String queryRemove = "DELETE FROM sql_users.users WHERE idNo = " + id;
                stmt.executeUpdate(queryRemove);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public static void main(String[] args) {
        
        DatabaseConnection dbConnection = new DatabaseConnection();
//        dbConnection.create();
//        dbConnection.connect();
//        dbConnection.add("Alberto", "suca", "albertoambrosi6@gmail.com", "Alberto06");
//        dbConnection.remove("Alberto", "suca", "albertoambrosi6@gmail.com", "Alberto06");
    
    
    
    }
    
}