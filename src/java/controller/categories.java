/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoriesservice;

/**
 *
 * @author Shaishav
 */
public class categories extends HttpServlet {

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
            String genre=request.getParameter("q");
            System.out.print(genre);
            if(genre.isEmpty() || "".equals(genre) || genre==null)
            {
                
                RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp?q=error in query");
                rd.forward(request, response);
                return;
                
            }
            Categoriesservice obj=new Categoriesservice(classname,driver);
            List list=obj.getAlbums(genre);
            System.out.print(list.size());
            request.setAttribute("List",list);
            RequestDispatcher rd=request.getRequestDispatcher("./categories.jsp?q="+genre+"");
            rd.forward(request, response);
            
            
      
        } 
        catch(Exception e)
        {
           System.out.print("Error in categories "+e);
            RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp?q="+e);
                rd.forward(request, response);
                return;
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
