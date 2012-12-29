


            function vote(amnt,song_id){
                $('.load').append('<img src="images/loading.gif" alt="Currently Loading" id="loading1">');
                $.ajax({

                    url: '../rating.do',
                    type: 'POST',
                    data: 'rate='+amnt+'&song_id='+song_id,

                    success: function(result) {

                        $('#response').remove();
                        $('#current-rating-result').append('<p id="response"><div class="classification"><div class="cover"></div><div class="progress" style="width: '+result*20+'%;"></div></div>' + result + '</p>');
                        $('#loading1').fadeOut(500,function(){

                            $(this).remove();

                        })

                        $('.star-rating').remove();

                    }
                });
            }