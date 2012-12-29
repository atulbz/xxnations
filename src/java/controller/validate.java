package controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.invoiceservice;
import model.modelplan;
import model.planservice;

/**
 *
 * @author Shaishav
 */
public class validate extends HttpServlet {

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
        
        
        HttpSession hs=request.getSession(false);
        if(hs.getAttribute("role")!="user")
        {
            response.sendRedirect("./login.jsp");
        }
        else
        {
            
        String user_id=(String)hs.getAttribute("user");
        int user_id_int=Integer.parseInt(user_id);
        Random obj=new Random();
        long invoice_number=obj.nextLong();
        
        if(user_id.isEmpty() || !user_id.equals(request.getParameter("custom")))
        {
            response.sendRedirect("./login.jsp");
        }
        else
        {
             ServletContext sc=getServletContext();
              String classname=(String)sc.getInitParameter("classname");
              String driver=(String)sc.getInitParameter("driver");
              planservice obj1=new planservice(classname, driver);
              List list=obj1.getPlanDetails(request.getParameter("plan_id"));
              modelplan modplan=(modelplan)list.get(0);
              System.out.print("List obtained");
              invoiceservice obj2=new invoiceservice(classname, driver);
              int i=obj2.addInvoice(user_id_int, invoice_number, modplan.getAmount());
              if(i!=1)
              {
                  response.sendRedirect("./home.jsp");
              }
            else
              {
                  
                  
                  
        try {
            out.write("Please wait your request is being proccessed..");
      out.write("<center><body onload='document.forms[0].submit()'>");
      out.write("<form action=\"https://www.sandbox.paypal.com/cgi-bin/webscr\" method=\"post\">\n");
      
      out.write("<input type=\"hidden\" name=\"cmd\" value=\"_xclick\">\n");
     // out.write("<input type=\"hidden\" name=\"hosted_button_id\" value=\"4RYCLZQ3AL2UJ\">\n");
      
      out.write("<input type=\"hidden\" name=\"business\" value=\"xxnations@gmail.com\">\n");
      out.write("\n");
      out.write("<input type=\"hidden\" name=\"amount\" value=\""+modplan.getAmount()+"\">\n");
     
      out.write("<input type=\"hidden\" name=\"currency_code\" value=\"USD\">\n");
      out.write("<input type=\"hidden\" name=\"item_name\" value=\""+modplan.getPlan_name()+"\">\n");
      out.write("<input type=\"hidden\" name=\"item_name\" value=\"Plan\">\n");
      out.write("<input type=\"hidden\" name=\"return\" value=\"\">\n");
      out.write("<input type=\"hidden\" name=\"cancel_return\" value=\"http://www.xxnations.com/home.jsp\">\n");
      out.write("<input type=\"hidden\" name=\"cancel_return\" value=\"http://www.xxnations.com/cancelorder.jsp\">\n");
      out.write("<input type=\"hidden\" name=\"notify_url\" value=\"http://www.xxnations.com/ipnjsp.jsp\">\n");
      out.write("\n");
      out.write("<input type=\"hidden\" name=\"invoice\" value=\""+invoice_number+"\">\n");
      out.write("<input type=\"hidden\" name=\"custom\" value=\""+user_id+"\">\n");
      out.write("\n");
      out.write("<input type=\"image\" src=\"./images/buynow.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">\n");
      out.write("<img alt=\"\" border=\"0\" src=\"./images/buynow.gif\" width=\"1\" height=\"1\">\n");
      out.write("</form>\n");
      out.write("<body></center>");

        
     
        }
                catch(Exception e)
                {
                    System.out.print(e);
                }
         finally {            
            out.close();
        }
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
    }
    
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

