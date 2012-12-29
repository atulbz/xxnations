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
public class Loginservice {

    String classname,driver;
    public Loginservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public String validate(String username,String password)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.validate(username,password);
        
    }

    public int getUserID(String username)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.getUserId(username);
        
        
    }
   
     public String validateadmin(String username,String password)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.validateadmin(username,password);
        
    }

    public int getAdminID(String username)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.getAdminId(username);
        
        
    }
    
    public String updateUser(int user_id,String username,String password)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.updateUserdao(user_id, username, password);
        
    }
      public String updateAdmin(int admin_id,String username,String password)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.updateAdmindao(admin_id, username, password);
        
    }
    
    public String getEmail(int user_id)
    {
        Logindao obj=new Logindao(classname,driver);
        return obj.getEmaildao(user_id);
    }
    
}
