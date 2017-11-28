<%-- 
    Document   : header
    Created on : Nov 17, 2017, 2:50:30 PM
    Author     : Malik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
            <div class ="container">
                 <div class="navbar-header">
                   <a class="navbar-brand" href="#">Book Store</a>
                 </div>
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="/books.jsp">Browse</a></li>
              <li><a href="#">Sale</a></li>
              <li><a href="/books.jsp">Textbooks</a></li>
           </ul>
             <ul class="nav navbar-nav navbar-right">
                 <li><a href =""<span class="glyphicon glyphicon-user"></span>
                         ${sessionScope.user.username}</a>
                 </li>
                     
              <li><a href="Admin"><span class="glyphicon glyphicon-cog"></span> Admin</a></li>
              <li><a href="Login?action=logout"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
            </ul>
        </div>
     </nav>
</html>