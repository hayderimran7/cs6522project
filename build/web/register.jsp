<%-- 
    Document   : register
    Created on : Nov 17, 2017, 8:40:27 AM
    Author     : Malik
--%>

<%@ page language="java" import="cs6522.*" %>
<html>
<head>
	<title> Register | cs6522 BookStore </title>
</head>

<body style="background: #eee url('img/homeBG.jpg') repeat scroll 0% 0%">
	<%
		cs6522.dbconnector con = new dbconnector();
		cs6522.users user = new users();
		String loginname = (String)request.getParameter("loginname");
		Boolean exist = user.user_exist(loginname, con.stmt);
		if (exist) {
	%>
	<script type="text/javascript">alert("This Login Name has been used");</script>
	<% } else { %>
	<%
		String password = (String)request.getParameter("password");
		String fullname = (String)request.getParameter("fullname");
		String cell = (String)request.getParameter("phone");
		String[] newvalues = new String[] {loginname, password, fullname, cell};
		user.new_user(newvalues, con.stmt);
	%>
	<script type="text/javascript">alert("Register Successful !!");</script>	
	<% } %>
	<% con.closeConnection(); %>
	<script type="text/javascript">location.href = "index.jsp";</script>
</body>
</html>
