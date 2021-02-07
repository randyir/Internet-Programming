import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String nim = request.getParameter("nim");
        String nama = request.getParameter("nama");
        String alamat = request.getParameter("alamat");
        String telp = request.getParameter("telp");
        String jenkel = request.getParameter("jenkel");
        String agama = request.getParameter("agama");

        Emp e = new Emp();
        e.setId(id);
        e.setNim(nim);
        e.setNama(nama);
        e.setAlamat(alamat);
        e.setTelp(telp);
        e.setJenkel(jenkel);
        e.setAgama(agama);

        int status = EmpDao.update(e);
        if (status > 0) {
            response.sendRedirect("ViewServlet");
//            out.println("<p>Berhasil mengubah data.</p>");
//            request.getRequestDispatcher("index.html").include(request, response);
        }
            else{  
                out.println("<p>Maaf, data tidak berhasil diubah.</p>");  
            }             
            out.close();  
        }
    }
}  