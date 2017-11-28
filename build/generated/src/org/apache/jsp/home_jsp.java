package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cs3520.*;
import java.sql.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Book Store</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write(" <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/home.css\" />\n");
      out.write("</head>\n");
      out.write("<body id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        <li><a href=\"#about\">ABOUT</a></li>\n");
      out.write("        <li><a href=\"#top_sellers\">TOP SELLERS</a></li> \n");
      out.write("        <li><a href=\"./browsebooks.jsp\">BROWSE </a></li> \n");
      out.write("\n");
      out.write("        <li><a href=\"#quotes\">QUOTES</a></li> \n");

    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {

      out.write("\n");
      out.write("      <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"./login1.jsp\">LOGIN <span class=\"caret\"></span></a>\n");
      out.write("        <ul class=\"dropdown-menu\">\n");
      out.write("          <li><a href=\"./login1.jsp\">LOGIN</a></li>\n");
      out.write("          <li><a href=\"./signUp.jsp\">SIGN-UP</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </li>\n");
} else {

      out.write("\n");
      out.write("<li><a href=\"\"> Welcome ");
      out.print(session.getAttribute("userid"));
      out.write("</a></li>\n");
      out.write("<li><a href=\"logout.jsp\">Logout</a></li> \n");
      out.write("<li><a href=\"cart.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"></span>My Cart</a></li> \n");

    }

      out.write("\n");
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<div class=\"jumbotron text-center\">\n");
      out.write("  <h1>THE BEST BOOK STORE</h1> \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Container (About Section) -->\n");
      out.write("<div id=\"about\" class=\"container-fluid\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-sm-8\">\n");
      out.write("      <h2>About Our Book Store</h2><br>\n");
      out.write("      <h4>WE SELL A WIDE VARIETY OF BOOKS FOR PEOPLE OF ALL AGES AND INTERESTS!</h4><br>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-4\">\n");
      out.write("      <span class=\"glyphicon glyphicon-book logo\"></span>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Container (BROWSE Section) -->\n");
      out.write("<div id=\"top_sellers\" class=\"container-fluid text-center bg-grey\">\n");
      out.write("  <h2>Browse</h2><br>\n");
      out.write("  <h4>Our Top Sellers</h4>\n");
      out.write("  <div class=\"row text-center slideanim\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("  \t");
 
		cs3520.dbconnector con = new dbconnector();
		cs3520.book books = new book();
		cs3520.util inst = new util();
		String query;
                ResultSet output;

		query = "select * from book limit 3";
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

	
      out.write("\n");
      out.write("  <div class=\"col-md-4\">\n");
      out.write("    <div class=\"thumbnail\">\n");
      out.write("      <a href=");
      out.print(img_href);
      out.write(">\n");
      out.write("        <img src=");
      out.print(img_href);
      out.write(" alt=\"book_image\" style=\"width:50%\">\n");
      out.write("      </a>\n");
      out.write("      <a href=");
      out.print(href);
      out.write(">\n");
      out.write("        <div class=\"caption\">\n");
      out.write("          <p>");
      out.print(title);
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"caption\">\n");
      out.write("          <p>Author ");
      out.print(author);
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"caption\">\n");
      out.write("          <p>ISBN ");
      out.print(ISBN);
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("      </a>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("          ");
 
}
              
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("  <br>\n");
      out.write(" <div id=\"quotes\" class=\"container-fluid text-center bg-grey\"> \n");
      out.write("  <h2>Why you should read books</h2>\n");
      out.write(" <div class=\"container\">\n");
      out.write("  <br>\n");
      out.write("  <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("    <!-- Indicators -->\n");
      out.write("    <ol class=\"carousel-indicators\">\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("      <li data-target=\"#myCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("    </ol>\n");
      out.write("\n");
      out.write("    <!-- Wrapper for slides -->\n");
      out.write("      <!-- Wrapper for slides -->\n");
      out.write("    <div class=\"carousel-inner\" role=\"listbox\">\n");
      out.write("      <div class=\"item active\">\n");
      out.write("        <h4>\"If we encounter a man of rare intellect, we should ask him what books he reads.\"<br><span> By:Ralph Waldo Emerson</span></h4>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"item\">\n");
      out.write("        <h4>\"A book is a device to ignite the imagination.\"<br><span> By: Alan Bennett</span></h4>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"item\">\n");
      out.write("        <h4>\"The more that you read, the more things you will know. The more that you learn, the more places you'll go. \"<br><span> By:Dr. Seuss</span></h4>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"item\">\n");
      out.write("        <h4>\"If you only read the books that everyone else is reading, you can only think what everyone else is thinking. \"<br><span> By:Haruki Murakami</span></h4>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- Left and right controls -->\n");
      out.write("    <a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Previous</span>\n");
      out.write("    </a>\n");
      out.write("    <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("      <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("      <span class=\"sr-only\">Next</span>\n");
      out.write("    </a>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<!-- Container (Contact Section) -->\n");
      out.write("<div id=\"contact\" class=\"container-fluid bg-grey\">\n");
      out.write("  <h2 class=\"text-center\">CONTACT</h2>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"text-center\">\n");
      out.write("      <p>Contact us if you have any questions or comments!.</p>\n");
      out.write("      <p><span class=\"glyphicon glyphicon-map-marker\"></span> CSUEB Hayward California</p>\n");
      out.write("      <p><span class=\"glyphicon glyphicon-envelope\"></span> bestBookStore@gmail.com</p>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write(" </div>\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("  <a href=\"#myPage\" title=\"To Top\">\n");
      out.write("    <span class=\"glyphicon glyphicon-chevron-up\"></span>\n");
      out.write("  </a>\n");
      out.write("  <p>CS 3520 MALIK & KHATTAB</p>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("  // Add smooth scrolling to all links in navbar + footer link\n");
      out.write("  $(\".navbar a, footer a[href='#myPage']\").on('click', function(event) {\n");
      out.write("    // Make sure this.hash has a value before overriding default behavior\n");
      out.write("    if (this.hash !== \"\") {\n");
      out.write("      // Prevent default anchor click behavior\n");
      out.write("      event.preventDefault();\n");
      out.write("\n");
      out.write("      // Store hash\n");
      out.write("      var hash = this.hash;\n");
      out.write("\n");
      out.write("      // Using jQuery's animate() method to add smooth page scroll\n");
      out.write("      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area\n");
      out.write("      $('html, body').animate({\n");
      out.write("        scrollTop: $(hash).offset().top\n");
      out.write("      }, 900, function(){\n");
      out.write("   \n");
      out.write("        // Add hash (#) to URL when done scrolling (default click behavior)\n");
      out.write("        window.location.hash = hash;\n");
      out.write("      });\n");
      out.write("    } // End if\n");
      out.write("  });\n");
      out.write("  \n");
      out.write("  $(window).scroll(function() {\n");
      out.write("    $(\".slideanim\").each(function(){\n");
      out.write("      var pos = $(this).offset().top;\n");
      out.write("\n");
      out.write("      var winTop = $(window).scrollTop();\n");
      out.write("        if (pos < winTop + 600) {\n");
      out.write("          $(this).addClass(\"slide\");\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("  });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
