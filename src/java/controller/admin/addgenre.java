/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.genreservice;

/**
 *
 * @author Shaishav
 */
public class addgenre extends HttpServlet {

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
            String Genre=request.getParameter("Genre");
            genreservice obj=new genreservice(classname,driver);
            List errormsgs=new LinkedList();
            if(Genre==null || Genre.isEmpty() || "".equals(Genre))
            {
                errormsgs.add("You must enter a Genre to create a Genre..");
            }
         boolean findgenre = obj.findgenre(Genre);
            if(findgenre)
            {
                 errormsgs.add("This Genre is already created fella..");
            }
           
          
              if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/genremgmt.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
               
            
            int i=obj.addGenre(Genre);
            
            if(i==1)
            {
                response.sendRedirect("../admin/genremgmt.jsp");
            }
            
          else
            {
                
               errormsgs.add("Error accoured while adding genre");
                request.setAttribute("errormsgs", errormsgs);
                RequestDispatcher rd=request.getRequestDispatcher("../admin/genremgmt.jsp");
                
                rd.forward(request, response); 
               
            }
        }
            catch(Exception e)
            {
                 response.sendError(400, e.toString().toUpperCase());
            }
        
        finally {            
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
