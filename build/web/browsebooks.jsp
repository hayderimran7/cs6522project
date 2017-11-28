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
        <li><a href="#browse">BROWSE </a></li> 

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

<!-- Container (BROWSE Section) -->
<div id="browse" class="container-fluid text-center bg-grey">
  <h2>Product Catalog</h2><br>
  <h4>All books in catalog</h4>
  <div class="row text-center slideanim">
    <div class="row">
  	<% 
		cs6522.dbconnector con = new dbconnector();
		cs6522.book books = new book();
		cs6522.util inst = new util();
		String query;
                ResultSet output;

		query = "select * from book";
		System.out.println(query);

		try {
		 output = con.stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}
                int count=1;
                while (output.next()) {
                    String img_href = "img/hp" + count + ".jpg";
                    String ISBN = output.getString("ISBN");
                    String href = "'onebook.jsp?ISBN=" + ISBN + "'"; 
                    String author = output.getString("author");
                    String title = output.getString("title");

	%>
  <div class="col-md-4">
    <div class="thumbnail">
      <a href=<%=img_href%>>
        <img src=<%=img_href%> alt="book_image" style="width:50%">
      </a>
      <a href=<%=href%>>
        <div class="caption">
          <p><%=title%></p>
        </div>
        <div class="caption">
          <p>Author <%=author%></p>
        </div>
        <div class="caption">
          <p>ISBN <%=ISBN%></p>
        </div>
      </a>
    </div>
  </div>
          <% 
}
              %>

</div>
</div>
</div>
  <br>
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
  <p>CS 6522 Malik</p>
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
