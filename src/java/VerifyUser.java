import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Shivani Chauhan
 */
public class VerifyUser extends HttpServlet {
    
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter(); 
         
         String email=request.getParameter("email");
         String password=request.getParameter("password");
         String utype=request.getParameter("utype");
         if(utype.equals("admin")){
             if(email.equals("admin@gmail.com") && password.equals("9685")){
                 String ch=request.getParameter("c1");
                     if(ch!=null){
                         //create cookie object
                         Cookie c1= new Cookie("id",email);
                         Cookie c2= new Cookie("pw",password);
                         //set max age
                         c1.setMaxAge(60*60*24*7);
                         c2.setMaxAge(60*60*24*7);
                         //add cookie to respose
                         response.addCookie(c1);
                         response.addCookie(c2);

                         
                     }
                 response.sendRedirect("adminpage.jsp");
             } else{
                response.sendRedirect("index.jsp"); 
                //out.println("invalid admin");
             }
         }
         else if(utype.equals("buyer")){
           
             String sql="select * from users where email=? and password=?";
             try{
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
                 //Connection con=Data.connect();
                 PreparedStatement ps=con.prepareStatement(sql);
                 ps.setString(1,email);
                 ps.setString(2,password);
                 ResultSet rs=ps.executeQuery();
                boolean b=rs.next();
                if(b==true){
                    
                     //storing email and password
                    //first fetch the session
                    HttpSession session=request.getSession();
                    //store the data in session
                    session.setAttribute("user",email);
                    
                     String ch=request.getParameter("c1");
                     if(ch!=null){
                         //create cookie object
                         Cookie c1= new Cookie("id",email);
                         Cookie c2= new Cookie("pw",password);
                         //set max age
                         c1.setMaxAge(60*60*24*7);
                         c2.setMaxAge(60*60*24*7);
                         //add cookie to respose
                         response.addCookie(c1);
                         response.addCookie(c2);

                         
                     }
                     response.sendRedirect("buyer.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                    //out.println("invalid byer details");
                }
            con.close();
             }
             catch(Exception e){
                 out.println(e);
             }
         }
        
    }

}
