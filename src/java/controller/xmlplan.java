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
import model.planservice;

/**
 *
 * @author Shaishav
 */
public class xmlplan extends HttpServlet {

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
        try {
            planservice obj=new planservice(classname, driver);
            String reqamount1=request.getParameter("amount");
                    String reqplanname=request.getParameter("planname");
                    float reqamount=0;
                    try
                    {
                    reqamount=Float.parseFloat(reqamount1);
                    }
                    catch(Exception x)
                    {
                        System.out.print("Error in parsing float"+x);
                    }
                    boolean planname=obj.checkPlanName(reqplanname);
                    boolean amount=obj.checkAmount(reqamount);
                           System.out.println(" A "+amount);
                           System.out.println("P "+planname);
                            
             out.println("<root>");
             out.print("<planname>");
             out.print(planname);
             out.print("</planname>");
             out.print("<amount>");
             out.print(amount);
             out.print("</amount>");
             
              out.println("</root>");
        }
        catch(Exception e)
        {
            System.out.print("Error in xmlplan"+e);
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
