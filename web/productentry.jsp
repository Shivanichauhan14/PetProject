<html>
    
    <body bgcolor="rosybrown">
    <center>
        <h3>web application</h3>
         <h3>product entry form</h3>
        <hr>
        <form action ="SaveProduct" method ="post">
            <table>
                <tr>
                    <td>Pcode</td><td><input type="text" name="pcode"/></td>
                </tr>
           
                <tr>
                    <td>Pname</td><td><input type="text" name="pname"/></td>
                </tr>
                
                <tr>
                    <td>Pdesc</td><td><input type="text" name="pdesc"/></td>
                </tr>
                
                <tr>
                            <td>Pcat</td><td><select name="pcat">
                                    <option>food</option>
                                    <option>clothes</option>
                                    <option>accessories</option>
                                    <option>care products</option>
                                    <option>grooming</option>
                                    <option>others</option>
                        </select></td>
                        
                </tr>
                
                <tr>
                    <td>Price</td><td><input type="text" name="price"/></td>
                </tr>
                
                
                <tr>
                    <td><input type="submit" value="Save"/></td>
                    <td><input type="reset" value="reset"/></td>

                </tr>
            </table>
        </form>
        <hr>
        <a href ="adminpage.jsp">HOME</a>
    </center>  
    </body>
</html>
