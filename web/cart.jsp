<%-- 
    Document   : home
    Created on : Nov 17, 2017, 6:49:22 PM
    Author     : Malik
--%>
<%@ page language="java" import="cs6522.*, java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Book Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script>
      function getCardInfo() {
      var cartype = document.getElementsByName('CreditCardType')[0].value;
      var carcode = document.getElementsByName('car_code')[0].value;
      var carnum = document.getElementsByName('car_number')[0].value;
      var elems= document.getElementsByName("cc_checkbox");
      var checked=false;
      for (i = 0; i < elems.length; i++) { 
          if (elems[0].checked){
              checked=true;
          }
      }
      console.log("checked value" + checked);
      if(checked==false){
          if((!carcode)&&(!carnum)){
              alert("must provide a credit car or select from one of available");
              return;
          }
      }
 	var post_data = {
			  cartype: cartype,
			  carcode: carcode  , 
			  carnum: carnum,
			 userid: 1
			};
      	$.post( "CreditCard", post_data, function(data) {
		console.log(data);
 alert("order has been place successfully");
                window.location = "index.jsp";
            });
         
               
  }
  </script>
  
 <link rel="stylesheet" type="text/css" href="./css/home.css" />
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#about">ABOUT</a></li>
        <li><a href="./index.jsp">TOP SELLERS</a></li> 
        <li><a href="./browsebooks.jsp">BROWSE </a></li> 

        <li><a href="#quotes">QUOTES</a></li> 
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="./login1.jsp">LOGIN <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="./login1.jsp">LOGIN</a></li>
          <li><a href="./signUp.jsp">SIGN-UP</a></li>
        </ul>
      </li>
<%} else {
%>
<li><a href=""> Welcome <%=session.getAttribute("userid")%></a></li>
<li><a href="logout.jsp">Logout</a></li> 
<li><a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>My Cart</a></li> 
<%
    }
%>

      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>THE BEST BOOK STORE</h1> 
</div>

<!-- Container (About Section) -->
<div id="about" class="container-fluid">
  <div class="row">
    <div class="col-sm-8">
      <h2>About Our Book Store</h2><br>
      <h4>WE SELL A WIDE VARIETY OF BOOKS FOR PEOPLE OF ALL AGES AND INTERESTS!</h4><br>
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-book logo"></span>
    </div>
  </div>
</div>

<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
<h3>Empty Cart: Nothing to show for Non-logged-in Users </h3>
<script type="text/javascript">alert("Please Login First !!");location.href = "index.jsp";</script>
<%
     }

		String username = (String) session.getAttribute("userid");
                String qname = "'" + username + "'"; 
		cs6522.dbconnector con = new dbconnector();
		cs6522.book books = new book();

		cs6522.users user = new users();
		cs6522.orders order = new orders();
                cs6522.credit credit = new credit();
		int cid = user.get_cid(qname, con.stmt);

		String ISBN = (String)request.getParameter("ISBN");
		if (ISBN != null && !ISBN.equals("")) {
			ISBN = "'" + ISBN + "'";
			String[] order_value = new String[] {ISBN, String.valueOf(cid), (String)request.getParameter("order_copies")};
			boolean order_succ = order.new_orders(order_value, con.stmt);
			if (order_succ) {
	%>
			<script type="text/javascript">
				alert("New Order Successful !! ");
			</script>
	<%
			} else {
	%>
			<script type="text/javascript">
				alert("Order didnt proceed !! ");
			</script>
	<%
			}
	%>
			<script type="text/javascript">
				location.href="onebook.jsp?ISBN=" + <%=ISBN%>;
			</script>
	<%
		}
	%>
	<div id="main" class="shell">
		
		<h3>My Orders : </h3>
		<table border="1">
			<tr>
				<th>Order ID</th>
				<th>Date</th>
				<th>ISBN</th>
				<th>Amount</th>
			</tr>
		<%
			ResultSet results;
			results = order.show_orders(cid, con.stmt);
			while (results.next()) {
		%>
			<tr>
				<th><%=results.getInt("oid")%></th>
				<th><%=results.getString("buy_date")%></th>
				<th><%=results.getString("ISBN")%></th>
				<th><%=results.getInt("amount")%></th>
			</tr>
		<%
			}
		%>
		</table>
		
		<%      
                        int total_results=0;
                        total_results = order.count_user_order(cid,con.stmt);
                        
			
		%>
                <p><b> Total Orders are : </b><%=total_results%></p>
	</div>
            <!--Current credit cards --->    
        <div>

            <h3><b> Current Credit Cards are:</b></h3>            
