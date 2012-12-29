/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.*;
import java.util.*;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class Categoriesdao {
    
String classname,driver;
    String Genre;
    String[] split;

    public Categoriesdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
   
  
          
    
    
    public List getAlbumsdao(String Genre)
    {
       List albumobjects=new ArrayList();
       Connection con=null;
        try
          
          {
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            String query="select Genre_id from genre where Genre=\'"+Genre+"\'";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
            rs.next();
            int result=rs.getInt(1);
            Statement ps=con.createStatement();
            String query2="select * from album where Genre_id="+result;
            System.out.println(query2);
            ResultSet rs1=ps.executeQuery(query2);
            //ArrayList albumobjects=new ArrayList();
            while(rs1.next())
            {
                modelalbum obj=new modelalbum();
                obj.setAlbum_id(rs1.getInt(1));
                obj.setAlbum_name(rs1.getString(2));
                obj.setGenre_id(rs1.getInt(3));
                obj.setRelease_date(rs1.getDate(4));
                obj.setArtist_name(rs1.getString(5));
                obj.setAlbum_info(rs1.getString(6));
                obj.setImg_url(rs1.getString(7));
                albumobjects.add(obj);
                       
            }
          if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            
            return albumobjects;
          }
          catch(Exception e)
          {
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              albumobjects=null;
           System.out.print("Error in categories dao"+e);                   
           return albumobjects;
           }
 }
}
