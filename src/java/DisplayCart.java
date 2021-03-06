
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Shivani Chauhan
 */
public class DisplayCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out=response.getWriter();
       
        HttpSession session=request.getSession();
        HashSet<String> set=(HashSet<String>) session.getAttribute("cart");
        
        out.println("<html>");
          out.println("<body bgcolor=\"rosybrown\">");
           out.println("<center>"); 
         out.println("<h3>your cart</h3>");
         out.println("<hr>"); 
         if(set==null){
             out.println("<h3>your cart is empty</h3>");
             out.println("<h4><a href=CategoryPage>START-BUYING</h4>");
    }else{
          out.println("<h3>your product code</h3>");
          String sql="SELECT * FROM PRODUCTS WHERE PCODE IN"+set;
          sql=sql.replace('[','(');
          sql=sql.replace(']',')');
         
          try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                out.println("<table border=2>");
                out.println("<tr>");
                out.println("<th>Code</th>");
                out.println("<th>Name</th>");
                out.println("<th>Desc</th>");
                out.println("<th>Catg</th>");
                out.println("<th>Price</th>");
                out.println("</tr>");
              int sum=0;
                while(rs.next()){
                    String s1=rs.getString(1);
                    String s2=rs.getString(2);
                    String s3=rs.getString(3);
                    String s4=rs.getString(4);
                    int s5=rs.getInt(5);//can also use parse int.
                     sum=sum+s5;
                    out.println("<tr>");
                    out.println("<td>"+s1+"</td>");
                    out.println("<td>"+s2+"</td>");
                    out.println("<td>"+s3+"</td>");
                    out.println("<td>"+s4+"</td>");
                    out.println("<td align=right>"+s5+"</td>");
                   out.println("<td><a href=RemoveProduct?code="+s1+">x</a></td>");//on clicking each cross remove product is called how will it know kise delete krna so use query string.
                    
                    out.println("</tr>");
                }
                 
               out.println("<tr>");
                out.println("<td></td><td></td><td></td>");//we need this columns blank
                out.println("<td>Total</td>");
                out.println("<td align=right>"+sum+"</td>");//to show total number.
                out.println("</table>");
                con.close();
            }catch(Exception e){
                out.println(e);
            }
            out.println("<h3><a href=purchase.jsp>PLACE-ORDER</a></h3>");
            out.println("<h4><a href=CategoryPage>ADD-MORE-PRODUCTS</a></h4>");          
         }    
         out.println("<hr>");
         out.println("<a href=buyer.jsp>HOME</a><br>");
         out.println("</center>");
         out.println("</body>");
         out.println("</html>");
        
        }
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
