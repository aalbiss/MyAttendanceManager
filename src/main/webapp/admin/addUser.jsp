<%--
  Created by IntelliJ IDEA.
  User: AlbertoAmbrosi
  Date: 29/02/2024
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form method="post" action="/admin/addUser">
    
    <p> ${created}</p>
    <p> ${error} </p>
    
    <label for="name">Full name: </label>
    <input type="text" name="name" id="name" required><br>
    
<%--    <label for="username">Username: </label>--%>
<%--    <input type="text" name="username" id="username" required><br>--%>
    
    <label for="mail">E-Mail: </label>
    <input type="email" name="mail" id="mail" required><br>
    
    <label for="password">Password: </label>
    <input type="password" name="password" id="password" required><br>
    
    <label for="confirmPass">Confirm password: </label>
    <input type="password" name="confirmPass" id="confirmPass" required><br>
    
    <label for="role"></label>
    <select name="role" id="role" required>
        <option value=""> Select one...</option>
        <option value="professor">Professor</option>
        <option value="student">Student</option>
    </select><br>
    
    <button type="submit"> Register </button>

</form>
<form method="get" action="/admin">
    <button name = "home"> Home </button>
</form>
</body>
</html>
