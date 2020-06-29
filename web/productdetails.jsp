
 <%
     int code=Integer.parseInt(request.getParameter("t1"));
     Class.forName("com.mysql.jdbc.Driver");
     String url="jdbc:mysql://localhost:3306/prodata";
     java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
     String sql="SELECT * FROM PRODUCTS WHERE PCODE=?";
     java.sql.PreparedStatement ps=con.prepareStatement(sql);
     ps.setInt(1,code);
     java.sql.ResultSet rs =ps.executeQuery();
     rs.next();
     String s1=rs.getString(1);
      String s2=rs.getString(2);
      String s3=rs.getString(3);
      String s4=rs.getString(4); 
      String s5=rs.getString(5);
      
%>
<html>
    
    <body>
        <h3>PRODUCT-DETAILS</h3>
        <hr>
        <pre>
            pcode   <%=s1 %>

            Name    <% out.println(s2); %>
            Desc    <% out.println(s3); %>
            Catg    <% out.println(s4); %>
            Price   <% out.println(s5);%>
        </pre>
        <a href="search.jsp">SEARCH-MORE</a><br>
        <a href="buyer.jsp">HOME</a>
    </body>
</html> 
<%
            con.close();
%>