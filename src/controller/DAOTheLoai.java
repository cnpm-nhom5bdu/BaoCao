package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.TheLoai;

/**
 *
 * @author Tuong Nguyen
 */
public class DAOTheLoai extends DAO {

    public boolean themTheLoai(TheLoai theLoai) {
        try {
            String sql = "INSERT INTO THELOAI (TENTHELOAI) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, theLoai.getTenTheloai());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean xoaTheLoai(TheLoai theLoai) {
        String query = "SELECT * FROM SACH WHERE MATHELOAI = "+theLoai.getMaTheLoai();
        ArrayList arrayList = new DAOSach().layDuLieu(query);
        if(arrayList.size()>0){
            return false;
        }
        try {
            String sql = "DELETE FROM THELOAI WHERE MATHELOAI = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, theLoai.getMaTheLoai());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean capNhatTheLoai(TheLoai theLoai) {
        try {
            String sql = "UPDATE THELOAI "
                    + "SET TENTHELOAI = ? "
                    + "WHERE MATHELOAI = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, theLoai.getTenTheloai());
            ps.setInt(2, theLoai.getMaTheLoai());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<TheLoai> layDuLieu(String query) {
        try {
            ArrayList<TheLoai> arrlResult = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setMaTheLoai(rs.getInt("MATHELOAI"));
                theLoai.setTenTheloai(rs.getString("TENTHELOAI"));
                arrlResult.add(theLoai);
            }
            return arrlResult;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTheLoai.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String tenTheLoai(String maTheLoai) {
        try {
            String sql = "SELECT TENTHELOAI FROM THELOAI WHERE MATHELOAI = '" + maTheLoai+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return rs.getString("TENTHELOAI");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int maTheLoai(String tenTheLoai) {
        try {
            String sql = "SELECT MATHELOAI FROM THELOAI WHERE TENTHELOAI = '" + tenTheLoai + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt("MATHELOAI");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public DefaultComboBoxModel ComboBoxModel() {
        try {
            DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
            String sql = "SELECT  TENTHELOAI FROM THELOAI";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbModel.addElement(rs.getString("TENTHELOAI"));
            }

            return cbModel;
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public DefaultTableModel tableModel(){
                try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã thể loại", "Tên thể loại"});
            String sql = "SELECT MATHELOAI,TENTHELOAI "
                    + "FROM  THELOAI";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MATHELOAI"), rs.getString("TENTHELOAI")});
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
