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
import model.albumservice;

/**
 *
 * @author Shaishav
 */
public class songs extends HttpServlet {

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
            String album_id1=request.getParameter("Album_id"); 
            System.out.print(album_id1);
            int Album_id=Integer.parseInt(album_id1);
            Songservice obj=new Songservice(classname,driver);
            List songlist=obj.getSongs(Album_id); 
            request.setAttribute("Songlist", songlist);
             if(album_id1.isEmpty() || "".equals(album_id1) || album_id1==null)
            {
                
                RequestDispatcher rd1=request.getRequestDispatcher("./oops.jsp");
                rd1.forward(request, response);
                return;
                
            }
             
                 
            
            RequestDispatcher rd=request.getRequestDispatcher("./songs.jsp");
            rd.forward(request, response);
            
            
           
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet songs</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet songs at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } 
        catch(Exception e)
        {
            System.out.print("Error in songs.do" +e);
            RequestDispatcher rd1=request.getRequestDispatcher("./oops.jsp");
                rd1.forward(request, response);
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
