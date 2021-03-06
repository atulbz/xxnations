package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.mailservice;

/**
 *
 * @author Shaishav
 */
public class resend extends HttpServlet {

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
            String email=request.getParameter("email");
            String emailid=(String)sc.getInitParameter("emailid");
              String pwd=(String)sc.getInitParameter("pwd");
            
            mailservice obj=new mailservice(classname, driver, emailid, pwd);
            String result=obj.resend(email);
            
            if(result=="success")
            {
                 response.sendRedirect("http://www.xxnations.com/verificationsend.jsp");
            }
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet resend</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet resend at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            else
            {
                out.print("oops seems you are not registered with us or your account is already activated");
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
