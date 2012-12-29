function validateGenre(genre) { 
    //var genre=document.getElementById("genre"); 
    var g=genre;
    if(g==null || g=="")
    {
     return;   
    }
    else
        {
    $.ajax(
    {
        
                                type: "GET",
                                data: "genre="+genre,
				url: "../xmlgenre.do",
				dataType: "xml",
                                success: function(xml)
                                {
         var msg = xml.getElementsByTagName("valid")[0].childNodes[0].nodeValue;
 
   if (msg == "true") {

       var mdiv = document.getElementById("genremessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "Enter a valid value";
       var submitBtn = document.getElementById("submit_btn");
       submitBtn.disabled = true;

    } 
    else {

       var mdiv = document.getElementById("genremessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Genre Available";
       var submitBtn = document.getElementById("submit_btn");
       submitBtn.disabled = false;
    }  
}

        
        
        
    });
}
}
