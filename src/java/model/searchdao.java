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
public class searchdao {
String classname,driver;
String[] split;

    public searchdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
    
    
   
    public List searchdao(String q)
    {
        Connection con=null;
        List list=new ArrayList(); 
        try
            {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                Statement st=con.createStatement();
            System.out.print("Default search");
            String s="select distinct song.Album_id,Album_name,song_id,Song_name,song_url,song.Genre_id,song.Artist_name,img_url from song join album using(Album_id) where Song_name LIKE '"+q+"' or Album_name like '"+q+"' or Album_name like \'"+q+"\' or Song_name like \'"+q+"_\' or Album_name like \'"+q+"_\' or Song_name like \'"+q+"%\' or Album_name like \'"+q+"%\' or Song_name like \'%"+q+"%\' or Album_name like \'%"+q+"%\' or song.Artist_name LIKE '"+q+"' or song.Artist_name like '"+q+"_' or song.Artist_name like '"+q+"%' or song.Artist_name like '%"+q+"%'";
            System.out.print(s);
            ResultSet rs=st.executeQuery(s);
            //String gernre_id=rs.getString(6);
            
            Statement st1=con.createStatement();
            
            
                //rs.beforeFirst();
                while(rs.next())
                {
                    ResultSet rs1=st1.executeQuery("select Genre from genre where Genre_id=\'"+rs.getString(6) +"\'");
                    rs1.next();
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    obj.setSong_id(rs.getInt(3));
                    obj.setSong_name(rs.getString(4));
                    obj.setSong_url(rs.getString(5));
                    obj.setGenre(rs1.getString(1));
                    obj.setArtist_name(rs.getString(7));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Search dao"+e);
                    list=null;
                    return list;
        }
    }
      public List searchsongdao(String q)
    {
        Connection con=null;
         List list=new ArrayList(); 
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select distinct song.Album_id,Album_name,song_id,Song_name,song_url,song.Genre_id,song.Artist_name,img_url from song join album using(Album_id) where Song_name LIKE \'"+q+"\' or Song_name like \'"+q+"_\' or Song_name like \'"+q+"%\' or Song_name like \'%"+q+"%\'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
           Statement st1=con.createStatement();
            
            
                //rs.beforeFirst();
                while(rs.next())
                {
                    ResultSet rs1=st1.executeQuery("select Genre from genre where Genre_id=\'"+rs.getString(6) +"\'");
                    rs1.next();
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    obj.setSong_id(rs.getInt(3));
                    obj.setSong_name(rs.getString(4));
                    obj.setSong_url(rs.getString(5));
                    obj.setGenre(rs1.getString(1));
                    obj.setArtist_name(rs.getString(7));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Search Song dao"+e);
                    list.add("Error");
                    return list;
        }
    }
      
    public List searchalbumdao(String q)
    {
        Connection con=null;
         List list=new ArrayList(); 
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select distinct song.Album_id,Album_name,song_id,Song_name,song_url,song.Genre_id,song.Artist_name,img_url from song join album using(Album_id) where Album_name LIKE '"+q+"' or Album_name like '"+q+"_' or Album_name like '"+q+"%' or Album_name like '%"+q+"%'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
        Statement st1=con.createStatement();
            
            
                //rs.beforeFirst();
                while(rs.next())
                {
                    ResultSet rs1=st1.executeQuery("select Genre from genre where Genre_id=\'"+rs.getString(6) +"\'");
                    rs1.next();
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    obj.setSong_id(rs.getInt(3));
                    obj.setSong_name(rs.getString(4));
                    obj.setSong_url(rs.getString(5));
                    obj.setGenre(rs1.getString(1));
                    obj.setArtist_name(rs.getString(7));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("searchalbumdao"+e);
                    list.add("Error");
                    return list;
        }
        
    }
    
    public List searchartistdao(String q)
    {
        Connection con=null;
         List list=new ArrayList(); 
        
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select distinct song.Album_id,Album_name,song_id,Song_name,song_url,song.Genre_id,song.Artist_name,img_url from song join album using(Album_id) where song.Artist_name LIKE '"+q+"' or song.Artist_name like '"+q+"_' or song.Artist_name like '"+q+"%' or song.Artist_name like '%"+q+"%' or song.Artist_name LIKE '"+q+"' or song.Artist_name like '"+q+"_' or song.Artist_name like '"+q+"%' or song.Artist_name like '%"+q+"%'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
        Statement st1=con.createStatement();
            
            
                //rs.beforeFirst();
                while(rs.next())
                {
                    String query3="select Genre from genre where Genre_id=\'"+rs.getString(6) +"\'";
                    System.out.print(query3);
                    ResultSet rs1=st1.executeQuery(query3);
                    rs1.next();
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    obj.setSong_id(rs.getInt(3));
                    obj.setSong_name(rs.getString(4));
                    obj.setSong_url(rs.getString(5));
                    obj.setGenre(rs1.getString(1));
                    obj.setArtist_name(rs.getString(7));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("searchartistdao"+e);
                    list=null;
                    return list;
        }
    }

public List adminsearchalbumdao(String q)
    {
        Connection con=null;
         List list=new ArrayList(); 
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select distinct Album_id,Album_name,Artist_name,img_url from album where Album_name LIKE '"+q+"' or Album_name like '"+q+"_' or Album_name like '"+q+"%' or Album_name like '%"+q+"%'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
                   
                //rs.beforeFirst();
                while(rs.next())
                {
                   // ResultSet rs1=st2.executeQuery("select Album_name from Album where Album_id='"+rs.getString(1)+"'");
                    //ResultSet rs2=st2.executeQuery("select Genre from GENRE where Genre_id=\'"+rs.getString(6) +"\'");
                    
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    //obj.setSong_id(rs.getString(3));
                    //obj.setSong_name(rs.getString(4));
                    //obj.setSong_url(rs.getString(5));
                    //obj.setGenre(rs2.getString(1));
                    obj.setArtist_name(rs.getString(3));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("adminsearchalbumdao"+e);
                    list.add("Error");
                    return list;
        }
        
    }
public List adminsearchartistdao(String q)
    {
        Connection con=null;
         List list=new ArrayList(); 
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select distinct Album_id,Album_name,Artist_name,img_url from album where Artist_name LIKE '"+q+"' or Artist_name like '"+q+"_' or Artist_name like '"+q+"%' or Artist_name like '%"+q+"%'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            
            
                //rs.beforeFirst();
                while(rs.next())
                {
                   // ResultSet rs1=st2.executeQuery("select Album_name from Album where Album_id='"+rs.getString(1)+"'");
                    //ResultSet rs2=st2.executeQuery("select Genre from GENRE where Genre_id=\'"+rs.getString(6) +"\'");
                    
                    modelsearch obj=new modelsearch();
                    obj.setAlbum_id(rs.getInt(1));
                    obj.setAlbum_name(rs.getString(2));
                    //obj.setSong_id(rs.getString(3));
                    //obj.setSong_name(rs.getString(4));
                    //obj.setSong_url(rs.getString(5));
                    //obj.setGenre(rs2.getString(1));
                    obj.setArtist_name(rs.getString(3));
                    obj.setImg_url(rs.getString("img_url"));
                    list.add(obj);      
                    
                }
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
        
            }
            catch(Exception e)
            {
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("adminsearchartistdao"+e);
                    list.add("Error");
                    return list;
        }
        
    }
public List adminsearchusernamedao(String q)
{
    Connection con=null;
     List list=new ArrayList(); 
    try
    {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
        con=DatasourceConnection.getConnection();    
        Statement st=con.createStatement();
            String query="select * from customer where username like \'"+q+"\' or username like \'"+q+"_\' or username like \'_"+q+"\' or username like \'"+q+"%\'  or username like \'%"+q+"\' or username like \'%"+q+"%\'";
            System.out.println(query+"@Query Ended@");
            ResultSet rs=st.executeQuery(query);
             while(rs.next())
            {
                modelregister obj=new modelregister();
                obj.setUser_id(rs.getInt("user_id"));
                obj.setUsername(rs.getString("username"));
                
                obj.setFname(rs.getString("first_name"));
                obj.setLname(rs.getString("last_name"));
                
                obj.setSex(rs.getString("sex"));
                obj.setDob(rs.getString("dob"));
                obj.setCity(rs.getString("city"));
                obj.setEmail(rs.getString("email"));
                
                list.add(obj);
             
            }
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
             return list;
    }
    catch(Exception e)
    {
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         System.out.print("adminsearchusernamedao"+e);
        return list;
    }
}

public List adminsearchemaildao(String q)
{
    Connection con=null;
     List list=new ArrayList(); 
    try
    {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
        con=DatasourceConnection.getConnection();    
        Statement st=con.createStatement();
            String query="select * from customer where email like \'"+q+"\' or email like \'"+q+"_\' or email like \'_"+q+"\' or email like \'"+q+"%\'  or email like \'%"+q+"\' or email like \'%"+q+"%\'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
             while(rs.next())
            {
                modelregister obj=new modelregister();
                obj.setUsername(rs.getString("username"));
                obj.setUser_id(rs.getInt("user_id"));
                obj.setFname(rs.getString("first_name"));
                obj.setLname(rs.getString("last_name"));
                
                obj.setSex(rs.getString("sex"));
                obj.setDob(rs.getString("dob"));
                obj.setCity(rs.getString("city"));
                obj.setEmail(rs.getString("email"));
                
                list.add(obj);
             
            }
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
             return list;
    }
    catch(Exception e)
    {
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         System.out.print("adminsearchemaildao"+e);
        return list;
    }
}
}
