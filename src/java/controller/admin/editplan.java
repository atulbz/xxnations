/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

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
import model.modelplan;
import model.planservice;

/**
 *
 * @author Shaishav
 */
public class editplan extends HttpServlet {

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
            ServletContext sc = getServletContext();
            String classname = (String) sc.getInitParameter("classname");
            String driver = (String) sc.getInitParameter("driver");
            String planid1 = request.getParameter("plan_id");
            int planid = Integer.parseInt(planid1);
            /*  String plan_name=request.getParameter("plan_name");
            String amount1=request.getParameter("amount");
            Float amount=Float.parseFloat(amount1);
            String duration1=request.getParameter("duration");
            Integer duration=Integer.parseInt(duration1);
            String songs1=request.getParameter("noofsongs");
            Integer songs=Integer.parseInt(songs1);
            
             */
            String plan_name = request.getParameter("plan_name");
            List errormsgs = new LinkedList();
            if (plan_name.isEmpty() || "".equals(plan_name) || plan_name == null) {
                errormsgs.add("Enter Plan Name");
            }
            planservice obj1 = new planservice(classname, driver);
            List list1 = obj1.getPlanDetails(planid1);
            modelplan modplan = (modelplan) list1.get(0);
           
          
            
            
            if (modplan.getPlan_name().equals(plan_name)) {
            } else {
                boolean checkPlanName = obj1.checkPlanName(plan_name);
                if(checkPlanName)
                {
                    errormsgs.add("Plan of same name "+plan_name+" exists");
                }
            }

            float amount =0;
            int duration = 0, songs = 0;
            String amount1 = request.getParameter("amount");
            if (amount1.isEmpty() || "".equals(amount1) || amount1 == null) {
                errormsgs.add("Enter Amount");
                System.out.print("Enter amount");
            } 
            
            else {
                try {
                    amount = Float.parseFloat(amount1);
                } catch (Exception e) {
                    errormsgs.add("Enter valid amount");
                }
            }

            if (modplan.getAmount() == amount) {
            } else {
                boolean checkAmount = obj1.checkAmount(amount);
                if(checkAmount)
                {
                       errormsgs.add("Plan of same Amount "+amount+" exists");
                    }
                }
            


            String duration1 = request.getParameter("duration");
            if (duration1.isEmpty() || "".equals(duration1) || duration1 == null) {
                errormsgs.add("Enter Duration");
            } else {


                try {
                    duration = Integer.parseInt(duration1);
                } catch (Exception e) {
                    errormsgs.add("Enter the valid value of duration");
                }
            }
            String songs1 = request.getParameter("noofsongs");

            if (songs1.isEmpty() || "".equals(songs1) || songs1 == null) {
                errormsgs.add("Enter No of Songs");
            } else {
                try {
                    songs = Integer.parseInt(songs1);
                } catch (Exception e) {
                    errormsgs.add("Enter valid No of Songs");
                }
            }
            
            System.out.print("Boolean "+!errormsgs.isEmpty());
            if (!errormsgs.isEmpty()) {
                RequestDispatcher rd = request.getRequestDispatcher("../admin/editplan.jsp");
                request.setAttribute("errormsgs", errormsgs);
                rd.forward(request, response);
                return;
            }


            planservice obj = new planservice(classname, driver);
            int i = obj.updatePlan(planid, plan_name, amount, duration, songs);

            if (i == 1) {
                out.print("Plan "+plan_name+" updated successfully click <a href=\"../admin/planmgmt.jsp\">here</a> to go to plan management or go to <a href=\"../admin/home.jsp\">home</a>");
            } else {
                 request.setAttribute("message", "<ul>The Plan "+plan_name+" cannot be added please check the following"
                      + "<br><li>Database is connected"
                      + "<br><li>Table Constraint are fulfilled check report to see the constraints"
                      + "<br><li>Database may be down try again later</li>");
              RequestDispatcher rd=request.getRequestDispatcher("../admin/error.jsp");
              rd.forward(request, response);
            }

        } catch (Exception e) {
            response.sendError(400, e.getMessage());
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
