/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class Songdao {
String classname,driver;
    int album_id;
    String[] split;

    public Songdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }

   
    
    
    public List getSongsdao(int album_id)
    {
        this.album_id=album_id;
     List list=new ArrayList();
     Connection con=null;
        try
          
          {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
              Statement st1=con.createStatement();
            ResultSet rs1=st1.executeQuery("select song_id,Song_name,song_url,Album_id,demo_url,Artist_name from song where Album_id="+album_id);
            
            while(rs1.next())
            {
                modelsong obj=new modelsong();
                obj.setSong_id(rs1.getInt(1));
                obj.setSong_name(rs1.getString(2));
                obj.setSong_url(rs1.getString(3));
                obj.setAlbum_id(rs1.getInt(4));
                obj.setDemo_url(rs1.getString(5));
                obj.setArtist_name(rs1.getString(6));
                list.add(obj);
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                 System.out.print(e);
            list=null;
           return list;
        }
   
}
    
    public boolean addsongdao(int album_id,String song_name,String song_url,String Artist_name,int bitrate,int frequency,int genreid,String duration,String len,String demo_url,String release_year)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement(); 
          
            String query1="INSERT INTO song (Album_id, Song_name, song_url, Artist_name, bitrate, frequency, Genre_id,duration,len,demo_url,release_year) VALUES ("+album_id+", \""+song_name+"\", \""+song_url+"\",\""+Artist_name+"\",\""+bitrate+"\",\""+frequency+"\",\""+genreid+"\",\""+duration+"\",\""+len+"\",\""+demo_url+"\",\""+release_year+"\")";
            //String query="INSERT INTO SONG (song_id, Album_id, Song_name, song_url,Artist_name,Genre_id) VALUES (null, "+album_id+", \""+song_name+"\", \""+song_url+"\",\""+Artist_name+"\",\""+genreid+"\")";
             System.out.print(query1);
            boolean result=st1.execute(query1);
            String query2="select song_id from song where song_url=\'"+song_url+"\'";
            System.out.print(query2);
            ResultSet rs1=st3.executeQuery(query2);
            rs1.next();
            String query3="INSERT INTO rating (song_id,album_id) VALUES ("+rs1.getString(1)+",\'"+album_id+"\')";
            st4.execute(query3);
            System.out.print(query1); 
            System.out.print(result);
            
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return result;
            
            
            
            
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Insert in song"+e);
            return true;
        }
    
    
    
    
    }
    
    
    
    public List getSongDetailsdao(int song_id)
    {
        Connection con=null;
         List list=new ArrayList();
        try
          
          {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
              Statement st1=con.createStatement();
            String query="select * from song where song_id="+song_id;
            System.out.print(query);
            ResultSet rs1=st1.executeQuery(query);
            
           
            Statement st2=con.createStatement();
            ResultSet rs2=st2.executeQuery("select * from comments where song_id="+song_id);
            while(rs1.next())
            {
                
                modelsong obj=new modelsong();
                obj.setSong_id(rs1.getInt(1));
                obj.setAlbum_id(rs1.getInt(2));
                obj.setSong_name(rs1.getString(3));
                obj.setSong_url(rs1.getString(4));
                obj.setArtist_name(rs1.getString("Artist_name"));
                obj.setLen(rs1.getString("len"));
                obj.setDuration(rs1.getString("duration"));
                obj.setDemo_url(rs1.getString("demo_url"));
                obj.setRelease_year(rs1.getString("release_year"));
                obj.setFrequency(rs1.getInt("frequency"));
                obj.setBitrate(rs1.getInt("bitrate"));
                genreservice x=new genreservice(classname, driver);
                String genre=x.getGenreName(rs1.getInt("Genre_id"));
                obj.setGenre(genre);
                list.add(obj); 
                        
                
            }
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}   
        return list;
    }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        list=null;
        System.out.print("Error in getsongdetail"+e);
        return list;
    }
    
}
    public List getLatestCommentsdao()
    {
        Connection con=null;
        System.out.print("Start");
         List list=new ArrayList();
        try
        {
            
            //Class.forName(classname);
           // System.out.print(s);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           // System.out.print(s);
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
           // System.out.print(s);
            String query="select user_id,comment,dat,comment_id,album_id,song_id from comments order by dat desc limit 5";
           System.out.println(query);
            ResultSet rs1=st1.executeQuery(query);
            
           // System.out.print(s);
            
            while(rs1.next())
            {
                Statement st2=con.createStatement();
                ResultSet rs2=st2.executeQuery("select user_name from login where user_id="+rs1.getInt(1));
                rs2.next();
                Statement st3=con.createStatement();
                String query3="select song_name from song where song_id="+rs1.getInt("song_id");
                ResultSet rs3=st3.executeQuery(query3);
                rs3.next();
                 System.out.println(query3);
                String username=rs2.getString(1);  
                modelcomments obj=new modelcomments();
                obj.setComment_id(rs1.getInt("comment_id"));
                obj.setUsername(username);
                obj.setComment(rs1.getString(2));
                obj.setTime(rs1.getString(3));
                obj.setSong_name(rs3.getString(1));
                list.add(obj);
                      
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
           // System.out.print(s);
        }        
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Get Comments"+e);   
        list=null;
        return list;
        }
   
    }
    
    public List getCommentsdao(int song_id)
    {
        Connection con=null;
        System.out.print("Start");
         List list=new ArrayList();
        try
        {
            
            //Class.forName(classname);
           // System.out.print(s);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();
            // System.out.print(s);
            Statement st1=con.createStatement();
           // System.out.print(s);
            String query="select user_id,comment,dat,comment_id from comments where song_id="+song_id+" order by dat desc";
           System.out.println(query);
            ResultSet rs1=st1.executeQuery(query);
            
           // System.out.print(s);
            
            while(rs1.next())
            {
                Statement st2=con.createStatement();
                ResultSet rs2=st2.executeQuery("select user_name from login where user_id="+rs1.getInt(1));
                rs2.next();
                String username=rs2.getString(1);  
                modelcomments obj=new modelcomments();
                obj.setComment_id(rs1.getInt("comment_id"));
                obj.setUsername(username);
                obj.setComment(rs1.getString(2));
                obj.setTime(rs1.getString(3));
                list.add(obj);
                      
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
           // System.out.print(s);
        }        
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Get Comments"+e);   
        list=null;
        return list;
        }
   
    }
    
      public List getCommentsuserdao(String user_id)
    {
        Connection con=null;
        System.out.print("Start");
         List list=new ArrayList();
        try
        {
            
           // Class.forName(classname);
           // System.out.print(s);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           // System.out.print(s);
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
           // System.out.print(s);
            String query="select user_id,comment,dat,comment_id,song_id from comments where user_id="+user_id+" order by dat desc";
           System.out.println(query);
            ResultSet rs1=st1.executeQuery(query);
            
           // System.out.print(s);
            
            while(rs1.next())
            {
                Statement st2=con.createStatement();
                ResultSet rs2=st2.executeQuery("select user_name from login where user_id="+rs1.getInt(1));
                rs2.next();
                String username=rs2.getString(1);  
                modelcomments obj=new modelcomments();
                obj.setComment_id(rs1.getInt("comment_id"));
                obj.setUser_id(rs1.getString("user_id"));
                obj.setUsername(username);
                obj.setComment(rs1.getString(2));
                obj.setTime(rs1.getString(3));
                obj.setSong_id(rs1.getString("song_id"));
                list.add(obj);
                      
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
           // System.out.print(s);
        }        
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Get Comments"+e);   
        list=null;
        return list;
        }
   
    }
      
    public void setCommentsdao(int song_id,int user_id,String comment)
    {
        Connection con=null;
           // String song_id1="1";
           // String username1="1";
           // String comment1="Hardcoded Comment";
        try
        {
            
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            
            Statement st2=con.createStatement();
            String q="select Album_id from song where song_id="+song_id;
            ResultSet rs=st2.executeQuery(q) ;
            rs.next();
           // Statement st2=con.createStatement();
            //int i=st1.executeUpdate("insert into COMMENTS values(null,"+username+","+song_id+","+comment+",datetime('now','+5 hours','+30 minutes'))");
            //INSERT INTO modelcomments (comment_id, username, song_id, comment, "time") VALUES (3, 1, '1', 'Nice song by user  1', '2011-12-31 10:38:01');
            //st1.executeUpdate("INSERT INTO modelcomments (comment_id, username, song_id, comment, \"time\") VALUES (NULL,"+username1+","+song_id1+" , \'"+comment1+"\', datetime('now','+5 hours','+30 minutes'))");
           // ResultSet rs=st2.executeQuery("select user_id from LOGIN where username=\'"+username+"\'");
            st1.executeUpdate("INSERT INTO comments (user_id, song_id, comment,album_id) VALUES (\'"+user_id +"\',\'"+song_id+"\' , \'"+comment+"\',\'"+rs.getString(1) +"\')");
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in set Comments"+e);
            
        }
    }
    
    public int deleteCommentDao(int comment_id)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="DELETE from comments where comment_id="+comment_id;
            System.out.print(query);
            int i=st1.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in delete Comments"+e);
            return 0;
        }
                
    }
    
    public int updateSongdao(String song_id,String album_id,String song_name,String song_url,String Artist_name,int bitrate,int frequency,int Genre_id,String duration,String len,String demo_url,String release_year)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="UPDATE song SET Album_id="+album_id+",Song_name=\'"+song_name+"\',song_url=\'"+song_url+"\',Artist_name=\'"+Artist_name+"\',bitrate="+bitrate+",frequency="+frequency+",Genre_id="+Genre_id+",duration=\'"+duration+"\',len=\'"+len+"\',release_year=\'"+release_year+"\' WHERE song_id ="+song_id+"";
            System.out.print(query);
            int i=st1.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
           
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         System.out.print("Error in update song"+e);   
            return 0;
        }
     
    }
    
    public boolean deleteSongdao(String song_id)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            String query1="DELETE FROM song WHERE song_id ="+song_id+"";
            boolean a=st1.execute(query1);
          //  String query2="DELETE FROM RATING WHERE song_id ="+song_id+"";
          //   boolean b=st2.execute(query2);
          //  String query3="DELETE FROM COMMENTS WHERE song_id ="+song_id+"";
         //    boolean c=st3.execute(query3);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return a;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in deleting song"+e);
            return true;
        }
    }
    
    public List getArtistdao()
       
       {
           Connection con=null;
           List list=new ArrayList();
       
           try
                    {
            //            Class.forName(classname);
            //            con=DriverManager.getConnection(split[0],split[1],split[2]); 
              con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select distinct Artist_name from song order by Artist_name";
                        ResultSet rs=st1.executeQuery(query);
                        
                        while(rs.next())
                        {
                            modelsong obj=new modelsong();
                            
                            obj.setArtist_name(rs.getString(1));
                            list.add(obj);
                            
                        }
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
                    
                    }
                      
            catch(Exception e)
                      { 
                          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                      list=null;
                      System.out.print("Error in getArtistdao songdao"+e);
                      return list;
                      }
       
       }
    
    public List getSongByArtistdao(String Artist_name)
       
       {
           Connection con=null;
            List list=new ArrayList();
       
           try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select song_name,song_id,album_id from song where Artist_name like '"+Artist_name+"'";
                        ResultSet rs=st1.executeQuery(query);
                       
                        while(rs.next())
                        {
                            modelsong obj=new modelsong();
                            obj.setSong_name(rs.getString(1));
                            obj.setSong_id(rs.getInt(2));
                            obj.setAlbum_id(rs.getInt(3));
                            list.add(obj);
                            
                        }
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
                    
                    }
                      
            catch(Exception e)
                      { 
                          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                      list=null;
                      System.out.print("Error in Get song by artist "+e);
                      return list;
                      }
       
       }
    
    public List getSongByGenredao(String Genre_id)
       
       {
           Connection con=null;
        List list=new ArrayList();
           try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select song_name,song_id,album_id from song where Genre_id="+Genre_id+"";
                        System.out.print(query);
                        ResultSet rs=st1.executeQuery(query);
                        
                        while(rs.next())
                        {
                            modelsong obj=new modelsong();
                            obj.setSong_name(rs.getString(1));
                            obj.setSong_id(rs.getInt(2));
                            obj.setAlbum_id(rs.getInt(3));
                            list.add(obj);
                            
                        }
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
                    
                    }
                      
            catch(Exception e)
                      { 
                          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                          list=null;
                          System.out.print("Error in getSongsbyGenre "+e);
                       return list;
                      }
       
       }
    
       public boolean genreUseddao(int Genre_id)
       
       {
           Connection con=null;
       
           try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String q="select Genre_id from song where Genre_id="+Genre_id+"";
                        System.out.print(q);
                        ResultSet rs=st1.executeQuery(q);
                        
                        if (rs.next())
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return true;
                        }
                        else
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return false;
                        }
                    }
           catch(Exception e)
           {
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
               System.out.print("Error in Genre used dao "+e);
               return true;
           }
}
       public List getTopSongsdao()
       {
           Connection con=null;
           List list=new ArrayList();
           
              try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        Statement st2=con.createStatement();
                         String query="select song_id,rating from rating order by rating desc limit 5";
                         
                         ResultSet rs1=st1.executeQuery(query);
                         while(rs1.next())
                            {  
                                ResultSet rs2=st2.executeQuery("select Song_name,song_id,Album_id from song where song_id="+rs1.getString("song_id"));
                                rs2.next();
                                Statement st3=con.createStatement();
                                ResultSet rs3=st3.executeQuery("select img_url from album where Album_id="+rs2.getInt(3));
                                rs3.next();
                                modelsong obj=new modelsong();
                                obj.setRating(rs1.getDouble(2));
                                obj.setSong_id(rs2.getInt(2));
                                obj.setSong_name(rs2.getString(1));
                                obj.setAlbum_id(rs2.getInt(3));
                                obj.setImg_url(rs3.getString(1));
                                list.add(obj);
                         }
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                         return list;
                    }
              catch(Exception e)
              {
                  if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                  list=null;
                  System.out.print("Error in top songs "+e);
                  return list;
                 
              }
       }
       
       public List getDownloadHistorydao(int user_id)
       {
           Connection con=null;
           List list=new ArrayList();
           try
           {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
               con=DatasourceConnection.getConnection();         
               Statement st1=con.createStatement();
                        String query="select * from music.downloadhistory where user_id="+user_id+" order by download_id desc";
                        System.out.print(query);
                        ResultSet rs=st1.executeQuery(query);
                        while (rs.next())
                        {
                            modelsong obj=new modelsong();
                            obj.setSong_name(rs.getString("song_name"));
                            obj.setDdate(rs.getString("dtime"));
                            list.add(obj);
                            
                        }
                       if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
           }
           catch(Exception e)
           {
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
               System.out.print(e);
               list=null;
               return list;
           }
       }
       
       public int checkSongNamedao(String song_name)
   {
       Connection con=null;
       try
       {
                        //Class.forName(classname);
                       //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();  
                        String query="select song_id from song where Song_name='"+song_name+"'";
                        ResultSet rs=st1.executeQuery(query);
                        if(rs.next())
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return 1;
                        }
                        else
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return 0;
                        }
       }
       catch(Exception e)
       {
           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
           System.out.print("Error in check Song dao"+e);
           return 0;
           
       }
   }
       
       public int verifySongNamedao(int song_id,String song_name)
   {
       Connection con=null;
       try
       {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();  
                        String query="select Song_name from song where song_id="+song_id;
                        ResultSet rs=st1.executeQuery(query);
                        rs.next();
                        String song_name1=rs.getString(1);
                        if(song_name.equals(song_name1))
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return 1;
                        }
                        else
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return 0;
                        }
       }
       catch(Exception e)
       {
           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
           System.out.print("Error in check Album dao"+e);
           return 0;
           
       }
   }


 public List getSongsNamedao(int album_id)
    {
        Connection con=null;
        this.album_id=album_id;
     List list=new ArrayList();
        try
          
          {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
              Statement st1=con.createStatement();
            ResultSet rs1=st1.executeQuery("select Song_name from song where Album_id="+album_id);
            
            while(rs1.next())
            {
                modelsong obj=new modelsong();
                obj.setSong_name(rs1.getString("Song_name"));
                list.add(obj);
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                 System.out.print(e);
            list=null;
           return list;
        }
   
}
 }