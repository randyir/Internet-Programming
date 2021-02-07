import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<head>");
        out.print("<title>18360021 - Randy I.R.</title>");
        out.print("<link href=\"./images/ISTN.png\" rel=\"shortcut icon\">");
        out.print("<style>a{text-decoration:none}</style>");
        out.print("</head>");
        out.println("<h1 align=\"center\"><font color=\"darkblue\">Edit<br>DATA MAHASISWA</font></h1>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        Emp e = EmpDao.getAccountById(id);
        
        out.print("<body bgcolor=\"lightblue\" link=\"darkblue\" alink=\"darkblue\" vlink=\"darkblue\"");
        out.print("<div class='wrapper'>");
        out.print("<form action='EditServlet2' method='post'>");
        out.print("<table>");
        out.print("<tr>" + "<td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
        out.print("<tr><td>NIM</td><td>:</td><td><input type='text' name='nim' autofocus value='" + e.getNim() + "'/></td></tr>");
        out.print("<tr>");
        out.print("<td>Nama</td><td>:</td>");
        out.print("<td><input type='text' name='nama' value='" + e.getNama() + "'/></td>");
        out.print("</tr>");
        out.print("<tr><td>Alamat</td><td>:</td><td><textarea name='alamat' value='" + e.getAlamat() + "'></textarea></td></tr>");
        out.print("<tr><td>Telp</td><td>:</td><td><input type='text' name='telp' value='" + e.getTelp() + "'/></td></tr>");
        out.print("<tr>"
                + "<td>Jenis kelamin</td><td>:</td>"
                + "<td><input type='radio' name='jenkel' value='pria'" + e.getJenkel() + "'/>Pria"
                + "<input type='radio' name='jenkel' value='wanita'>Wanita</td></tr>");
        out.print("<tr><td>Agama</td><td>:</td><td>");
        out.print("<select name='agama'>");
        out.print("<option>Islam</option>");
        out.print("<option>Kristen</option>");
        out.print("<option>Katolik</option>");
        out.print("<option>Buddha</option>");
        out.print("<option>Hindu</option>");
        out.print("</select>");
        out.print("</td></tr>");
        out.print("<tr><td colspan='2'><button type='submit'>SIMPAN</button></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("</div>");
        out.close();
    }
}