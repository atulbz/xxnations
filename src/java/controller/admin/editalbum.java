/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.albumservice;
import model.modelalbum;

/**
 *
 * @author Shaishav
 */
public class editalbum extends HttpServlet {

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
            String Release_date=null;
            String album_name=request.getParameter("Album_name");
            String Genre_id=request.getParameter("Genre");
            String Album_id=request.getParameter("Album_id");
            int album_id=Integer.parseInt(Album_id);
            String Release_date1=request.getParameter("Release_date");
             
            
            String Artist_name=request.getParameter("Artist_name");
            String Album_info=request.getParameter("Album_info");
            String img_url=request.getParameter("img_url");
            String Featuring_artists=request.getParameter("Featuring_artists");
            
             List errormsgs=new LinkedList();
            if(album_name.isEmpty() || "".equals(album_name) || album_name==null)
            {
                errormsgs.add("You must Enter a album name");
            }
            
            if(Genre_id.isEmpty() || "".equals(Genre_id) || Genre_id==null)
            {
                errormsgs.add("You must Enter a Genre");
            }
            
            if(Release_date1.isEmpty() || "".equals(Release_date1) || Release_date1==null)
            {
                errormsgs.add("You must Enter a Year");
            }
            
            try
            {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date Release_date2 = dateFormat.parse(Release_date1); 
             Release_date= dateFormat.format(Release_date2);
            }
            catch(Exception e)
                    {
                        
                        errormsgs.add("You must Enter a Valid value for Year in form yyyy-mm-dd");
                    }
             //SimpleDateFormat parsedate = new SimpleDateFormat("mm-yyyy-dd");
            // Date Release_date2 = parsedate.parse(Release_date1);
            
            if(Artist_name.isEmpty() || "".equals(Artist_name) || Artist_name==null)
            {
                errormsgs.add("You must Enter a Artist Name");
            }
            
            
            if(Album_info.isEmpty() || "".equals(Album_info) || Album_info==null)
            {
                errormsgs.add("You must Enter a Album Info");
            }
            
            
            albumservice obj3=new albumservice(classname, driver);
            int j=obj3.verifyAlbum(album_id,album_name);
            if(j==1)
            {
                
            }
            else
            {
            albumservice obj2=new albumservice(classname, driver);
            int k=obj2.checkAlbum(album_name);
            if(k==1)
            {
                   errormsgs.add("Album of same name exists");
            }
            }
            
            
                if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/editalbum.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
            
            
            albumservice obj=new albumservice(classname,driver);
            int result=obj.updateAlbum(album_name, Genre_id, Album_id, Release_date, Artist_name, Album_info, img_url, Featuring_artists);
            if(result==1)
            {
                response.sendRedirect("../admin/albummgmt.jsp");
            }
            else
            {
                 request.setAttribute("message", "<ul>The Album "+album_name+" cannot be added please check the following"
                      + "<br><li>Database is connected"
                      + "<br><li>Table Constraint are fulfilled check report to see the constraints"
                      + "<br><li>Database may be down try again later</li>");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
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
