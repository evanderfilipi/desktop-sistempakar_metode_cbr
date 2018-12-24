/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp_kerusakan_motor;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Evander Filipi
 */
public class Form_Kecocokan extends javax.swing.JFrame {
    
    int id = 0;
    String cari = "";
    String cari2 = "";
    String cari3 = "";
    String kd_gejala = "";
    String nama_gejala = "";
    String kd_kerusakan = "";
    String nama_kerusakan = "";
    
    private void getDataKerusakan() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT kd_kerusakan AS `Kode Kerusakan`, nama_kerusakan AS `Nama Kerusakan` FROM tb_kerusakan");
            kerusakanTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void getDataPencarianKerusakan() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT kd_kerusakan AS `Kode Kerusakan`, nama_kerusakan AS `Nama Kerusakan` FROM tb_kerusakan WHERE kd_kerusakan like '%"+cari+"%' or nama_kerusakan like '%"+cari+"%'");
            kerusakanTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void getDataGejala() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT kd_gejala AS `Kode Gejala`, nama_gejala AS `Nama Gejala` FROM tb_gejala");
            gejalaTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void getDataPencarianGejala() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT kd_gejala AS `Kode Gejala`, nama_gejala AS `Nama Gejala` FROM tb_gejala WHERE kd_gejala like '%"+cari2+"%' or nama_gejala like '%"+cari2+"%'");
            gejalaTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void getDataKecocokan() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT id AS `ID`, kd_kerusakan AS `Kode Kerusakan`, nama_kerusakan AS `Nama Kerusakan`, kd_gejala AS `Kode Gejala`, nama_gejala AS `Nama Gejala` FROM tb_kecocokan ORDER BY kd_kerusakan ASC");
            kecocokanTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void getDataPencarianKecocokan() {
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT id AS `ID`, kd_kerusakan AS `Kode Kerusakan`, nama_kerusakan AS `Nama Kerusakan`, kd_gejala AS `Kode Gejala`, nama_gejala AS `Nama Gejala` FROM tb_kecocokan "
                    + "WHERE kd_kerusakan like '%"+cari3+"%' or nama_kerusakan like '%"+cari3+"%' or kd_gejala like '%"+cari3+"%' or nama_gejala like '%"+cari3+"%' ORDER BY kd_kerusakan ASC");
            kecocokanTbl.setModel(DbUtils.resultSetToTableModel(sql));
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void alur() {
        if ((kd_gejala.equals("") && kd_kerusakan.equals("")) || (kd_gejala.equals("") || kd_kerusakan.equals(""))) {
            inputBtn.setEnabled(false);
        } else {
            inputBtn.setEnabled(true);
        }
        if (id == 0){
            hapusBtn.setEnabled(false);
        } else {
            hapusBtn.setEnabled(true);
        }
    }
    
    

