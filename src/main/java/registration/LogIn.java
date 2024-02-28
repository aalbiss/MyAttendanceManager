package registration;

import Database.DatabaseConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "logIn", urlPatterns = "/login")
public class LogIn extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        DatabaseConnection dbConnection = new DatabaseConnection();
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Some inputs are missing");
            doGet(request, response);
        } else {
            if(dbConnection.is(username, password).equalsIgnoreCase("admin")){
                getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request, response);
            }else if (dbConnection.is(username, password).equalsIgnoreCase("student")) {
                getServletContext().getRequestDispatcher("/student/studentPage.jsp").forward(request, response);
            } else if (dbConnection.is(username, password).equalsIgnoreCase("professor")) {
                getServletContext().getRequestDispatcher("/professor/professor.jsp").forward(request, response);
            } else{
                request.setAttribute("error", "Invalid username or password");
                doGet(request, response);
            }
        }
    }
}