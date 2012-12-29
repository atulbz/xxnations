/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class Counterdao {
String classname,driver;
String[] split;

    public Counterdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
   
    public int decCounterdao(int user_id,String query)
    {
        Connection con=null;
     try
     {
            //Class.forName(classname);
           // Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement();
            ResultSet rs1=st3.executeQuery("select Song_name from song where song_url=\'"+query+"\'");
            rs1.next();
            //st4.execute("insert into downloadhistory(user_id,song_name) values("+user_id+",\'"+rs1.getString(1) +"\')");
            //ResultSet rs=st1.executeQuery("select user_id from login where user_id=\""+user_id+"\"");
            //String id=rs.getString(1); 
            //int i=s.executeUpdate("update TRY SET \"counter\"=counter-1 where counter>0 and user_id=\""+id+"\"");
              int update=st1.executeUpdate("update counter SET counter=counter-1 where counter>0 and user_id="+user_id);
            
            if(update==1)
            {
              //ResultSet rs=s.executeQuery("select counter from try where user_id=\""+id+"\"");
                ResultSet rs2=st2.executeQuery("select counter from counter where user_id="+user_id);  
                rs2.next();
                int i= rs2.getInt("counter");
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return i;
                
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
         System.out.print("Error in dec counter"+e);
         return 0;
     }
     
}
    
    public int getCounterdao(int user_id)
    {
        Connection con=null;
        try
        {
                     //Class.forName(classname);
             //        Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
               
                    con=DatasourceConnection.getConnection();Statement st1=con.createStatement();
                    Statement st3=con.createStatement();
                    String query="select counter_id,user_id,counter,date(valid_upto) from counter where user_id="+user_id;
                    System.out.print(query);
                    ResultSet rs=st1.executeQuery(query);
                    rs.next();
                    int i=rs.getInt(3);
                    System.out.print("This is counter"+i);
                    Date valid_upto=rs.getDate(4);
              //      System.out.println("date is "+valid_upto);
            
                    Calendar cal = Calendar.getInstance();
              
                    Date system=cal.getTime();
                //System.out.print(system);
              
                
                if(valid_upto.getTime()>system.getTime())
                {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Expiration is away");
                    return i;
                }
                else
                {
                 String counter="update counter set valid_upto=CURRENT_TIMESTAMP,counter=0 where user_id="+user_id;
                 System.out.print(counter);
                 int j=st3.executeUpdate(counter);
                 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                     return 0;
                }
     
        }
           catch(Exception e)
           {
               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                System.out.print("Get Counter"+e);
                 return 0;
               
           }
        
    }
    public boolean checkDatedao(String date)
    {
            
        try{
             Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy-dd");
                Date system=cal.getTime();
                cal.setTime(new SimpleDateFormat("MM-yyyy-dd").parse(""+date+""));
                Date valid_upto=cal.getTime();
                if(valid_upto.getTime()>system.getTime())
                {
                    return true;
                }
                else
                {
                    return false;
                }
        }
        catch(Exception e)
        {
            System.out.print(e);
            return false;
        }
        
    }
    
    public int updateCounterdao(int nos,int duration)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
            //Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="update  counter set counter=counter+"+nos+",valid_upto=date_add(valid_upto,interval "+duration+" day)";
            System.out.print(query);
            int i=st1.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
            
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in update counter "+e);
            return 0;
        }
    }
}
