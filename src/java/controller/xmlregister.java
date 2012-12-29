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
import model.registerservice;

/**
 *
 * @author Shaishav
 */
public class xmlregister extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
              out.print("<?xml version='1.0' encoding='iso-8859-1'?>");
              String requsername=null;
              String reqemail=null;
              boolean username=false,email=false;
        try {
            registerservice obj=new registerservice(classname, driver);
            
            try
            {
             requsername=request.getParameter("username");
             System.out.print("username : "+requsername );
             reqemail=request.getParameter("email");
             System.out.print("email : "+reqemail );
            }
            catch(Exception e)
            {
                System.out.print("error in sub part"+e);
            }
            try
            {
            username=obj.checkUsername(requsername) ;
            }
            catch(Exception e)
            {
                
            }
            
            System.out.print("busername : "+username );
            try
            {
            email=obj.checkEmail(reqemail);
            }
            catch(Exception e)
            {
                
            }
            System.out.print("bemail : "+email );
             out.println("<root>");
             out.print("<username>");
             out.print(username);
             out.print("</username>");
             out.print("<email>");
             out.print(email);
             out.print("</email>");
             out.println("</root>");
        } 
        catch(Exception e)
        {
        System.out.print("Error in xml register"+e);
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
