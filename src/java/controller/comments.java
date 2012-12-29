
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.commentservice;

/**
 *
 * @author Shaishav
 */
public class comments extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try 
        {
        HttpSession hs=request.getSession(false);
         out.print((String)hs.getAttribute("user")+"Hello");
        
        if(hs.getAttribute("role")=="user")
        {
        
            ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
            String song_id1=request.getParameter("song_id");
            int song_id=Integer.parseInt(song_id1);
            String comment=request.getParameter("comment");
            String user_id1=(String)hs.getAttribute("user");
            int user_id=Integer.parseInt(user_id1);
            //out.print(user_id);
           
            //out.print(comment);
            //out.print(song_id);
           
            
            commentservice obj=new commentservice(classname,driver);
            obj.setComments(song_id, user_id, comment) ;
            
            response.sendRedirect(request.getHeader("referer"));
        }   
       
        
        else
        {
            response.sendRedirect("../login.jsp");
            
        }
         } 
        catch(Exception e)
        {
            System.out.print("Error in comment controller "+e);
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
