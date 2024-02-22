<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<form method="post" action="/login">
    
    <p> ${error} </p>
    
    <label for="username">Username: </label>
    <input type="text" name="username" id="username"><br>
    
    <label for="password">Password: </label>
    <input type="password" name="password" id="password"><br>
    
    <button type="submit"> Login </button>

</form>
</body>
</html>