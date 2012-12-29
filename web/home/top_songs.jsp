

<%@page import="model.modelsong"%>
<%@page import="model.Songservice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<link  rel="stylesheet"  type="text/css" href="../css/fixrating.css"></link>


<div id="wrapper" style="position: absolute; top:250px; left: 400px">
 <h1 align="center" style="font-size:18px">Top Songs</h1><br>
	<!-- Slider #2 (images of slider #1 reversed) -->
	<div id="slider-two">

    
              
        
  
<%

try
               {
    
           Songservice objx=new Songservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
           List listtopsongs=objx.getTopSongs();
            for(int i=0;i<listtopsongs.size();i++)
                            { 
modelsong obj1=(modelsong)listtopsongs.get(i);

out.print("<div><span><a href=\"../details.do?Album_id="+obj1.getAlbum_id()+"&song_id="+obj1.getSong_id()+"\"><img src=\""+obj1.getImg_url()+"\" height=\"180\" width=\"130\" ></a></span>");
out.print("<h3><a href=\"../details.do?Album_id="+obj1.getAlbum_id()+"&song_id="+obj1.getSong_id()+"\">"+obj1.getSong_name()+"</a>");
out.print("<div id='ratingresult' class='classification'><div class='cover'></div><div class='progress' title='" + obj1.getRating() + " of 5.0 star' style='width: "+obj1.getRating()*20 +"px;'></div></div></h3></div>");
            }
           }
            
    catch(Exception e)
               {
    out.print(e);
}


%>
        </div>
</div> 
