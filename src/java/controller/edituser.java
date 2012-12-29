/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class edituser extends HttpServlet {

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
                   city=request.getParameter("city"),
                   email=request.getParameter("email"),
                   sex=request.getParameter("sex");
          
          HttpSession hs=request.getSession(false);
          if(hs.getAttribute("role")!="user")
          {
              response.sendRedirect("index.jsp");
              return;
          }
            String user_id1=(String)hs.getAttribute("user");
             String susername=(String)hs.getAttribute("username");
             String semail=(String)hs.getAttribute("email");
             System.out.print("sesion mail"+semail);
                    List errormsgs=new LinkedList();
                       
                   
                   
                    if(fname.isEmpty() || "".equals(fname) || fname==null)
            {
                errormsgs.add("First cannot be left empty");
                
                System.out.println("fname");
            }
            
            if(lname.isEmpty() || "".equals(lname) || lname==null)
            {
                errormsgs.add("Last Name cannot be left empty");
                System.out.println("lname");
               
            }
                   
              
           if(pass.isEmpty() || "".equals(pass) || pass==null)
            {
                errormsgs.add("Password cannot be empty");
                System.out.println("pass");
            }
             
              
             
              
             
               if(sex.isEmpty() || "".equals(sex) || sex==null)
            {
                errormsgs.add("Gender has to be something");
                System.out.println("gender");
                
            }
               
                if(dob.isEmpty() || "".equals(dob) || dob==null)
            {
                errormsgs.add("Everyone is born when were you ?");
                System.out.println("dob");
               
            }
                 if(city.isEmpty() || "".equals(city) || city==null)
            {
                errormsgs.add("Humans live in named area what is yours");
                System.out.println("city");
                
            }
                 
                 
                 if(username.isEmpty() || "".equals(username) || username==null)
            {
                errormsgs.add("Username cannot be empty");
                System.out.println("username");
                
            }
            
              else
              {
                  if(susername.equals(username))
                  {
                      
                  }
                  else
                  {
            registerservice obj3=new registerservice(classname, driver);
            boolean checkUsername = obj3.checkUsername(username);
           if(checkUsername)   
           {
               errormsgs.add(username+"  already being used");
               System.out.println("usedusername");
               
               
             
           }
              }}
           
           if(email.isEmpty() || "".equals(email) || email==null)
            {
                errormsgs.add("Email cannot be empty");
                System.out.println("email");
                
            }
           else
           {
               if(email.equals(semail))
               {
                 
               }
               else
               {
             registerservice obj4=new registerservice(classname, driver); 
            boolean checkEmail = obj4.checkEmail(email);
                   
            if(checkEmail)
            {
               errormsgs.add(email+" email address is already being used"); 
               System.out.println("usedemail");
               
               
            }
           }
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
                   
                RequestDispatcher rd=request.getRequestDispatcher("./editprofile.jsp");
                
                request.setAttribute("errormsgs", errormsgs);
                
                rd.forward(request, response);
                System.out.println("This is main");
                return;
                
            }  
               System.out.println("This is main"); 
                
                
                
                   int user_id=Integer.parseInt(user_id1);
            Loginservice obj1=new Loginservice(classname,driver);
            String result=obj1.validate(username,pass);
            System.out.print("Login test result"+result);
             if(result.equals("foundtrue"))
            {
             
          registerservice obj=new registerservice(classname,driver);
          int i=obj.updateUser(user_id, fname, lname, username, pass,dob,sex, city, email);
          
            
          if(i==1)
          {
             System.out.print("login and password same Great Work");
             response.sendRedirect("../manageaccount.jsp?userid="+user_id);
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
                 int i=obj.updateUser(user_id, fname, lname, username, pass,dob,sex, city, email);
            
          if(i==1)
          {
             Loginservice update=new Loginservice(classname,driver);
             String updatelogin=update.updateUser(user_id, username, pass);
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
             HttpSession hs1=request.getSession(false);
             hs1.invalidate();
             response.sendRedirect("../index.jsp");
             
          }
          else
          {
              out.print("Work hard");
          }
             }
        }
        catch(Exception e)
        {
                 System.out.print("error in edit user"+e);
 response.sendRedirect("../index.jsp");
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
