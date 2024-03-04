<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin profile</title>
    </head>
    <body>
    
        <p>Admin account</p>
        <form method="get" action="/admin/createCourse">
            <button name = "createCourse"> Create course </button>
        </form>
        <form method="get" action="/admin/addUser">
            <button name = "addUser"> Add user </button>
        </form>
        <form method="get" action="/index.jsp">
            <button name = "exit"> Exit </button>
        </form>
    </body>
</html>


<%--cambia index--%>
