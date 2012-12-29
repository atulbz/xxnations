/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class downloaddao {
         
         String classname,driver;
         String[] split;
    public downloaddao(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
        split = driver.split(",");
    }
    
    public List getDownloadHistorydao(int user_id)
       {
              Connection con=null;   
           List list=new ArrayList();
           try
           {
                        //Class.forName(classname);
                    
                       // con=DriverManager.getConnection(split[0],split[1],split[2]); 
                       con=DatasourceConnection.getConnection();
                        Statement st1=con.createStatement();
                        
                        String query="select * from downloadhistory where user_id="+user_id+" order by download_id desc";
                        
                        System.out.print(query);
                        ResultSet rs=st1.executeQuery(query);
                        while (rs.next())
                        {
                            modeldownload obj=new modeldownload();
                            obj.setSong_name(rs.getString("song_name"));
                            obj.setDtime(rs.getString("dtime"));
                            obj.setUrl(rs.getString("url"));
                            list.add(obj);
                            
                        }
                       if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        return list;
           }
           catch(Exception e)
           {
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
               System.out.print("Error in downloadhistory dao"+e);
               list=null;
               return list;
           }
       }
    public int setDownloadHistorydao(int user_id,String song_name,String url)
    {
        Connection con=null;
             try
             {
                      //Class.forName(classname);
                      //  con=DriverManager.getConnection(split[0],split[1],split[2]); 
                 con=DatasourceConnection.getConnection();      
                 Statement st1=con.createStatement();
                        String q="insert into downloadhistory(user_id,song_name,url) values("+user_id+",'"+song_name+"','"+url+"')";
                        int i=st1.executeUpdate(q);
                        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        if(i==1)
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
                      System.out.print("Error in insert"+e);
                      return 0;
             }
             
             
             
    }
}
