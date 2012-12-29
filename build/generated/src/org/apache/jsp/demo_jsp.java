package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" <!--\n");
      out.write("Design by Bryant Smith\n");
      out.write("http://www.bryantsmith.com\n");
      out.write("http://www.aszx.net\n");
      out.write("email: template [-at-] bryantsmith [-dot-] com\n");
      out.write("Released under Creative Commons Attribution 2.5 Generic.  In other words, do with it what you please; but please leave the link if you'd be so kind :)\n");
      out.write("\n");
      out.write("Name       : Green Creative\n");
      out.write("Description: One column, with top naviagation\n");
      out.write("Version    : 1.0\n");
      out.write("Released   : 20081222\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/try/style.css\" />\n");
      out.write("<title>Green Creative by Bryant Smith</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div id=\"page\">\n");
      out.write("\t\t\n");
      out.write("        <div id=\"header\">\n");
      out.write("        \t<div id=\"headerTitle\">Green Creative</div>\n");
      out.write("            <div id=\"headerSubText\">Inspired by Creative Commons, licensed under Creative Commons.</div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <div id=\"bar\">\n");
      out.write("        \t<a href=\"#\">home</a>\n");
      out.write("            <a href=\"#\">about</a>\n");
      out.write("            <a href=\"#\">portfolio</a>\n");
      out.write("            <a href=\"#\">prices</a>\n");
      out.write("            <a href=\"#\">products</a>\n");
      out.write("            <a href=\"#\">faq</a>\n");
      out.write("            <a href=\"#\">contact</a>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"contentTitle\"><h1>Template Usage</h1></div>\n");
      out.write("        <div class=\"contentText\">\n");
      out.write("          <p>You may use this template on any site, anywhere, for free just please leave the link back to me in the footer. This template validates XHTML Strict 1.0, CSS Validates as well; enjoy :) </p>\n");
      out.write("          <p>&nbsp;</p>\n");
      out.write("          <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Integer mi. Vivamus sit amet neque vitae sapien bibendum sodales. Curabitur elementum. Duis imperdiet. Donec eleifend porttitor sapien. Praesent leo. Quisque auctor velit sed tellus. Suspendisse potenti. Aenean laoreet imperdiet nunc. Donec commodo suscipit dolor. Aenean nibh. Sed id odio. Aliquam lobortis risus ut felis. Sed vehicula pellentesque quam.</p>\n");
      out.write("          <p>&nbsp;</p>\n");
      out.write("          <p><a href=\"index.html\">(read more)</a></p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"contentTitle\"><h1>Another Title Goes Here!</h1></div>\n");
      out.write("        <div class=\"contentText\">\n");
      out.write("          <p>This particular template goes not have a naviagation panel; it was intended for simple sites.   I am also making a version of this template with navigation, check out <a href=\"http://www.bryantsmith.com\">BryantSmith.com</a> to get it.</p>\n");
      out.write("          <p>&nbsp;</p>\n");
      out.write("          <p><a href=\"index.html\">(read more)</a></p>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"contentTitle\"><h1>Yet Another?</h1></div>\n");
      out.write("        <div class=\"contentText\">Each title is an H1 tag, so choose them carefully :)</div>  \n");
      out.write("</div>\n");
      out.write("        <div id=\"footer\"><a href=\"http://www.aszx.net\">web development</a> by <a href=\"http://www.bryantsmith.com\">bryant smith</a> | <a href=\"http://www.quackit.com\">web tutorials</a> | <a href=\"http://www.htmlcodes.me\">html codes</a> | <a href=\"http://www.free-templates.me\">free templates</a></div>\n");
      out.write("</body>\n");
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
