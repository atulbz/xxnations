<%@page import="model.Counterservice"%>      
<link rel="stylesheet" href="../css/3col_leftNav.css" type="text/css">
        <link href="../css/demo.css" media="screen" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../css/globalheaderdemo.css" />
	
    
        <script type="text/javascript" src="../js/jquery-min.js"></script>
        <script type="text/javascript" src="../js/globalheaderscript.js"></script>
    <%
     String user_idcounterstring=(String)session.getAttribute("user");
  int user_idcounter=Integer.parseInt(user_idcounterstring);
  Counterservice obj4=new Counterservice((String)application.getInitParameter("classname"),(String)application.getInitParameter("driver"));
  int counter=obj4.getCounter(user_idcounter);

%>

     
        
        
<div id="masthead" style="background-color: #364F86; width: 100%;">
  <h1 id="siteName" style="color:#CCCCCC; font-size:20px; margin-left: 47;">The Music Store</h1><br><br>
  <div id="menu-container" style="position: absolute; top: 16px;" >
  
	
    <ul id="navigationMenu" style=" position: relative; margin-top: 15px; min-width: 700px">

        <li id="globallist"><a href="../index.jsp" class="normalMenu">Home</a></li>
<li id="globallist"><a href="../features.jsp" class="normalMenu">Features</a></li>
<li id="globallist"><a href="../plan.jsp" class="normalMenu">Plan and Pricing</a></li>
<li id="globallist"><a href="../aboutus.jsp" class="normalMenu">About us</a></li>
<li id="globallist"><a href="../contactus.jsp" class="normalMenu">Contact us</a></li>

</ul>
  </div>
  
  <hr>
  <h2 align="right" id="pageName" style="color:#CCCCCC; font-size:18px">Welcome <% out.print(session.getAttribute("username").toString().toUpperCase()); %></h2>
  <div id="breadCrumb"> 
      <div align="right"><a href="../logout.do" style="color:#CCCCCC; font-size:14px">Log out</a> | <a href="../manageaccount.jsp" style="color:#CCCCCC; font-size:14px">My Account</a></div>
</div>
</div
<br>
<br>
         <div align="center" style="min-width: 720px; min-width: 1300px; " >
    <table  style="width: 100%; min-width: 720px;" class="avoidcss"><tr><td style="text-align: left; width: 500px"><i>Song Pending : 
                    <%=counter %></i></td><td>
                <form action="../search.do" method="get">
                    <input type="text" name="q" id="searchdiv" value="Search.." onfocus="this.style.opacity='1'; q.value=null " onblur="this.style.opacity='.5'; if(q.value==null) q.value='Search..'"   style="opacity:0.5;"/>
                    <input type="submit" value="Search" style="width:128px;" />
                    
                    
                        All :<input type="radio" name="radio" value="All" />
                        Song  :<input type="radio" name="radio" value="Song" checked="checked" />
                        Album :<input type="radio" name="radio" value="Album" />
                        Artist:<input type="radio" name="radio" value="Artist" />
                   
                </form></td></tr></table>
            </div>  

            
  <%@include file="sidebar.jsp" %>