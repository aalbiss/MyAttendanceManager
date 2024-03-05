package Database;

import model.User;

import java.sql.*;

public class UserDao {
    
    private final String DB_URL = "jdbc:mysql://localhost/";
    private final String USER = "root";
    private final String PASS = "Alberto06";
    
    public void addUser(User user){
        
        String name = user.getFullName();
        String username = user.getUsername();
        String mail = user.getMail();
        String password = user.getPassword();
        String role = user.getRole();
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password + "' AND role = '" + role + "'";
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
                String query = "INSERT INTO sql_users.users(name, username, mail, password, role) VALUES (?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, mail);
                ps.setString(4, password);
                ps.setString(5, role);
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
    
    public void removeUser(User user){
        
        String name = user.getFullName();
        String username = user.getUsername();
        String mail = user.getMail();
        String password = user.getPassword();
        String role = user.getRole();
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.users WHERE name = '" + name +  "' AND username = '" + username +  "' AND mail = '" + mail +  "' AND  password = '" + password +  "' AND role = '" + role + "'";
        
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
    
    public boolean checkExistUser(User user){

        String username = user.getUsername();
        String mail = user.getMail();
        
        int id = 0;
        boolean exist = false;
        String queryFindUsername = "SELECT idNo, username, mail FROM sql_users.users WHERE username = '" + username +  "' AND mail = '" + mail + "'";
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
    
    public int checkExistsAdmin(User user){
        
        String role = user.getRole();
        
        int id = 0;
        
        String queryFindRole = "SELECT idNo, role FROM sql_users.users WHERE role = 'admin'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFindRole);
            
            
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
        return id;
        
    }
    
    public boolean checkExistProfessor(String name){
        
        boolean exists = false;
        String queryFindProfessor = "SELECT idNo, name, role FROM sql_users.users WHERE name LIKE '%" + name + "%' AND role = 'professor'";
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFindProfessor);

            if(rs.next()){
                exists = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        return exists;
    }
    
    public String getNameProfessor(String name){
        
        String fullName = "";
        String queryFindProfessor = "SELECT idNo, name, role FROM sql_users.users WHERE name LIKE '%" + name + "%' AND role = 'professor'";
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFindProfessor);
            
            if(rs.next()){
                fullName = rs.getString("name");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        return fullName;
    }
    
    
    public String is(User user){
        
        
        String username = user.getUsername();
        String password = user.getPassword();
        
        String role = "";
        String queryFind = "SELECT role, username, password FROM sql_users.users WHERE username = '" + username +  "' AND  password = '" + password +  "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                role = rs.getString("role");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) { con.close(); }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return role;
    }
    
}
