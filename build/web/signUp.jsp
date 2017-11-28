<%-- 
    Document   : signUp
    Created on : Nov 17, 2017, 12:41:25 PM
    Author     : Malik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
    <body>
       <form id="form_register" action="register.jsp" method="POST">
  <div class="form-group">
    <label for="loginname">Login Name</label>
    <input type="loginname" name="loginname" class="form-control" id="fname">
  </div>
  <div class="form-group">
    <label for="password">Password </label>
    <input type="password" name="password" class="form-control" id="lname">
  </div>
    <div class="form-group">
    <label for="fullname">Fullname </label>
    <input type="fullname" name="fullname" class="form-control" id="email">
  </div>
    <div class="form-group">
    <label for="phone">Phone Number:</label>
    <input type="phone" name="phone" class="form-control" id="phone">
  </div>       
  <button type="submit" onclick="return checkRegister()" class="btn btn-default">Submit</button>
<button type="cancel" onclick="window.location='index.jsp';return false;">Cancel</button>
       </form>
    <script src="./js/login.js" type="text/javascript"></script>

    </body>
</html>
