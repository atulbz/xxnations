/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.searchservice;

/**
 *
 * @author Shaishav
 */
public class searchadmin extends HttpServlet {

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
            String q=request.getParameter("q");
            System.out.print(q);
            String radio=request.getParameter("radio");  
            String search=request.getParameter("search");
            if(search == null)
            {
                search="";
            }
            System.out.print(search);
            System.out.print("Radio is "+radio); 
             List list;
             searchservice obj=new searchservice(classname,driver);
             if(radio.equals("Song"))
             {
                  list=obj.searchsong(q);
             }
             else if(radio.equals("Album") & search.equals("album"))
             {
                  list=obj.adminsearchalbum(q);
             }
             else if(radio.equals("Artist") & search.equals("album"))
             {
                  list=obj.adminsearchartist(q);
             }
             else if(radio.equals("Artist"))
             {
                  list=obj.searchartist(q);
             }
             else if(radio.equals("Album"))
             {
                 list=obj.searchalbum(q);
             }
                     
             else if(radio.equals("username"))
             {
                 System.out.println("1Errrrror");
                 list=obj.searchusername(q);
                 System.out.println("2Errrrror");
                 if(list.isEmpty())
                 {
                     System.out.print("3Errrrror");
                 }
                 System.out.println("4Errrrror");
               request.setAttribute("list", list);
               System.out.println("5Errrrror");
            request.setAttribute("q", q);
            System.out.println("6Errrrror");
            RequestDispatcher rd=request.getRequestDispatcher("../admin/listuser.jsp");
            System.out.println("7Errrrror");
            rd.forward(request, response);
            return;
           
             }
                     
             else if(radio.equals("email"))
             {
                 list=obj.searchemail(q);
                  if(list.isEmpty())
                 {
                     System.out.print("Errrrror");
                 }
                request.setAttribute("list", list);
                request.setAttribute("q", q);
                 
                RequestDispatcher rd=request.getRequestDispatcher("../admin/listuser.jsp");
                rd.forward(request, response);
             }
             else
             {
                 list=obj.search(q);
             }
             System.out.println(request.getRequestURI());
             request.setAttribute("list",list);
             if(search.equals("song"))
             {
                 
            RequestDispatcher rd=request.getRequestDispatcher("../admin/searchsong.jsp");
            rd.forward(request, response);
             }
             else
             {
                 RequestDispatcher rd=request.getRequestDispatcher("../admin/searchalbum.jsp");
                 rd.forward(request, response);
                 
             }
        }
             catch(Exception e)
             {
                 System.out.println("Error in searchadmin"+ e);
             }
             
             /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchadmin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchadmin at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
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
