<%--
  Created by IntelliJ IDEA.
  User: AlbertoAmbrosi
  Date: 29/02/2024
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Course</title>
</head>
<body>
<form method="post" action="/admin/createCourse">
    
    <p> ${created}</p>
    <p> ${error} </p>
    
    <label for="name">Course name: </label>
    <input type="text" name="name" id="name" required><br>
    
    <label for="professor">Professor: </label>
    <input type="text" name="professor" id="professor" required><br>
    
    <label for="duration">Duration: </label>
    <input type="text" name="duration" id="duration" required><br>
    
    <button type="submit"> Create new course </button>

</form>
<form method="get" action="/admin">
    <button name = "home"> Home </button>
</form>
</body>
</html>
