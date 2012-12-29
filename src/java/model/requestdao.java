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
public class requestdao {
      String classname,driver;
String[] split;

         public requestdao(String classname, String driver) {
                  this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
         }

         public int setRequestdao(String user_id,String username,String album,String song)
         {
             Connection con=null;
                  try
                  {
                           
            //Class.forName(classname);
           //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                      Statement st=con.createStatement();
            String query="insert into request(user_id,username,album,song) values('"+user_id+"','"+username+"','"+album+"','"+song+"') ";
            int i=st.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(i==1)
            {
                     return 1;
            }
            else
            {
                     return 0;
            }
            
                  }
                  catch(Exception e)
                  {
                      if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                           System.out.print("Error in set request"+e);
                           return 0;
                  }
         }

         public List getRequestdao()
         {
             Connection con=null;
                  List list=new ArrayList();
                  try
                  {
                    
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                      Statement st=con.createStatement();
            String query="select * from request order by rtime desc";
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                     modelrequest obj=new modelrequest();
                     obj.setUser_id(rs.getInt("user_id"));
                     obj.setUsername(rs.getString("username"));
                     obj.setAlbum(rs.getString("album"));
                     obj.setSong(rs.getString("song"));
                     obj.setRtime(rs.getString("rtime"));
                     obj.setRequest_id(rs.getShort("request_id"));
                     list.add(obj);
            }                    
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
                  }
                  catch(Exception e)
                  {
                      if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        System.out.print("Error in get Request"+e);
                        list=null;
                        return list;
                  }
         }
         
         public List getRequestuserdao(String user_id)
         {
             Connection con=null;
                  List list=new ArrayList();
                  try
                  {
                    
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                      Statement st=con.createStatement();
            String query="select * from request where user_id="+user_id+" order by rtime desc ";
            System.out.print(query);
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                     modelrequest obj=new modelrequest();
                     obj.setUser_id(rs.getInt("user_id"));
                     obj.setUsername(rs.getString("username"));
                     obj.setAlbum(rs.getString("album"));
                     obj.setSong(rs.getString("song"));
                     obj.setRtime(rs.getString("rtime"));
                     obj.setRequest_id(rs.getShort("request_id"));
                     list.add(obj);
            }                    
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
                  }
                  catch(Exception e)
                  {
                      if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                        System.out.print("Error in get Request"+e);
                        list=null;
                        return list;
                  }
         }
         
         public int deleteRequestdao(String request_id)
         {
             Connection con=null;
                try
                {
                        // Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                    Statement st=con.createStatement();
            String query="delete from request where request_id="+request_id;
            int i=st.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(i==1)
            {
                     return 1;
            }
            else
            {
                     return 0;
            }
            
                  }
                
                catch(Exception e)
                {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Error in delete "+e);
                    return 0;
                }
         }
         
}
