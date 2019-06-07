package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.DocGia;
import model.Sach;

/**
 *
 * @author Tuong Nguyen
 */
public class DAOMuonTraSach extends DAO {

    public DefaultTableModel tableModel(DocGia docGia) {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản"});
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
                    + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN, MUONSACH, DOCGIA "
                    + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
                    + "AND SACH.MANXB = NHAXUATBAN.MANXB "
                    + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
                    + "AND MUONSACH.SOTHE = DOCGIA.MADOCGIA "
                    + "AND SACH.MASACH = MUONSACH.MASACH "
                    + "AND MUONSACH.SOTHE = '" + docGia.getMaDocGia() + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MASACH"), rs.getString("TENSACH"), rs.getString("TENTACGIA"), rs.getString("TENTHELOAI"), rs.getString("TENNXB"), rs.getInt("NAMXUATBAN")});
            }
            rs.close();
            ps.close();
            conn.close();
            return tm;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public DefaultTableModel tableModel() {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản"});
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
                    + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN, MUONSACH, DOCGIA "
                    + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
                    + "AND SACH.MANXB = NHAXUATBAN.MANXB "
                    + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
                    + "AND MUONSACH.SOTHE = DOCGIA.MADOCGIA "
                    + "AND SACH.MASACH = MUONSACH.MASACH ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MASACH"), rs.getString("TENSACH"), rs.getString("TENTACGIA"), rs.getString("TENTHELOAI"), rs.getString("TENNXB"), rs.getInt("NAMXUATBAN")});
            }
            rs.close();
            ps.close();
            conn.close();
            return tm;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     public DefaultTableModel tableModelThongKe() {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã đọc giả","Tên đọc giả","Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản"});
            String sql = "SELECT MADOCGIA, TENDOCGIA,MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
                    + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN, MUONSACH, DOCGIA "
                    + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
                    + "AND SACH.MANXB = NHAXUATBAN.MANXB "
                    + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
                    + "AND MUONSACH.SOTHE = DOCGIA.MADOCGIA "
                    + "AND SACH.MASACH = MUONSACH.MASACH ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getInt("MADOCGIA"),rs.getString("TENDOCGIA"),rs.getString("MASACH"), rs.getString("TENSACH"), rs.getString("TENTACGIA"), rs.getString("TENTHELOAI"), rs.getString("TENNXB"), rs.getInt("NAMXUATBAN")});
            }
            rs.close();
            ps.close();
            conn.close();
            return tm;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean muonSach(DocGia docGia, Sach sach) {

        ArrayList arr = new DAOSach().layDuLieu("SELECT * FROM SACH WHERE MASACH = " + sach.getMaSach() + " AND SOLUONG > " + 0);
        if (arr.size() == 0) {
            return false;
        }
        String sql = "INSERT INTO MUONSACH (SOTHE, MASACH) "
                + "VALUES (?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, docGia.getMaDocGia());
            ps.setInt(2, sach.getMaSach());
            boolean result = ps.executeUpdate() > 0;
            if (result) {
                sach.setSoLuong(sach.getSoLuong() - 1);
                new DAOSach().capNhatThongTinSach(sach);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMuonTraSach.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean traSach(DocGia docGia, Sach sach) {
        try {
            String sql = "DELETE FROM MUONSACH "
                    + "WHERE SOTHE = ? "
                    + "AND MASACH = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, docGia.getMaDocGia());
            ps.setInt(2, sach.getMaSach());
            boolean result = ps.executeUpdate() > 0;
            if (result) {
                sach.setSoLuong(sach.getSoLuong() + 1);
                new DAOSach().capNhatThongTinSach(sach);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMuonTraSach.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList layDuLieu(String query) {
        try {
            ArrayList arrayList = new ArrayList();
            PreparedStatement ps = conn.prepareStatement(query);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object object = new Object[]{rs.getString("SOTHE"), rs.getString("MASACH")};
                arrayList.add(object);
            }
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(DAOMuonTraSach.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
