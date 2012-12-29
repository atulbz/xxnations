/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Exception;
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
import model.*;

/**
 *
 * @author Shaishav
 */
public class addsong extends HttpServlet {

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
        
           ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
               List errormsgs=new LinkedList();
         // String album_id1=request.getParameter("album_id");
          int album_id=0;
          try
          {
              String album_id1=request.getParameter("album_id");
                if(album_id1.isEmpty() || "".equals(album_id1) || album_id1==null)
            {
                errormsgs.add("You must select a Album");
            }
              
          album_id=Integer.parseInt(album_id1);
          }
          catch(Exception e)
          {
              
              errormsgs.add("Album must be selected");
          }
        
          String song_name=request.getParameter("song_name");
          
            
               if(song_name.isEmpty() || "".equals(song_name) || song_name==null)
            {
                errormsgs.add("You must Enter a Song name");
            }
             
         
          String song_url=request.getParameter("song_url");
          
            
               if(song_url.isEmpty() || "".equals(song_url) || song_url==null)
            {
                errormsgs.add("You must Enter a Song URL");
            }
             
          
          String Artist_name=request.getParameter("artist_name");
          
            
               if(Artist_name.isEmpty() || "".equals(Artist_name) || Artist_name==null)
            {
                errormsgs.add("You must Enter a Artist name");
            }
             
          
          int frequency=0;
          try
          {
              String frequency1=request.getParameter("frequency");
               if(frequency1.isEmpty() || "".equals(frequency1) || frequency1==null)
            {
                errormsgs.add("You must Enter a Artist name");
            }
          frequency=Integer.parseInt(frequency1);
          }
          catch(Exception e)
          {
              errormsgs.add("Enter the valid value of frequency");
          }
          String release_year=request.getParameter("release_year");
          
            if(release_year.isEmpty() || "".equals(release_year) || release_year==null)
            {
                errormsgs.add("You must Enter a Release Year");
            }
          
            String genre=request.getParameter("genre");
          
            if(genre.isEmpty() || "".equals(genre) || genre==null)
            {
                errormsgs.add("You must Select a genre name");
            }
         
          int bitrate=0;
          try
          {
               String bitrate1=request.getParameter("bitrate");
                if(bitrate1.isEmpty() || "".equals(bitrate1) || bitrate1==null)
            {
                errormsgs.add("You must Enter a Artist name");
            }
                  bitrate=Integer.parseInt(bitrate1);
          
          }
          catch(Exception e)
          {
              errormsgs.add("Enter a valid value of bitrate");
          }
          String duration=request.getParameter("duration");
          
                     
          String len=request.getParameter("len");
          
           if(len.isEmpty() || "".equals(len) || len==null)
            {
                errormsgs.add("You must Select  size of song");
            }
          String demo_url=request.getParameter("demo_url");
         
           if(demo_url.isEmpty() || "".equals(demo_url) || demo_url==null)
            {
                errormsgs.add("You must have a demo url to let your user listen music");
            }
            
           Songservice obj3=new Songservice(classname, driver);
           int j=obj3.checkSongName(song_name);
           if(j==1)
           {
               errormsgs.add("Song of same name exists");
           }
             
          try
            {
                 if(release_year.isEmpty() || "".equals(release_year) || release_year==null)
            {
                errormsgs.add("You must have a demo url to let your user listen music");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date Release_date2 = dateFormat.parse(release_year); 
             
            }
            catch(Exception e)
                    {
                        
                        errormsgs.add("You must Enter a Valid value for Year in form yyyy-mm-dd");
                    }
          
           if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/addsong.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
           
          if(genre.isEmpty())
          {
              response.sendRedirect("../admin/addsong.jsp");
          }
          Songservice obj=new Songservice(classname,driver);
                                       

                                
          boolean result=obj.addsong( album_id, song_name, song_url, Artist_name, bitrate, frequency, genre, duration, len, demo_url, release_year)   ;
          System.out.print(result);
          if(result==false)
          {
              response.sendRedirect("../admin/addsongsuccess.jsp");
          }
            else
          {
             request.setAttribute("message", "The Song "+song_name+" cannot be added please check the following"
                      + "<br>Database is connected"
                      + "<br>Table Constraint are fulfilled check report to see the constraints"
                      + "<br>Database may be down try again later");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
              rd.forward(request, response);
              return;
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
