package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Iterator;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html;charset=windows-1252");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");

if((String)session.getAttribute("role")=="admin")
       {
response.sendRedirect("../admin/home.jsp");
} 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../admin/css/style.css\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1250\">\n");
      out.write("        <title>\n");
      out.write("            Login\n");
      out.write("        </title>\n");
      out.write("    </head>\n");
      out.write(" <body>\n");
      out.write("     <div id=\"header\">\n");
      out.write("\t\t<div class=\"shell\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"head\">\n");
      out.write("\t\t\t\t<h1><a href=\"home.jsp\">Xxnations</a></h1>\n");
      out.write("                        </div>\n");
      out.write("                </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("     <div id=\"a\" align=\"center\" style=\"margin-top: 200px\">\n");
      out.write("         ");

try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<font color='red'");
        out.println("<p>Please correct following errors:</p>");
   Iterator msgs=errormsgs.iterator();
        out.println("<ul>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ul>");
        
        out.println("</font>");
}
}
catch(Exception e)
               {
    
}


      out.write("\n");
      out.write("     <h3>Login</h3>\n");
      out.write("    \n");
      out.write("     <form method=\"post\" action=\"../admin/loginadmin.do\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Username  : </td><td> <input name=\"username\" size=15 type=\"text\" /> </td> \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td> Password  : </td><td> <input name=\"password\" size=15 type=\"password\" /> </td> \n");
      out.write("                    </tr>\n");
      out.write("                    <tr><td></td><td>\n");
      out.write("                <input type=\"submit\" value=\"login\" /></td></tr>\n");
      out.write("                </table>\n");
      out.write("     </form>     \n");
      out.write("                      <br />\n");
      out.write("     <a href=\"../admin/forgotpassword.jsp\" style=\"text-decoration: none\">Forgot your password ?</a>\n");
      out.write("     </div>\n");
      out.write("                  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
