/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.commentservice;

/**
 *
 * @author Shaishav
 */
public class removecomment extends HttpServlet {

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
            String cid1=request.getParameter("cid");
           String redirect=request.getParameter("redirect");
           System.out.println("Redirect value   =  "+redirect);
            String song_id=request.getParameter("song_id");
            int cid=Integer.parseInt(cid1);
            commentservice obj=new commentservice(classname, driver);
            int j=obj.deleteComment(cid);
            if(j==1)
            {
                 if(redirect=="x" || redirect.equals("x"))
                 {
                     System.out.print("Going back to commentsbyuser");
                          String user_id=request.getParameter("user_id");
                                  response.sendRedirect("../admin/commentsbyuser.jsp?user_id="+user_id);
                 }
                 else
                 {
                     response.sendRedirect("../admin/editsong.jsp?redirect="+redirect+"&song_id="+song_id);
                     //out.print("This comment is deleted"+request.getQueryString());
                 }
                 }
            else
            {
                      response.sendError(400, "Comment cannot be deleted ");
            }
            
                  }
                  
                  catch(Exception e)
                  {
                           response.sendError(400, "Comment cannot be deleted "+e.getMessage());
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
