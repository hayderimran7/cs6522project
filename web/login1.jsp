<%-- 
    Document   : login
    Created on : Nov 17, 2017, 9:38:47 PM
    Author     : Malik
--%>        
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel = "stylesheet" href = "./css/login.css"/>
</head>
<!-- Button to open the modal login form -->
<button onclick="document.getElementById('id01').style.display='block'">Login</button>

<!-- The Modal -->
<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" 
class="close" title="Close Modal">&times;</span>

  <!-- Modal Content -->
  <form class="modal-content animate" action="check_login.jsp" method="POST">
    <div class="container-fluid">
      <label><b>Username</b></label>
      <input type="text" placeholder="Enter Your Username" name="uname" required>
      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Your Password" name="psw" required>
      <button type="submit">Login</button>
    </div>
    <div class="container" style="body">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" 
              class="cancelbtn">Cancel
      </button>
    </div>
  </form>
   
</div>
</html>

