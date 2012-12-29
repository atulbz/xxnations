<script>
    function show_alert()
{
alert("Please log in first!");
}
</script>

<form action="" method="post" id="login" >
    <table align="center" cellpadding="5px;">
                                    <tr><td colspan="2" align="center"> Request Us..</td></tr>
                                    <tr><td>Name of Album</td><td><input type="text" name="album"></td></tr>
                                    <tr><td>Name of Song</td><td><input type="text" name="song"></td></tr>
                                    <tr align="center"><td colspan="2"><input type="submit" name="submit" onclick="show_alert(); return false;"></td></tr>
                                    
                           </table>
                  </form>