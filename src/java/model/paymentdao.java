/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class paymentdao {
    
    String classname,driver;
    String[] split;
    public paymentdao(String classname,String driver) {
        this.classname=classname;
        this.driver=driver;
         split = driver.split(",");
    }
    
    
    public int addPaymentdao(int user_id,float amount,int duration,int  no_of_songs,String plan_name,String name,String city,String email)
    {
        Connection con=null;
        try
        {
            
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="INSERT INTO payment (user_id, `name`,amount, valid_upto, no_of_songs, plan_name,city,email) VALUES ("+user_id+", '"+name+"',"+amount+", date_add(current_timestamp,interval "+duration+" day), "+no_of_songs+", \'"+plan_name+"\',\'"+city+"\',\'"+email+"\');";
            System.out.print(query);
            int i=st1.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
            
        }
        catch(Exception e)
            
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
        System.out.print("Error in add payment"+e);    
        return 0;
        
        }
        
    }
    
    public List getPaymentdao(int user_id)
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="select * from payment where user_id="+user_id+" order by paymentdate desc";
            ResultSet rs=st1.executeQuery(query);
            while(rs.next())
            {
                modelpayment obj=new modelpayment();
                obj.setPayment_id(rs.getInt("payment_id"));
                obj.setName(rs.getString("name"));
                obj.setPaymentdate(rs.getTimestamp("paymentdate"));
                obj.setAmount(rs.getFloat("amount"));
                obj.setValid_upto(rs.getTimestamp("valid_upto"));
                obj.setNo_of_songs(rs.getInt("no_of_songs"));
                obj.setPlan_name(rs.getString("plan_name"));
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
            System.out.print("Error in getPayment dao "+e);
            list=null;
            return list;
        }
    }
    
    public List getAllPaymentdao()
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            String query="select * from payment order by paymentdate desc";
            
            ResultSet rs=st1.executeQuery(query);
            while(rs.next())
            {
                modelpayment obj=new modelpayment();
                ResultSet rs1=st2.executeQuery("select user_name from login where user_id="+rs.getString("user_id"));
                rs1.next();
                obj.setUsername(rs1.getString(1));
                obj.setPayment_id(rs.getInt("payment_id"));
                obj.setName(rs.getString("name"));
                obj.setPaymentdate(rs.getTimestamp("paymentdate"));
                obj.setAmount(rs.getFloat("amount"));
                obj.setValid_upto(rs.getTimestamp("valid_upto"));
                obj.setNo_of_songs(rs.getInt("no_of_songs"));
                obj.setPlan_name(rs.getString("plan_name"));
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
            System.out.print("Error in getPayment dao "+e);
            list=null;
            return list;
        }
    }
     public List getRangePaymentdao(String from,String to)
    {
        Connection con=null;
        List list=new ArrayList();
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            String query="SELECT * FROM payment WHERE paymentdate BETWEEN \""+from+"\" AND \""+to+"\"";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            while(rs.next())
            {
                modelpayment obj=new modelpayment();
                ResultSet rs1=st2.executeQuery("select user_name from login where user_id="+rs.getString("user_id"));
                rs1.next();
                obj.setUsername(rs1.getString(1));
                obj.setPayment_id(rs.getInt("payment_id"));
                obj.setName(rs.getString("name"));
                obj.setPaymentdate(rs.getTimestamp("paymentdate"));
                obj.setAmount(rs.getFloat("amount"));
                obj.setValid_upto(rs.getTimestamp("valid_upto"));
                obj.setNo_of_songs(rs.getInt("no_of_songs"));
                obj.setPlan_name(rs.getString("plan_name"));
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
            System.out.print("Error in getPayment dao "+e);
            list=null;
            return list;
        }
    }
    
}
