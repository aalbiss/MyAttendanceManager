package admin;

import java.io.*;

import Database.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;

@WebServlet(name = "addUser", urlPatterns = "/admin/addUser")
public class addUser extends HttpServlet {
    
    private UserDao userDao;
    
    public void init(){
        userDao = new UserDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin/addUser.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fullName = request.getParameter("name").toLowerCase();
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String confirmPass = request.getParameter("confirmPass");
        String role = request.getParameter("role");
        String n[] = fullName.split(" ");
        String username = n[0] + "." + n[1];
        
        User user= new User();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setMail(mail);
        user.setPassword(password);
        user.setConfirmPass(confirmPass);
        user.setRole(role);
        
        
        if(fullName == null || fullName.isEmpty() || username == null || username.isEmpty() || mail == null || mail.isEmpty() || password == null || password.isEmpty() || confirmPass == null || confirmPass.isEmpty() || role == null || role.isEmpty()){
            request.setAttribute("error", "Some inputs are missing");
        }else if (!password.equals(confirmPass)) {
            request.setAttribute("error", "Passwords doesn't match");
        } else{
            if (!userDao.checkExistUser(user)){
                userDao.addUser(user);
                request.setAttribute("created", "The account has been created");
            }else{
                request.setAttribute("error", "This account already exists");
            }
        }
        doGet(request, response);
    }
}


