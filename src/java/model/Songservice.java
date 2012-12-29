/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;

/**
 *
 * @author Shaishav
 */
public class Songservice {
    
     String classname,driver;
    String Song_name,song_url,Album_id,song_id;

    public Songservice(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
    }
    
    public List getSongs(int Album_id)
    {
       Songdao obj=new Songdao(classname,driver);
       return obj.getSongsdao(Album_id);
       
    }
    public List getSongsName(int Album_id)
    {
       Songdao obj=new Songdao(classname,driver);
       return obj.getSongsNamedao(Album_id);
       
    }
    
    public List getSongDetails(int song_id)
    {
        Songdao obj=new Songdao(classname,driver);
        return obj.getSongDetailsdao(song_id);
    }
         
    public List getComments(int song_id)
    {
        Songdao obj=new Songdao(classname,driver);
        return obj.getCommentsdao(song_id);
        
    }
    
      public List getCommentsuser(String user_id)
    {
        Songdao obj=new Songdao(classname,driver);
        return obj.getCommentsuserdao(user_id);
        
    }
      
     public void setComments(int song_id,int user_id,String comment)
    {
        Songdao obj=new Songdao(classname,driver);
        obj.setCommentsdao(song_id, user_id, comment);
        
    }
    public boolean addsong(int album_id,String song_name,String song_url,String Artist_name,int bitrate,int frequency,String Genre,String duration,String len,String demo_url,String release_year)
    {
         genreservice obj=new genreservice(classname, driver) ;
        int Genre_id = obj.getGenreId(Genre);
        Songdao obj1=new Songdao(classname,driver);
        
        return obj1.addsongdao(album_id, song_name, song_url, Artist_name, bitrate, frequency, Genre_id, duration, len, demo_url, release_year);
    }
     
    public int updateSong(String song_id,String album_id,String song_name,String song_url,String Artist_name,int bitrate,int frequency,String Genre,String duration,String len,String demo_url,String release_year)
    {
        genreservice obj=new genreservice(classname, driver) ;
        int Genre_id = obj.getGenreId(Genre);
        Songdao obj1=new Songdao(classname,driver);
        return obj1.updateSongdao(song_id, album_id, song_name, song_url, Artist_name, bitrate, frequency, Genre_id, duration, len, demo_url, release_year);
        
    }
    public boolean deleteSong(String song_id)
    {
        Songdao obj=new Songdao(classname,driver);
        return obj.deleteSongdao(song_id);
    }
    
      public List getArtist()
    {
         Songdao obj=new Songdao(classname,driver);
         return obj.getArtistdao();
        
    }
      
      public List getSongByArtist(String Artist_name)
    {
         Songdao obj=new Songdao(classname,driver);
         return obj.getSongByArtistdao(Artist_name);
        
    }
       public List getSongByGenre(String Genre_id)
    {
         Songdao obj=new Songdao(classname,driver);
         return obj.getSongByGenredao(Genre_id);
        
    }
       
       public boolean genreUsed(String Genre)
       {
           genredao obj=new genredao(classname,driver);
           Songdao obj1=new Songdao(classname,driver);
           return obj1.genreUseddao(obj.getGenreiddao(Genre));
       }
       
       public List getTopSongs()
       {
           Songdao obj=new Songdao(classname,driver);
           return obj.getTopSongsdao();
       }
       public int deleteComment(int comment_id)
       {
           Songdao obj=new Songdao(classname,driver);
           return obj.deleteCommentDao(comment_id);
       }
       
       public List getDownloadHistory(int user_id)
       {
           Songdao obj=new Songdao(classname,driver);
           return obj.getDownloadHistorydao(user_id);
       }
       public int checkSongName(String Song_name)
      {
         Songdao obj=new Songdao(classname,driver);
          return obj.checkSongNamedao(Song_name);
      }
      
      public int verifySong(int song_id,String song_name)
      {
          Songdao obj=new Songdao(classname,driver);
          return obj.verifySongNamedao(song_id,song_name);
      }
      public List getLatestComment()
       {
           Songdao obj=new Songdao(classname,driver);
           return obj.getLatestCommentsdao();
       }
}

