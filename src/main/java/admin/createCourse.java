package admin;

import java.io.*;

import Database.CourseDao;
import Database.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Course;
import model.User;

@WebServlet(name = "createCourse", urlPatterns = "/admin/createCourse")
public class createCourse extends HttpServlet {
    
    private CourseDao courseDao;
    private UserDao userDao;
    
    public void init(){
        courseDao = new CourseDao();
        userDao = new UserDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin/createCourse.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String courseName = request.getParameter("name");
        String professor = request.getParameter("professor");
        String duration = request.getParameter("duration");
        Course course = new Course();
        
        String fullName = userDao.getNameProfessor(professor);
        
        course.setName(courseName);
        course.setProfessor(fullName);
        course.setDuration(duration);
        
        int d = Integer.parseInt(duration);
        
        if(courseName == null || courseName.isEmpty() || professor == null || professor.isEmpty() || duration == null || duration.isEmpty()){
            request.setAttribute("error", "Some inputs are missing");
        }else if (d <= 0) {
            request.setAttribute("error", "Invalid duration");
        } else{
            if (!courseDao.checkExistsCourse(course) && userDao.checkExistProfessor(professor)){
                courseDao.addCourse(course);
                request.setAttribute("created", "The course has been created");
            } else if(courseDao.checkExistsCourse(course)) {
                request.setAttribute("error", "This course already exists");
            }else{
                request.setAttribute("error" , "Invalid course and/or professor name");
            }
        }
        doGet(request, response);
    }
}


