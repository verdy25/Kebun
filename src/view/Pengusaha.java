/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import model.UserModel;

/**
 *
 * @author HP
 */
public class Pengusaha extends javax.swing.JFrame {

    int MouseX;
    int MouseY;

    GridBagLayout layout = new GridBagLayout();

    PengusahaBeranda beranda;
    PengusahaDftrKebutuhan dftrKebutuhan;
    PengusahaTbhKebutuhan tbhKebutuhan;
    PengusahaProfile profil;
    PengusahaDftrTrx trx;
    PengusahaVerif verif;

    public Pengusaha(PengusahaBeranda pengusahaBeranda, PengusahaDftrKebutuhan pengusahaDftrKebutuhan,
            PengusahaTbhKebutuhan pengusahaTbhKebutuhan, PengusahaProfile pengusahaProfile,
            PengusahaDftrTrx pengusahaDftrTrx, PengusahaVerif pengusahaVerif) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.beranda = pengusahaBeranda;
        this.profil = pengusahaProfile;
        this.tbhKebutuhan = pengusahaTbhKebutuhan;
        this.dftrKebutuhan = pengusahaDftrKebutuhan;
        this.trx = pengusahaDftrTrx;
        this.verif = pengusahaVerif;

        panelPengusaha.setLayout(layout);
        panelPengusaha.add(beranda);
        panelPengusaha.add(profil);
        panelPengusaha.add(tbhKebutuhan);
        panelPengusaha.add(dftrKebutuhan);
        panelPengusaha.add(trx);
        panelPengusaha.add(verif);

        this.beranda.setVisible(true);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(false);
        this.verif.setVisible(false);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserModel m = new UserModel();
                Login vl = new Login();
                Daftar vd = new Daftar();
                Main vm = new Main(vl, vd);

                MainController c1 = new MainController(vd, m, vm);
                MainController c2 = new MainController(vl, m, vm);
                dispose();
            }

        });
    }

    public JLabel getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user.setText(nama_user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nama_user = new javax.swing.JLabel();
        btnBeranda = new javax.swing.JButton();
        btnProfil = new javax.swing.JButton();
        btnVerif = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnTbhPerm = new javax.swing.JButton();
        btnDftrPerm = new javax.swing.JButton();
        panelPengusaha = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel13MouseDragged(evt);
            }
        });
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 860, 40));

        jPanel1.setBackground(new java.awt.Color(234, 255, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/icons8_steve_jobs_64px.png"))); // NOI18N
        nama_user.setText("Setev JObs");
        jPanel1.add(nama_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        btnBeranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnBeranda.png"))); // NOI18N
        btnBeranda.setBorderPainted(false);
        btnBeranda.setContentAreaFilled(false);
        btnBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerandaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBeranda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnProfil.png"))); // NOI18N
        btnProfil.setBorderPainted(false);
        btnProfil.setContentAreaFilled(false);
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        btnVerif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnVerif.png"))); // NOI18N
        btnVerif.setBorderPainted(false);
        btnVerif.setContentAreaFilled(false);
        btnVerif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerif, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnLogout.png"))); // NOI18N
        btnLogout.setBorderPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 70, 20));

        jLabel4.setText("Permintaan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        btnTbhPerm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnTambahPermintaan.png"))); // NOI18N
        btnTbhPerm.setBorderPainted(false);
        btnTbhPerm.setContentAreaFilled(false);
        btnTbhPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTbhPermActionPerformed(evt);
            }
        });
        jPanel1.add(btnTbhPerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        btnDftrPerm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnDaftarPermintaan.png"))); // NOI18N
        btnDftrPerm.setBorderPainted(false);
        btnDftrPerm.setContentAreaFilled(false);
        btnDftrPerm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDftrPermActionPerformed(evt);
            }
        });
        jPanel1.add(btnDftrPerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        panelPengusaha.setBackground(new java.awt.Color(247, 255, 246));
        panelPengusaha.setLayout(new java.awt.GridBagLayout());

        jLabel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel10MouseDragged(evt);
            }
        });
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });
        panelPengusaha.add(jLabel10, new java.awt.GridBagConstraints());

        jPanel1.add(panelPengusaha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 660, 510));

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/close.png"))); // NOI18N
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));

        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/btnDaftarTransaksi.png"))); // NOI18N
        btnTransaksi.setBorderPainted(false);
        btnTransaksi.setContentAreaFilled(false);
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - MouseX, kordinatY - MouseY);
    }//GEN-LAST:event_jLabel10MouseDragged

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        MouseX = evt.getX();
        MouseY = evt.getY();
    }//GEN-LAST:event_jLabel10MousePressed

    private void btnBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerandaActionPerformed
        this.beranda.setVisible(true);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(false);
        this.verif.setVisible(false);
    }//GEN-LAST:event_btnBerandaActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        this.beranda.setVisible(false);
        this.profil.setVisible(true);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(false);
        this.verif.setVisible(false);
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnDftrPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDftrPermActionPerformed
        this.beranda.setVisible(false);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(true);
        this.trx.setVisible(false);
        this.verif.setVisible(false);
    }//GEN-LAST:event_btnDftrPermActionPerformed

    private void btnTbhPermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTbhPermActionPerformed
        this.beranda.setVisible(false);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(true);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(false);
        this.verif.setVisible(false);
    }//GEN-LAST:event_btnTbhPermActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        this.beranda.setVisible(false);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(true);
        this.verif.setVisible(false);
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jLabel13MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();

        this.setLocation(kordinatX - MouseX, kordinatY - MouseY);
    }//GEN-LAST:event_jLabel13MouseDragged

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        MouseX = evt.getX();
        MouseY = evt.getY();
    }//GEN-LAST:event_jLabel13MousePressed

    private void btnVerifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifActionPerformed
        this.beranda.setVisible(false);
        this.profil.setVisible(false);
        this.tbhKebutuhan.setVisible(false);
        this.dftrKebutuhan.setVisible(false);
        this.trx.setVisible(false);
        this.verif.setVisible(true);
    }//GEN-LAST:event_btnVerifActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Pengusaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengusaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengusaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengusaha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengusaha(beranda, dftrKebutuhan, tbhKebutuhan, profil, trx, verif).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBeranda;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDftrPerm;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnTbhPerm;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnVerif;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nama_user;
    private javax.swing.JPanel panelPengusaha;
    // End of variables declaration//GEN-END:variables
}