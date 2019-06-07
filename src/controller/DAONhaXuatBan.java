package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.NhaXuatBan;

/**
 *
 * @author Tuong Nguyen
 */
public class DAONhaXuatBan extends DAO {

    public boolean themNhaXuatBan(NhaXuatBan nxb) {
        try {
            String sql = "INSERT INTO NHAXUATBAN (TENNXB, DIACHI)"
                    + "VALUES (?, ?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nxb.getTenNhaXuatBan());
            ps.setString(2, nxb.getDiaChi());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean xoaNhaXuatBan(NhaXuatBan nxb) {
        String query = "SELECT * FROM SACH WHERE MANXB = "+nxb.getMaNhaXuatBan();
        ArrayList arrayList = new DAOSach().layDuLieu(query);
        if(arrayList.size()>0){
            return false;
        }
        try {
            String sql = "DELETE FROM NHAXUATBAN WHERE MANXB = " + nxb.getMaNhaXuatBan();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean capNhatThongTinNhaXuatBan(NhaXuatBan nxb) {
        try {
            String sql = "UPDATE NHAXUATBAN "
                    + "SET TENNXB = ?, "
                    + "DIACHI = ?"
                    + "WHERE MANXB = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nxb.getTenNhaXuatBan());
            ps.setString(2, nxb.getDiaChi());
            ps.setInt(3, nxb.getMaNhaXuatBan());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<NhaXuatBan> layDuLieu(String query) {
        try {
            ArrayList<NhaXuatBan> arrlKetQua = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setMaNhaXuatBan(rs.getInt("MANXB"));
                nxb.setTenNhaXuatBan(rs.getString("TENNXB"));
                arrlKetQua.add(nxb);
            }
            return arrlKetQua;
        } catch (SQLException ex) {
            ex.getMessage();
            return null;
        }

    }

    public String tenNhaXuatBan(String maNhaXuatBan) {
        try {
            String sql = "SELECT TENNXB FROM NHAXUATBAN WHERE MANXB = '" + maNhaXuatBan+"'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return rs.getString("TENNXB");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int maNhaXuatBan(String tenNhaXuatBan) {
        try {
            String sql = "SELECT MANXB FROM NHAXUATBAN WHERE TENNXB = '" + tenNhaXuatBan + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt("MANXB");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public DefaultComboBoxModel ComboBoxModel() {
        try {
            DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
            String sql = "SELECT  TENNXB FROM NHAXUATBAN";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbModel.addElement(rs.getString("TENNXB"));
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
            tm.setColumnIdentifiers(new Object[]{"Mã NXB", "Tên NXB", "Địa chỉ"});
            String sql = "SELECT * FROM  NHAXUATBAN";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MANXB"), rs.getString("TENNXB"), rs.getString("DIACHI")});
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
