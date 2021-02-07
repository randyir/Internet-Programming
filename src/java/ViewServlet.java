import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<head>");
        out.print("<link href=\"./images/ISTN.png\" rel=\"shortcut icon\">");
        out.print("<title>18360021 - Randy I.R.</title>");
        out.print("<style>");
        out.print("a{");
        out.print("text-decoration:none");
        out.print("}");
        out.print("</style>");
        out.print("</head>");
        out.print("<body bgcolor=\"lightblue\" link=\"darkblue\" alink=\"darkblue\" vlink=\"darkblue\">");
        out.println("<h1 align=center><font color=\"darkblue\">MAHASISWA TERDAFTAR</font></h1>");

        List<Emp> list = EmpDao.getAllAccounts();

        out.print("<div class='view-wrapper'>");

        out.print("<table border='1' width='100%' bgcolor='lightgreen'>");
        out.print("<tr>"
                + "<th bgcolor='yellow' align='center'>Id</th>"
                + "<th bgcolor='yellow' align='center'>Nim</th>"
                + "<th bgcolor='yellow' align='center'>Nama</th>"
                + "<th bgcolor='yellow' align='center'>Alamat</th>"
                + "<th bgcolor='yellow' align='center'>Telp.</th>"
                + "<th bgcolor='yellow' align='center'>Jenis Kelamin</th>"
                + "<th bgcolor='yellow' align='center'>Agama</th>"
                + "<th bgcolor='yellow' align='center'>UBAH</th>"
                + "<th bgcolor='yellow' align='center'>HAPUS</th>"
                + "</tr>");

        for (Emp e : list) {
            out.print("<tr>"
                    + "<td align='center'>" + e.getId() + "</td>"
                    + "<td align='center'>" + e.getNim() + "</td>"
                    + "<td align='center'>" + e.getNama() + "</td>"
                    + "<td align='center'>" + e.getAlamat() + "</td>"
                    + "<td align='center'>" + e.getTelp() + "</td>"
                    + "<td align='center'>" + e.getJenkel() + "</td>"
                    + "<td align='center'>" + e.getAgama() + "</td>"
                    + "<td align='center'><a href='EditServlet?id=" + e.getId() + "'><button>UBAH</button></a></td>"
                    + "<td align='center'><a href='DeleteServlet?id=" + e.getId() + "'><button>HAPUS</button></a></td>"
                    + "</tr>");
        }
        out.print("</table>");
        out.print("<br>");
        out.println("<a href='index.html'><button>MENDAFTAR MAHASISWA</button></a>");
        out.print("</div>");
        out.close();
    }
}