    /**
     * Creates new form Form_Kecocokan
     */
    public Form_Kecocokan() {
        initComponents();
        getDataKerusakan();
        getDataGejala();
        getDataKecocokan();
        alur();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
        jLabel1 = new javax.swing.JLabel();
        cari1Txt = new javax.swing.JTextField();
        cari1Btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        kerusakanTbl = new javax.swing.JTable();
        refresh1Btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cari2Txt = new javax.swing.JTextField();
        cari2Btn = new javax.swing.JButton();
        refresh2Btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        gejalaTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cari3Txt = new javax.swing.JTextField();
        cari3Btn = new javax.swing.JButton();
        refresh3Btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        kecocokanTbl = new javax.swing.JTable();
        inputBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Kecocokan");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Kerusakan"));

        jLabel1.setText("Cari Kode/Nama Kerusakan");

        cari1Btn.setText("CARI");
        cari1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari1BtnActionPerformed(evt);
            }
        });

        kerusakanTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Kerusakan", "Nama Kerusakan"
            }
        ));
        kerusakanTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kerusakanTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(kerusakanTbl);

        refresh1Btn.setText("REFRESH");
        refresh1Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh1BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari1Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refresh1Btn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cari1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari1Btn)
                    .addComponent(refresh1Btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Gejala"));

        jLabel2.setText("Cari Kode/Nama Gejala");

        cari2Btn.setText("CARI");
        cari2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari2BtnActionPerformed(evt);
            }
        });

        refresh2Btn.setText("REFRESH");
        refresh2Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh2BtnActionPerformed(evt);
            }
        });

        gejalaTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Gejala", "Nama Gejala"
            }
        ));
        gejalaTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gejalaTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(gejalaTbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cari2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari2Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refresh2Btn))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cari2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari2Btn)
                    .addComponent(refresh2Btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Kecocokan"));

        jLabel3.setText("Cari Kode/Nama Kerusakan/Gejala");

        cari3Btn.setText("CARI");
        cari3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari3BtnActionPerformed(evt);
            }
        });

        refresh3Btn.setText("REFRESH");
        refresh3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh3BtnActionPerformed(evt);
            }
        });

        kecocokanTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Kode Kerusakan", "Nama Kerusakan", "Kode Gejala", "Nama Gejala"
            }
        ));
        kecocokanTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kecocokanTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(kecocokanTbl);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari3Btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(refresh3Btn))
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cari3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari3Btn)
                    .addComponent(refresh3Btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3))
        );

        inputBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        inputBtn.setText("INPUT >>");
        inputBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBtnActionPerformed(evt);
            }
        });

        hapusBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hapusBtn.setText("<< HAPUS");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearBtn.setText("CLEAR ALL");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hapusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(inputBtn)
                        .addGap(51, 51, 51)
                        .addComponent(hapusBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cari1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari1BtnActionPerformed
        // TODO add your handling code here:
        cari = cari1Txt.getText();
        getDataPencarianKerusakan();
    }//GEN-LAST:event_cari1BtnActionPerformed

    private void cari2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari2BtnActionPerformed
        // TODO add your handling code here:
        cari2 = cari2Txt.getText();
        getDataPencarianGejala();
    }//GEN-LAST:event_cari2BtnActionPerformed

    private void cari3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari3BtnActionPerformed
        // TODO add your handling code here:
        cari3 = cari3Txt.getText();
        getDataPencarianKecocokan();
    }//GEN-LAST:event_cari3BtnActionPerformed

    private void refresh1BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh1BtnActionPerformed
        // TODO add your handling code here:
        getDataKerusakan();
        cari1Txt.setText("");
        cari = "";
        kd_kerusakan = "";
        nama_kerusakan = "";
        alur();
    }//GEN-LAST:event_refresh1BtnActionPerformed

    private void refresh2BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh2BtnActionPerformed
        // TODO add your handling code here:
        getDataGejala();
        cari2Txt.setText("");
        cari2 = "";
        kd_gejala = "";
        nama_gejala = "";
        alur();
    }//GEN-LAST:event_refresh2BtnActionPerformed

    private void refresh3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh3BtnActionPerformed
        // TODO add your handling code here:
        getDataKecocokan();
        cari3Txt.setText("");
        cari3 = "";
        id = 0;
        alur();
    }//GEN-LAST:event_refresh3BtnActionPerformed

    private void gejalaTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gejalaTblMouseClicked
        // TODO add your handling code here:
        try {
            int row = gejalaTbl.getSelectedRow();
            String kliktabel=(gejalaTbl.getModel().getValueAt(row,0).toString());
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_gejala WHERE kd_gejala='"+kliktabel+"'");

            if (sql.next()) {
                kd_gejala = sql.getString("kd_gejala");
                nama_gejala = sql.getString("nama_gejala");
                alur();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_gejalaTblMouseClicked

    private void kerusakanTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kerusakanTblMouseClicked
        // TODO add your handling code here:
        try {
            int row = kerusakanTbl.getSelectedRow();
            String kliktabel=(kerusakanTbl.getModel().getValueAt(row,0).toString());
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_kerusakan WHERE kd_kerusakan='"+kliktabel+"'");

            if (sql.next()) {
                kd_kerusakan = sql.getString("kd_kerusakan");
                nama_kerusakan = sql.getString("nama_kerusakan");
                alur();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_kerusakanTblMouseClicked

    private void kecocokanTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kecocokanTblMouseClicked
        // TODO add your handling code here:
        try {
            int row = kecocokanTbl.getSelectedRow();
            String kliktabel=(kecocokanTbl.getModel().getValueAt(row,0).toString());
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_kecocokan WHERE id='"+kliktabel+"'");

            if (sql.next()) {
                id = sql.getInt("id");
                alur();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_kecocokanTblMouseClicked

    private void inputBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBtnActionPerformed
        // TODO add your handling code here:
        int idnya = 0;
        String cek_kd1 = "";
        String cek_kd2 = "";
        try {
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sqll = stm.executeQuery("SELECT kd_kerusakan, kd_gejala FROM tb_kecocokan WHERE kd_kerusakan='"+kd_kerusakan+"' AND kd_gejala='"+kd_gejala+"'");        
            if (sqll.next()) {
               cek_kd1 = sqll.getString("kd_kerusakan");
               cek_kd2 = sqll.getString("kd_gejala");
            } else {}
            if (kd_kerusakan.equals(cek_kd1) && kd_gejala.equals(cek_kd2)){
                JOptionPane.showMessageDialog(null, "Data kerusakan dan gejala yang diinput sudah ada!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);    
            } else {
                String sql = "INSERT INTO tb_kecocokan VALUES('"+idnya+"','"+kd_kerusakan+"','"+nama_kerusakan+"','"+kd_gejala+"','"+nama_gejala+"')";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                getDataKecocokan();
            }
        } catch (SQLException | HeadlessException e){
                JOptionPane.showMessageDialog(null, "Gagal menginput!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_inputBtnActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM tb_kecocokan WHERE id='"+id+"'";
            java.sql.Connection conn = (java.sql.Connection)Koneksi_DB.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            id = 0;
            getDataPencarianKecocokan();
            alur();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus!","Pemberitahuan",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        getDataKerusakan();
        getDataGejala();
        getDataKecocokan();
        cari1Txt.setText("");
        cari = "";
        kd_kerusakan = "";
        nama_kerusakan = "";
        cari2Txt.setText("");
        cari2 = "";
        kd_gejala = "";
        nama_gejala = "";
        cari3Txt.setText("");
        cari3 = "";
        id = 0;
        alur();
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Kecocokan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Kecocokan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Kecocokan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Kecocokan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Kecocokan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari1Btn;
    private javax.swing.JTextField cari1Txt;
    private javax.swing.JButton cari2Btn;
    private javax.swing.JTextField cari2Txt;
    private javax.swing.JButton cari3Btn;
    private javax.swing.JTextField cari3Txt;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable gejalaTbl;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JButton inputBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable kecocokanTbl;
    private javax.swing.JTable kerusakanTbl;
    private javax.swing.JButton refresh1Btn;
    private javax.swing.JButton refresh2Btn;
    private javax.swing.JButton refresh3Btn;
    // End of variables declaration//GEN-END:variables
}
