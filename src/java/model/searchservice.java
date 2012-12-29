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
public class searchservice {
String classname,driver;

    public searchservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }
   
    public List search(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.searchdao(q);
                
    }
    public List searchsong(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.searchsongdao(q);
                
    }
    public List searchalbum(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.searchalbumdao(q);
                
    }
    
    public List searchartist(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.searchartistdao(q);
                
    }
        public List adminsearchsong(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.searchsongdao(q);
                
    }
    public List adminsearchalbum(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.adminsearchalbumdao(q);
                
    }
    
    public List adminsearchartist(String q)
    {
        searchdao obj=new searchdao(classname,driver);
        return obj.adminsearchartistdao(q);
                
    }
    public List searchusername(String q)
    {
         searchdao obj=new searchdao(classname,driver);
        return obj.adminsearchusernamedao(q);
        
    }
    public List searchemail(String q)
    {
         searchdao obj=new searchdao(classname,driver);
        return obj.adminsearchemaildao(q);
        
    }
}
