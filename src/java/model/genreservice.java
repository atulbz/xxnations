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
public class genreservice {
    String classname,driver;

    public genreservice(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
    }
    
    
    
    
    
    public boolean findgenre(String genre)
    {
    genredao obj=new genredao(classname,driver);
    return obj.findgenredao(genre);
    }
    public List getGenre()
    {
        genredao obj=new genredao(classname,driver);
        return obj.getGenredao();
    }
    
    public int addGenre(String Genre)
    {
        genredao obj=new genredao(classname,driver);
        return obj.addGenredao(Genre);
    }
     public int removeGenre(String Genre_id)
    {
        genredao obj=new genredao(classname,driver);
        return obj.removeGenredao(Genre_id);
    }
     
     public int updateGenre(String Genre,String Genre_id)
     {
         genredao obj=new genredao(classname,driver);
         return obj.UpdateGenredao(Genre,Genre_id);
     }
     
     public int getGenreId(String genre)
     {
         genredao obj=new genredao(classname,driver);
         return obj.getGenreiddao(genre);
         
     }
     
     public String getGenreName(int Genre_id)
     {
         genredao obj=new genredao(classname,driver);
         return obj.getGenreNamedao(Genre_id);
     }
}
