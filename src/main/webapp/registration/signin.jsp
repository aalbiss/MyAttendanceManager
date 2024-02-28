<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign In</title>
    </head>
    <body>
        <form method="post" action="/signin">
            
            <p> ${error} </p>
            
            <label for="name">Birth name: </label>
            <input type="text" name="name" id="name" required><br>
            
            <label for="username">Username: </label>
            <input type="text" name="username" id="username" required><br>
            
            <label for="mail">E-Mail: </label>
            <input type="email" name="mail" id="mail" required><br>
            
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required><br>
            
            <label for="confirmPass">Confirm password: </label>
            <input type="password" name="confirmPass" id="confirmPass" required><br>
            
            <button type="submit"> Register </button>
        
        </form>
        
        <p>If you are a professor sign up and then contact the admin.</p>
    
    
    </body>
</html>