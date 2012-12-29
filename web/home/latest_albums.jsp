

<%@page import="model.modelalbum"%>
<%@page import="model.albumservice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>


<link rel="stylesheet" href="../css/3col_leftNav.css" type="text/css">
<link href="../css/movingboxes.css" media="screen" rel="stylesheet">
	<!--[if lt IE 9]>
	<link href="css/movingboxes-ie.css" rel="stylesheet" media="screen" />
	<![endif]-->

	<!-- Required script -->

	<script src="../js/jquery-min.js"></script>
	<script src="../js/jquery.movingboxes.js"></script>
 <script type="text/javascript" src="../js/tooltip.jquery.js"></script>
	<!-- Demo only -->
	<link href="../css/demo.css" media="screen" rel="stylesheet">
	<script src="../js/demo.js"></script>
	<script type="text/javascript">
			$(document).ready(function(){
				$('.tooltip').tooltip({
							folderurl : '../trial.jsp'
							});
						
			});
		</script>
<style type="text/css">
ul#slider-one { width: 600px; }
		ul#slider-one > li { width: 260px; }
		div#slider-two { width: 600px; }
		div#slider-two > div { width: 260px; }

</style>

    
    
        
        

<%

try
               {
    
            albumservice objy=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List list1=objy.getLatestAlbum();
       %>

    <div id="wrapper" style="position: absolute; top:650px; left: 400px">
	<h1 align="center" style="font-size:18px; position: relative; top: 25px">Latest Releases</h1><br>
	<!-- Slider #1 -->
	<ul id="slider-one">

          
          
          <%      
         for(int i=0;i<list1.size();i++)
                            {    
modelalbum obj1=(modelalbum)list1.get(i);
                 out.print("<li><a href=\"../songs.do?Album_id="+obj1.getAlbum_id()+"&Album_name="+obj1.getAlbum_name()+"\" id=\"?Album_id="+obj1.getAlbum_id()+"\" class=\"tooltip\"><img src="+obj1.getImg_url()+" height=\"180\" width=\"130\"> </a>");
                 out.print("<h3><a href=\"../songs.do?Album_id="+obj1.getAlbum_id()+"&Album_name="+obj1.getAlbum_name()+"\">"+obj1.getAlbum_name()+"</a></h3></li>");
             
            }
         

           }
            
    catch(Exception e)
               {
    out.print(e);
}


%>

        </ul>
        </div>

