package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import cs3520.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<title> Register | CS3520 BookStore </title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background: #eee url('img/homeBG.jpg') repeat scroll 0% 0%\">\n");
      out.write("\t");

		cs3520.dbconnector con = new dbconnector();
		cs3520.users user = new users();
		String loginname = (String)request.getParameter("loginname");
		Boolean exist = user.user_exist(loginname, con.stmt);
		if (exist) {
	
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">alert(\"This Login Name has been used\");</script>\n");
      out.write("\t");
 } else { 
      out.write('\n');
      out.write('	');

		String password = (String)request.getParameter("password");
		String fullname = (String)request.getParameter("fullname");
		String cell = (String)request.getParameter("phone");
		String[] newvalues = new String[] {loginname, password, fullname, cell};
		user.new_user(newvalues, con.stmt);
	
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">alert(\"Register Successful !!\");</script>\t\n");
      out.write("\t");
 } 
      out.write('\n');
      out.write('	');
 con.closeConnection(); 
      out.write("\n");
      out.write("\t<script type=\"text/javascript\">location.href = \"home.jsp\";</script>\n");
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
