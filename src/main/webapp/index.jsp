<!DOCTYPE html>
<html>

<head>
  <title>Log In</title>
  <link rel="stylesheet" href="/CSS/style.css">
</head>

<body>
<div class="container">
  <div class="box form-box">
    <header>Login</header>
    <p> ${error} </p>
    <form method="post" action="/login">
      <div class="field input">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required><br>
      </div>
      <div class="field input">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password" required><br>
      </div>
      <div class="field">
        <button class="btn" type="submit"> Login </button>
      </div>
    </form>
  </div>
</div>
</body>

</html>