/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.String;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Counterservice;
import model.Songservice;
import model.downloadservice;
import model.modelsong;
import model.tempservice;

/**
 *
 * @author Shaishav
 */
public class download_qr extends HttpServlet {
public int count;
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
         
          HttpSession hs = request.getSession(false);
        if (hs.getAttribute("user")==null) {
            response.sendRedirect("./login.jsp");

        } 
            else
            {
                     try 
                     
                     {
                              
            ServletContext sc = getServletContext();
            String classname = (String) sc.getInitParameter("classname");
            String driver = (String) sc.getInitParameter("driver");


            String user_id1 = (String) hs.getAttribute("user");
            int user_id=Integer.parseInt(user_id1);
            String song_id1 = request.getParameter("song_id");
            
            if(song_id1.isEmpty() || "".equals(song_id1) || song_id1==null)
            {
                
                RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp");
                rd.forward(request, response);
                return;
                
            }
            int song_id=Integer.parseInt(song_id1);
            Songservice obj2 = new Songservice(classname, driver);
            List list = obj2.getSongDetails(song_id);
            modelsong list1 = (modelsong) list.get(0);

            Counterservice obj = new Counterservice(classname, driver);
            int i = obj.getCounter(user_id);
            if (i <= 0) {
               RequestDispatcher rd = request.getRequestDispatcher("./home.jsp");
                rd.forward(request, response);


            } else {
                Counterservice obj1 = new Counterservice(classname, driver);
                count = obj1.decCounter(user_id, list1.getSong_url());

                if (count < 0) {
                    // response.sendRedirect("http://localhost:8084/WebApplication5try/");

                    response.sendRedirect("./index.jsp");
                } else {
                    Random ek=new Random();
                    String es=""+ek.nextLong();
                    tempservice ex=new tempservice(classname, driver);
                    int esetTemp = ex.setTemp(user_id,es,list1.getSong_url(),list1.getLen());
                    //response.sendRedirect(""downloadwithcode.do?k="+es+"&sname="+list1.getSong_name());
                   String url="http://"+request.getHeader("Host") +"/downloadqueue.do?k="+es+"&sname="+list1.getSong_name().trim();
                   downloadservice obj3=new downloadservice(classname, driver);
                   int update=obj3.setDownloadhistory(user_id, list1.getSong_name(), url);
                   System.out.print(url);
                   response.sendRedirect("qrcode.do?url="+url);
                   return;
          }
            }
            
           } 
         catch(Exception w)
         {
                  System.out.print(w);
             RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp");
                rd.forward(request, response);
                return;
         }
            
         
         finally {
            out.close();
        }
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
