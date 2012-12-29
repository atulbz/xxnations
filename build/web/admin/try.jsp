
<%@page import="model.*" %>
<%@page import="java.util.*" %>

<%
            albumservice obj1=new albumservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
            List list1=obj1.getAlbumlist();
            Iterator it=list1.iterator(); 
  %>          
                       
            
            <html>
            <head>
            <title>Add Song</title>  
            <style type="text/css">
 .bp_invalid {
    color:red;
   
    
 }
 .bp_valid {
    color:green;
 }
</style>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
            
            </head>
            <body>
                <table>
                <form action='/WebApplication5try/addsong.do' name="form1">
                   <tr><td> Album name </td><td><input type="text" name="Album_name" value="" /></td></tr>
                    <br>
                    <tr><td>Genre    </td><td><input type="text" name="Genre" value="" id="genre" onblur="validateGenre(this.value)" /><div id="genremessage"> </div></td></tr>
                    <br>
                    <tr><td>Release date    </td><td><input type="text" name="Release_date" value="" /></td></tr>
                    <br>
                    <tr><td>Artist name</td><td><input type="text" name="Artist_name" value="" /></td></tr>
                    <br>
                    <tr><td>Album info</td><td><textarea name="Album_info" rows="4" cols="20" ></textarea></td></tr>
                    
                    <br>
                    <tr><td>Image url    </td><td><input type="text" name="img_url" value="" /></td></tr>
                    <br>
                    <tr><td>Featuring Artist</td><td><input type="text" name="Featuring_artists" value="" /></td></tr>
                    <br>
            </td><td><input type='submit' id="submit_btn" value='Add Album'>
            </form>
                    <div id="i"></div>
                </table>
                <script language="javascript" type="text/javascript" >
 
function validateGenre(genre) { 
    //var genre=document.getElementById("genre"); 
    $.ajax(
    {
        
                                type: "GET",
                                data: "genre="+genre,
				url: "/WebApplication5try/xmlgenre.do",
				dataType: "xml",
                                success: function(xml)
                                {
         var msg = xml.getElementsByTagName("valid")[0].childNodes[0].nodeValue;
 
   if (msg == "false") {

       var mdiv = document.getElementById("genremessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "Invalid Genre";
       var submitBtn = document.getElementById("submit_btn");
       submitBtn.disabled = true;

    } 
    else {

       var mdiv = document.getElementById("genremessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Valid Genre";
       var submitBtn = document.getElementById("submit_btn");
       submitBtn.disabled = false;
    }  
}
    });

}

function album(id){
//document.getElementsByName('artist_name').value=id;
$.ajax({
				type: "GET",
                                data: "id="+id,
				url: "/WebApplication5try/xmlgenre.do",
				dataType: "xml",
				success: function(result) {
        var s=$(result).find("artistname").text();                        
        $('#genre').replaceWith('</td><td><input type="text" name="artist_name" id="artist_name" value='+s+'>');
 				}});}


</script>
             <%
    
String x="Hello how are you .mp3";
System.out.print(x.replaceAll(" ", "_"));
%>
            
            </body>
            </html>