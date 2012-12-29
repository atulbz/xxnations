
/* To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class ratingdao {
String classname,driver;
String[] split;

    public ratingdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
   
    

public void setRatingdao(String song_id,int rate)
{
  Connection con=null;  
    
    try
    {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
        con=DatasourceConnection.getConnection();    
        Statement st=con.createStatement();
            String query="update rating set rating=ROUND((rating+"+rate+")/2,1) where song_id="+song_id;
            st.execute(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            
            
            
            
    }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
       System.out.print("Error in rating "+e); 
    }
    
}

public double getRatingdao(String song_id)
{
    
    Connection con=null;
    try
    {
            //Class.forName(classname);
           //con=DriverManager.getConnection(split[0],split[1],split[2]); 
        con=DatasourceConnection.getConnection();    
        Statement st=con.createStatement();
            String query="select rating from rating where song_id="+song_id;
            ResultSet rs=st.executeQuery(query);
            rs.next();
            double i=rs.getDouble("rating"); 
            //st.setQueryTimeout(7);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
            
            
            
            
            
            
    }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        
        System.out.print(e);
        return 10;
    }

}
}
