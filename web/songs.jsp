

<%-- 
    Document   : songs
    Created on : Jan 3, 2012, 1:02:12 AM
    Author     : Shaishav
--%>

<%@page import="java.util.*" %>
<%@page import="java.math.*" %>
<%@page import="model.*" %>
<%@page import="model.Counterservice"%>
<%@page errorPage="./oops.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(request.getParameter("Album_name")); %></title>
        
      
   <script type="text/javascript" src="js/player.js"></script>
 
                </head>
    <body>
         <%
    if ((String)session.getAttribute("role")== "user") {
  %>
  <%@include file="./common/globalheaderuser.jsp" %>
  
  <%
    }
                else
                    {
%>
                    
<%@include file="./common/globalheaderguest.jsp" %>
     <% } %>
     <div style="position: absolute; margin-top: 75px; margin-left: 450px; ">
        <h1>List of Songs </h1>
         <hr align="left" style="width: 500px;">
        <%
        
    
        
        String query=request.getQueryString();
        String Album_id=request.getParameter("Album_id");
List listsongs=(List)request.getAttribute("Songlist");      
if(listsongs.isEmpty())
       {
    out.print("<i>This album does not exists or no Songs in this album will be added soon...</i><br>");
}
Iterator it=listsongs.iterator();
   albumservice obj2=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
     String img_url=obj2.getUrl(Album_id);
     out.print("<img src="+img_url+" height=\"300\" width=\"300\"><br><br><br>");
     out.print("List of songs<br><br>");
     out.print("<table cellspacing=\"10\" cellpadding=\"10\">");
     out.print("<th>Song Name</th><br><th>Artist Name</th><br><th>Details</th><br><th>Download</th>");
     while(it.hasNext())
       {
    modelsong obj=(modelsong)it.next();
    String s="<a href=\""+obj.getDemo_url()+"\"></a>";
    String url=doencrypt(s);
    out.print("<div style=\"display: none\">"+url+"</div>");
    out.print("<tr><td>");
    out.print(obj.getSong_name());
    out.print("</td><td>"+obj.getArtist_name());
    out.print("</td><td><a href=\"details.do?"+query+"&song_id="+obj.getSong_id()+"\"> Details </a></td>");
    out.print("&nbsp&nbsp&nbsp&nbsp<td><a href=\"download_url.do?song_id="+obj.getSong_id()+"\">Download</a></td></tr>");
      }
  
        %>
       </table>            
    </div>
       <%@include file="./common/Footer.jsp" %>
           </body>
              <HEAD>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
            <%!
      public String  doencrypt(String url)
 { 

String result=encrypt(url); 
String codetocopy;
codetocopy="<Script Language='Javascript'>\n";
 codetocopy+="<!-- HTML Encryption provided by iWEBTOOL.com -->\n"; 
codetocopy+="<!--\n"; codetocopy+="document.write(unescape('"+result+"'));\n"; 
codetocopy+="//-->\n"; 
codetocopy+="</Script>"; 
return codetocopy;

} 

public String encrypt(String tx)
 { 
String hex=""; 
int i; 
for (i=0; i<tx.length(); i++) 
{ 
hex += '%'+hexfromdec((int)tx.charAt(i));
}
return hex; 
} 

public String hexfromdec(int num) 
{
 if (num > 65535) 
{ 
return ("err!");
}
long first = Math.round(num/4096 - .5);
long temp1 = num - first * 4096;
long second = Math.round(temp1/256 -.5); 
long temp2 = temp1 - second * 256; 
long third = Math.round(temp2/16 - .5);
 long fourth = temp2 - third * 16; 
return (""+getletter(third)+getletter(fourth));
 }

 public String getletter(long num) 
{ 
if (num < 10)
 { 
return ""+num; 
}
 else
 { 
if (num == 10) 
{
 return "A"; 
} 
if (num == 11)
 {
 return "B"; 
}
 if (num == 12) 
{
 return "C"; 
}
 if (num == 13) 
{
 return "D"; 
}
 if (num == 14) 
{
 return "E"; 
}
else if (num == 15) 
{
 return "F"; 
}
else
       {
return "";
}
 }
 }
        
        
        
        %>
</html>

