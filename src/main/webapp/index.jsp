<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <title>Log In</title>
    <link rel="stylesheet" href="/CSS/style.css">
  </head>

  <body>
    <form method="post" action="/login">

      <div class="login-section">
        <p> ${error} </p>

        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required><br>

        <label for="password">Password: </label>
        <input type="password" name="password" id="password" required><br>

        <button type="submit"> Login </button>
      </div>

    </form>
  </body>

  </html>