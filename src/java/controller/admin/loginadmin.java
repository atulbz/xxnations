package controller.admin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javax.servlet.http.HttpSession;
import model.Loginservice;

/**
 *
 * @author Shaishav
 */
public class loginadmin extends HttpServlet {

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
            String username=request.getParameter("username");
            String password=request.getParameter("password"); 
           // String password=""+pass.hashCode();
            int user_id1;
            Loginservice obj=new Loginservice(classname,driver);
            String result=obj.validateadmin(username, password);
            out.print(result);
            List errormsgs=new LinkedList();
            if(username.isEmpty() || "".equals(username) || username==null)
            {
                errormsgs.add("Enter username");
            }
            
            if(password.isEmpty() || "".equals(password) || password==null)
            {
                errormsgs.add("Enter password");
            }
            if(!errormsgs.isEmpty())
            {
                RequestDispatcher rd=request.getRequestDispatcher("../admin/login.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }
                
            if(result.equals("foundtrue"))
            {
                user_id1=obj.getAdminID(username);
                String user_id=user_id1+"";
                HttpSession hs=request.getSession(true);
                hs.setAttribute("role","admin");
                hs.setAttribute("user",user_id);
                hs.setAttribute("username", username);
                
                System.out.println("Session Created");
               // response.sendRedirect("http://localhost:8084/WebApplication5try/");  
                response.sendRedirect("../admin/home.jsp");  
            }
            else 
            {
                //response.sendRedirect("http://localhost:8084/WebApplication5try/"); 
                     errormsgs.add("Invalid username or password");
                RequestDispatcher rd=request.getRequestDispatcher("../admin/login.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
                
            }
        }
        catch(Exception e)
        {
            //response.sendRedirect("http://localhost:8084/WebApplication5try/");  
       response.sendError(400,"This controller has following exception "+e.getMessage());  
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
