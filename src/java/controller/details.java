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
import model.Songservice;
import model.commentservice;

/**
 *
 * @author Shaishav
 */
public class details extends HttpServlet {

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
            String song_id1=request.getParameter("song_id");
            int song_id=Integer.parseInt(song_id1);
            //if(comment!=null)
            //{
              if(song_id1==null||song_id1.isEmpty() ||"".equals(song_id1))  
              {
                  RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp");
                rd.forward(request, response);
                return;
              }
                       
            //String song_id=request.getParameter("song_id");
            String Album_id=request.getParameter("Album_id"); 
            System.out.println("Album_id"+Album_id);
            Songservice obj=new Songservice(classname,driver);
            List Songdetails=obj.getSongDetails(song_id); 
            commentservice obj1=new commentservice(classname,driver);
            List comments=obj1.getComments(song_id);
            request.setAttribute("Songdetails", Songdetails);
            request.setAttribute("comments", comments);
            String url="./details.jsp?Album_id="+Album_id;
            System.out.print(url);
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
         
        }
        catch(Exception e)
        {
           RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp");
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
