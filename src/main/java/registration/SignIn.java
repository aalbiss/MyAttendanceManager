package registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signIn", urlPatterns = "/signin")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/registration/signin.jsp").forward(request, response);
        
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = " ";
        String username = " ";
        String mail = " ";
        String password = " ";
        String confirmPass = " ";
        
        name = request.getParameter("name");
        username = request.getParameter("username");
        mail = request.getParameter("mail");
        password = request.getParameter("password");
        confirmPass = request.getParameter("confirmPass");
        
        
        if(name == null || name.isEmpty() || username == null || username.isEmpty() || mail == null || mail.isEmpty() || password == null || password.isEmpty() || confirmPass == null || confirmPass.isEmpty()){
            request.setAttribute("error", "Some inputs are missing");
            doGet(request, response);
        } else if (!password.equals(confirmPass)) {
            request.setAttribute("error", "Passwords doesn't match");
            doGet(request, response);
        } else{
            getServletContext().getRequestDispatcher("/student/studentPage.jsp").forward(request, response);
        }
        
    
    }
    
    
    
    
}
