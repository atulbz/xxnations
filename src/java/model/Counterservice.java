/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
public class Counterservice {
String classname,driver;
    public Counterservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public int decCounter(int user_id,String query)
    {
        Counterdao obj=new Counterdao(classname,driver);
        return obj.decCounterdao(user_id,query);
    }
    
    public int getCounter(int user_id)
    {
        Counterdao obj=new Counterdao(classname,driver);
        return obj.getCounterdao(user_id);
    }
    
    public boolean checkDate(String date)
    {
        Counterdao obj=new Counterdao(classname,driver);
        return obj.checkDatedao(date);
    }
    
    public int updateCounter(int nos,int duration)
    {
        Counterdao obj=new Counterdao(classname,driver);
        return obj.updateCounterdao(nos, duration);
    }
}
