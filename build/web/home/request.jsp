
                  <%
try
{
         String errorrequest=request.getParameter("errorrequest");
         if(errorrequest==null||errorrequest.isEmpty()||errorrequest=="")
                                   {
                  
         }
         else
                                   {
                  out.print(errorrequest);
         }
}        
catch(Exception e)
{
         
}                       
%>
                  <form action="../request.do" method="post">
                           <table align="center">
                                    <tr><td colspan="2" align="center"> Request Us.. </td></tr>
                                    <tr><td>Name of Album</td><td><input type="text" name="album"></td></tr>
                                    <tr><td>Name of Song</td><td><input type="text" name="song"></td></tr>
                                    <tr><td><input type="submit" name="submit"></td></tr>
                           </table>
                  </form>
        