<table class="table table-striped table-bordered">
  <thead>
  <tr>
    <th> CreditCard </th>
    <th> Credit Card Number </th>
    <th> Credit Card Code </th>
  </tr>
  </thead>
  <tbody>
<%  ResultSet card_results;
   card_results = credit.show_cards(cid, con.stmt);
			while (card_results.next()) {
 
     
 
%>
      <tr>
          <td><input type="checkbox" name="cc_checkbox" />    &nbsp;   </td>
          <td><%=card_results.getString("ctype")%> </td>      
          <td><%=card_results.getString("cnum")%> </td>      
          <td><%=card_results.getString("ccode")%> </td>      
      </tr>
      <%  }
        con.closeConnection(); %>
  </tbody>
</table>
            
            
        </div>
<!--CREDIT CART PAYMENT-->
                    <div class="panel panel-info">
                        <div class="panel-heading"><span><i class="glyphicon glyphicon-lock"></i></span> Secure Payment</div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-12"><strong>Card Type:</strong></div>
                                <div class="col-md-12">
                                    <select id="CreditCardType" name="CreditCardType" class="form-control">
                                        <option value="Visa">Visa</option>
                                        <option value="MasterCard">MasterCard</option>
                                        <option value="American Express">American Express</option>
                                        <option value="Discover">Discover</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Credit Card Number:</strong></div>
                                <div class="col-md-12"><input type="text" class="form-control" name="car_number" value="" /></div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Card CVV:</strong></div>
                                <div class="col-md-12"><input type="text" class="form-control" name="car_code" value="" /></div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <strong>Expiration Date</strong>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <select class="form-control" name="">
                                        <option value="">Month</option>
                                        <option value="01">01</option>
                                        <option value="02">02</option>
                                        <option value="03">03</option>
                                        <option value="04">04</option>
                                        <option value="05">05</option>
                                        <option value="06">06</option>
                                        <option value="07">07</option>
                                        <option value="08">08</option>
                                        <option value="09">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                </select>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <select class="form-control" name="">
                                        <option value="">Year</option>
                                        <option value="2015">2015</option>
                                        <option value="2016">2016</option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                        <option value="2024">2024</option>
                                        <option value="2025">2025</option>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12">
                                    <span>Pay secure using your credit card.</span>
                                </div>
                                <div class="col-md-12">
                                    <ul class="cards">
                                        <li class="visa hand">Visa</li>
                                        <li class="mastercard hand">MasterCard</li>
                                        <li class="amex hand">Amex</li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <button type="submit" onclick="getCardInfo()" class="btn btn-primary btn-submit-fix">Place Order</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--CREDIT CART PAYMENT END-->
                
                
                
                
 <div id="quotes" class="container-fluid text-center bg-grey"> 
  <h2>Why you should read books</h2>
 <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
      <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <h4>"If we encounter a man of rare intellect, we should ask him what books he reads."<br><span> By:Ralph Waldo Emerson</span></h4>
      </div>
      <div class="item">
        <h4>"A book is a device to ignite the imagination."<br><span> By: Alan Bennett</span></h4>
      </div>
      <div class="item">
        <h4>"The more that you read, the more things you will know. The more that you learn, the more places you'll go. "<br><span> By:Dr. Seuss</span></h4>
      </div>
        <div class="item">
        <h4>"If you only read the books that everyone else is reading, you can only think what everyone else is thinking. "<br><span> By:Haruki Murakami</span></h4>
      </div>
    </div>
    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<!-- Container (Contact Section) -->
<div id="contact" class="container-fluid bg-grey">
  <h2 class="text-center">CONTACT</h2>
  <div class="row">
    <div class="text-center">
      <p>Contact us if you have any questions or comments!.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> CSUEB Hayward California</p>
      <p><span class="glyphicon glyphicon-envelope"></span> bestBookStore@gmail.com</p>
    </div>
  </div>
</div>
 </div>

<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>CS 6522 MALIK </p>
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
});
</script>

</body>
</html>
