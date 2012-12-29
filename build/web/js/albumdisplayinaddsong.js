function album(id){
//document.getElementsByName('artist_name').value=id;
$.ajax({
				type: "GET",
                                data: "id="+id,
				url: "../xmlalbum.do",
				dataType: "xml",
				success: function(result) {
        var artist_name=$(result).find("artistname").text(); 
        var release_year=$(result).find("releaseyear").text(); 
        var genre=$(result).find("genre").text(); 
        $('#artist_name').replaceWith('<input type="text" name="artist_name" id="artist_name" value='+artist_name+'>');
        $('#release_year').replaceWith('<input type="text" name="release_year" id="release_year" value='+release_year+'>')
      //  $('#genre').replaceWith("<option value =\""+genre+"\">"+genre+"</option>")
      //  $('#genre').add("<option value =\""+genre+"\" selected=\"selected\">"+genre+"</option>");
     // $('#'+genre+'').replaceWith("<option value =\""+genre+"\" selected=\"selected\">"+genre+"</option>");
      //$('#'+genre+'').append("selected=\"selected\"");
      $('#genre').val(genre);
    }});}

