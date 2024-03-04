package Database;

import model.Course;

import java.sql.*;

public class CourseDao {
    
    private final String DB_URL = "jdbc:mysql://localhost/";
    private final String USER = "root";
    private final String PASS = "Alberto06";
    
    public void addCourse(Course course){
        
        String name = course.getName();
        String professor = course.getProfessor();
        String duration = course.getDuration();
        
        int id = 0;
        String queryFind = "SELECT * FROM sql_users.course WHERE name = '" + name +  "' AND professor = '" + professor +  "' AND duration = '" + duration + "'";
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
                String query = "INSERT INTO sql_users.course(name, professor, duration) VALUES (?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, professor);
                ps.setString(3, duration);
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
    
    public void removeCourse(Course course){
        
        String name = course.getName();
        String professor = course.getProfessor();
        String duration = course.getDuration();
        
        int id = 0;
        String queryFind = "SELECT name, professor,duration FROM sql_users.course WHERE name = '" + name + "' AND professor = '" + professor + "' AND duration = '" + duration + "'";
        
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
                
                String queryRemove = "DELETE FROM sql_users.course WHERE courseID = ?";
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
    
    public boolean checkExistsCourse(Course course){
        boolean exists = false;
        
        String name = course.getName();
        String professor = course.getProfessor();
        String duration = course.getDuration();
        
        String queryFind = "SELECT name, professor,duration FROM sql_users.course WHERE name = '" + name + "' AND professor = '" + professor + "' AND duration = '" + duration + "'";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryFind);
            
            if (rs.next())
                exists = true;
            
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
    
}