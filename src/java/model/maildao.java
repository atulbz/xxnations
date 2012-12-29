/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shaishav
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import view.DatasourceConnection;
public class maildao {
    
    String classname,driver;
    String[] split;
    String emailid;
    String pwd;

    public maildao(String classname, String driver,String emailid,String pwd) {
        this.classname = classname;
        this.driver = driver;
        this.emailid=emailid;
        this.pwd=pwd;
        split = driver.split(",");
    }

  
    public String sendmaildao(String email)
    {
        Connection con=null;
        try
        {
                  //Class.forName(classname);
                 //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();      
            Statement st1=con.createStatement();
                  String query="select kcode from customer_temp where email=\'"+email+"\'"; 
                  ResultSet rs=st1.executeQuery(query);
                  
                  if(rs.next())
                  {
                      
    String to=email;
    String code=rs.getString(1);
    System.out.print(code);
    String host = "smtp.gmail.com";
    String from = emailid;
    String pass = pwd;
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    //String[] to = {"xxnations@gmail.com"}; // added this line
 
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
 
    InternetAddress toAddress = new InternetAddress(to);
 
    // To get the array of addresses
    //for( int i=0; i < to.length; i++ ) { // changed from a while loop
      //  toAddress[i] = new InternetAddress(to[i]);
   // }
    System.out.println(Message.RecipientType.TO);
 
   // for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress);
    //}
    message.setSubject("Your activation link");
    
    message.setContent("Click on the below link to activate your account <a href=\"http://www.xxnations.com/verificationservlet.do?s="+code+"\"> Click Here </a>","text/html");
    Transport transport = session.getTransport("smtp");
    transport.connect(host, from, pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
    return "success";
    
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
        System.out.print(e);
    }
 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
return "error";
	} 
    
    
    public String resenddao(String email)
    
    
    
    {
 Connection con=null;
        try
        {
                  //Class.forName(classname);
                 //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();      
            Statement st1=con.createStatement();
                  String query="select kcode from customer_temp where email=\'"+email+"\'"; 
                  System.out.print(query);
                  ResultSet rs=st1.executeQuery(query);
                  
                  if(rs.next())
                  {
                      
    String to=email;
    String code=rs.getString(1);
    System.out.print(code);
    String host = "smtp.gmail.com";
    String from = emailid;
    String pass = pwd;
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    //String[] to = {"xxnations@gmail.com"}; // added this line
 
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
 
    InternetAddress toAddress = new InternetAddress(to);
 
    // To get the array of addresses
    //for( int i=0; i < to.length; i++ ) { // changed from a while loop
      //  toAddress[i] = new InternetAddress(to[i]);
   // }
    System.out.println(Message.RecipientType.TO);
 
   // for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress);
    //}
        
    message.setSubject("Resending your activation link");
    
    message.setContent("Click on the below link to activate your account <a href=\"http://www.xxnations.com/verificationservlet.do?s="+code+"\"> Click Here </a>","text/html");
    Transport transport = session.getTransport("smtp");
    transport.connect(host, from, pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
    
    return "success";
    
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
        System.out.print(e);
    }
 if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
return "error";
	}       
        
    
    

public String forgotdao(String email)
    
    
    
    {
        Connection con=null;
        System.out.println("dao"+email);
 
        try
        {
                  //Class.forName(classname);
                  //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();      
            Statement st1=con.createStatement();
                  Statement st2=con.createStatement();
                  String query1="select user_id from login where email=\'"+email+"\'";
                  ResultSet rs1=st1.executeQuery(query1);
                  
                    if(rs1.next())
                    {
                      
     String query2="select user_name,password from login where user_id=\'"+rs1.getString(1) +"\'"; 
     ResultSet rs2=st2.executeQuery(query2);
      rs2.next();                                                    
    String to=email;
    String username=rs2.getString(1);
    String password=rs2.getString(2);
    System.out.print(username+"  "+password);
    String host = "smtp.gmail.com";
    String user = emailid;
    String pass = pwd;
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", user);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    //String[] to = {"xxnations@gmail.com"}; // added this line
 
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
   // message.setContent("<br>Username :"+username+"<br>Password : "+password+"", "text/html");
    message.setFrom(new InternetAddress(user));
 
    InternetAddress toAddress = new InternetAddress(to);
 
    // To get the array of addresses
    //for( int i=0; i < to.length; i++ ) { // changed from a while loop
      //  toAddress[i] = new InternetAddress(to[i]);
   // }
    System.out.println(Message.RecipientType.TO);
 
   // for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress);
    //}
    message.setSubject("Forgot Password");
    
    message.setContent("Your new username and password are  <br>Username :"+username+"<br>Password : "+password+"Click <a href='www.xxnations.com/login.jsp'>here</a> to login ","text/html");
    Transport transport = session.getTransport("smtp");
    transport.connect(host, user, pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
    
    return "success";
   
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
             System.out.print("Registered but error"+e);
             
   
    }
                  
            

     if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
return "error";

	} 

public String adminforgotdao(String email)
    
    
    
    {
        Connection con=null;
        System.out.println("dao"+email);
 
        try
        {
                  //Class.forName(classname);
                  //con=DriverManager.getConnection(split[0],split[1],split[2]); 
            con=DatasourceConnection.getConnection();      
            Statement st1=con.createStatement();
                  Statement st2=con.createStatement();
                  String query1="select admin_id from admin where email=\'"+email+"\'";
                  System.out.print(query1);
                  ResultSet rs1=st1.executeQuery(query1);
                  
                    if(rs1.next())
                    {
                      
     String query2="select username,password from admin where admin_id=\'"+rs1.getString(1) +"\'"; 
     ResultSet rs2=st2.executeQuery(query2);
      rs2.next();                                                    
    String to=email;
    String username=rs2.getString(1);
    String password=rs2.getString(2);
    System.out.print(username+"  "+password);
    String host = "smtp.gmail.com";
    String user = emailid;
    String pass = pwd;
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", "true"); // added this line
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", user);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
 
    //String[] to = {"xxnations@gmail.com"}; // added this line
 
    Session session = Session.getDefaultInstance(props, null);
    MimeMessage message = new MimeMessage(session);
   // message.setContent("<br>Username :"+username+"<br>Password : "+password+"", "text/html");
    message.setFrom(new InternetAddress(user));
 
    InternetAddress toAddress = new InternetAddress(to);
 
    // To get the array of addresses
    //for( int i=0; i < to.length; i++ ) { // changed from a while loop
      //  toAddress[i] = new InternetAddress(to[i]);
   // }
    System.out.println(Message.RecipientType.TO);
 
   // for( int i=0; i < toAddress.length; i++) { // changed from a while loop
        message.addRecipient(Message.RecipientType.TO, toAddress);
    //}
    message.setSubject("Forgot Password");
    
    message.setContent("Your new username and password are   <br>Username :"+username+"<br>Password : "+password,"text/html");
    Transport transport = session.getTransport("smtp");
    transport.connect(host, user, pass);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
    if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
    
    return "success";
   
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
             System.out.print("Registered but error"+e);
             
   
    }
                  
            

     if (con != null) { 				DatasourceConnection.closeConnection(con); 			}
return "error";

	} 
}
    
           
