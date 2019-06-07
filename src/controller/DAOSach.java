package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Sach;

/**
 *
 * @author Tuong Nguyen
 */
public class DAOSach extends DAO {

    public boolean themSach(Sach sach) {
        if (new DAOSach().layDuLieu("SELECT * FROM SACH WHERE TENSACH LIKE '" + sach.getTenSach() + "'").size() > 0) {
            return false;
        }
        try {
            String sql = "INSERT INTO SACH (TENSACH, MATACGIA, MATHELOAI, MANXB, NAMXUATBAN, SOLUONG)"
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setInt(2, sach.getMaTacGia());
            ps.setInt(3, sach.getMaTheLoai());
            ps.setInt(4, sach.getMaNXB());
            ps.setInt(5, sach.getNamXuatBan());
            ps.setInt(6, sach.getSoLuong());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean xoaSach(Sach sach) {
        String query = "SELECT * FROM MUONSACH WHERE MASACH = " +sach.getMaSach();
        ArrayList arrayList = new DAOMuonTraSach().layDuLieu(query);
        if(arrayList.size()>0){
            return false;
        }
        try {
            String sql = "DELETE FROM SACH WHERE MASACH = " + sach.getMaSach();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean capNhatThongTinSach(Sach sach) {
        try {
            String sql = "UPDATE SACH "
                    + "SET TENSACH = ?, "
                    + "MATACGIA = ?, "
                    + "MATHELOAI = ?, "
                    + "MANXB = ?, "
                    + "NAMXUATBAN = ?, "
                    + "SOLUONG = ? "
                    + "WHERE MASACH = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sach.getTenSach());
            ps.setInt(2, sach.getMaTacGia());
            ps.setInt(3, sach.getMaTheLoai());
            ps.setInt(4, sach.getMaNXB());
            ps.setInt(5, sach.getNamXuatBan());
            ps.setInt(6, sach.getSoLuong());
            ps.setInt(7, sach.getMaSach());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Sach> layDuLieu(String query) {
        try {
            ArrayList<Sach> arrlKetQua = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sach sach = new Sach();
                sach.setMaSach(rs.getInt("MASACH"));
                sach.setTenSach(rs.getString("TENSACH"));
                sach.setMaTacGia(rs.getInt("MATACGIA"));
                sach.setMaTheLoai(rs.getInt("MATHELOAI"));
                sach.setMaNXB(rs.getInt("MANXB"));
                sach.setNamXuatBan(rs.getInt("NAMXUATBAN"));
                sach.setSoLuong(rs.getInt("SOLUONG"));
                arrlKetQua.add(sach);
            }
            return arrlKetQua;

        } catch (SQLException ex) {
            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public DefaultTableModel TableModel() {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng"});
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
                    + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
                    + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
                    + "AND SACH.MANXB = NHAXUATBAN.MANXB "
                    + "AND SACH.MATHELOAI = THELOAI.MATHELOAI ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MASACH"), rs.getString("TENSACH"), rs.getString("TENTACGIA"), rs.getString("TENTHELOAI"), rs.getString("TENNXB"), rs.getInt("NAMXUATBAN"), rs.getInt("SOLUONG")});
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

//    public DefaultTableModel SearchResultTableModel(String query) {
//        try {
//            DefaultTableModel tm = new DefaultTableModel();
//            tm.setColumnIdentifiers(new Object[]{"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng"});
//            PreparedStatement ps = conn.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String tenTacGia = new DAOTacGia().tenTacGia(rs.getString("MATACGIA"));
//                String tenTheLoai = new DAOTheLoai().tenTheLoai(rs.getString("MATHELOAI"));
//                String tenNhaXuatBan = new DAONhaXuatBan().tenNhaXuatBan(rs.getString("MANXB"));
//                tm.addRow(new Object[]{rs.getString("MASACH"), rs.getString("TENSACH"), tenTacGia, tenTheLoai, tenNhaXuatBan, rs.getInt("NAMXUATBAN"), rs.getInt("SOLUONG")});
//            }
//            rs.close();
//            ps.close();
//            conn.close();
//            return tm;
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOSach.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }
    public DefaultTableModel searchResultTableModel(String query) {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng"});
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getInt("MASACH"), rs.getString("TENSACH"), rs.getString("TENTACGIA"), rs.getString("TENTHELOAI"), rs.getString("TENNXB"), rs.getInt("NAMXUATBAN"), rs.getInt("SOLUONG")});
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

}
