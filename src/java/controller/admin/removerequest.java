/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

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
public class removerequest extends HttpServlet {

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
                         HttpSession hs=request.getSession(false);
                           if((String)hs.getAttribute("user")!=null)
                           {
                                    
              ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
              String reqid=null;
              try
              {
              reqid=request.getParameter("reqid");
              }
              catch(Exception e)
              {
                 response.sendRedirect("../login.jsp");       
              }
               requestservice obj=new requestservice(classname, driver);
               int i=obj.deleteRequest(reqid);
               if(i==1)
               {
                        System.out.print(request.getRequestURI());
                     out.print("Request has been removed click <a href=\"../requesthistory.jsp\">here</a> to go back");   
               }
                                    
                                    
                                    
                                    
                           }
                           else
                           {
                                    response.sendRedirect("../login.jsp");
                           }
                  } finally {                           
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
