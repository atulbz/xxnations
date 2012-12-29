package controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletContext;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType; 
import com.google.zxing.client.j2se.*;


/**
 *
 * @author Shaishav
 */
public class qrcode extends HttpServlet {

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
        //PrintWriter out = response.getWriter();
        try {
            
            //String qrtext = (String)request.getAttribute("url1");
             ServletContext sc = getServletContext();
            String classname = (String) sc.getInitParameter("classname");
            String driver = (String) sc.getInitParameter("driver");


            //String user_id = (String) hs.getAttribute("user");
            String url = request.getParameter("url");
            ByteArrayOutputStream out = QRCode.from(url).to(ImageType.PNG).stream();
 
        response.setContentType("image/png");
        response.setContentLength(out.size());
 
        OutputStream outStream = response.getOutputStream();
 
        outStream.write(out.toByteArray());
        
        outStream.flush();
        outStream.close();
        } finally {            
           
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
