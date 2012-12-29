package controller.admin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Counterservice;
import model.invoiceservice;
import model.modelplan;
import model.paymentservice;
import model.planservice;

/**
 *
 * @author Shaishav
 */
public class ipn extends HttpServlet {

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
            System.out.print(request.getRequestURL());
            Enumeration en = request.getParameterNames();
String str = "cmd=_notify-validate";
while(en.hasMoreElements()){
String paramName = (String)en.nextElement();
String paramValue = request.getParameter(paramName);
System.out.print(paramName+"-"+paramValue);
str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
}
System.out.print(str);

URL u = new URL("http://http://www.sandbox.paypal.com/cgi-bin/webscr");
URLConnection uc = u.openConnection();
uc.setDoOutput(true);

PrintWriter pw = new PrintWriter(uc.getOutputStream());
pw.println(str);
pw.close();

BufferedReader in = new BufferedReader(
new InputStreamReader(uc.getInputStream()));

String res = in.readLine();

   
       System.out.print(res);
     
in.close();

                
                            
            

String user_id1=request.getParameter("custom");
int user_id=Integer.parseInt(user_id1);
String st=request.getParameter("st");
String amt1=request.getParameter("payment_gross");
float amt=Float.parseFloat(amt1);
String cc=request.getParameter("cc");
String item_number=request.getParameter("item_number");
String sig=request.getParameter("sig");
String name=request.getParameter("address_name");
String city=request.getParameter("address_city");
String email=request.getParameter("payer_email");
String invoice_number1=request.getParameter("invoice");
String payment_status=request.getParameter("payment_status");
long invoice_number=Long.parseLong(invoice_number1);

if(res.equals("VERIFIED")) {
    System.out.print("Verified");
    if("Completed".equals(payment_status)||"completed".equals(payment_status.toLowerCase()) || "COMPLETED".equals(payment_status.toUpperCase()))
    {
              try
            
        {
           invoiceservice obj=new invoiceservice(classname, driver);
           int i=obj.getInvoice(user_id, invoice_number, amt);
           if(i!=1)
           {
             System.out.print("no payement");                 
           }
            else
           {
               int x=obj.removeInvoice(user_id, invoice_number, amt);
             
           planservice obj1=new planservice(classname, driver);
           List list=obj1.getPlanDetailpayment(amt);
           modelplan modplan=(modelplan)list.get(0);
           int no_of_songs=modplan.getSongs();
           String plan_name=modplan.getPlan_name();
           int duration=modplan.getDuration();
           paymentservice obj2=new paymentservice(classname, driver);
           int j=obj2.addPayment(user_id, amt,duration, no_of_songs, plan_name, name, city, email);
              
           if(j!=1)
           {
               System.out.print("Payement table update failed");
           }
          else
           {
               Counterservice obj3=new Counterservice(classname, driver);
               int k=obj3.updateCounter(no_of_songs,duration);
               if(k!=1)
               {
                   System.out.print("Counter failed to update");
               }
               else
               {
                   
                   System.out.print("Great Work");
               }
           }
               
           }
            
        }
              catch(Exception x)
              {
                  System.out.print(x);
              }
         finally {            
            out.close();
        }
    }
    else
    {
            System.out.print("payement status is not completed");
    }
}
else
{
         System.out.print("paypal verification failed");
}
        }
        catch(Exception e)
        {
                 System.out.print(e);
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

   
}
