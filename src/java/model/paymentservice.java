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
public class paymentservice {
    String classname,driver;
    
    
    public paymentservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public int addPayment(int user_id,float amount,int duration,int  no_of_songs,String plan_name,String name,String city,String email)
    {
        paymentdao obj=new paymentdao(classname, driver);
        return obj.addPaymentdao(user_id, amount,duration, no_of_songs, plan_name, name, city, email);
        
    }
   
    public List getPayment(int user_id)
    {
          paymentdao obj=new paymentdao(classname, driver);
          return obj.getPaymentdao(user_id);
    }
     public List getAllPayment()
    {
          paymentdao obj=new paymentdao(classname, driver);
          return obj.getAllPaymentdao();
    }
      public List getRangePayment(String from,String to)
    {
          paymentdao obj=new paymentdao(classname, driver);
          return obj.getRangePaymentdao(from, to);
    }
}
