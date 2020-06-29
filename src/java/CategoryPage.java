
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class CategoryPage extends HttpServlet {

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int n=0;//initialised number of item in cart to zero.
            //to read email from session
           //fetch session
            HttpSession session=request.getSession();
            String user = (String) session.getAttribute("user");
            if(user==null){
                response.sendRedirect("index.jsp");//to make this page secure.
            }
            //to know number of iyems in our cart.
            HashSet<String> set=(HashSet<String>) session.getAttribute("cart");
            if(set!=null)
            {
                n=set.size();
            }
            
        PrintWriter out = response.getWriter();
       try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
           String sql="SELECT DISTINCT pcat FROM products order by pcat";
           PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs=ps.executeQuery();
           out.println("<html>");
           out.println("<body bgcolor=\"rosybrown\">");
           out.println("<center>");
           out.println("<h3>welcome "+user+"</h3>");//for session use.
           out.println("<h3>select desired category</h3>");
           out.println("<hr>");
           //rs m sari category thi n hmne loop chalakr sari categories ko print kra dia niche
           while(rs.next()){
               String s=rs.getString(1);
               out.println("<a href=ProductList?ct="+s+">");//har category ke click p product list call krna h to ye ek baar use krenge.jo category hm log display krre h usi category ko query string m concatinate kr dia h.
               out.println(s);
               out.println("</a>");
               out.println("<br>");
           }
           out.println("<hr>");
           out.println("<h5>number of products in cart : "+n+"</h5>");
           out.println("<a href=buyer.jsp>BUYER-PAGE</a>");
           out.println("</center>");
           out.println("</body>");
           out.println("</html>");
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
