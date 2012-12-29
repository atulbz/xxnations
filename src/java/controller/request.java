/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.requestservice;

/**
 *
 * @author Shaishav
 */
public class request extends HttpServlet {

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
                  
                   HttpSession hs=request.getSession(false);
                           if((String)hs.getAttribute("user")!=null)
                           {
                                    String user_id=(String)hs.getAttribute("user");
                                    String username=(String)hs.getAttribute("username");
                  try {
                          
                           ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
              String song,album;
              try
              {
                            album=request.getParameter("album");
              }
              catch(Exception e)
              {
                       album="----";
              }
              try
              {
                            song=request.getParameter("song");
              }
              catch(Exception e)
              {
                       song="---";
              }
                  
              
              String x="Atleast one value must be selected";
              
              if(album.isEmpty() && song.isEmpty())
               
              
              {
                                    response.sendRedirect("../index.jsp?errorrequest="+x);
                           }
                           else
                           {
                                    requestservice obj=new requestservice(classname, driver);
                                    int i=obj.setRequest(user_id, username, song, album);
                                    if(i==1)
                                    {
                                         response.sendRedirect("../home.jsp");     
                                    }
                                    else
                                    {
                                             response.sendError(400, "Request cannot be added try again later");
                                    }
                                    
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
                           else
                           {
                                 response.sendRedirect("../login.jsp");                                       
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
