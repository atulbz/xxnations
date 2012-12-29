<%@ page import="java.util.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="model.*" %>

<%

try {
    
    ServletContext sc=getServletContext();
    String classname=(String)sc.getInitParameter("classname");
    String driver=(String)sc.getInitParameter("driver");
    System.out.print(request.getRequestURL());
    Enumeration en = request.getParameterNames();
    String str = "cmd=_notify-validate";
    while(en.hasMoreElements())
        
        {
        
             String paramName = (String)en.nextElement();
             String paramValue = request.getParameter(paramName);
             System.out.print(paramName+"-"+paramValue);
             str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
              System.out.println(paramName +" - "+paramValue);
        }
    
    System.out.println(str);
    
    URL u = new URL("https://www.sandbox.paypal.com/cgi-bin/webscr");
    URLConnection uc = u.openConnection();
    uc.setDoOutput(true);
    
    PrintWriter pw = new PrintWriter(uc.getOutputStream());
    pw.println(str);
    pw.close();
    
    BufferedReader in = new BufferedReader(
            new InputStreamReader(uc.getInputStream()));
    
    String res = in.readLine();
    
    
    System.out.print(res);
    
    in.close();
    
    
    
    
    
    String user_id1=request.getParameter("custom");
    System.out.println("userid1");
    int user_id=Integer.parseInt(user_id1);
        System.out.println("userid");
    String amt1=request.getParameter("mc_gross");
        System.out.println("amt1"+amt1);
    float amt=Float.parseFloat(amt1);
            System.out.println("amt"+amt);
    String item_number=request.getParameter("item_number");
           System.out.println("item_number"+item_number);
    String name=request.getParameter("address_name");
            System.out.println("name"+name);
    String city=request.getParameter("address_city");
            System.out.println("city"+city);
    String email=request.getParameter("payer_email");
            System.out.println("amt"+amt1);
    String invoice_number1=request.getParameter("invoice");
            System.out.println("invoice_number1"+invoice_number1);
    String payment_status=request.getParameter("payment_status");
            System.out.println("payment_status"+payment_status);
    long invoice_number=Long.parseLong(invoice_number1);
            System.out.println("invoice_number"+invoice_number);
            System.out.print("Result from paypal"+res);
    if(res.equals("VERIFIED"))
    
                {
                          System.out.print("Verified");
        
            if(true)
            
                  {
            
                                    try
                                            
                                                      {
                                                               invoiceservice obj=new invoiceservice(classname, driver);
                                                               int i=obj.getInvoice(user_id, invoice_number, amt);
                                                               if(i!=1)
                                                                        {
                                                                          System.out.print("no payement");
                                                                         }
                                                                else
                                                                         {
                                                                                   int x=obj.removeInvoice(user_id, invoice_number, amt);
                    
                                                                                          planservice obj1=new planservice(classname, driver);
                                                                                          List list=obj1.getPlanDetailpayment(amt);
                                                                                          modelplan modplan=(modelplan)list.get(0);
                                                                                          int no_of_songs=modplan.getSongs();
                                                                                          String plan_name=modplan.getPlan_name();
                                                                                          int duration=modplan.getDuration();
                                                                                          paymentservice obj2=new paymentservice(classname, driver);   
                                                                                          int j=obj2.addPayment(user_id, amt,duration, no_of_songs, plan_name, name, city, email);
                    
                                                                        
                                                                                          if(j!=1)
                                                                                                   {
                                                                                                         System.out.print("Payement table update failed");
                                                                                                   }
                                                                                                   else 
                                                                                                   {
                                                                                                         Counterservice obj3=new Counterservice(classname, driver);
                                                                                                         int k=obj3.updateCounter(no_of_songs,duration);
                                                                                                         if(k!=1)
                                                                                                                  {
                                                                                                                      System.out.print("Counter failed to update");
                                                                                                                  }
                                                                                                          else 
                                                                                                                   {
                            
                                                                                                                      System.out.print("Great Work");
                                                                                                                    }
                                                                                                         }
                    
                                                                              }
                
                                                      } 
                                    catch(Exception x)
                                            {
                                                    System.out.print("Error in null pointer "+x);
                                            }
                                    finally
                                            {
                                            }
                                    
                           } 
                          
                          else
                                   {
                                       System.out.print("payement status is not completed");
                                   }
                          }
                           else
                                    {
                                        System.out.print("paypal verification failed");
                                    }
    
                    }

catch(Exception e)
                  {
                           System.out.print("Main error"+e);
                  }
         
%>