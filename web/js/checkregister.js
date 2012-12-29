
function checkUsername(username) 
{     //var genre=document.getElementById("genre"); 
if(username==null || username=="")
    {
        return;
    }
    else
        {
    $.ajax(
    {
        type: "GET",
        data: "username="+username,
        url: "../xmlregister.do",
        datatype: "xml",
        success: function(result)
        {
      var pname=$(result).find('username').text();      
            
            if(pname=="true")
                {
                 
                 var mdiv = document.getElementById("usernamemessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "Username has already been used";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = true;
                 
                 
                }
                else
                    {
                        var mdiv = document.getElementById("usernamemessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Valid Username";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = false;
                        
                    }
            
        }
        
        
    });
        }
}

function checkEmail(email) 
{     //var genre=document.getElementById("genre"); 
    if(email==null || email=="")
        {
            return;
        }
        else
            {
    $.ajax(
    {
        type: "GET",
        data: "email="+email,
        url: "../xmlregister.do",
        datatype: "xml",
        success: function(result)
        {
            var amount=$(result).find('email').text();    
            console.log(amount);
            if(amount=="true")
                {
                 
                 var mdiv = document.getElementById("emailmessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "Email already used enter valid value";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = true;
                 
                 
                }
                else
                    {
                        var mdiv = document.getElementById("emailmessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Available ";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = false;
                        
                    }
            
        }
     
    });
}
}