<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN</title>
    </head>
    <body>
        <form method="post" action="/signin">
            
            <p> ${error} </p>
            
            <label for="name">Birth name: </label>
            <input type="text" name="name" id="name"><br>
            
            <label for="username">Username: </label>
            <input type="text" name="username" id="username"><br>
            
            <label for="mail">E-Mail: </label>
            <input type="email" name="mail" id="mail"><br>
            
            <label for="password">Password: </label>
            <input type="password" name="password" id="password"><br>
            
            <label for="confirmPass">Confirm password: </label>
            <input type="password" name="confirmPass" id="confirmPass"><br>
            
            <button type="submit"> Register </button>
        
        </form>
    </body>
</html>