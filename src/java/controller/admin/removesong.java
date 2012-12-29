/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Songservice;

/**
 *
 * @author Shaishav
 */
public class removesong extends HttpServlet {

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
        try {
          ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
            String song_id=request.getParameter("song_id");
            String Album_id=request.getParameter("Album_id");
            Songservice obj=new Songservice(classname,driver);
            boolean result=obj.deleteSong(song_id);
            if(!result)
            {
                 request.setAttribute(Album_id, "Album_id");
                
               // response.sendRedirect("http://localhost:8080/WebApplication5try/admin/updatesuccess.jsp");
               String s="../admin/deletesuccess.jsp";
               request.setAttribute("redirect", "song");
                RequestDispatcher rd=request.getRequestDispatcher(s);
                rd.forward(request, response);
            }
            
            else
            {
                request.setAttribute("message", "<ul>The Album cannot be added please check the following"
                      + "<br><li>Database is connected"
                      + "<br><li>Table Constraint are fulfilled check report to see the constraints"
                      + "<br><li>Database may be down try again later</ul>");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
              rd.forward(request, response);
            }
            
        } finally {            
            out.close();
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
