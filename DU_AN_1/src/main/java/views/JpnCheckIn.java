/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import domainmodel.PhieuDatLich;
import enumclass.trangThaiPhieuDL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelview.QLAcount;
import service.IPhieuDatLichService;
import service.Impl.PhieuDatLichServiceImpl;

/**
 *
 * @author ASUS
 */
public class JpnCheckIn extends javax.swing.JPanel {

    private Map<String, PhieuDatLich> map = new HashMap<>();
    private IPhieuDatLichService phieuDatLichService = new PhieuDatLichServiceImpl();
    private QLAcount qLAcount;
    private JPanel pnTong;
    private JLabel lbHome;
    private DefaultTableModel tableModel;
    private List<PhieuDatLich> listPhieuDatLich = new ArrayList<>();
    private PhieuDatLich phieuDL = new PhieuDatLich();
    private Date ngayTao;


    /**
     * Creates new form JpnCheckIn
     */
    public JpnCheckIn(QLAcount qLAcount, JPanel pnTong, JLabel lbHome,Date ngayTao) {
        initComponents();
        this.ngayTao= ngayTao;
        this.pnTong = pnTong;
        this.qLAcount = qLAcount;
        this.lbHome = lbHome;
        tableModel = (DefaultTableModel) jTable1.getModel();
        listPhieuDatLich = phieuDatLichService.getPhieuDatLichByTT();
        for (PhieuDatLich phieuDatLich : listPhieuDatLich) {
            map.put(phieuDatLich.getKhachHang().getSoDienThoai(), phieuDatLich);
        }
        showData(listPhieuDatLich);
        iTemChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmPhieuDatSan(phieuDL, qLAcount, pnTong, lbHome).setVisible(true);
                PopupMenu.setVisible(false);
            }
        });
        iTemDoiLich.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrmDoiLichDat(phieuDL,qLAcount,pnTong,lbHome,ngayTao).setVisible(true);
                PopupMenu.setVisible(false);
            }
        });
        iTemHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int checkOption = JOptionPane.showConfirmDialog(pnTong, "Xác nhận hủy lịch đặt", "Thông Báo", JOptionPane.YES_NO_OPTION);
                if (checkOption == JOptionPane.YES_OPTION) {
                    phieuDL.setTrangThai(trangThaiPhieuDL.DA_HUY);
                    String check = phieuDatLichService.updateTrangThai(phieuDL);
                    if (check.equals("Sửa Trạng Thái Thành Công")) {
                        JOptionPane.showMessageDialog(pnTong, "Đã hủy lịch đặt");
                        listPhieuDatLich = phieuDatLichService.getPhieuDatLichByTT();
                        showData(listPhieuDatLich);
                    }
                }
                PopupMenu.setVisible(false);
            }
        });
    }

    private Object[] billData(PhieuDatLich phieuDatLich) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String ngayDenSan = sdf.format(phieuDatLich.getNgayDenSan());
        return new Object[]{phieuDatLich.getKhachHang().getTenKhachHang(), phieuDatLich.getKhachHang().getSoDienThoai(),
            phieuDatLich.getSanCa().getCa().getThoiGianBatDau() + "-" + phieuDatLich.getSanCa().getCa().getThoiGianKetThuc(),
            ngayDenSan, phieuDatLich.getSanCa().getSanbong().getLoaiSan().getTenLoaiSan(), phieuDatLich.getTongTienSan()};
    }

    private void showData(List<PhieuDatLich> listPDL) {
        tableModel.setNumRows(0);
        for (PhieuDatLich phieuDatLich : listPDL) {
            tableModel.addRow(billData(phieuDatLich));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenu = new javax.swing.JPopupMenu();
        iTemChiTiet = new javax.swing.JMenuItem();
        iTemDoiLich = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        iTemHuy = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnXemchitiet = new javax.swing.JButton();
        btnDoiLich = new javax.swing.JButton();
        btnHuyLD = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new utill.SearchText();
        jLabel2 = new javax.swing.JLabel();

        iTemChiTiet.setText("Xem chi tiết");
        PopupMenu.add(iTemChiTiet);

        iTemDoiLich.setText("Đổi lịch đặt");
        PopupMenu.add(iTemDoiLich);
        PopupMenu.add(jSeparator1);

        iTemHuy.setText("Hủy lịch đặt");
        PopupMenu.add(iTemHuy);

        setBackground(new java.awt.Color(186, 228, 229));

        jPanel1.setBackground(new java.awt.Color(65, 147, 169));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên KH", "SDT", "Thời Gian nhận sân", "Ngày nhận sân", "Loại sân", "Tiền sân"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        btnXemchitiet.setBackground(new java.awt.Color(51, 102, 255));
        btnXemchitiet.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXemchitiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemchitiet.setText("Xem chi tiết");
        btnXemchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemchitietActionPerformed(evt);
            }
        });

        btnDoiLich.setBackground(new java.awt.Color(51, 102, 255));
        btnDoiLich.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDoiLich.setForeground(new java.awt.Color(255, 255, 255));
        btnDoiLich.setText("Đổi lịch đặt");
        btnDoiLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiLichActionPerformed(evt);
            }
        });

        btnHuyLD.setBackground(new java.awt.Color(255, 51, 51));
        btnHuyLD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHuyLD.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyLD.setText("Hủy lịch đặt");
        btnHuyLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyLDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiLich, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemchitiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHuyLD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnXemchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnDoiLich, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnHuyLD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("SĐT Khách Hàng:");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 366, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(211, 211, 211))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quản Lí Khách Hàng Check In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(456, 456, 456)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


    }//GEN-LAST:event_jTable1MouseClicked

    private void btnXemchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemchitietActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTable1.getSelectedRow();
            PhieuDatLich phieuDatLich = listPhieuDatLich.get(row);
            new FrmPhieuDatSan(phieuDatLich, qLAcount, pnTong, lbHome).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chọn lên table");
        }
    }//GEN-LAST:event_btnXemchitietActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtSearch.getText().isBlank()) {
                listPhieuDatLich = phieuDatLichService.getPhieuDatLichBySDT(txtSearch.getText());
            } else {
                listPhieuDatLich = phieuDatLichService.getPhieuDatLichByTT();
            }
            showData(listPhieuDatLich);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnHuyLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyLDActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTable1.getSelectedRow();
            PhieuDatLich phieuDatLich = listPhieuDatLich.get(row);
            int checkOption = JOptionPane.showConfirmDialog(this, "Xác nhận hủy lịch đặt", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (checkOption == JOptionPane.YES_OPTION) {
                phieuDatLich.setTrangThai(trangThaiPhieuDL.DA_HUY);
                String check = phieuDatLichService.updateTrangThai(phieuDatLich);
                if (check.equals("Sửa Trạng Thái Thành Công")) {
                    JOptionPane.showMessageDialog(this, "Đã hủy lịch đặt");
                    listPhieuDatLich = phieuDatLichService.getPhieuDatLichByTT();
                    showData(listPhieuDatLich);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chọn lên table");
        }
    }//GEN-LAST:event_btnHuyLDActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Xin mời chọn dòng");
            return;
        }
        if (evt.isPopupTrigger()) {
            phieuDL = listPhieuDatLich.get(index);
            PopupMenu.show(jTable1, evt.getPoint().x, evt.getPoint().y);
        }

    }//GEN-LAST:event_jTable1MouseReleased

    private void btnDoiLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiLichActionPerformed
        // TODO add your handling code here:
        try {
            int row = jTable1.getSelectedRow();
            PhieuDatLich phieuDatLich = listPhieuDatLich.get(row);
            new FrmDoiLichDat(phieuDL,qLAcount,pnTong,lbHome,ngayTao).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chọn lên table");
        }
    }//GEN-LAST:event_btnDoiLichActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JButton btnDoiLich;
    private javax.swing.JButton btnHuyLD;
    private javax.swing.JButton btnXemchitiet;
    private javax.swing.JMenuItem iTemChiTiet;
    private javax.swing.JMenuItem iTemDoiLich;
    private javax.swing.JMenuItem iTemHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private utill.SearchText txtSearch;
    // End of variables declaration//GEN-END:variables
}
