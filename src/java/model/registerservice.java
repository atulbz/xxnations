/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Shaishav
 */
public class registerservice {
String classname,driver;

    public registerservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }
  
    
    public void addTemp(String fname,String lname,String username,String password,String sex,String dob,String city,String email,String kcode )
    
    {
        
        registerdao obj=new registerdao(classname,driver);
        obj.addTempDao(fname, lname, username, password,sex, dob, city, email,kcode);
    }
    
   /*public void add(String fname,String lname,String username,String password,String age,String sex,String dob,String city,String email,String question,String answer)
    
    {
        
        registerdao obj=new registerdao(classname,driver);
        obj.adddao(fname, lname, username, password, age, sex, dob, city, email, question, answer);
    }*/
   
   public boolean verify(String s)
   {
       registerdao obj=new registerdao(classname,driver);
       return obj.verify(s);
   }
    
   public List editUser(int id)
   {
       registerdao obj=new registerdao(classname,driver);
       return obj.editUserdao(id);
       
   }
    public List editAdmin(String id)
   {
       registerdao obj=new registerdao(classname,driver);
       return obj.editAdmindao(id);
       
   }
    public int updateUser(int user_id,String fname,String lname,String username,String password,String sex,String dob,String city,String email)
   {
       registerdao obj=new registerdao(classname,driver);
       return obj.updateUserdao(user_id, fname, lname, username, password,sex,dob, city, email);
       
   }
    public int updateAdmin(int admin_id,String fname,String lname,String username,String password,String sex,String email,String dob)
   {
       registerdao obj=new registerdao(classname,driver);
       return obj.updateAdmindao(admin_id, fname, lname, username, password,sex, email,dob);
       
   }
    public List listuser(String q)
    {
        registerdao obj=new registerdao(classname,driver);
        return obj.listuserdao(q);
    }
            
    public boolean checkUsername(String username )
    {
        registerdao obj=new registerdao(classname,driver);
        return obj.checkUsernamedao(username);
    }
    
    public boolean checkEmail(String email)
    {
        registerdao obj=new registerdao(classname,driver);
        return obj.checkEmaildao(email);
    }
    
    public String findEmail(int user_id)
    {
        registerdao obj=new registerdao(classname,driver);
        return obj.findEmaildao(user_id);
    }
    
    public int removeUser(int user_id)
    {
        registerdao obj=new registerdao(classname,driver);
        return obj.removeUserdao(user_id);
    }
}
