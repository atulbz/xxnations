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
public class editgenre extends HttpServlet {

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
             String Genre_id=request.getParameter("Genre_id");
             int genre_id=Integer.parseInt(Genre_id);
            List errormsgs=new LinkedList();
            genreservice obj1 =new genreservice(classname,driver);
           
            if(Genre==null || Genre.isEmpty() || "".equals(Genre))
            {
                errormsgs.add("You must enter a Genre to create a Genre..");
            }
            String genreName = obj1.getGenreName(genre_id);
            if(genreName.equals(Genre))
            {
                
            }
            else
            {
            boolean findgenre = obj1.findgenre(Genre);
            if(findgenre)
            {
                 errormsgs.add("This genre is already created..");
            }
            }
            
              if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/editgenre.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
           
    
 int i=obj1.updateGenre(Genre,Genre_id);

if(i==1)
{
    
    response.sendRedirect("../admin/listgenre.jsp");
    return;
}
else
{
      errormsgs.add("Error accoured while editing genre");
                request.setAttribute("errormsgs", errormsgs);
                RequestDispatcher rd=request.getRequestDispatcher("../admin/genremgmt.jsp");
                
                rd.forward(request, response);
}

       }
        catch(Exception e)
        {
        response.sendError(400, e.getMessage());
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
