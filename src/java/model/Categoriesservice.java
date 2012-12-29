/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.util.List;


/**
 *
 * @author Shaishav
 */
public class Categoriesservice {
    String classname,driver;
    String Genre;
    public Categoriesservice(String classname,String driver)
    {
      this.classname=classname;
      this.driver=driver;
    }
    
    public List getAlbums(String Genre)
    {
        
       
        Categoriesdao dao=new Categoriesdao(classname,driver);
        return dao.getAlbumsdao(Genre);
        
    }
    
}
