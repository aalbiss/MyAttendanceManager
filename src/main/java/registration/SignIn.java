package registration;

import Database.DatabaseConnection;
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
        
        DatabaseConnection dbConnection = new DatabaseConnection();
        
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPass");
        
        if(name == null || name.isEmpty() || username == null || username.isEmpty() || mail == null || mail.isEmpty() || password == null || password.isEmpty() || confirmPass == null || confirmPass.isEmpty()){
            request.setAttribute("error", "Some inputs are missing");
            doGet(request, response);
        }else if (!password.equals(confirmPass)) {
            request.setAttribute("error", "Passwords doesn't match");
            doGet(request, response);
        } else{
            
            if (dbConnection.checkExistsAdmin() >= 1 && !dbConnection.checkExistsSignin(username, mail)){
                dbConnection.add(name,username, mail, password, "student");
                getServletContext().getRequestDispatcher("/student/studentPage.jsp").forward(request, response);
                
            }else if(dbConnection.checkExistsAdmin() == 0 && !dbConnection.checkExistsSignin(username, mail)) {
                dbConnection.add(name, username, mail, password, "admin");
                getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request, response);
                
            }else{
                request.setAttribute("error", "This account already exists");
                doGet(request, response);
                
            }
        }
    }
}