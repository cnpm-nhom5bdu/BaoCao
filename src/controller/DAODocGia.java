package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.DateFormater;
import model.DocGia;

/**
 *
 * @author Tuong Nguyen
 */
public class DAODocGia extends DAO {

    public boolean themDocGia(DocGia docGia) {
        try {
            String sql = "INSERT INTO DOCGIA (TENDOCGIA, NGAYSINH, GIOITINH) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, docGia.getTenDocGia());
            ps.setDate(2, DateFormater.formatStringToSqlDate(docGia.getNgaySinh()));
            ps.setString(3, docGia.getGioiTinh());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean xoaDocGia(DocGia docGia) {
        String query = "SELECT * FROM MUONSACH WHERE SOTHE = "+docGia.getMaDocGia();
        ArrayList arrayList = new DAOMuonTraSach().layDuLieu(query);
        if(arrayList.size()>0){
            return false;
        }
        try {
            String sql = "DELETE FROM DOCGIA WHERE MADOCGIA = " + docGia.getMaDocGia();
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps.executeUpdate(sql) > 0;
        } catch (Exception ex) {
            ex.getMessage();
            return false;
        }

    }

    public boolean capNhatThongTinDocGia(DocGia docGia) {
        try {
            String sql = "UPDATE DOCGIA SET "
                    + "TENDOCGIA = ?, "
                    + "NGAYSINH = ? ,"
                    + "GIOITINH = ? "
                    + "WHERE MADOCGIA =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, docGia.getTenDocGia());
            ps.setString(2, DateFormater.formatDateToString(docGia.getNgaySinh()));
            ps.setString(3, docGia.getGioiTinh());
            ps.setInt(4, docGia.getMaDocGia());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAODocGia.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ArrayList<DocGia> layDuLieu(String query) {
        ArrayList<DocGia> arrlKetQua = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DocGia docGia = new DocGia();
                docGia.setMaDocGia(rs.getInt("MADOCGIA"));
                docGia.setTenDocGia(rs.getString("TENDOCGIA"));

                String[] arr  = rs.getString("NGAYSINH").split(" ");

                docGia.setNgaySinh(DateFormater.formatStringToDate(arr[0]));
                docGia.setGioiTinh(rs.getString("GIOITINH"));
                arrlKetQua.add(docGia);
            }
            return arrlKetQua;
        } catch (SQLException ex) {
            ex.getMessage();
            return null;
        }
    }
    
    public DefaultTableModel tableModel(){
        DefaultTableModel tableModel = new DefaultTableModel();
        try {
            tableModel.setColumnIdentifiers(new Object[]{"Mã đọc giả", "Tên đọc giả", "Ngày sinh", "Giới tính"});
            String sql =  "SELECT * FROM DOCGIA";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String[]arrS = rs.getString("NGAYSINH").split(" ");
                tableModel.addRow(new Object[]{rs.getString("MADOCGIA"), rs.getString("TENDOCGIA"), DateFormater.format(arrS[0]),rs.getString("GIOITINH")});
            }
            ps.close();
            conn.close();
            return tableModel;
        } catch (SQLException ex) {
            Logger.getLogger(DAODocGia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args) {
        DocGia docGia = new DocGia();

        docGia.setGioiTinh("Nam");
        docGia.setTenDocGia("Tường Nguyễn");
        new DAODocGia().themDocGia(docGia);
    }
}
