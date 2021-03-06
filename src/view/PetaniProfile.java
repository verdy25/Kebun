/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author verdy
 */
public class PetaniProfile extends javax.swing.JPanel {

    /**
     * Creates new form PetaniProfile
     */
    public PetaniProfile() {
        initComponents();
    }
    
    public void nama(String x){
        nama.setText(x);
    }
    
    public void password(String x){
        password.setText(x);
    }
    
    public void email(String x){
        email.setText(x);
    }
    
    public void hp(String x){
        hp.setText(x);
    }
    
    public void telp(String x){
        telp.setText(x);
    }
    
    public void nama_perusahaan(String x){
        nama_perusahaan.setText(x);
    }
    
    public void propinsi(String x){
        cbProvinsi.setSelectedItem(x);
    }
    
    public void listPropinsi(List<String> x){
        cbProvinsi.setModel(new DefaultComboBoxModel(x.toArray()));
    }
    
    public void kota(String x){
        kota.setText(x);
    }
        
    public void kecamatan(String x){
        kecamatan.setText(x);
    }
    
    
    public void alamat(String x){
        alamat.setText(x);
    }
    
    public void kodepos(String x){
        kodepos.setText(x);
    }
    
    public void deskripsi(String x){
        deskripsi.setText(x);
    }
    
    public void web(String x){
        webiste.setText(x);
    }
    
    //get
    
    public JButton ubah(){
        return btnUbah;
    }
    
    public JButton selesai(){
        return btnSelesai;
    }
    
    public JTextField nama(){
        return nama;
    }
    
    public JPasswordField password(){
        return password;
    }
    
    public JPasswordField passwordc(){
        return passwordc;
    }
    
    public JTextField email(){
        return email;
    }
    
    public JTextField hp(){
        return hp;
    }
    
    public JTextField telp(){
        return telp;
    }
    
    public JTextField nama_perusahaan(){
        return nama_perusahaan;
    }
        
    public JComboBox cbProvinsi(){
        return cbProvinsi;
    }
        
    public JTextField kota(){
        return kota;
    }
    
    
    public JTextField kecamatan(){
        return kecamatan;
    }
    
    public JTextArea alamat(){
        return alamat;
    }
    
    public JTextField kodepos(){
        return kodepos;
    }
    
    public JTextArea deskripsi(){
        return deskripsi;
    }
    
    public JTextField web(){
        return webiste;
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        tfSubJudul = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        hp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        telp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nama_perusahaan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsi = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        kodepos = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        webiste = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSelesai = new javax.swing.JButton();
        passwordc = new javax.swing.JPasswordField();
        btnUbah = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        cbProvinsi = new javax.swing.JComboBox<>();
        kecamatan = new javax.swing.JTextField();
        kota = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBackground(new java.awt.Color(247, 255, 246));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfSubJudul.setText("Profil Akun");
        jPanel2.add(tfSubJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 540, 10));

        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        nama.setCaretColor(new java.awt.Color(204, 204, 204));
        nama.setEnabled(false);
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, 20));

        jLabel1.setText("Nama Lengkap");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, -1));

        jLabel3.setText("Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 90, -1));

        jLabel5.setText("Password Baru");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 150, -1));

        jLabel6.setText("E-mail");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 150, -1));

        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        email.setCaretColor(new java.awt.Color(204, 204, 204));
        email.setEnabled(false);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 180, 20));

        jLabel7.setText("No HP");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 150, -1));

        hp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        hp.setCaretColor(new java.awt.Color(204, 204, 204));
        hp.setEnabled(false);
        hp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpActionPerformed(evt);
            }
        });
        jPanel2.add(hp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 180, 20));

        jLabel8.setText("No Telp");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 150, -1));

        telp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        telp.setCaretColor(new java.awt.Color(204, 204, 204));
        telp.setEnabled(false);
        telp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpActionPerformed(evt);
            }
        });
        jPanel2.add(telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 180, 20));

        jLabel9.setText("Nama Perusahaan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 150, -1));

        nama_perusahaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        nama_perusahaan.setCaretColor(new java.awt.Color(204, 204, 204));
        nama_perusahaan.setEnabled(false);
        nama_perusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_perusahaanActionPerformed(evt);
            }
        });
        jPanel2.add(nama_perusahaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 180, 20));

        jLabel11.setText("Provinsi");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 150, -1));

        jLabel12.setText("Kota");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 150, -1));

        jLabel13.setText("Kecamatan");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 150, -1));

        jLabel14.setText("Alamat");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 80, -1));

        alamat.setColumns(20);
        alamat.setRows(3);
        alamat.setAutoscrolls(false);
        alamat.setBorder(null);
        alamat.setEnabled(false);
        jScrollPane1.setViewportView(alamat);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 180, 70));

        deskripsi.setColumns(20);
        deskripsi.setRows(3);
        deskripsi.setTabSize(1);
        deskripsi.setBorder(null);
        deskripsi.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        deskripsi.setEnabled(false);
        jScrollPane2.setViewportView(deskripsi);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 180, 70));

        jLabel15.setText("Deskripsi");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 80, -1));

        kodepos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        kodepos.setCaretColor(new java.awt.Color(204, 204, 204));
        kodepos.setEnabled(false);
        kodepos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeposActionPerformed(evt);
            }
        });
        jPanel2.add(kodepos, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 180, 20));

        jLabel16.setText("Kode Pos");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 150, -1));

        webiste.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        webiste.setCaretColor(new java.awt.Color(204, 204, 204));
        webiste.setEnabled(false);
        webiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webisteActionPerformed(evt);
            }
        });
        jPanel2.add(webiste, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 180, 20));

        jLabel17.setText("Website");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 150, -1));

        btnSelesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnSelesai.png"))); // NOI18N
        btnSelesai.setBorderPainted(false);
        btnSelesai.setContentAreaFilled(false);
        jPanel2.add(btnSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 160, 20));

        passwordc.setAutoscrolls(false);
        passwordc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        passwordc.setCaretColor(new java.awt.Color(204, 204, 204));
        passwordc.setEnabled(false);
        jPanel2.add(passwordc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 180, 20));

        btnUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnEdit.png"))); // NOI18N
        btnUbah.setBorder(null);
        btnUbah.setBorderPainted(false);
        btnUbah.setContentAreaFilled(false);
        jPanel2.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 160, -1));

        password.setAutoscrolls(false);
        password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        password.setCaretColor(new java.awt.Color(204, 204, 204));
        password.setEnabled(false);
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 180, 20));

        cbProvinsi.setEditable(true);
        cbProvinsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbProvinsi.setEnabled(false);
        jPanel2.add(cbProvinsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 180, -1));

        kecamatan.setEnabled(false);
        jPanel2.add(kecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 180, -1));

        kota.setEnabled(false);
        jPanel2.add(kota, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Sebelum di simpan pastikan form password terisi terlebih dahulu");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Apabila ingin mengganti password, silahkan isi form password confirmation dengan password baru anda");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void hpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hpActionPerformed

    private void telpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpActionPerformed

    private void nama_perusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_perusahaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_perusahaanActionPerformed

    private void kodeposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeposActionPerformed

    private void webisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webisteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_webisteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbProvinsi;
    private javax.swing.JTextArea deskripsi;
    private javax.swing.JTextField email;
    private javax.swing.JTextField hp;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField kecamatan;
    private javax.swing.JTextField kodepos;
    private javax.swing.JTextField kota;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nama_perusahaan;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordc;
    private javax.swing.JTextField telp;
    private javax.swing.JLabel tfSubJudul;
    private javax.swing.JTextField webiste;
    // End of variables declaration//GEN-END:variables
}
