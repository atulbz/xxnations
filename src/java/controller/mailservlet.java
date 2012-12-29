package controller;

 

import javax.servlet.*;

import javax.servlet.http.*;

import java.io.*;

import javax.mail.*;

import javax.mail.internet.*;   // important

import javax.mail.event.*;  // important

import java.net.*;

import java.util.*;

public class mailservlet extends HttpServlet

{

  public  void doPost(HttpServletRequest request,HttpServletResponse response)

    throws ServletException, IOException

  {

  PrintWriter out=response.getWriter();

  response.setContentType("text/html");

  try

  {

   Properties props=new Properties();

   props.put("mail.smtp.host","localhost");   //  'localhost' for testing

   Session   session1  =  Session.getDefaultInstance(props,null);

   String s = request.getParameter("s"); 

   String email = request.getParameter("email");

   String s3 = request.getParameter("text3");

   String s4 = request.getParameter("area1");

   Message message =new MimeMessage(session1);

   message.setFrom(new InternetAddress("xxnations@gmail.com"));

  message.setRecipients

  (Message.RecipientType.TO,InternetAddress.parse(email,false));

   message.setSubject("Verification Email");

   message.setContent("Click this link <a href=\"http://xxnations.com/WebApplication5try/verificationservlet.do?"+s+"\">http://xxnations.com/WebApplication5try/verificationservlet.do?"+s+"</a>","text/html");  

   Transport.send(message);

   System.out.println("mail has been sent to "+email);

  }

  catch(Exception ex)

  {

   System.out.println("ERROR....."+ex);

  }

  }

}