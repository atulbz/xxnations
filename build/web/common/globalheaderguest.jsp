        <link rel="stylesheet" href="../css/3col_leftNav.css" type="text/css">
        <link href="../css/demo.css" media="screen" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../css/globalheaderdemo.css" />
	
        
        <script type="text/javascript" src="../js/jquery-min.js"></script>
        <script type="text/javascript" src="../js/globalheaderscript.js"></script>
        
        
        
<div id="masthead" style="background-color: #364F86; width: 100%; min-width: 1300px">
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
  <h2 align="right" id="pageName" style="color:#CCCCCC; font-size:18px">Welcome Guest</h2>
  <div id="breadCrumb"> 
      <div align="right"><a href="../login.jsp" style="color:#CCCCCC; font-size:14px">Login</a> | <a href="../register.jsp" style="color:#CCCCCC; font-size:14px">Sign Up</a> | <a href="../forgotpassword.jsp" style="color:#CCCCCC; font-size:14px">Forgot Password</a> </div>
</div>
</div>
        
             
           
<br>
<div align="center" style="min-width: 1300px; width: 100%; height: 40px; position: relative; left: -170px;" >
    <table style="min-width: 800px">
        <tr><td>
                <form action="../search.do" method="get">
                    <input type="text" name="q" id="searchdiv" value="Search.." onfocus="this.style.opacity='1'; q.value=null " onblur="this.style.opacity='.5'; if(q.value==null) q.value='Search..'"   style="opacity:0.5;"/>
                    <input type="submit" value="Search" style="width:128px;" />
                    
                    
                     <label>  All :</label><input type="radio" name="radio" value="All" />
                    <label>  Song  :</label><input type="radio" name="radio" value="Song" checked="checked" />
                    <label> Album :</label><input type="radio" name="radio" value="Album" />
                    <label> Artist:</label><input type="radio" name="radio" value="Artist" />
                   
                </form></td></tr></table>
            </div>  
                               
 
       
<%@include file="sidebar.jsp" %>
