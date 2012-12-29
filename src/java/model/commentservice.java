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
public class commentservice {
String classname,driver;
    public commentservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public void setComments(int song_id,int user_id,String comment)
    {
            Songservice obj=new Songservice(classname,driver);
            obj.setComments(song_id, user_id, comment);
    }
    public List getComments(int song_id)
    {
        Songservice obj=new Songservice(classname,driver);
        return obj.getComments(song_id);  
    }
    public int deleteComment(int cid)
    {
                     Songservice obj=new Songservice(classname,driver);
                     return obj.deleteComment(cid);
    }
    public List getLatestComments()
    {
               Songservice obj=new Songservice(classname,driver);
               return obj.getLatestComment();
    }
      public List getCommentsUser(String user_id)
    {
        Songservice obj=new Songservice(classname,driver);
        return obj.getCommentsuser(user_id);  
    }
}
