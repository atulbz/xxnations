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
public class requestservice {
         String classname,driver;

         public requestservice(String classname, String driver) {
                  this.classname = classname;
                  this.driver = driver;
         }
         
         public int setRequest(String user_id,String username,String song,String album)
         {
                  requestdao obj=new requestdao(classname, driver);
                  return obj.setRequestdao(user_id, username, album, song);
         }
         
         public List getRequest()
         {
                  requestdao obj=new requestdao(classname, driver);
                  return obj.getRequestdao();
         }
         public List getRequestuser(String user_id)
         {
                  requestdao obj=new requestdao(classname, driver);
                  return obj.getRequestuserdao(user_id);
         }
         public int deleteRequest(String request_id)
         {
                  requestdao obj=new requestdao(classname, driver);
                  return obj.deleteRequestdao(request_id);
         }
}
