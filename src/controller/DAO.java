package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import model.DocGia;

/**
 *
 * @author Tuong Nguyen
 */
public class DAO {
    protected Connection conn;

    public DAO() {
        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://A:/db_library.mdb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DAO();
    } 
}
