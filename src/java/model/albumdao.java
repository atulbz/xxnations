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
public class albumdao {
String classname,driver;String[] split;

    public albumdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
    
    public List getAlbumListdao()
    {
        List list=new ArrayList();
          Connection con=null; 
       try
       {
           //Class.forName(classname);
       
              //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();   
           Statement st1=con.createStatement();
              String query="select Album_name,Album_id,img_url from album order by Album_name";
              ResultSet rs1=st1.executeQuery(query);
              
              
              while(rs1.next())
              {
              modelalbum obj=new modelalbum();
              obj.setAlbum_name(rs1.getString(1));
              obj.setAlbum_id(rs1.getInt(2));
              obj.setImg_url(rs1.getString(3));
              list.add(obj);
              
              }
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              return list;
    }
    catch(Exception e)
    {
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        list=null;
        System.out.print("get album list"+e);
        return list;
        
    }
       
    } 
    
    
       public List getDetailsdao(String id)
       {
           Connection con=null;
           List list=new ArrayList();
           
           
           try
       {
           //Class.forName(classname);
       
              //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();   
           Statement st1=con.createStatement();
              String query1="select * from album where Album_id="+id+"";
              System.out.print(query1);
              ResultSet rs1=st1.executeQuery(query1);
              boolean result=rs1.next();
              Statement st2=con.createStatement();
              String query2="select Genre from genre where Genre_id="+rs1.getString(3)+"";
              System.out.print(query2);
              ResultSet rs2=st2.executeQuery(query2);
              rs2.next();
              
              if(result)
              {
              modelalbum obj=new modelalbum();
              obj.setAlbum_id(rs1.getInt(1));
              obj.setAlbum_info(rs1.getString(6));
              obj.setAlbum_name(rs1.getString(2));
              obj.setArtist_name(rs1.getString("Artist_name"));
              obj.setFeaturing_artists(rs1.getString(8));
              obj.setGenre(rs2.getString(1));
              obj.setImg_url(rs1.getString(7));
              obj.setRelease_date(rs1.getDate(4));
              list.add(obj);
              
              }
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              return list;
    }
    catch(Exception e)
    {
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        list=null;
        System.out.print("getalbumdetailsdao "+e);
       return list;
        
    }
           
     
       }
       
       public List getAlbumByArtistdao(String Artist_name)
       
       {
           Connection con=null;
           List list=new ArrayList();
          
       
           try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select Artist_name,Album_id,Album_name,img_url from album where Artist_name='"+Artist_name+"'";
                        ResultSet rs=st1.executeQuery(query);
                        
                        while(rs.next())
                        {
                            modelalbum obj=new modelalbum();
                            obj.setArtist_name(rs.getString(1));
                            obj.setAlbum_id(rs.getInt(2));
                            obj.setAlbum_name(rs.getString(3));
                            obj.setImg_url(rs.getString("img_url"));
                            list.add(obj);
                            
                        }
                        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
                    
                    }
                      
