
function checkPlanName(planname) 
{     //var genre=document.getElementById("genre"); 
    var p=planname;
    
    if(p==null || p=="")
        {
            return;
        }
        else
            {
    $.ajax(
    {
        type: "GET",
        data: "planname="+planname,
        url: "../xmlplan.do",
        datatype: "xml",
        success: function(result)
        {
      var pname=$(result).find('planname').text();      
            
            if(pname=="true")
                {
                 
                 var mdiv = document.getElementById("planmessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "Enter a valid value";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = true;
                 
                 
                }
                else
                    {
                        var mdiv = document.getElementById("planmessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Plan Name Can be added";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = false;
                        
                    }
            
        }
        
        
    });
            }
}

function checkAmount(amount) 
{     //var genre=document.getElementById("genre"); 
    var a=amount;
    if(a==null || a=="")
        {
            return;
        }
        else
            {
    $.ajax(
    {
        type: "GET",
        data: "amount="+amount,
        url: "../xmlplan.do",
        datatype: "xml",
        success: function(result)
        {
            var amount=$(result).find('amount').text();    
            console.log(amount);
            if(amount=="true")
                {
                 
                 var mdiv = document.getElementById("amountmessage");

       // set the style on the div to invalid

       mdiv.className = "bp_invalid";
       mdiv.innerHTML = "There seems error in Amount value either it is already being used or it is not in Integer or Float";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = true;
                 
                 
                }
                else
                    {
                        var mdiv = document.getElementById("amountmessage");

       // set the style on the div to valid

       mdiv.className = "bp_valid";
       mdiv.innerHTML = "Valid Amount";
       var submitBtn = document.getElementById("submit");
       submitBtn.disabled = false;
                        
                    }
            
        }
        
            
      
           
        
    });
            }
}