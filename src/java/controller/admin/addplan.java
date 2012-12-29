/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
public class addplan extends HttpServlet {

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
                    //String planid=request.getParameter("");
                      String plan_name=request.getParameter("plan_name");
                     List errormsgs=new LinkedList();
            if(plan_name.isEmpty() || "".equals(plan_name) || plan_name==null)
            {
                errormsgs.add("Enter Plan Name");
            }
                  float amount=0;  
                  int duration=0,songs=0;
                     String amount1=request.getParameter("amount");
                     if(amount1.isEmpty() || "".equals(amount1) || amount1==null)
            {
                errormsgs.add("Enter Amount");
            }
                 else
                     {
                         try
                     {
                     amount=Float.parseFloat(amount1);
                     }
                                 
                             
                                 
                                 
                     catch(Exception e)
                     {
                       errormsgs.add("Enter valid amount");                           
                     }
                     }
                    String duration1=request.getParameter("duration");
                     if(duration1.isEmpty() || "".equals(duration1) || duration1==null)
            {
                errormsgs.add("Enter Duration");
            }
                   else
                     {
                         
                     
                    try
                    {
                    duration=Integer.parseInt(duration1);
                    }
                     catch(Exception e)
                     {
                       errormsgs.add("Enter the valid value of duration");                           
                     }
                     }
                    String songs1=request.getParameter("noofsongs");
                  
                    if(songs1.isEmpty() || "".equals(songs1) || songs1==null)
            {
                errormsgs.add("Enter No of Songs");
            }
                   else
                    {
                    try
                    {
                    songs=Integer.parseInt(songs1);
                     }
                     catch(Exception e)
                     {
                       errormsgs.add("Enter valid No of Songs");                           
                     }
                    }
                      planservice checkplanname=new planservice(classname, driver);
                    boolean checkplannameboolean=checkplanname.checkPlanName(plan_name);
                    if(checkplannameboolean)
                    {
                        errormsgs.add("Plan Name Already used"); 
                                                   
                    }
                    boolean checkplanamountboolean=checkplanname.checkAmount(amount);
                    if(checkplanamountboolean)
                    {
                        errormsgs.add("Plan of same amount already exists"); 
                                                 
                    }
                        
              
                    if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/addplan.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
              planservice obj=new planservice(classname, driver);
              
              int i=obj.addPlan(plan_name, amount, duration, songs);
              
              if(i==1)
              {
                  response.sendRedirect("../admin/addplansuccess.jsp?q="+plan_name);
              }
              else
              {
              request.setAttribute("message", "The Plan "+plan_name+" cannot be added please check the following"
                      + "<br>Database is connected"
                      + "<br>Table Constraint are fulfilled check report to see the constraints"
                      + "<br>Database may be down try again later");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
              rd.forward(request, response);
              
              }
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addplan</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addplan at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } 
        
          catch(Exception e)
            {
                 response.sendError(400, e.toString());
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
