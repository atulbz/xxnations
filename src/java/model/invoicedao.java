/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import view.DatasourceConnection;

/**
 *
 * @author Shaishav
 */
public class invoicedao {
String classname,driver;
    String[] split;
    
    public invoicedao(String classname,String driver)
    {
        this.classname = classname;
        this.driver = driver;
        split = driver.split(",");
    }

    
    
    public int addInvoicedao(int user_id,long invoice_number,float amount)
    {
        Connection con=null;
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="insert into invoice(user_id,invoice_number,amount) VALUES("+user_id+","+invoice_number+","+amount+")";
            System.out.print("invoice dao "+query);
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
    
    public int getInvoicedao(int user_id,long invoice_number,float amount)
    {
       
        Connection con=null;
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]);   
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            
            String query="select * from invoice where invoice_number="+invoice_number+" and user_id="+user_id+" and cast(amount as decimal(15,2))=cast("+amount+" as decimal(15,2))";                          
            System.out.print("invoice dao "+query);
            ResultSet rs=st1.executeQuery(query);
            
            if(rs.next())
            {
                if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
                return 1;
            }
            if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            return 0;
            
        }
        catch(Exception e)
        {
             if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
            System.out.print(e);
        
        return 0;
        }
        
    }
    
     public int removeInvoicedao(int user_id,long invoice_number,float amount)
   
     {
         Connection con=null;
        try
        {
            //Class.forName(classname);
            //con=DriverManager.getConnection(split[0],split[1],split[2]);   
            con=DatasourceConnection.getConnection();
            Statement st1=con.createStatement();
            String query="DELETE FROM invoice where user_id="+user_id+" and invoice_number="+invoice_number+" and amount="+amount+"";
            System.out.print("invoice dao "+query);
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
       
}

