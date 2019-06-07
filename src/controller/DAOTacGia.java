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
import model.TacGia;

/**
 *
 * @author Tuong Nguyen
 */
public class DAOTacGia extends DAO {

    public boolean themTacGia(TacGia tacGia) {
        try {
            String sql = "INSERT INTO TACGIA (TENTACGIA) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tacGia.getTenTacGia());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean xoaTacGia(TacGia tacGia) {
        String query = "SELECT * FROM SACH WHERE SACH.MATACGIA = "+tacGia.getMaTacGia();
        ArrayList arrayList = new DAOSach().layDuLieu(query);
        if(arrayList.size()>0){
            return false;
        }
        try {
            String sql = "DELETE FROM TACGIA WHERE MATACGIA = " + tacGia.getMaTacGia();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean capNhatTacGia(TacGia tacGia) {
        try {
            String sql = "UPDATE TACGIA "
                    + "SET TENTACGIA = ?"
                    + " WHERE MATACGIA = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tacGia.getTenTacGia());
            ps.setInt(2, tacGia.getMaTacGia());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<TacGia> layDuLieu(String query) {
        try {
            ArrayList<TacGia> arrlResult = new ArrayList<>();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TacGia tacGia = new TacGia();
                tacGia.setMaTacGia(rs.getInt("MATACGIA"));
                tacGia.setTenTacGia(rs.getString("TENTACGIA"));
                arrlResult.add(tacGia);
            }
            return arrlResult;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String tenTacGia(String maTacGia) {
        try {
            String sql = "SELECT TENTACGIA FROM TACGIA WHERE MATACGIA = '" + maTacGia + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return rs.getString("TENTACGIA");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int maTacGia(String tenTacGia) {
        try {
            String sql = "SELECT MATACGIA FROM TACGIA WHERE TENTACGIA = '" + tenTacGia + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            return rs.getInt("MATACGIA");
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public DefaultComboBoxModel ComboBoxModel() {
        try {
            DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
            String sql = "SELECT  TENTACGIA FROM TACGIA";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbModel.addElement(rs.getString("TENTACGIA"));
            }
            return cbModel;
        } catch (SQLException ex) {
            Logger.getLogger(DAONhaXuatBan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public DefaultTableModel tableModel() {
        try {
            DefaultTableModel tm = new DefaultTableModel();
            tm.setColumnIdentifiers(new Object[]{"Mã tác giả", "Tên tác giả"});
            String sql = "SELECT MATACGIA, TENTACGIA "
                    + "FROM TACGIA";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tm.addRow(new Object[]{rs.getString("MATACGIA"), rs.getString("TENTACGIA")});
            }
            rs.close();
            ps.close();
            conn.close();
            return tm;
        } catch (SQLException ex) {
            Logger.getLogger(DAOTacGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
