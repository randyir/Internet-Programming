import java.util.*;
import java.sql.*;

public class EmpDao {    
    //connect to mysql
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_uas_java", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //save data
    public static int save(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO user (nim, nama, alamat, telp, jenkel, agama) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, e.getNim());
            ps.setString(2, e.getNama());
            ps.setString(3, e.getAlamat());
            ps.setString(4, e.getTelp());
            ps.setString(5, e.getJenkel());
            ps.setString(6, e.getAgama());
            //lanjut disini
            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //mengubah data di database
    public static int update(Emp e) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE user SET nim=?, nama=?, alamat=?, telp=?, jenkel=?, agama=? WHERE id=?");
            ps.setString(1, e.getNim());
            ps.setString(2, e.getNama());
            ps.setString(3, e.getAlamat());
            ps.setString(4, e.getTelp());
            ps.setString(5, e.getJenkel());
            ps.setString(6, e.getAgama());
            ps.setInt(5, e.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    //menghapus data di database
    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    //menampilkan data berdasarkan id
    public static Emp getAccountById(int id) {
        Emp e = new Emp();

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setNim(rs.getString(2));
                e.setNama(rs.getString(3));
                e.setAlamat(rs.getString(4));
                e.setTelp(rs.getString(5));
                e.setJenkel(rs.getString(6));
                e.setAgama(rs.getString(7));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<Emp> getAllAccounts() {
        List<Emp> list = new ArrayList<Emp>();

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setNim(rs.getString(2));
                e.setNama(rs.getString(3));
                e.setAlamat(rs.getString(4));
                e.setTelp(rs.getString(5));
                e.setJenkel(rs.getString(6));
                e.setAgama(rs.getString(7));
                list.add(e);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}