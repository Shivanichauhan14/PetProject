
<html>
    
    <body>
        <h3>ENTER YOUR INFORMATION!</h3>
        <form action="PurchaseProduct" method="post">
        <table>
            <tr>
                <td>product code</td><td> <input type="text" name="procode"/></td><td>(enter product code here)</td>
            </tr>
            <tr>
                <td>Name</td><td> <input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>City</td><td> <input type="text" name="city"</td>
            </tr>
            <tr>
                <td>Adddress</td><td> <input type="text" name="address"/></td>
            </tr>
            <tr>
                <td>Mobile</td><td> <input type ="text" name="mobile"/></td>
            </tr>
            <tr>
                <td>order date</td><td> <input type="text" name="date"/></td>
            </tr>
             <tr>
                <td>order month</td><td> <input type="text" name="month"/></td>
            </tr>
             <tr>
                <td>order year</td><td> <input type="text" name="year"/></td>
            </tr>
            <tr>
                <td>Payment method</td><td> <select name="payment"><option>cash</option><option>card</option></select></td>
            </tr>
            <tr>
                <td><input type="submit" value="DONE"></td> 
                <td><a href="DisplayCart">CANCEL</a></td>
            </tr>
        </table>
        </form>
    </body>
</html>
