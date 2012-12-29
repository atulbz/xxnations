function validateGenre(genre) { 
    //var genre=document.getElementById("genre"); 
    $.ajax(
    {
        
                                type: "GET",
                                data: "genre="+genre,
				url: "../xmlgenre.do",
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