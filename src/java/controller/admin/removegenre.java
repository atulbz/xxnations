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
import model.genreservice;

/**
 *
 * @author Shaishav
 */
public class removegenre extends HttpServlet {

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
            String genre=request.getParameter("Genre");
            out.print("Genre is "+genre);
            Songservice obj=new Songservice(classname,driver);
            boolean result=obj.genreUsed(genre);
            System.out.print(result);
            
            if(result==true)
            {
                
                RequestDispatcher rd=request.getRequestDispatcher("../admin/cannotremove.jsp");
                rd.forward(request, response);
                return;
            }
            
            genreservice obj1=new genreservice(classname,driver);
            int i=obj1.removeGenre(genre);
            if(i==1)
            {
               response.sendRedirect("../admin/removegenre.jsp");
            }
            else
            {
                request.setAttribute("message", "The Genre "+genre+" cannot be added please check the following"
                      + "<br>Database is connected"
                      + "<br>Table Constraint are fulfilled check report to see the constraints"
                      + "<br>Database may be down try again later");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
              rd.forward(request, response);
            }
        }
        catch(Exception e)
        {
            response.sendError(400, "Error in removing Genre "+e.getMessage());
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