            catch(Exception e)
                      { 
                           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                          list=null;
                          System.out.print("Album by artist "+e);
                  return list;
                      }
       
       }
  public boolean addAlbumdao(String album_name,String Genre,String Release_date,String Artist_name,String Album_info,String img_url,String Featuring_artists)
  {
      Connection con=null;
      try
      {
          //Class.forName(classname);
          //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();
          Statement st1=con.createStatement();
          ResultSet rs=st1.executeQuery("select Genre_id from genre where Genre='"+Genre+"'");
          rs.next();
          Statement st2=con.createStatement();
          String query="INSERT INTO album (Album_name, Genre_id, Release_date, Artist_name, Album_info, img_url, Featuring_artists) VALUES ('"+album_name+"', "+rs.getString(1) +", '"+Release_date+"', '"+Artist_name+"', '"+Album_info+"', '"+img_url+"', '"+Featuring_artists+"');";
          boolean result=st2.execute(query);
          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
          return result;
          
      }
      catch(Exception e)
      {
           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
          System.out.print("Add album"+e);
          return true;
      }
      
  }
  
  public int updateAlbumdao(String album_name,String Genre_id,String Album_id,String Release_date,String Artist_name,String Album_info,String img_url,String Featuring_artists)
  {
      Connection con=null;
      try
      {
          //Class.forName(classname);
          //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();
          Statement st1=con.createStatement();
          String query1="select Genre_id from genre where genre='"+(Genre_id).toLowerCase()+"'";
          System.out.print(query1);
          ResultSet rs=st1.executeQuery(query1);
          rs.next();
          Statement st2=con.createStatement();
          String query2="UPDATE album SET Album_name = '"+album_name+"', Genre_id = "+rs.getString("Genre_id") +", Release_date='"+Release_date+"', Artist_name='"+Artist_name+"', Album_info='"+Album_info+"', img_url='"+img_url+"', Featuring_artists='"+Featuring_artists+"'  WHERE Album_id = "+Album_id+"";
          System.out.print(query2);
          int i=st2.executeUpdate(query2);
          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
          return i;
      
      }
      catch(Exception e)
      {
           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
          System.out.print("Update Album"+e);
          return 0;
      }
      
  }
   public boolean deleteAlbumdao(String Album_id)
    {
     Connection con=null;
        try
        {
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement();
            Statement st5=con.createStatement();
          //  String query1="DELETE FROM SONG WHERE Album_id ="+Album_id+"";
          //  boolean p=st1.execute(query1);
          //  String query2="DELETE FROM RATING WHERE album_id="+Album_id+"";
          //  System.out.print(query2);
          //  boolean q=st2.execute(query2);
          //  String query4="DELETE FROM COMMENTS where album_id="+Album_id+"";
          //  System.out.println(query4);
          //  st4.execute(query4);
            String query3="DELETE FROM album WHERE Album_id ="+Album_id+"";
             System.out.print(query3);
             boolean r=st3.execute(query3);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return r;
        }
        catch(Exception e)
        {
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print(e);
            return true;
        }
        
        
    }
   
   public List getArtistdao()
    {
        Connection con=null;
        List list=new ArrayList();
           
      try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select distinct Artist_name from album order by Artist_name";
                        ResultSet rs=st1.executeQuery(query);
                        
                        while(rs.next())
                        {
                            modelalbum obj=new modelalbum();
                            System.out.print("*");
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
                       return list;
                      }
   
    }
   public List getAlbumByGenredao(int Genre_id)
       
       {
           Connection con=null;
           List list=new ArrayList();
         
       
           try
                    {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
                        con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        String query="select Album_id,Album_name,img_url from album where Genre_id='"+Genre_id+"'";
                        System.out.print(query);
                        ResultSet rs=st1.executeQuery(query);
                        
                        while(rs.next())
                        {
                            modelalbum obj=new modelalbum();
                            obj.setAlbum_id(rs.getInt(1));
                            obj.setAlbum_name(rs.getString(2));
                            obj.setImg_url(rs.getString("img_url"));
                            list.add(obj);
                            
                        }
                        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
                    
                    }
                      
            catch(Exception e)
                      { 
                           if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                          list=null;
                        return list;
                      }
       
       }
   
   public List getLatestAlbumdao()
   {
       Connection con=null;
          List list=new ArrayList();
       
       try
       {
           
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();
                        String query="select Album_id,Album_name,img_url from album order by  Release_date desc limit 5;";
                        ResultSet rs1=st1.executeQuery(query);
                        
                        while(rs1.next())
                        {
                            modelalbum obj=new modelalbum();
                            obj.setAlbum_id(rs1.getInt(1));
                            obj.setAlbum_name(rs1.getString(2));
                            obj.setImg_url(rs1.getString("img_url"));
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
    
   public int checkAlbumNamedao(String album_name)
   {
       Connection con=null;
       try
       {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();  
                        String query="select album_id from album where Album_name='"+album_name+"'";
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
           System.out.print("Error in check Album dao"+e);
           return 0;
           
       }
   }
   public int verifyAlbumNamedao(int album_id,String album_name)
   {
       Connection con=null;
       try
       {
                        //Class.forName(classname);
                        //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();  
                        String query="select Album_name from album where Album_id="+album_id;
                        ResultSet rs=st1.executeQuery(query);
                        rs.next();
                        String album_name1=rs.getString(1);
                        if(album_name.equals(album_name1))
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
   public String getUrldao(String album_id)
   {
       Connection con=null;
       try
       {
          //Class.forName(classname);
                           //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();             
           Statement st1=con.createStatement();  
                        String query="select img_url from album where Album_id="+album_id+"";
                        System.out.println(query);
                        ResultSet rs=st1.executeQuery(query);
                        if(rs.next())
                        {
                            
                            String s=rs.getString(1);
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return s;
                        }
                        else
                        {
                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                            return "../images/album.jpg";
                        }
       }
       catch(Exception e)
       {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
           System.out.print("Error in getUrl dao"+e);
           return "../images/album.jpg";
           
       }
   }
}

