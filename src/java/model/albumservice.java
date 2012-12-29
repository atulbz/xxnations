/*
 * To change this template,String  choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Shaishav
 */
public class albumservice {
String classname,driver;
    public albumservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public List getAlbumlist()
    {
        albumdao obj=new albumdao(classname,driver);
        return obj.getAlbumListdao();
    }
    public List getArtist()
    {
        albumdao obj=new albumdao(classname,driver);
        return obj.getArtistdao();
    }
    
    public List getDetails(String id)
    {
        albumdao obj=new albumdao(classname,driver);
        return obj.getDetailsdao(id);
    }
    
    public List getAlbumByArtist(String Artist_name)
    {
         albumdao obj=new albumdao(classname,driver);
         return obj.getAlbumByArtistdao(Artist_name);
      
    }
    public boolean addAlbum(String album_name,String Genre,String Release_date,String Artist_name,String Album_info,String img_url,String Featuring_artists)
    {
        albumdao obj=new albumdao(classname,driver);
        return obj.addAlbumdao(album_name, Genre, Release_date, Artist_name, Album_info, img_url, Featuring_artists);
    }
    public int updateAlbum(String album_name,String Genre_id,String Album_id,String Release_date,String Artist_name,String Album_info,String img_url,String Featuring_artists)
    {
      albumdao obj=new albumdao(classname,driver);
      return obj.updateAlbumdao(album_name, Genre_id, Album_id, Release_date, Artist_name, Album_info, img_url, Featuring_artists);
    }
    
    public boolean deleteAlbum(String Album_id)
    {
         albumdao obj=new albumdao(classname,driver);
         return obj.deleteAlbumdao(Album_id);
      
    }
      public List getAlbumByGenre(int Genre_id)
    {
         albumdao obj=new albumdao(classname,driver);
         return obj.getAlbumByGenredao(Genre_id);
        
    }
      
      public List getLatestAlbum()
    {
         albumdao obj=new albumdao(classname,driver);
         return obj.getLatestAlbumdao();
        
    }
     
      public int checkAlbum(String album_name)
      {
          albumdao obj=new albumdao(classname,driver);
          return obj.checkAlbumNamedao(album_name);
      }
      
      public int verifyAlbum(int album_id,String album_name)
      {
          albumdao obj=new albumdao(classname,driver);
          return obj.verifyAlbumNamedao(album_id,album_name);
      }
      
      public String getUrl(String Album_id)
      {
               albumdao obj=new albumdao(classname,driver);
               return obj.getUrldao(Album_id);
      }
}