/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class mailservice {
String classname,driver,emailid,pwd;

    public mailservice(String classname, String driver,String emailid,String pwd) {
        this.classname = classname;
        this.driver = driver;
        this.emailid=emailid;
        this.pwd=pwd;
    }
  
    
    public String sendmail(String email)
    {
        
    maildao obj=new maildao(classname, driver, emailid, pwd);
    return obj.sendmaildao(email);
    
    }
    
    public String resend(String email)
    {
    
     maildao obj=new maildao(classname, driver, emailid, pwd);
     return obj.resenddao(email);
        
    }
    
    public String forgot(String email)
    {
        System.out.println("service"+email);
        maildao obj=new maildao(classname, driver, emailid, pwd);
        return obj.forgotdao(email);
    }
    public String adminforgot(String email)
    {
        System.out.println("service"+email);
        maildao obj=new maildao(classname, driver, emailid, pwd);
        return obj.adminforgotdao(email);
    }
}
