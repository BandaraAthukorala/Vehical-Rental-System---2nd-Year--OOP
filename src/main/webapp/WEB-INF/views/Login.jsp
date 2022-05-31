<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
<div class="fakenavbar">
  <div class="container">
    <h2>Easy Rent</h2>
  </div>
</div>

  <div class="container"> 
    <div class="jumbotron">
      <div class="jumbotron-content">
        <h1>Login Page</h1>
        <p class="jumbotron-lg-only">Use the employee username and password to login</p>
        <form name="user-info" action="<%= request.getContextPath() %>/Login" method="post">
          <div class="form-group">
            <label for="email">Username:</label>
            <input type="text" name="eusername" class="form-control" placeholder="Username">
          </div>
          <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" name="epassword" class="form-control" placeholder="Password">
          </div>
          <button type="submit" class="btn btn-primary">Login</button>
        </form>
      </div>
    </div>
    
  </div>

	 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
</body>

</html>