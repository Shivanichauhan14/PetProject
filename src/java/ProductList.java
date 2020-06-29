
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shivani Chauhan
 */
public class ProductList extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out=response.getWriter();
         String s=request.getParameter("ct");
         String sql="SELECT pcode,pname FROM  products WHERE pcat=?";
         try{
             Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
           PreparedStatement ps=con.prepareStatement(sql);
           ps.setString(1, s);
           ResultSet rs=ps.executeQuery();//this rs will have two column i.e pname and pcode but will have more rows belong to tht category
           out.println("<html>");
           out.println("<body bgcolor=\"rosybrown\">");
           out.println("<center>");
           out.println("<h3>select desired product</h3>");
           out.println("<hr>");
           //rs m sari category thi n hmne loop chalakr sari categories ko print kra dia niche
           while(rs.next()){
               String s1=rs.getString(1);
               String s2=rs.getString(2);
               out.println("<a href=ProductDetails?code="+s1+">");//query string me code isliye dia coz name do same ho skte h.and showing name.
               out.println(s2);//coz just have to print the name and as hyperlink so use a href
               out.println("</a>");
               out.println("<br>");
           }
           out.println("<hr>");
           out.println("<a href=buyer.jsp>BUYER-PAGE</a><br>");
           out.println("<a href=CategoryPage>CATEGORY-PAGE</a><br>");
           out.println("</center>");
           out.println("</body>");
           out.println("</html>");
           con.close();
         }catch(Exception e){
             out.println(e);
         }
  
    
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
