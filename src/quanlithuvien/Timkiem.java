/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlithuvien;

//import controller.DAONhaXuatBan;
//import controller.DAOSach;
//import controller.DAOTacGia;
//import controller.DAOTheLoai;
//import java.awt.Color;
//import java.util.ArrayList;
//import javax.swing.BorderFactory;
//import javax.swing.JOptionPane;
//import javax.swing.border.Border;
//import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author viet hoa
 */
public class Timkiem extends javax.swing.JFrame {

    /**
     * Creates new form Timkiem
     */
    public Timkiem() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbSearchOption = new javax.swing.JComboBox<>();
        txtNamXuatBan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        cbLoaiSach = new javax.swing.JComboBox<>();
        cbTacGia = new javax.swing.JComboBox<>();
        cbNhaXuatBan = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSearchResult = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mã sách");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tên sách");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Loại sách");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tác giả");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nhà xuất bản");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tìm kiếm");

        cbSearchOption.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbSearchOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn thuộc tính cần tìm", "Mã sách", "Tên sách", "Loại sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản" }));
        cbSearchOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSearchOptionActionPerformed(evt);
            }
        });

        txtNamXuatBan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtNamXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamXuatBanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Năm XB");

        txtMaSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaSach.setText(" ");

        txtTenSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbLoaiSach.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbLoaiSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbTacGia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbTacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbNhaXuatBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbNhaXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jButton1.setText("QUAY LẠI TRANG CHỦ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbTacGia, 0, 336, Short.MAX_VALUE)
                    .addComponent(cbLoaiSach, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSearchOption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbNhaXuatBan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(111, 111, 111)
                        .addComponent(btnTimKiem)))
                .addGap(63, 63, 63))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSearchOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(jButton1))
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tbSearchResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng"
            }
        ));
        tbSearchResult.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jScrollPane2.setViewportView(tbSearchResult);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("TÌM KIẾM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSearchOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSearchOptionActionPerformed
//        setEnableFalse();
//        setValues();

        if (cbSearchOption.getSelectedItem().equals("Mã sách")) {
            txtMaSach.setEnabled(true);
        } else if (cbSearchOption.getSelectedItem().equals("Tên sách")) {
            txtTenSach.setEnabled(true);
        } else if (cbSearchOption.getSelectedItem().equals("Loại sách")) {
            cbLoaiSach.setEnabled(true);
        } else if (cbSearchOption.getSelectedItem().equals("Nhà xuất bản")) {
            cbNhaXuatBan.setEnabled(true);
        } else if (cbSearchOption.getSelectedItem().equals("Năm xuất bản")) {
            txtNamXuatBan.setEnabled(true);
        }
        if (cbSearchOption.getSelectedItem().equals("Tác giả")) {
            cbTacGia.setEnabled(true);
        }
    }//GEN-LAST:event_cbSearchOptionActionPerformed

    private void txtNamXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamXuatBanActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (cbSearchOption.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức tìm kiếm");
            return;
        }
        if (txtMaSach.isEnabled()) {
            if (txtMaSach.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách cần tìm");
                return;
            }
            String sql = "SELECT * FROM SACH, TACGIA, THELOAI, NHAXUATBAN WHERE MASACH = " + txtMaSach.getText();
            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        } else if (txtNamXuatBan.isEnabled()) {
            if (txtNamXuatBan.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xuất bản cần tìm");
                return;
            } else {
                try {
                    Integer.parseInt(txtNamXuatBan.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Năm xuất bản không hợp lệ");
                    return;
                }
            }
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
            + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
            + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
            + "AND SACH.MANXB = NHAXUATBAN.MANXB "
            + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
            + "AND NAMXUATBAN = " + txtNamXuatBan.getText();
            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        } else if (txtTenSach.isEnabled()) {
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
            + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
            + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
            + "AND SACH.MANXB = NHAXUATBAN.MANXB "
            + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
            + "AND TENSACH = '" + txtTenSach.getText() + "'";

            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        } else if (cbLoaiSach.isEnabled()) {
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
            + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
            + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
            + "AND SACH.MANXB = NHAXUATBAN.MANXB "
            + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
            + "AND TENTHELOAI = '" + cbLoaiSach.getSelectedItem() + "';";
            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        } else if (cbNhaXuatBan.isEnabled()) {
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
            + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
            + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
            + "AND SACH.MANXB = NHAXUATBAN.MANXB "
            + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
            + "AND TENNXB = '" + cbNhaXuatBan.getSelectedItem() + "';";
            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        } else if (cbTacGia.isEnabled()) {
            String sql = "SELECT MASACH,TENSACH, TENTACGIA, TENNXB, TENTHELOAI,NAMXUATBAN,SOLUONG "
            + "FROM SACH, THELOAI, TACGIA, NHAXUATBAN "
            + "WHERE SACH.MATACGIA = TACGIA.MATACGIA "
            + "AND SACH.MANXB = NHAXUATBAN.MANXB "
            + "AND SACH.MATHELOAI = THELOAI.MATHELOAI "
            + "AND TENTACGIA = '" + cbTacGia.getSelectedItem() + "';";
            tbSearchResult.setModel(new DAOSach().searchResultTableModel(sql));
        }
        if (tbSearchResult.getModel().getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Giaodienchinh timkiem= new Giaodienchinh();
        timkiem.setVisible(true);
        this.dispose();
                        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Timkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Timkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Timkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Timkiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Timkiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbLoaiSach;
    private javax.swing.JComboBox<String> cbNhaXuatBan;
    private javax.swing.JComboBox<String> cbSearchOption;
    private javax.swing.JComboBox<String> cbTacGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbSearchResult;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
