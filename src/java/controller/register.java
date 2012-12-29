/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mailservice;
import model.registerservice;

/**
 *
 * @author Shaishav
 */
public class register extends HttpServlet {

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
              String emailid=(String)sc.getInitParameter("emailid");
              String pwd=(String)sc.getInitParameter("pwd");
          
            
            
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String username = request.getParameter("username");
            String pass = request.getParameter("password");
            String cpassword = request.getParameter("cpassword");
            System.out.println("Confirm Password" + cpassword);

            String sex = request.getParameter("sex");
            String dob = request.getParameter("dob");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
                   
                   Random obj=new Random();
                   String s=""+obj.nextLong();
                  
                   
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
                   
              if(username.isEmpty() || "".equals(username) || username==null)
            {
                errormsgs.add("Username cannot be empty");
                System.out.println("username");
                
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
              }
           
           if(email.isEmpty() || "".equals(email) || email==null)
            {
                errormsgs.add("Email cannot be empty");
                System.out.println("email");
                
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
           
            if(cpassword.isEmpty() || "".equals(cpassword) || cpassword==null)
            {
                errormsgs.add("Confirm password cannot be empty");
                System.out.println("cpass");
                
            }
                   
          
           
             if(pass.isEmpty() || "".equals(pass) || pass==null)
            {
                errormsgs.add("Password cannot be empty");
                System.out.println("pass");
            }
             
              
             if(!cpassword.equals(pass))
             {
                       System.out.println("vconfirm pass");
                       System.out.println("vpassword"+pass);
                errormsgs.add("Password and Confirm password must match");
               
                       
                   
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
                 try
            {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date Release_date2 = dateFormat.parse(dob); 
            Date test=dateFormat.parse("1900-1-1");
            if(Release_date2.before(test))
            {
                         errormsgs.add("Your date of birth suggests you lived more than 100 years..!!");
            }
            
            if(Release_date2.after(new Date()))
            {
                         errormsgs.add("Your date of birth suggests you are not even born..!!");
            }
          
            }
            catch(Exception e)
                    {
                        
                        errormsgs.add("You must Enter a Valid value for Date of Birth in form YYYY-MM-DD");
                    }
                 
                if(!errormsgs.isEmpty())
            {
                   
                RequestDispatcher rd=request.getRequestDispatcher("./register.jsp");
                System.out.println("This is main");
                request.setAttribute("errormsgs", errormsgs);
                
                rd.forward(request, response);
                return;
            }  
                 
                   request.setAttribute("email", email);
                   request.setAttribute("s", s);
                   //RequestDispatcher rd=request.getRequestDispatcher("mailservlet.do");
                   //rd.forward(request, response);
                   String password=""+pass.hashCode();
                   registerservice obj1=new registerservice(classname,driver);            
                   obj1.addTemp(fname, lname, username, pass,sex, dob, city, email,s);
                   mailservice obj2=new mailservice(classname, driver, emailid, pwd);
                   String result=obj2.sendmail(email);
                   if("success".equals(result))
                   {
                      response.sendRedirect("http://www.xxnations.com/verificationsend.jsp");
                   }
                   else
                   {
                       out.print("Error Occured");
                   }
            
            
            
            
            
        }
        catch(Exception e)
        {
            out.print("Error in registration <br> "+e);
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
