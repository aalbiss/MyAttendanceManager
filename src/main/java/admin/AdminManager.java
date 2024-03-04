package admin;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AdminManager", urlPatterns = "/admin" )
public class AdminManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        if (null != request.getParameter("createCourse")){
            getServletContext().getRequestDispatcher("/createCourse").forward(request, response);
        }
        else if(null != request.getParameter("addUser")){
            getServletContext().getRequestDispatcher("/addUser").forward(request, response);
        }
        
    }
}


