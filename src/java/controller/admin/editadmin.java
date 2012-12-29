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
import javax.servlet.http.HttpSession;
import model.Loginservice;
import model.registerservice;

/**
 *
 * @author Shaishav
 */
public class editadmin extends HttpServlet {

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
          String fname=request.getParameter("fname"),
                   lname=request.getParameter("lname"),
                   username=request.getParameter("username"),
                   pass=request.getParameter("password"),                    
                   dob=request.getParameter("dob"),
                   email=request.getParameter("email"),
                   sex=request.getParameter("sex"),
                  admin_id1=request.getParameter("admin_id");
                 int admin_id=Integer.parseInt(admin_id1);
           List errormsgs=new LinkedList();
           
           if(fname==null || fname.isEmpty() || "".equals(fname))
           {
               errormsgs.add("First Name Cannot be Empty");
           }
            if(username==null || username.isEmpty() || "".equals(username))
           {
               errormsgs.add("User Name Cannot be Empty");
           }
             if(pass==null || pass.isEmpty() || "".equals(pass))
           {
               errormsgs.add("Password Cannot be Empty");
           }
              if(dob==null || dob.isEmpty() || "".equals(dob))
           {
               errormsgs.add("Date of Birth Cannot be Empty");
           }
               if(email==null || email.isEmpty() || "".equals(email))
           {
               errormsgs.add("Email Cannot be Empty");
           }
            
               try
            {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date Release_date2 = dateFormat.parse(dob); 
          
            }
            catch(Exception e)
                    {
                        
                        errormsgs.add("You must Enter a Valid value for Date of Birth in form yyyy-mm-dd");
                    }
                
           
            if(!errormsgs.isEmpty())
            {
                   
                RequestDispatcher rd=request.getRequestDispatcher("../admin/admineditprofile.jsp");
                
                request.setAttribute("errormsgs", errormsgs);
                
                rd.forward(request, response);
                
                return;
                
            }  
                 Loginservice obj1=new Loginservice(classname,driver);
            String result=obj1.validateadmin(username,pass);
            System.out.print("Login test result"+result);
             if(result.equals("foundtrue"))
            {
             
                     registerservice obj=new registerservice(classname,driver);
                    int i=obj.updateAdmin(admin_id, fname, lname, username, pass, sex,email,dob);
                    
            
          if(i==1)
          {
             System.out.print("login and password same Great Work");
             response.sendRedirect("../admin/home.jsp");
          }
          else
          {
              out.print("Work hard");
          }
            }
             else
             {
                 System.out.print("updateing user");
                 registerservice obj=new registerservice(classname,driver);
                    int i=obj.updateAdmin(admin_id, fname, lname, username, pass, sex,email,dob);
                    
          if(i==1)
          {
             Loginservice update=new Loginservice(classname,driver);
             String updatelogin=update.updateAdmin(admin_id, username, pass);
             System.out.print("login update result"+updatelogin);
             if(updatelogin.equals("updated"))
          {
             out.print(" all done Great Work");
            
          }
          else
          {
              out.print("Work hard");
          }
             System.out.print(" it will be redirected Great Work");
             HttpSession hs=request.getSession(false);
             hs.invalidate();
             response.sendRedirect("../admin/login.jsp");
            
          }
          else
          {
              out.print("Work hard");
          }
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
