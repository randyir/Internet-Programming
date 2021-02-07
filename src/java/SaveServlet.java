import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String nim = request.getParameter("nim");
            String nama = request.getParameter("nama");
            String alamat = request.getParameter("alamat");
            String telp = request.getParameter("telp");
            String jenkel = request.getParameter("jenkel");
            String agama = request.getParameter("agama");
            
            Emp e = new Emp();
            e.setNim(nim);
            e.setNama(nama);
            e.setAlamat(alamat);
            e.setTelp(telp);
            e.setJenkel(jenkel);
            e.setAgama(agama);
                       
            int status = EmpDao.save(e);
            if(status>0) {
            //    response.sendRedirect("ViewServlet");
                out.println("<p>Berhasil Mendaftar.</p>");
                request.getRequestDispatcher("index.html").include(request, response);
            }
            else {
                out.println("<p>Maaf, anda tidak berhasil mendaftar.</p>");
            }
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}