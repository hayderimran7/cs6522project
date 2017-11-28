package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("  <title>Login</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("    <body>\n");
      out.write("       <form id=\"form_register\" action=\"register.jsp\" method=\"POST\">\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"loginname\">Login Name</label>\n");
      out.write("    <input type=\"loginname\" name=\"loginname\" class=\"form-control\" id=\"fname\">\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form-group\">\n");
      out.write("    <label for=\"password\">Password </label>\n");
      out.write("    <input type=\"password\" name=\"password\" class=\"form-control\" id=\"lname\">\n");
      out.write("  </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("    <label for=\"fullname\">Fullname </label>\n");
      out.write("    <input type=\"fullname\" name=\"fullname\" class=\"form-control\" id=\"email\">\n");
      out.write("  </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("    <label for=\"phone\">Phone Number:</label>\n");
      out.write("    <input type=\"phone\" name=\"phone\" class=\"form-control\" id=\"phone\">\n");
      out.write("  </div>       \n");
      out.write("  <button type=\"submit\" onclick=\"return checkRegister()\" class=\"btn btn-default\">Submit</button>\n");
      out.write("<button type=\"cancel\" onclick=\"window.location='home.jsp';return false;\">Cancel</button>\n");
      out.write("       </form>\n");
      out.write("    <script src=\"./js/login.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
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
