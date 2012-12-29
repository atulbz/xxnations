package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Iterator;
import model.genreservice;
import model.modelgenre;
import java.util.*;
import controller.SessionCounter;
import model.modelcomments;
import model.commentservice;
import model.modelalbum;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(6);
    _jspx_dependants.add("/./common/globalheaderguest.jsp");
    _jspx_dependants.add("/./common/sidebar.jsp");
    _jspx_dependants.add("/./common/Footer.jsp");
    _jspx_dependants.add("/./common/../home/request.jsp");
    _jspx_dependants.add("/./common/../home/indexrequest.jsp");
    _jspx_dependants.add("/./common/../home/latest_comments.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");

if((String)session.getAttribute("role")=="user")
       {
response.sendRedirect("../index.jsp");
}

     
      out.write("   \r\n");
      out.write("       \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1250\">\r\n");
      out.write("        <title>\r\n");
      out.write("            Login\r\n");
      out.write("        </title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"line-height: 1.166;\t\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("        background-color: #EEEEEF\">\r\n");
      out.write("           \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/3col_leftNav.css\" type=\"text/css\">\r\n");
      out.write("        <link href=\"../css/demo.css\" media=\"screen\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/globalheaderdemo.css\" />\r\n");
      out.write("\t\r\n");
      out.write("        \r\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/jquery-min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"../js/globalheaderscript.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("<div id=\"masthead\" style=\"background-color: #364F86; width: 100%; min-width: 1300px\">\r\n");
      out.write("  <h1 id=\"siteName\" style=\"color:#CCCCCC; font-size:20px; margin-left: 47;\">The Music Store</h1><br><br>\r\n");
      out.write("  \r\n");
      out.write("  <div id=\"menu-container\" style=\"position: absolute; top: 16px;\" >\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("    <ul id=\"navigationMenu\" style=\" position: relative; margin-top: 15px; min-width: 700px\">\r\n");
      out.write("\r\n");
      out.write("        <li id=\"globallist\"><a href=\"../index.jsp\" class=\"normalMenu\">Home</a></li>\r\n");
      out.write("<li id=\"globallist\"><a href=\"../features.jsp\" class=\"normalMenu\">Features</a></li>\r\n");
      out.write("<li id=\"globallist\"><a href=\"../plan.jsp\" class=\"normalMenu\">Plan and Pricing</a></li>\r\n");
      out.write("<li id=\"globallist\"><a href=\"../aboutus.jsp\" class=\"normalMenu\">About us</a></li>\r\n");
      out.write("<li id=\"globallist\"><a href=\"../contactus.jsp\" class=\"normalMenu\">Contact us</a></li>\r\n");
      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("  <hr>\r\n");
      out.write("  <h2 align=\"right\" id=\"pageName\" style=\"color:#CCCCCC; font-size:18px\">Welcome Guest</h2>\r\n");
      out.write("  <div id=\"breadCrumb\"> \r\n");
      out.write("      <div align=\"right\"><a href=\"../login.jsp\" style=\"color:#CCCCCC; font-size:14px\">Login</a> | <a href=\"../register.jsp\" style=\"color:#CCCCCC; font-size:14px\">Sign Up</a> | <a href=\"../forgotpassword.jsp\" style=\"color:#CCCCCC; font-size:14px\">Forgot Password</a> </div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("        \r\n");
      out.write("             \r\n");
      out.write("           \r\n");
      out.write("<br>\r\n");
      out.write("<div align=\"center\" style=\"min-width: 1300px; width: 100%; height: 40px; position: relative; left: -170px;\" >\r\n");
      out.write("    <table style=\"min-width: 800px\">\r\n");
      out.write("        <tr><td>\r\n");
      out.write("                <form action=\"../search.do\" method=\"get\">\r\n");
      out.write("                    <input type=\"text\" name=\"q\" id=\"searchdiv\" value=\"Search..\" onfocus=\"this.style.opacity='1'; q.value=null \" onblur=\"this.style.opacity='.5'; if(q.value==null) q.value='Search..'\"   style=\"opacity:0.5;\"/>\r\n");
      out.write("                    <input type=\"submit\" value=\"Search\" style=\"width:128px;\" />\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("                     <label>  All :</label><input type=\"radio\" name=\"radio\" value=\"All\" />\r\n");
      out.write("                    <label>  Song  :</label><input type=\"radio\" name=\"radio\" value=\"Song\" checked=\"checked\" />\r\n");
      out.write("                    <label> Album :</label><input type=\"radio\" name=\"radio\" value=\"Album\" />\r\n");
      out.write("                    <label> Artist:</label><input type=\"radio\" name=\"radio\" value=\"Artist\" />\r\n");
      out.write("                   \r\n");
      out.write("                </form></td></tr></table>\r\n");
      out.write("            </div>  \r\n");
      out.write("                               \r\n");
      out.write(" \r\n");
      out.write("       \r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"../css/demo.css\" media=\"screen\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("      <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/styles.css\" />\n");
      out.write("                <script type=\"text/javascript\" src=\"../js/jquery-min.js\"></script>\n");
      out.write("\n");
      out.write("<div id=\"navBar\" style=\"position: absolute; top: 255px; width: auto\">\n");
      out.write("  \n");
      out.write("    <div style=\"position: absolute; margin-top: 8px;\">\n");
      out.write("            <ul id=\"sliding-navigation\">\n");
      out.write("                \n");
      out.write("                <li class=\"sliding-element\"><h3 style=\"font-size: 20px\">Browse by Genre</h3></li><hr style=\"width: auto\">\n");
      out.write("  \n");
      out.write("\t");

                genreservice obj = new genreservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
                List listgenredemo = obj.getGenre();
                for (int iq = 0; iq < listgenredemo.size(); iq++) {
                    modelgenre obj2 = (modelgenre) listgenredemo.get(iq);
                    out.print("<li class='sliding-element'><a href=\"../categories.do?q=" + obj2.getGenre() + "\" style='font-size:18px' >" + obj2.getGenre() + "</a></li>");
                    
                }

            
      out.write("\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("    \n");
      out.write("    <div style=\"float:right; position: absolute; top: 270px; left: 1100px; right: 200px;  height: 400px; width: 150px; background-color: #C0C0C0; text-align: center\">\n");
      out.write("        <h1> <br><br>Your<br> Ad<br> Here<br><br></h1>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"a\" style=\"position: absolute; left: 406px; top: 298px; width: 549px;\">\r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("     <form action=\"../login.do\" method=\"post\">\r\n");
      out.write("         \r\n");
      out.write("         <table cellspacing=\"20px\" align=\"center\">\r\n");
      out.write("             <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <h1 align=\"center\">Login Form</h1>\r\n");
      out.write("                        <th></th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td> <label>Username  : </label></td><td> <input name=\"username\" size=15 type=\"text\" /> </td> \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td><label> Password  :</label> </td><td> <input name=\"password\" size=15 type=\"password\" /> </td> \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr><td colspan=\"2\" style=\"text-align: center\">\r\n");
      out.write("                            <input type=\"submit\" value=\"login\" /></td></tr>\r\n");
      out.write("                </tbody>             \r\n");
      out.write("         </table>\r\n");
      out.write("           </form>\r\n");
      out.write("  \r\n");
      out.write("                  \r\n");
      out.write("                         ");

try
               {
List errormsgs=(List)request.getAttribute("errormsgs");
if(!errormsgs.isEmpty())
       {
        out.println("<br><div style='postion: absolute; left: 200px;'><font color='red'>" );
        out.println("Please correct following errors:");
   Iterator msgs=errormsgs.iterator();
        out.println("<ol>");
        while(msgs.hasNext())
        {
            String str=(String)msgs.next();
            out.println("<li>" + str + "</li>");
        }
        out.println("</ol>");
        
        out.println("</font></div>");
}
}
catch(Exception e)
               {
    
}

      out.write("\r\n");
      out.write("                    \r\n");
      out.write("              \r\n");
      out.write("   </div>              \r\n");
      out.write("     \r\n");
      out.write("\n");
      out.write("      \n");
      out.write("        <div id=\"siteInfo\" style=\"padding-bottom: 2px; background-color: #364F86; top: 1300px; height:220px; position: absolute; width: 100%; min-height: 220px; min-width: 1300px;\"> \n");
      out.write("           \n");
      out.write("            \n");
      out.write("            <div style=\"position: absolute; left: 150px\">\n");
      out.write("                        <h2 align=\"center\" style=\"color:#CCCCCC\">Request A Song</h2>\n");
      out.write("        ");
 
if(session.getAttribute("role")=="user")
{           


      out.write('\n');
      out.write("\n");
      out.write("                  ");

try
{
         String errorrequest=request.getParameter("errorrequest");
         if(errorrequest==null||errorrequest.isEmpty()||errorrequest=="")
                                   {
                  
         }
         else
                                   {
                  out.print(errorrequest);
         }
}        
catch(Exception e)
{
         
}                       

      out.write("\n");
      out.write("                  <form action=\"../request.do\" method=\"post\">\n");
      out.write("                           <table align=\"center\">\n");
      out.write("                                    <tr><td colspan=\"2\" align=\"center\"> Request Us.. </td></tr>\n");
      out.write("                                    <tr><td>Name of Album</td><td><input type=\"text\" name=\"album\"></td></tr>\n");
      out.write("                                    <tr><td>Name of Song</td><td><input type=\"text\" name=\"song\"></td></tr>\n");
      out.write("                                    <tr><td><input type=\"submit\" name=\"submit\"></td></tr>\n");
      out.write("                           </table>\n");
      out.write("                  </form>\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        ");

}
else
{          

      out.write('\n');
      out.write("<script>\n");
      out.write("    function show_alert()\n");
      out.write("{\n");
      out.write("alert(\"Please log in first!\");\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<form action=\"\" method=\"post\" id=\"login\" >\n");
      out.write("    <table align=\"center\" cellpadding=\"5px;\">\n");
      out.write("                                    <tr><td colspan=\"2\" align=\"center\"> Request Us..</td></tr>\n");
      out.write("                                    <tr><td>Name of Album</td><td><input type=\"text\" name=\"album\"></td></tr>\n");
      out.write("                                    <tr><td>Name of Song</td><td><input type=\"text\" name=\"song\"></td></tr>\n");
      out.write("                                    <tr align=\"center\"><td colspan=\"2\"><input type=\"submit\" name=\"submit\" onclick=\"show_alert(); return false;\"></td></tr>\n");
      out.write("                                    \n");
      out.write("                           </table>\n");
      out.write("                  </form>");
      out.write('\n');

}

      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"position: absolute; left: 520px\">\n");
      out.write("                            <h2 style=\"color:#CCCCCC\">Latest Comments</h2><br>\n");
      out.write("<marquee onMouseOver=\"this.scrollAmount=0\" onMouseOut=\"this.scrollAmount=2\" scrollamount=\"2\" direction=\"up\" loop=\"true\" width=\"30%\" height=\"100px\">\n");
      out.write("\n");
      out.write("     \n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                  <table id=\"results\" width=\"700\">  \n");
      out.write("                      \n");
      out.write("                 ");


try
               {
    
            commentservice objy=new commentservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List comments=objy.getLatestComments();
         for(int i=0;i<comments.size();i++)
                            {    
modelcomments com = (modelcomments) comments.get(i);
               
                out.print(com.getUsername().toUpperCase()+" commented on "+com.getSong_name());
                out.print("<br>");
                out.print("comment : <i>" + com.getComment()+"</i>");
                out.print("<br>");
                out.print("<br>");
                }
             out.print("</td>");
            out.print("</tr></table>");
           }
 
            
    catch(Exception e)
               {
    out.print(e);
}



      out.write("\n");
      out.write("\n");
      out.write("</marquee>\n");
      out.write("</div>\n");
      out.write("            <div style=\"position: absolute; left:750px\">\n");
      out.write("                <h2 align=\"center\" style=\"color: #CCCCCC\"> Our Music</h2>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"../aboutus.jsp\" style=\"color: #CCCCCC\">About Us</a><br><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"../contactus.jsp\" style=\"color: #CCCCCC\">Contact Us</a><br><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"../policy.jsp\" style=\"color: #CCCCCC\">Privacy Policy</a><br><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;<a href=\"../sitemap.jsp\" style=\"color: #CCCCCC\">Site Map</a><br>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"position: absolute; left:900px\">\n");
      out.write("                <h2 align=\"center\" style=\"color: #CCCCCC\">Follow Us On</h2><br>\n");
      out.write("               &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"#\" ><img src=\"../images/facebook.png\"></a>\n");
      out.write("                &nbsp;&nbsp;<a href=\"#\" ><img src=\"../images/twitter.png\"></a>\n");
      out.write("                <br><br>\n");
      out.write("              &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<a href=\"#\" ><img src=\"../images/google+1.jpg\"></a>\n");
      out.write("                &nbsp;&nbsp;<a href=\"#\" ><img src=\"../images/feed-icon32x32.png\"></a>\n");
      out.write("            </div>\n");
      out.write("            <div style=\"position: absolute; left:1150px\">\n");
      out.write("        ");

    SessionCounter counteronlineuser = (SessionCounter) session
            .getAttribute("counteronlineuser");

      out.write("\n");
      out.write("            <h2>Online user(s): ");
      out.print( counteronlineuser.getActiveSessionNumber() );
      out.write("</h2>\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("\r\n");
      out.write(" </body>\r\n");
      out.write("</html>\r\n");
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
