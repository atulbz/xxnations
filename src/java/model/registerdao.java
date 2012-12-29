/*
 * To change this template,String  choose Tools | Templates
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
public class registerdao {
String classname,driver;
String[] split;

    public registerdao(String classname, String driver) {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }
    
    
    /*public void adddao(String fname,String lname,String username,String password,String age,String sex,String dob,String city,String email,String question,String answer)
    {
            
    try
    {
            Class.forName(classname);
            con=DriverManager.getConnection(split[0],split[1],split[2]); 
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement();
           
            String query1="INSERT INTO Customer (user_id, username, password, first_name, last_name, age, sex, dob, city, email, question, answer) VALUES (NULL, \'"+username+"\',\'"+password+"\', \'"+fname+"\', \'"+lname+"\', \'"+age+"\', \'"+sex+"\', \'"+dob+"\', \'"+city+"\', \'"+email+"\', \'"+question+"\', \'"+answer+"\')";
            boolean customer=st1.execute(query1);
            
            System.out.println(customer);
            
            String query3="select user_id from Customer where username=\'"+username+"\'";
            ResultSet rs1=st3.executeQuery(query3);
            
            String user_id=rs1.getString("user_id");
            System.out.println(user_id);
            
            String query2="INSERT INTO login (user_id, username, password) VALUES (\'"+user_id+"\', \'"+username+"\', \'"+password+"\')";
            boolean login=st2.execute(query2);
            System.out.println(login);
           // String query3="select user_id from login where username=\'"+username+"\'";
           // ResultSet rs1=st3.executeQuery(query3);
            String query4="INSERT INTO COUNTER (counter_id, user_id) VALUES (NULL, \'"+user_id +"\')";
            boolean counter=st4.execute(query4);
            System.out.println(counter);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            
            
            
            
    }
    catch(Exception e)
    {
         System.out.println(e);
    }
    finally
    {
        System.out.println();
    }
    
        
        
    }
    */
    public void addTempDao(String fname,String lname,String username,String password,String sex,String dob,String city,String email,String kcode)
    {
            Connection con=null;
    try
    {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement();
           
            String query1="INSERT INTO customer_temp (username, password, first_name, last_name,sex, dob, city, email,kcode) VALUES (\'"+username+"\',\'"+password+"\', \'"+fname+"\', \'"+lname+"\',\'"+sex+"\', \'"+dob+"\', \'"+city+"\', \'"+email.toLowerCase()+"\',\'"+kcode+"\')";
            boolean customer=st1.execute(query1);
            
            System.out.println("c_temp "+customer);
            
            String query3="select user_id from customer_temp where username=\'"+username+"\'";
            ResultSet rs1=st3.executeQuery(query3);
            rs1.next();
            String user_id=rs1.getString("user_id");
            System.out.println(user_id);
            
            String query2="INSERT INTO login (user_id,user_name, password,email) VALUES (\'"+user_id+"\',\'"+username+"\', \'"+password+"\',\'"+email.toLowerCase()+"\')";
            System.out.print(query2);
            boolean login=st2.execute(query2);
            System.out.println("log_temp "+login);
           // String query3="select user_id from login where username=\'"+username+"\'";
           // ResultSet rs1=st3.executeQuery(query3);*/
            
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            
             
            
    }
    catch(Exception e)
    {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
         System.out.println("Error in add temp dao "+e);
    }
    finally
    {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

        System.out.println("Finally of register");
    }
    
        
        
    }
    
    
    public boolean verify(String s)
    {
        Connection con=null;
        try
    {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
        con=DatasourceConnection.getConnection();    
        Statement st1=con.createStatement();
            Statement st2=con.createStatement();
            Statement st3=con.createStatement();
            Statement st4=con.createStatement();
            Statement st5=con.createStatement();
            Statement st6=con.createStatement();
            
            String query="select * from customer_temp where kcode=\""+s+"\"";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            if(rs.next())
            {
                int user_idt=rs.getInt(1);
                String username=rs.getString(2);
                String password=rs.getString(3);
                String fname=rs.getString(4);
                String lname=rs.getString(5);
                
                String sex=rs.getString(6);
                String dob=rs.getString(7);
                String city=rs.getString(8);
                String email=rs.getString(9);
                
                String querya="DELETE FROM customer_temp WHERE kcode=\'"+s+"\'";
                st6.execute(querya);
                System.out.print("deleted");
                String query1="INSERT INTO customer (username, password, first_name, last_name,sex, dob, city, email) VALUES (\'"+username+"\',\'"+password+"\', \'"+fname+"\', \'"+lname+"\', \'"+sex+"\', \'"+dob+"\', \'"+city+"\', \'"+email+"\')";
                    boolean customer=st2.execute(query1);
                System.out.print("Customer Updated"+query1+customer);
                String query3="select username,user_id from customer where username=\'"+username+"\'";
                 ResultSet rs1=st3.executeQuery(query3);
                 rs1.next();
                 String uname=rs1.getString("username");
                  System.out.println(uname);
                  String user_id=rs1.getString("user_id");
                  System.out.println(user_id);
                  String query2="update login set status='true',user_id="+user_id+" where user_id="+user_idt+"";
                  System.out.print(query2);
                  //String query2="INSERT INTO login (user_id, username, password,status) VALUES (\'"+user_id+"\', \'"+s2+"\', \'"+s3+"\',\""+true+"\")";
                  boolean login=st4.execute(query2);
                  System.out.println("update"+login);
                // String query3="select user_id from login where username=\'"+username+"\'";
               // ResultSet rs1=st3.executeQuery(query3);
                String query4="INSERT INTO counter (user_id) VALUES (\'"+rs1.getString(2) +"\')";
                boolean counter=st5.execute(query4);
                System.out.println("counter"+counter);
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return true;
            }
            else
            {
                        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

                return false;
            }
                
                 
                
                
            }
                
              catch(Exception e)
        {
                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

           System.out.print(e);
        }

                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

        return false;
        
    } 
    
     public List editUserdao(int id)
   {
       Connection con=null;
       List list=new ArrayList();
       
       try
       {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection(); 
           Statement st1=con.createStatement();
            String query="select * from customer where user_id="+id+"";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            if(rs.next())
            {
                modelregister obj=new modelregister();
                obj.setUsername(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setFname(rs.getString(4));
                obj.setLname(rs.getString(5));
                obj.setSex(rs.getString(6));
                obj.setDob(rs.getString(7));
                System.out.print(rs.getString(7));
                obj.setCity(rs.getString(8));
                obj.setEmail(rs.getString(9));
                
                list.add(obj);
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
            
       }
       catch(Exception e)
       {
        if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

           System.out.print(e);
           return list;
       }
       
   }
    
     public List editAdmindao(String id)
   {
       Connection con=null;
       List list=new ArrayList();
       
       try
       {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection(); 
           Statement st1=con.createStatement();
            String query="select * from admin where admin_id='"+id+"'";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            if(rs.next())
            {
                modelregister obj=new modelregister();
                obj.setUsername(rs.getString(2));
                obj.setPassword(rs.getString(3));
                obj.setFname(rs.getString(4));
                obj.setLname(rs.getString(5));
                obj.setSex(rs.getString(6));
                obj.setEmail(rs.getString(7));
                obj.setDob(rs.getString(8));
                list.add(obj);
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return list;
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return list;
            
       }
       catch(Exception e)
       {
                   if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

           System.out.print(e);
           return list;
       }
       
   }
     
      public int updateUserdao(int user_id,String fname,String lname,String username,String password,String dob,String sex,String city,String email)
   {
       Connection con=null;
       try
       {
            //Class.forName(classname);
           // con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection(); 
           Statement st1=con.createStatement();
           Statement st2=con.createStatement();
            String query="UPDATE customer SET dob='"+dob+"', email = \'"+email.toLowerCase()+"\', sex = \'"+sex+"\', first_name=\'"+fname+"\',last_name=\'"+lname+"\',username=\'"+username+"\',password=\'"+password+"\',city=\'"+city+"\' WHERE user_id ="+user_id;
            String query1="UPDATE login SET email = \'"+email.toLowerCase()+"\' WHERE user_id ="+user_id ;
            System.out.print(query);
            int i=st1.executeUpdate(query);
            int j=st2.executeUpdate(query1);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i*j;
            
       }
       catch(Exception e)
       {
                   if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

           System.out.print("update user"+e);
           return 0;
       }
   }
   
      
      
      public int updateAdmindao(int admin_id,String fname,String lname,String username,String password,String sex,String email ,String dob)
   {
       Connection con=null;
       try
       {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
           con=DatasourceConnection.getConnection(); 
           Statement st1=con.createStatement();
            String query="UPDATE admin SET dob='"+dob+"',email = \'"+email.toLowerCase()+"\', sex = \'"+sex+"\', fname=\'"+fname+"\',lname=\'"+lname+"\',username=\'"+username+"\',password=\'"+password+"\' WHERE admin_id ="+admin_id+"";
            System.out.print(query);
            int i=st1.executeUpdate(query);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return i;
       }
       catch(Exception e)
       {
                   if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

           System.out.print(e);
           return 0;
       }
       
   }
      public List listuserdao(String q)
      {
           List list=new ArrayList();
       Connection con=null;
      try
      {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();  
          Statement st1=con.createStatement();
            String query="select * from customer order by "+q+"";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            while(rs.next())
            {
                modelregister obj=new modelregister();
                obj.setUser_id(rs.getInt("user_id"));
                obj.setUsername(rs.getString(2));
                
                obj.setFname(rs.getString(4));
                obj.setLname(rs.getString(5));
                
                obj.setSex(rs.getString(6));
                obj.setDob(rs.getString(7));
                obj.setCity(rs.getString(8));
                obj.setEmail(rs.getString(9));
               
                list.add(obj);
                
            
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
          return list;
      }
      catch(Exception e)
      {
                  if (con != null) { 				DatasourceConnection.closeConnection(con); 			}

          list=null;
           System.out.print(e);
           return list;
      }
      }
      
      public boolean checkUsernamedao(String username)
      {
          Connection con=null;
             try
          {
          if(username.isEmpty())
          {
              return true;
          }
       
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();  
          Statement st1=con.createStatement(); 
            String query="select user_id from customer where binary username=\'"+username+"\' union select user_id from customer_temp where binary username=\'"+username+"\'";
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);


            if(rs.next())
            {
                                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return true;
            }
            else
            {
                                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return false;
            }
          }
          catch(Exception e)
          {
                                  if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              System.out.print("Error in Checkusernamedao"+e);
              return true;
              
          }
      }
      
       public boolean checkEmaildao(String email1)
      {
          Connection con=null;
               String email=email1.toLowerCase();
           try
          {
          if(email.isEmpty())
          {
              return false;
          }
         
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();  
          Statement st1=con.createStatement(); 
             String query="select user_id from customer where binary email=\'"+email+"\' union select user_id from customer_temp where binary  username=\'"+email+"\'";
            ResultSet rs=st1.executeQuery(query);
            if(rs.next())
            {
                                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return true;
            }
            else
            {
                                    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return false;
            }
          }
          catch(Exception e)
          {
                                  if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
              System.out.print("Error in Checkusernamedao"+e);
              return true;
              
          }
      }
       
       public String findEmaildao(int user_id)
    {
        Connection con=null;
        try
      {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
          con=DatasourceConnection.getConnection();  
          Statement st1=con.createStatement();
            String query="select email,username from customer where user_id="+user_id;
            System.out.print(query);
            ResultSet rs=st1.executeQuery(query);
            if(rs.next())
            {
                String s=rs.getString(1);
                                            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return s;
            }
            else
            {
                                   if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return "error";
            }
      }
        catch(Exception e)
        {
                               if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print("Error in find email"+e);
            return "error";
        }
       
    }
       
       public int removeUserdao(int user_id)
       {
           Connection con=null;
           try
           {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
               Statement st1=con.createStatement();
               Statement st2=con.createStatement();
            String query1="delete from customer where user_id="+user_id;
            String query2="delete from login where user_id="+user_id;
            int i=st1.executeUpdate(query1);
            int j=st2.executeUpdate(query2);
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
             return i&j;
            
            
            
           }
           catch(Exception e)
           {
               System.out.print("Error in remove user"+e);
                                  if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
               return 0;
           }
       }
       
    }
            
    
    
    

