package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class download extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

                 // String fileName="http://sound9.mp3pk.com/indian/jannat/jannat01(www.songs.pk).mp3";
                //URL url = new URL("http://sound9.mp3pk.com/indian/jannat/jannat01(www.songs.pk).mp3");
       URL url = new URL("http://127.0.0.1:8080/WebApplication5try/images/loading.gif");
		URLConnection uc = url.openConnection();
                InputStream inputStream = uc.getInputStream();

                 ServletOutputStream stream = null;
                  BufferedInputStream buf = null;
             try
             {
        

      stream = response.getOutputStream();
    //  File mp3 = new File(fileName);

      //set response headers
      response.setContentType("audio/mpeg");

      response.addHeader("Content-Disposition", "attachment; filename="
          +"Shaishav.mp3");

     // response.setContentLength((int) mp3.length());

      //FileInputStream input = new FileInputStream(mp3);
      buf = new BufferedInputStream(inputStream);
      int readBytes = 0;
      //read from the file; write to the ServletOutputStream
      while ((readBytes = buf.read()) != -1)
        stream.write(readBytes);
    } 
    
    catch (Exception ioe) {
      System.out.print(ioe);
    } finally {
      if (stream != null)
        stream.close();
      if (buf != null)
        buf.close();
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }
}