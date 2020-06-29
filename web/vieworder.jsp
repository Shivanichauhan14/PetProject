

<%
     int date=Integer.parseInt(request.getParameter("date"));
   
     Class.forName("com.mysql.jdbc.Driver");
     String url="jdbc:mysql://localhost:3306/prodata";
     java.sql.Connection con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
     String sql="SELECT * FROM orders WHERE date=?";
     java.sql.PreparedStatement ps=con.prepareStatement(sql);
     ps.setInt(1,date);
     java.sql.ResultSet rs =ps.executeQuery();
     rs.next();
      String s1=rs.getString(1);
      String s2=rs.getString(2);
      String s3=rs.getString(3);
      String s4=rs.getString(4); 
      String s5=rs.getString(5);
      String s6=rs.getString(6);
      String s7=rs.getString(7);
      String s8=rs.getString(8);
      String s9=rs.getString(9);
      
%>
<html>
    
    <body>
        <h3>ORDER-DETAILS</h3>
        <hr>
        <pre>
            product code   <%=s1 %>

            Name    <% out.println(s2); %>
            city    <% out.println(s3); %>
            address <% out.println(s4); %>
            mobile  <% out.println(s5);%>
            date    <% out.println(s6);%>
            month   <% out.println(s7);%> 
            year    <% out.println(s8);%>
            payment <% out.println(s9);%>
        </pre>
        <a href="orders.jsp">BACK</a><br>
        <a href="admin.jsp">HOME</a>
    </body>
</html> 
<%
            con.close();
%>
