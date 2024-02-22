package registration;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "logIn", urlPatterns = "/login")
public class LogIn extends HttpServlet {
    
    String username = " ";
    String password = " ";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/registration/login.jsp").forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            request.setAttribute("error", "Some inputs are missing");
            doGet(request, response);
        }else{
            getServletContext().getRequestDispatcher("/student/studentPage.jsp").forward(request, response);
        }
    
    }
}
