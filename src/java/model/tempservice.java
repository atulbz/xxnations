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
public class tempservice {
String classname,driver;

    public tempservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }

public int setTemp(int user_id,String k,String url,String size)
{
        
    tempdao obj=new tempdao(classname, driver);
    return obj.setTempdao(user_id, k,url,size);
}
    public List getTemp(String k)
{
    tempdao obj=new tempdao(classname, driver);     
    return obj.getTempdao(k);
}
   public void delTemp(String k)
   {
       tempdao obj=new tempdao(classname, driver);     
       obj.delTempdao(k);
   }
    
}
