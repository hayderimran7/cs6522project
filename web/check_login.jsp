<%@ page language="java" import="cs6522.*" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title> Welcome | CS6522 BookStore </title>
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" id="bootstrap-css" />
    <link rel="stylesheet" type="text/css" href="./css/login.css" />
    <script src="./js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body style="background: #eee url('img/homeBG.png') repeat scroll 0% 0%">
	
	<div class="container">
	   <div class="login-container">
            <div id="output"></div>
        </div>
    </div>
<%
		cs6522.dbconnector con = new dbconnector();
		cs6522.users user = new users();
		String loginname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("psw");
		if (loginname == null || password == null) {
	%>
		<script type="text/javascript">alert("Illegal EMPTY Loginname or Password !!");</script>
		<script type="text/javascript">location.href = "login1.jsp";</script>
	<%
		} else {
			Boolean match = user.login_user(loginname, password, con.stmt);
			if (match) {
                     session.setAttribute("userid", loginname);

	%>
			<script type="text/javascript">
				var name = <%= "'" + loginname + "'" %>;
				$("#output").addClass("alert alert-success animated fadeInUp").html("Welcome Back " + "<span style='text-transform:uppercase'>" + name + "</span>");
	        	$("#output").removeClass(' alert-danger');
	        	
	        	var date = new Date();
	        	var expiresMin = 60;
	        	date.setTime(date.getTime()+expiresMin*60*1000);
	        	document.cookie = "expires="+date.toGMTString();
	        	document.cookie = "loginname=" + name;
	        	function jmp() {
	        		location.href = "index.jsp";
				}
				setTimeout("jmp()", 3000);
			</script>
	<% 
			} else { %>
			<script type="text/javascript">alert("Wrong Loginname or Password !!");</script>
			<script type="text/javascript">location.href = "login1.jsp";</script>
	<% 		} 
		}
		con.closeConnection();
	
	%>
	
</body>
</html>