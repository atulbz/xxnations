
<%@page import="model.genreservice"%>
<%@page import="model.modelgenre"%>
<%@page import="java.util.*"%>

<link href="../css/demo.css" media="screen" rel="stylesheet">

      <link rel="stylesheet" type="text/css" href="../css/styles.css" />
                <script type="text/javascript" src="../js/jquery-min.js"></script>

<div id="navBar" style="position: absolute; top: 255px; width: auto">
  
    <div style="position: absolute; margin-top: 8px;">
            <ul id="sliding-navigation">
                
                <li class="sliding-element"><h3 style="font-size: 20px">Browse by Genre</h3></li><hr style="width: auto">
  
	<%
                genreservice obj = new genreservice((String) application.getInitParameter("classname"), (String) application.getInitParameter("driver"));
                List listgenredemo = obj.getGenre();
                for (int iq = 0; iq < listgenredemo.size(); iq++) {
                    modelgenre obj2 = (modelgenre) listgenredemo.get(iq);
                    out.print("<li class='sliding-element'><a href=\"../categories.do?q=" + obj2.getGenre() + "\" style='font-size:18px' >" + obj2.getGenre() + "</a></li>");
                    
                }

            %>
    </ul>
  </div>
    
    
  
</div>
    
    <div style="float:right; position: absolute; top: 270px; left: 1150px; right: 200px;  height: 400px; width: 150px; background-color: #C0C0C0; text-align: center">
        <h1> <br><br>Your<br> Ad<br> Here<br><br></h1>
    </div>
    

