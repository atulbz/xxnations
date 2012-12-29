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
public class tempdao {
    String classname,driver;
    String[] split;
    public tempdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
   
    
    public int setTempdao(int user_id,String k,String url,String size)
    {
        Connection con=null;
         try
          {
              //Class.forName(classname);
              //con=DriverManager.getConnection(split[0],split[1],split[2]); 
              con=DatasourceConnection.getConnection();
              Statement st=con.createStatement();
              String s="insert into temp(user_id,k,url,size) values('"+user_id+"','"+k+"','"+url+"','"+size+"')";
              System.out.println(s);
              int i=st.executeUpdate(s);
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
              System.out.print(e);
              return 0;
          }
    }
    
     public List getTempdao(String k)
    {
        Connection con=null;
             List list=new ArrayList();
         try
          {
              //Class.forName(classname);
              //con=DriverManager.getConnection(split[0],split[1],split[2]); 
              con=DatasourceConnection.getConnection();
              Statement st=con.createStatement();
              String s="select url,size from temp where k='"+k+"'";
              System.out.println(s);
              ResultSet rs=st.executeQuery(s);
              rs.next();
              String url=rs.getString(1);
              list.add(url);
              String size12=rs.getString(2);
              
              list.add(size12);
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              if(!list.isEmpty())
              {
                  
                  return list;
              }
              else
              {
                  System.out.print("Error in gettempdao");
             list=null;
              return list;
              }
              
          }
          catch(Exception e)
          {
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    list=null;
              System.out.print("Error in gettempdao"+e);
              return list;
          }
    }
     
     
     public void delTempdao(String k)
     {
             Connection con=null;
         try
         {
              //Class.forName(classname);
              //con=DriverManager.getConnection(split[0],split[1],split[2]); 
             con=DatasourceConnection.getConnection(); 
             Statement st=con.createStatement();
              String s="DELETE FROM temp where k='"+k+"'";
              st.execute(s);
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         }
         catch(Exception e)
         {
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         }
     }
}
