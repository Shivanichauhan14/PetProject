import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveProducts extends HttpServlet {

      private Connection con;
    private PreparedStatement ps;
    
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
            String sql="delete from products where pcode=? ";
            ps=con.prepareStatement(sql);   
        }
        catch(Exception e){
            e.printStackTrace();
        }
         
    }
    public void destroy(){
         try{
             con.close();
         }
         catch(Exception e){
             e.printStackTrace();

         }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        PrintWriter out = response.getWriter();
        
        String s1=request.getParameter("pcode");
         
           try{
                             
            ps.setInt(1,Integer.parseInt(s1)); 
                      
            ps.executeUpdate();
            
           out.println("<html>");
           out.println("<body>");
           out.println("<hr>");
           out.println("<h3>Product-successfully-deleted</h3>");
           out.println("<<h4><a href = adminpage.jsp>AdminPage</a></h4>");
           out.println("<h4><a href = remove.jsp>delete-More-item</a></h4>");
           out.println("<hr>");
           out.println("<body>");
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
