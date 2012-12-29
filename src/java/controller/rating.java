
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ratingservice;


public class rating extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try 
        {
        HttpSession hs=request.getSession(false);
         
        
        if(hs.getAttribute("role")=="user")
        {
            
            ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
            String rate=request.getParameter("rate");
            System.out.println("rate"+rate);
            String song_id=request.getParameter("song_id");
            System.out.println("Song_id from reqest"+song_id);
            //String song_id=request.getParameter("song_id");
            int i=Integer.parseInt(rate);
            if(i>5)
            {
                rate="5";
            }
            else
            {
                
            }
           
            
            ratingservice obj=new ratingservice(classname,driver);
            obj.setRating(song_id,i);
            double rating=obj.getRating(song_id);
          
            out.println("<div id='ratingresult' class='classification'><div class='cover'></div><div class='progress' title='" + rating + " of 5.0 star' style='width: "+rating*25+"'px;'></div></div>"
                    + "");
             
        
         }
         else
         {
            out.println("<a href=\"../login.jsp\">Log in</a> to rate ");
         }
    }
        catch(Exception e)
        {
            System.out.print("Error in rating.do"+e);
            
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
