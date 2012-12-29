package controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.tempservice;

public class downloadwithcode extends HttpServlet {

    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        ServletOutputStream stream = null;
        BufferedInputStream buf = null;
        tempservice res=null;
        String k=null;
     
       
        try {
           
            ServletContext sc = getServletContext();
            String classname = (String) sc.getInitParameter("classname");
            String driver = (String) sc.getInitParameter("driver");
            k=request.getParameter("k");
            if(k.isEmpty() || "".equals(k) || k==null)
            {
                
                RequestDispatcher rd=request.getRequestDispatcher("./oops.jsp");
                rd.forward(request, response);
                return;
                
            }
            String sname;
            if(request.getParameter("sname")==null)
                sname="Download";
            else
            {
                sname=request.getParameter("sname");
                System.out.println("Name of song from request "+sname);
            }
           res =new tempservice(classname, driver);
          List temp=null;
            try
           {
             temp = res.getTemp(k);
             if(temp==null)
             {
                 response.sendRedirect("../used.jsp");
               return;
             }
                       }
           catch(Exception e)
           {
               System.out.print("Error in downloadwith code tomp object empty");
               response.sendRedirect("../used.jsp");
               return;
           }
            String link=(String)temp.get(0);
            System.out.print("link "+link);
            //String size12=(String)temp.get(1);
            
            //String size1=size12.toString();
            //int size=Integer.parseInt(size12);
            //System.out.print("size "+size1);
            //if(size1.isEmpty() || size1==null || size1==null)
           // {
                                         
           // }
           // else
           // {
               
                     //response.setContentLength(size*1024);
           // }
            if(link==null)
            {
                response.sendRedirect("./home.jsp");
            }
            
            URL url = new URL(link);
            URLConnection uc = url.openConnection();
            stream = response.getOutputStream();
            
            InputStream is = uc.getInputStream();
                 try
                 {
                    response.setContentLength(uc.getContentLength());
                 }
                 catch(Exception e)
                 {
                 
                 }
                          
            StringBuilder s = new StringBuilder(link);
            int i = s.lastIndexOf(".");
            String format = (String) s.subSequence(i, s.length());
            System.out.println("Format of file"+format);
            String filename = sname + format;
            System.out.println("Name of file"+filename);



            //set response headers
            response.setContentType("audio/mpeg");

            response.addHeader("Content-Disposition", "attachment; filename="
                    + filename.replaceAll(" ", "_"));


             
            // FileInputStream input = new FileInputStream(mp3);
            buf = new BufferedInputStream(is);
            int readBytes = 0;
            //read from the file; write to the ServletOutputStream
            while ((readBytes = is.read()) != -1) 
            {
                
               
                stream.write(readBytes);
               
            }
             if(is.read()==-1)
                {
                System.out.println("###################TEMP DELETED");
                     res.delTemp(k);
                }
            
        } catch (IOException ioe) {
            System.out.print("*****************************************************"+ioe);
        } finally {
            if (stream != null) {
                stream.close();
            }
            if (buf != null) {
                buf.close();
            }
           
        }
    }
    
    


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}