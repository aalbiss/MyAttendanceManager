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
            throw new RuntimeException(e);
        }
    }
    
    public void connect(){
        System.out.println("Connecting to a selected database...");
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected database successfully...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void add(String name, String username, String mail, String password, String userType){
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "'";
        PreparedStatement ps = null;
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next()) {
                id = rs.getInt("idNo");
            }
            if(id == 0){
                String query = "INSERT INTO sql_users.users(name, username, mail, password, userType) VALUES (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, mail);
                ps.setString(4, password);
                ps.setString(5, userType);
                ps.executeUpdate();
            }
            
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void remove(String name, String username, String mail, String password){
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "'";
        
        PreparedStatement ps = null;
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                id = rs.getInt("idNo");
            
            if(id != 0) {
                
                String queryRemove = "DELETE FROM sql_users.users WHERE idNo = ?";
                ps = con.prepareStatement(queryRemove);
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
    }
    
    public boolean checkExists(String name, String username, String mail, String password){
        
        int id = 0;
        boolean exist = false;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                id = rs.getInt("idNo");
            
            if(id != 0)
                exist = true;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        return exist;
        
    }
    
    public boolean checkExistsLogin(String username, String password){
        
        int id = 0;
        boolean exist = false;
        String queryFind = "SELECT idNo, username, password FROM sql_users.users WHERE username = '" + username +  "' AND  password = '" + password +  "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                id = rs.getInt("idNo");
            
            if(id != 0)
                exist = true;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return exist;
    }
    
    public boolean checkExistsSignin(String username, String mail){
        
        int id = 0;
        boolean exist = false;
        String queryFindUsername = "SELECT idNo, username FROM sql_users.users WHERE username = '" + username +  "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFindUsername);
            
            if (rs.next())
                id = rs.getInt("idNo");
            
            if(id != 0)
                exist = true;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        return exist;
        
    }
    
    public int checkExistsAdmin(){
        
        int id = 0;
        
        String queryFindUserType = "SELECT idNo, userType FROM sql_users.users WHERE userType = 'admin'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFindUserType);
            
            
            if (rs.next())
                id = rs.getInt("idNo");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(id);
        return id;
        
    }
    
    public String is(String username, String password){
        String userType = "";
        String queryFind = "SELECT userType, username, password FROM sql_users.users WHERE username = '" + username +  "' AND  password = '" + password +  "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                userType = rs.getString("userType");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return userType;
    }
    
    public static void main(String[] args) {

        DatabaseConnection dbConnection = new DatabaseConnection();
//        dbConnection.create();
//        dbConnection.connect();
//        dbConnection.add("Alberto", "suca", "albertoambrosi6@gmail.com", "Alberto06");
//        dbConnection.remove("Alberto", "suca", "albertoambrosi6@gmail.com", "Alberto06");
    }
    
}