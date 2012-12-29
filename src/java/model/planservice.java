/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Shaishav
 */
public class planservice {

    String classname, driver;

    public planservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }

    public List getPlans() {
        plandao obj = new plandao(classname, driver);
        return obj.getPlansdao();

    }
       public boolean checkPlanName(String planname) {
        plandao obj = new plandao(classname, driver);
        return obj.checkPlanNameDao(planname);
    }

    public boolean checkAmount(float amount) {
        plandao obj = new plandao(classname, driver);
        return obj.checkAmountDao(amount);
    }

    public int addPlan(String plan_name, float amount, int duration, int nos) {
        plandao obj = new plandao(classname, driver);
        return obj.addPlandao(plan_name, amount, duration, nos);
    }

    public int updatePlan(int plan_id, String plan_name, float amount, int duration, int nos) {
        plandao obj = new plandao(classname, driver);
        return obj.updatePlandao(plan_id, plan_name, amount, duration, nos);
    }

    public List getPlanDetails(String plan_id) {
        plandao obj = new plandao(classname, driver);
        return obj.getPlanDetailsdao(plan_id);

    }

    public int removePlan(String plan_id) {
        plandao obj = new plandao(classname, driver);
        return obj.removePlandao(plan_id);

    }
    
     public List getPlanDetailpayment(float amount)
     {
         plandao obj = new plandao(classname, driver);
         return obj.getPlanDetailpaymentdao(amount);
     }
}
