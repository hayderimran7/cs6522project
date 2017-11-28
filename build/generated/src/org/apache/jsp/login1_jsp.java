package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("        \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Login</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("  <link rel = \"stylesheet\" href = \"./css/login.css\"/>\n");
      out.write("</head>\n");
      out.write("<!-- Button to open the modal login form -->\n");
      out.write("<button onclick=\"document.getElementById('id01').style.display='block'\">Login</button>\n");
      out.write("\n");
      out.write("<!-- The Modal -->\n");
      out.write("<div id=\"id01\" class=\"modal\">\n");
      out.write("  <span onclick=\"document.getElementById('id01').style.display='none'\" \n");
      out.write("class=\"close\" title=\"Close Modal\">&times;</span>\n");
      out.write("\n");
      out.write("  <!-- Modal Content -->\n");
      out.write("  <form class=\"modal-content animate\" action=\"check_login.jsp\" method=\"POST\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("      <label><b>Username</b></label>\n");
      out.write("      <input type=\"text\" placeholder=\"Enter Your Username\" name=\"uname\" required>\n");
      out.write("      <label><b>Password</b></label>\n");
      out.write("      <input type=\"password\" placeholder=\"Enter Your Password\" name=\"psw\" required>\n");
      out.write("      <button type=\"submit\">Login</button>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\" style=\"body\">\n");
      out.write("      <button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" \n");
      out.write("              class=\"cancelbtn\">Cancel\n");
      out.write("      </button>\n");
      out.write("    </div>\n");
      out.write("  </form>\n");
      out.write("   \n");
      out.write("</div>\n");
      out.write("</html>\n");
      out.write("\n");
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
