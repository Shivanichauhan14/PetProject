
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PurchaseProduct extends HttpServlet {
    
    
        private Connection con;
    private PreparedStatement ps;
    
    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
            String sql="insert into orders values(?,?,?,?,?,?,?,?,?)";
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
       PrintWriter out=response.getWriter();
        //read the data
        String s1=request.getParameter("procode");
        String s2=request.getParameter("name");
        String s3=request.getParameter("city");
        String s4=request.getParameter("address");
        String s5=request.getParameter("mobile");
        String s6=request.getParameter("date");
        String s7=request.getParameter("month");   
        String s8=request.getParameter("year");
        String s9=request.getParameter("payment");
        //proces the data
        try{
            
            ps.setString(1,s1);
            ps.setString(2,s2);
            ps.setString(3,s3);
            ps.setString(4,s4);
            ps.setString(5,s5);
            ps.setString(6,s6);
            ps.setString(7,s7); 
            ps.setString(8,s8);
            ps.setString(9,s9);

            ps.executeUpdate();
            
            out.println("your order is placed.");
                
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
