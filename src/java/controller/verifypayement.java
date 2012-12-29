/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shaishav
 */
public class verifypayement extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession hs=request.getSession();
        String s=(String)hs.getAttribute("user");
        out.write(request.getParameter("custom"));
        out.write(s);
        
        if(s.isEmpty() || !s.equals(request.getParameter("custom")))
        {
            response.sendRedirect("./login.jsp");
        }
        else
        {
            
        try {
            out.write("<body onload='document.forms[0].submit()'>");

       out.write("<form action=\"http://localhost:9090/cgi-bin/webscr\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" name=\"cmd\" value=\"_xclick-subscriptions\"/>\n");
      out.write("    <input type=\"hidden\" name=\"business\" value=\"email@atyourwebsite.com\"/>\n");
      out.write("    <input type=\"hidden\" name=\"item_name\" value=\"FooBar Magazine\"/>\n");
      out.write("    <input type=\"hidden\" name=\"item_number\" value=\"101\"/>\n");
      out.write("    <input type=\"hidden\" name=\"a1\" value=\"0\"/>\n");
      out.write("    <input type=\"hidden\" name=\"p1\" value=\"10\"/>\n");
      out.write("    <input type=\"hidden\" name=\"t1\" value=\"D\"/>\n");
      out.write("    <input type=\"hidden\" name=\"a3\" value=\"10.00\"/>\n");
      out.write("    <input type=\"hidden\" name=\"p3\" value=\"2\"/>\n");
      out.write("    <input type=\"hidden\" name=\"t3\" value=\"Y\"/>\n");
      out.write("    <input type=\"hidden\" name=\"custom\" value=\"");
      out.print((String)hs.getAttribute("user"));
      out.write("\"/>\n");
      out.write("    \n");
      out.write("    <input type=\"hidden\" name=\"login_email\" value=\"xxnati_1326017502_per@gmail.com\"/>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <input type=\"hidden\" name=\"cancel_return\" value=\"http://localhost:8080/paypal/ipn.jsp\"/>\n");
      out.write("    <input type=\"image\" src=\"https://www.sandbox.paypal.com/en_US/i/btn/btn_subscribeCC_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">\n");
      out.write("<img alt=\"\" border=\"0\" src=\"https://www.sandbox.paypal.com/en_US/i/scr/pixel.gif\" width=\"1\" height=\"1\">\n");
      out.write("\n");
      out.write("</form>\n");
        }
                catch(Exception e)
                {
                    System.out.print(e);
                }
         finally {            
            out.close();
        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
