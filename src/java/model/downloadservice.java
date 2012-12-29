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
public class downloadservice {
         
         String classname,driver;
    public downloadservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
         public List getDownloadhistory(int user_id)
         {
                  
                  downloaddao obj=new downloaddao(classname, driver);
                  return obj.getDownloadHistorydao(user_id);
         }
         public int setDownloadhistory(int user_id,String song_name,String url)
         {
                  downloaddao obj=new downloaddao(classname, driver);
                  return obj.setDownloadHistorydao(user_id, song_name, url);
         }
}
