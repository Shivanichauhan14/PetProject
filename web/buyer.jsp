<%
                String user = (String) session.getAttribute("user");
                 if(user==null){
                response.sendRedirect("index.jsp");
            }//to make this secure page.

%>
<html>
   
    <body bgcolor="rosybrown">
    <center>
        <h1>Hello buyer !! ... <%=user%></h1>
        <hr>
        <a href="CategoryPage">EXPLORE STORE</a><br>
        <a href="search.jsp">SEARCH-PRODUCT</a><br>
        <a href="DisplayCart">VIEW-CART</a><br>
        <a href="EndTheSession">LOGOUT</a>

        </hr>
    </center>
    </body>
</html>
 