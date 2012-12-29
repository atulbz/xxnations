/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class Logindao {
String classname,driver;
String[] split;




    public Logindao(String classname, String driver) {
        
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
        
    }
    
    
    public String validate(String username,String password)
    {
        Connection con=null;
       
        try
            
        {
          //  Class.forName(classname);
          //  Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            PreparedStatement ps=con.prepareStatement("select * from login where binary user_name=? and binary password=? "); 
            //ResultSet rs=st.executeQuery('select user_id from LOGIN where username=/"'+username+'/" and password=/"'+password+'/"'); 
            //ResultSet rs=st.executeQuery("select * from login where binary user_name=\'"+username+"\'and binary password=\'"+password+"\'"); 
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                if("true".equals(rs.getString("status")))
                {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    return "foundtrue";
                }
                else 
                {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    return "foundfalse";
                }
                
                
                /*HttpSession hs1=request.getSession(true);
                hs1.setAttribute("user",rs.getString(1));
                System.out.println("Session Created");
                response.sendRedirect("http://localhost:8084/WebApplication5");
                  */    
            }
                    
            else
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return "notfound";
            }
            
          }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in validateion "+e);
            return "error"+e;
        }
}
    public int getUserId(String username)
    {
        
        String error="error";
        Connection con=null;
        try
        {
            
        
            //Class.forName(classname);
            //Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
             con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            //ResultSet rs=st.executeQuery('select user_id from LOGIN where username=/"'+username+'/" and password=/"'+password+'/"'); 
            ResultSet rs=st.executeQuery("select user_id from login where binary user_name=\'"+username+"\'"); 
            rs.next();
            int s=rs.getInt(1);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return s;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in getting user_id"+e);
            
            return 0;
        }
        
    }
 
    public String validateadmin(String username,String password)
    {
        
Connection con=null;
        try
            
        {
            //Class.forName(classname);
            //Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            //ResultSet rs=st.executeQuery('select user_id from LOGIN where username=/"'+username+'/" and password=/"'+password+'/"'); 
            String query="select * from admin where binary username=\'"+username+"\'and binary password=\'"+password+"\'";
            PreparedStatement ps=con.prepareStatement("select * from admin where binary username=? and binary password=? "); 
             ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            System.out.print(query);
            
            if(rs.next())
            {
                    System.out.print(rs.getString(1));
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Found true");
                    return "foundtrue";
                
            }
            
            
            else 
                {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                    System.out.print("Found false");
                    return "foundfalse";
                }
               
            }
                    
           
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return "error"+e;
        }
}
  
     public int getAdminId(String username)
    {
        Connection con=null;
        
        String error="error";
        try
        {
            
        
            //Class.forName(classname);
            //Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
             con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            //ResultSet rs=st.executeQuery('select user_id from LOGIN where username=/"'+username+'/" and password=/"'+password+'/"'); 
            ResultSet rs=st.executeQuery("select admin_id from admin where binary username=\'"+username+"\'"); 
            System.out.print("admin id get");
            rs.next();
            int s=rs.getInt(1);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return s;
        }
        catch(Exception e)
        {
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print(e);
            return 0;
        }
        
    }
     
     public String updateUserdao(int user_id,String username,String password)
    {
        Connection con=null;
            try
            {
            //Class.forName(classname);
            //Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
                Statement st=con.createStatement();
            String query="update login set user_name='"+username+"',password='"+password+"' where user_id="+user_id;
            System.out.print(query);
            int i=st.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(i==1)
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return "updated";
            }
            else
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return "notupdated";
            }
            }
                    
            catch(Exception e)
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
               System.out.print(e);
               return "notupdate";
            }
    }
    
      public String updateAdmindao(int admin_id,String username,String password)
    {
        Connection con=null;
          try
            {
            //Class.forName(classname);
           // Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
             con=DatasourceConnection.getConnection();
                Statement st=con.createStatement();
            String query="update admin set username='"+username+"',password='"+password+"' where admin_id="+admin_id+"";
            System.out.print(query);
            int i=st.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            if(i==1)
            {
            return "updated";
            }
            else
            {
                return "notupdated";
            }
            }
                    
            catch(Exception e)
            {
                if (con != null) 
{ 				DatasourceConnection.closeConnection(con); 
	}
               System.out.print(e);
               return "notupdate";
            }
        
    }
      
      public String getEmaildao(int user_id)
      {
          String error="error";
          Connection con=null;
        try
        {
            
        
            //Class.forName(classname);
           // Connection con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st=con.createStatement();
            //ResultSet rs=st.executeQuery('select user_id from LOGIN where username=/"'+username+'/" and password=/"'+password+'/"'); 
            ResultSet rs=st.executeQuery("select email from login where user_id="+user_id+""); 
            rs.next();
            String email=rs.getString("email");
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return email;
        }
        catch(Exception e)
        {
            if (con != null) 
{ 				DatasourceConnection.closeConnection(con); 
	}
            System.out.print("Error in getting user_id"+e);
            
            return error;
        }
          
      }
}
