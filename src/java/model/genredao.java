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
public class genredao {
    String classname,driver;
    String[] split;

    public genredao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
    
    
    
    public boolean findgenredao(String genre)
    {
   Connection con=null;
    try
        {
        
        
                     ////Class.forName(classname);
                     ////con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();         
            Statement st1=con.createStatement();
                     String query="select Genre_id from genre where Genre='"+genre.toLowerCase()+"'";
                     System.out.print("genredao find genre "+query);
                     ResultSet rs=st1.executeQuery(query);
                     if(rs.next())
                     {
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                         return true;
                     }
        
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        return false;
        }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Error in findgenredao "+e);
        return true;
    }
}
    public List getGenredao()
    {
        Connection con=null;
        List list=new ArrayList();
         try
        {
        
        
                     //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();         
            Statement st1=con.createStatement();
                     String q="select * from genre order by genre";
                     System.out.print(q);
                     ResultSet rs=st1.executeQuery(q);
                     
                     while(rs.next())
                     {
                         modelgenre obj=new modelgenre();
                         obj.setGenre_id(rs.getInt(1));
                         obj.setGenre(rs.getString(2));
                         list.add(obj);
                     }
        
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        return list;
        }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        list=null;
        System.out.print("Error in get Genre "+e);
        return list;
    }
    }
    
    public int addGenredao(String Genre)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
                     String query="insert into genre(Genre) values('"+Genre.toLowerCase()+"')";
                     System.out.print(query);
                     int i=st1.executeUpdate(query);
                     if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                     return i;
          
        }
        
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Add genre"+e);
        return -1;
    }
    }
    
    public int removeGenredao(String Genre)
    {
        Connection con=null;
        //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();
            try
        {
           
            Statement st1=con.createStatement();
                     String query="DELETE FROM genre WHERE Genre='"+Genre+"'";
                     System.out.print(query);
                     int i=st1.executeUpdate(query);
                     if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                     return i;
          
        }
        
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Remove genre"+e);
        return -1;
    }
    }
    
    public int getGenreiddao(String Genre)
    {
     Connection con=null;
   
   
        
        
                     //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();
            
             try
        {
            Statement st1=con.createStatement();    
            String query="select Genre_id from genre where Genre='"+Genre+"'";
                     System.out.print(query);
                     ResultSet rs=st1.executeQuery(query);
                     if(rs.next())
                     {
                         int s=rs.getInt(1);
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                         return s;
                     }
        
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        return 0;
        }
    catch(Exception e)
    {
         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Get  genre id"+e);
        return 0;
    }
    }
    
    
    public int UpdateGenredao(String Genre,String Genre_id)
    {
        Connection con=null;
       
            //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();
           
                     try
        { 
             Statement st1=con.createStatement();
                     String query="UPDATE genre SET Genre = '"+Genre+"' WHERE Genre_id = "+Genre_id+"";
                     System.out.print(query);
                     int i=st1.executeUpdate(query);
                     if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                     return i;
          
        }
        
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print(e);
        return -1;
    }
    }
    
    public String getGenreNamedao(int Genre_id)
    {
        Connection con=null;
        try
        {
            
                   //Class.forName(classname);
                     //con=DriverManager.getConnection(split[0],split[1],split[2]);  
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
                     String query="select Genre from genre where Genre_id="+Genre_id;
                     ResultSet rs=st1.executeQuery(query);
                     if(rs.next())
                     {
                         
                         String s=rs.getString(1);;
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                         return s;
                     }
                     else
                     {
                         if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                         return null;
                     }
                     
            
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print(e);
            return null;
        }
    }
}