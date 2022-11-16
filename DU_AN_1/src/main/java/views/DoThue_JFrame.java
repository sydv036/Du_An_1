/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import domainmodel.KichThuoc;
import domainmodel.MauSac;
import domainmodel.NhaSanXuat;
import enumclass.trangThaiDoThue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelview.QLDoThue;
import service.Impl.DoThueServiceImpl;
import service.Impl.KichThuocServiceImpl;
import service.Impl.MauSacServiceImpl;
import service.Impl.NhaSanXuatServiceImpl;

/**
 *
 * @author Admin
 */
public class DoThue_JFrame extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel boxMaMS = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxMaKT = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxMaNSX = new DefaultComboBoxModel();
    private List<QLDoThue> listqLDoThues = new ArrayList<>();
    private List<MauSac> listMSS = new ArrayList<>();
    private List<KichThuoc> listKThuoc = new ArrayList<>();
    private List<NhaSanXuat> listNSXX = new ArrayList<>();
    private MauSacServiceImpl mauSacServiceImpl = new MauSacServiceImpl();
    private KichThuocServiceImpl kichThuocServiceImpl = new KichThuocServiceImpl();
    private NhaSanXuatServiceImpl nhaSanXuatServiceImpl = new NhaSanXuatServiceImpl();
    private DoThueServiceImpl doThueServiceImpl = new DoThueServiceImpl();

    /**
     * Creates new form DoThue_JFrame
     */
    public DoThue_JFrame() {
        initComponents();
        txtID.enable(false);
        LoadData();
        loadCbb();
    }

    private void LoadData() {
        Table.setModel(dtm = new DefaultTableModel());
        String[] deader = {"Id", "Mã Đồ Thuê", "Tên Đồ Thuê", "Mã Màu Sắc", "Mã Kích Thước", "Mã NSX", "Số Lượng", "Đơn giá", "Trạng Thái"};
        dtm.setColumnIdentifiers(deader);
        listqLDoThues = doThueServiceImpl.getAll();
        for (QLDoThue qldtt : listqLDoThues) {
            dtm.addRow(qldtt.toData());
        }
    }

    private void loadCbb() {
        cbbMaMauSac.setModel(boxMaMS);
        cbbMaKichThuoc.setModel(boxMaKT);
        cbbMaNSX.setModel(boxMaNSX);
        for (MauSac ms : mauSacServiceImpl.getAll()) {
            boxMaMS.addElement(ms.getMaMauSac());
        }
        for (KichThuoc ktt : kichThuocServiceImpl.getAll()) {
            boxMaKT.addElement(ktt.getMaSize());
        }
        for (NhaSanXuat nsxx : nhaSanXuatServiceImpl.getAll()) {
            boxMaNSX.addElement(nsxx.getMaNSX());
        }
    }

    private void fillData() {
        txtID.setText(String.valueOf(mouclick().getId()));
        txtMaDoThue.setText(mouclick().getMaDoThue());
        txtTenDoThue.setText(mouclick().getTenDoThue());
        cbbMaMauSac.setSelectedItem(mouclick().getMaMauSac());
        cbbMaKichThuoc.setSelectedItem(mouclick().getMaKichThuoc());
        cbbMaNSX.setSelectedItem(mouclick().getMaNhaSanXuat());
        txtSoLuong.setText(String.valueOf(mouclick().getSoLuong()));
        txtDonGia.setText(String.valueOf(mouclick().getDonGia()));
        trangThaiDoThue tthaiDoThue = mouclick().getTrangThai();
        if (tthaiDoThue == trangThaiDoThue.Con_Hang) {
            radioConHang.setSelected(true);
        } else {
            radioHetHang.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private QLDoThue mouclick() {
        int click = Table.getSelectedRow();
        return listqLDoThues.get(click);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbMaMauSac = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lbTenMauSac = new javax.swing.JLabel();
        txtMaDoThue = new javax.swing.JTextField();
        txtTenDoThue = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbbMaKichThuoc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        lbTenKichThuoc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbMaNSX = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        lbTenNSX = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        radioConHang = new javax.swing.JRadioButton();
        radioHetHang = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel2.setText("Mã Đồ Thuê");

        jLabel3.setText("Tên Đồ Thuê");

        jLabel4.setText("Số lượng");

        jLabel5.setText("Mã Màu Sắc");

        cbbMaMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaMauSacActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên Màu Sắc ");

        lbTenMauSac.setText("-");

        jLabel8.setText("Mã Kích Thước");

        cbbMaKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaKichThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaKichThuocActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên Kích Thước");

        lbTenKichThuoc.setText("-");

        jLabel11.setText("Mã Nhà Sản Xuất");

        cbbMaNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaNSXActionPerformed(evt);
            }
        });

        jLabel12.setText("Tên Nhà Sản Xuất");

        lbTenNSX.setText("-");

        jLabel14.setText("Đơn Giá");

        jLabel15.setText("Trạng Thái");

        buttonGroup1.add(radioConHang);
        radioConHang.setText("Còn Hàng");

        buttonGroup1.add(radioHetHang);
        radioHetHang.setText("Hết Hàng");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtMaDoThue)
                                                .addComponent(txtTenDoThue, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnDelete)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                    .addComponent(txtSoLuong))
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(radioConHang)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(radioHetHang)
                                        .addGap(9, 9, 9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbMaKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbTenKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTenNSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnUpdate)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDoThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbTenMauSac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(lbTenKichThuoc)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(lbTenNSX))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(radioConHang)
                    .addComponent(radioHetHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        JOptionPane.showMessageDialog(this, doThueServiceImpl.Delete(mouclick()));
        listqLDoThues.clear();
        LoadData();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String madoThue = txtMaDoThue.getText();
        String tenDoThue = txtTenDoThue.getText();
        String maMS = cbbMaMauSac.getSelectedItem().toString();
        String maKT = cbbMaKichThuoc.getSelectedItem().toString();
        String maNSX = cbbMaNSX.getSelectedItem().toString();
        String soLuong = txtSoLuong.getText();
        String donGia = txtDonGia.getText();
        trangThaiDoThue tdt = trangThaiDoThue.Con_Hang;
        if (radioHetHang.isSelected()) {
            tdt = trangThaiDoThue.Het_Hang;
        }
        QLDoThue qLDoThue = new QLDoThue(null, madoThue, tenDoThue, maKT, null, maMS, null, maNSX, null, Integer.valueOf(soLuong), Double.valueOf(donGia), tdt);
        JOptionPane.showMessageDialog(this, doThueServiceImpl.AddorUpdate(qLDoThue));
        listqLDoThues.clear();
        LoadData();
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbbMaMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaMauSacActionPerformed
        MauSac msss = mauSacServiceImpl.getOne(cbbMaMauSac.getSelectedItem().toString());
        lbTenMauSac.setText(msss.getTenMauSac());
    }//GEN-LAST:event_cbbMaMauSacActionPerformed

    private void cbbMaKichThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaKichThuocActionPerformed
        KichThuoc kthuoc = kichThuocServiceImpl.getOne(cbbMaKichThuoc.getSelectedItem().toString());
        lbTenKichThuoc.setText(String.valueOf(kthuoc.getSize()));
    }//GEN-LAST:event_cbbMaKichThuocActionPerformed

    private void cbbMaNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaNSXActionPerformed
        NhaSanXuat nsxxx = nhaSanXuatServiceImpl.getOne(cbbMaNSX.getSelectedItem().toString());
        lbTenNSX.setText(nsxxx.getTenNSX());
    }//GEN-LAST:event_cbbMaNSXActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String madoThue = txtMaDoThue.getText();
        String tenDoThue = txtTenDoThue.getText();
        String maMS = cbbMaMauSac.getSelectedItem().toString();
        String maKT = cbbMaKichThuoc.getSelectedItem().toString();
        String maNSX = cbbMaNSX.getSelectedItem().toString();
        String soLuong = txtSoLuong.getText();
        String donGia = txtDonGia.getText();
        trangThaiDoThue tdt = trangThaiDoThue.Con_Hang;
        if (radioHetHang.isSelected()) {
            tdt = trangThaiDoThue.Het_Hang;
        }
        QLDoThue qLDoThue = new QLDoThue(mouclick().getId(), madoThue, tenDoThue, maKT, null, maMS, null, maNSX, null, Integer.valueOf(soLuong), Double.valueOf(donGia), tdt);
        JOptionPane.showMessageDialog(this, doThueServiceImpl.AddorUpdate(qLDoThue));
        listqLDoThues.clear();
        LoadData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        fillData();
    }//GEN-LAST:event_TableMouseClicked

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
            java.util.logging.Logger.getLogger(DoThue_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoThue_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoThue_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoThue_JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoThue_JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaKichThuoc;
    private javax.swing.JComboBox<String> cbbMaMauSac;
    private javax.swing.JComboBox<String> cbbMaNSX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTenKichThuoc;
    private javax.swing.JLabel lbTenMauSac;
    private javax.swing.JLabel lbTenNSX;
    private javax.swing.JRadioButton radioConHang;
    private javax.swing.JRadioButton radioHetHang;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMaDoThue;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenDoThue;
    // End of variables declaration//GEN-END:variables
}
