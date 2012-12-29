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
public class plandao {
    String classname,driver;
    String[] split;
    

    public plandao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
    
    
    public List getPlansdao()
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            
           // Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();   
            String query="select * from plan";
            ResultSet rs=st1.executeQuery(query);
             while(rs.next())
             {
                 
                 modelplan obj=new modelplan();
                 obj.setPlanid(rs.getInt("planid"));
                 obj.setPlan_name(rs.getString("plan_name"));
                 obj.setAmount(rs.getFloat("amount"));
                 obj.setDuration(rs.getInt("duration"));
                 obj.setSongs(rs.getInt("no_of_songs"));
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
    
    public boolean checkPlanNameDao(String planname)
    {
        Connection con=null;
          try
        {
            if(planname.isEmpty())
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return true;
            }
            
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();  
            String s="select plan_name from plan where plan_name=\'"+planname.toUpperCase()+"\'";
            System.out.print(s);
            ResultSet rs=st1.executeQuery(s);
            boolean result=rs.next();
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(result)
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
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              System.out.print("error in checkplanname plandao"+e);
              return true;
          }
                  }
    
    public boolean checkAmountDao(float amount)
    {
        Connection con=null;
          try
        {
            if(amount==0)
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return true;
            }
            
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();  
            String s="select amount from plan where amount="+amount+"";
            ResultSet rs=st1.executeQuery(s);
            boolean result=rs.next();
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(result)
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
              if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              System.out.print(e);
              return true;
          }
                  }
    
    
    
    public int addPlandao(String plan_name,float amount,int duration,int nos)
     {
         Connection con=null;
         try
         {
             
             
          con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement(); 
            String s="INSERT INTO plan (plan_name, amount, duration, no_of_songs) VALUES (\'"+plan_name.toUpperCase()+"\', "+amount+", "+duration+", "+nos+");";
            System.out.print(s);
            int result=st1.executeUpdate(s);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(result==1)
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
    
    public int updatePlandao(int plan_id,String plan_name,float amount,int duration,int nos)
     {
         Connection con=null;
         try
         {
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement(); 
            String s="UPDATE plan SET duration = "+duration+", no_of_songs = "+nos+",amount="+amount+",plan_name=\'"+plan_name+"\' WHERE planid ="+plan_id+"";
            System.out.print(s);
            int result=st1.executeUpdate(s);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(result==1)
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
    
    public List getPlanDetailsdao(String plan_id)
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();   
            String query="select * from plan where planid="+plan_id;
            System.out.print(plan_id);
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
             while(rs.next())
             {
                 
                    modelplan obj=new modelplan();
                 obj.setPlanid(rs.getInt("planid"));
                 obj.setPlan_name(rs.getString("plan_name"));
                 obj.setAmount(rs.getFloat("amount"));
                 obj.setDuration(rs.getInt("duration"));
                 obj.setSongs(rs.getInt("no_of_songs"));
                 list.add(obj);
                 
             }
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
             return list;
       
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in dao "+e);
            list=null;
            return list;
        }
        
    }
    
    public int removePlandao(String plan_id)
    {
        Connection con=null;
         try
        {
            
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement(); 
            String query="DELETE FROM plan where planid="+plan_id;
            int i=st1.executeUpdate(query);
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
    
     public List getPlanDetailpaymentdao(float amount)
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            
           con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();   
            String query="SELECT * FROM plan WHERE CAST(amount AS DECIMAL(15,2))=CAST("+amount+" AS DECIMAL(15,2))";
            System.out.print(amount);
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
             while(rs.next())
             {
                 
                    modelplan obj=new modelplan();
                 obj.setPlanid(rs.getInt("planid"));
                 obj.setPlan_name(rs.getString("plan_name"));
                 obj.setAmount(rs.getFloat("amount"));
                 obj.setDuration(rs.getInt("duration"));
                 obj.setSongs(rs.getInt("no_of_songs"));
                 list.add(obj);
                 
             }
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
             return list;
         }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in dao "+e);
            list=null;
            return list;
        }
        
        }
    
}
