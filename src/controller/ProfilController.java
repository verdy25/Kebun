/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.ProfileModel;
import model.UserModel;
import view.PengusahaProfile;
import view.PetaniProfile;

/**
 *
 * @author verdy
 */
public class ProfilController {

    ProfileModel m;
    PetaniProfile v;
    UserModel m_user;
    PengusahaProfile v2;

    public ProfilController(ProfileModel m, PetaniProfile v, UserModel m_user) {
        this.v = v;
        this.m = m;
        this.m_user = m_user;
        String data[] = m.getProfil();

        v.setVisible(true);
        v.ubah().addActionListener(new ubah());
        v.selesai().addActionListener(new selesai());

        try {
            List<String> propinsi = m.dataProvinsi();
            v.listPropinsi(propinsi);
            v.nama(data[0]);
            v.email(data[1]);
            v.hp(data[2]);
            v.telp(data[3]);
            v.nama_perusahaan(data[4]);
            v.propinsi(data[5]);
            v.kota(data[6]);
            v.kecamatan(data[7]);
            v.alamat(data[8]);
            v.kodepos(data[9]);
            v.deskripsi(data[10]);
            v.web(data[11]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        v.password(data[12]);
    }

    public ProfilController(ProfileModel m, PengusahaProfile v2, UserModel m_user) {
        this.v2 = v2;
        this.m = m;
        this.m_user = m_user;
        String data[] = m.getProfil();

        v2.setVisible(true);
        v2.ubah().addActionListener(new ubah2());
        v2.selesai().addActionListener(new selesai2());

        try {
            List<String> propinsi = m.dataProvinsi();
            v2.listPropinsi(propinsi);
            v2.nama(data[0]);
            v2.email(data[1]);
            v2.hp(data[2]);
            v2.telp(data[3]);
            v2.nama_perusahaan(data[4]);
            v2.propinsi(data[5]);
            v2.kota(data[6]);
            v2.kecamatan(data[7]);
            v2.alamat(data[8]);
            v2.kodepos(data[9]);
            v2.deskripsi(data[10]);
            v2.web(data[11]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        v.password(data[12]);
    }

    private class ubah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            open();
            JOptionPane.showMessageDialog(null, "Silahkan mengganti data yang diinginkan");
        }
    }

    private class selesai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String data[] = m.getProfil();
            String new_password;
            if (v.password().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Isi password terlebih dahulu");
            } else {
                if (v.password().getText().equals(data[12]) && v.passwordc().getText().equalsIgnoreCase("")) {
                    try {
                        m.simpan(v.nama().getText(), v.password().getText(), v.email().getText(), v.hp().getText(),
                                v.telp().getText(), v.nama_perusahaan().getText(), v.cbProvinsi().getSelectedItem().toString(),
                                v.kota().getText(), v.kecamatan().getText(),
                                v.alamat().getText(), v.kodepos().getText(), v.deskripsi().getText(),
                                v.web().getText());
                        close();
                        JOptionPane.showMessageDialog(null, "Berhasil memperbarui profil");
                        v.password().setText(null);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (v.password().getText().equals(data[12])) {
                    new_password = v.passwordc().getText();
                    if (new_password.length() > 6 || new_password.length() < 16) {
                        JOptionPane.showMessageDialog(null, "password kurang memenuhi syarat");
                    } else {
                        try {
                            m.simpan(v.nama().getText(), v.passwordc().getText(), v.email().getText(), v.hp().getText(),
                                    v.telp().getText(), v.nama_perusahaan().getText(), v.cbProvinsi().getSelectedItem().toString(),
                                    v.kota().getText(), v.kecamatan().getText(),
                                    v.alamat().getText(), v.kodepos().getText(), v.deskripsi().getText(),
                                    v.web().getText());
                            close();
                            JOptionPane.showMessageDialog(null, "Berhasil memperbarui profil dan password");
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Password salah");
                }
            }

        }

    }

    public void close() {
        v.nama().enable(false);
        v.password().enable(false);
        v.passwordc().enable(false);
        v.email().enable(false);
        v.hp().enable(false);
        v.telp().enable(false);
        v.nama_perusahaan().enable(false);
        v.cbProvinsi().enable(false);
        v.kodepos().enable(false);
        v.kota().enable(false);
        v.alamat().enable(false);
        v.deskripsi().enable(false);
        v.web().enable(false);
    }

    public void open() {
        v.nama().enable(true);
        v.password().enable(true);
        v.passwordc().enable(true);
        v.email().enable(true);
        v.hp().enable(true);
        v.telp().enable(true);
        v.nama_perusahaan().enable(true);
        v.cbProvinsi().enable(true);
        v.kodepos().enable(true);
        v.kota().enable(true);
        v.kecamatan().enable(true);
        v.alamat().enable(true);
        v.deskripsi().enable(true);
        v.web().enable(true);
    }
    
    private class ubah2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            open2();
            JOptionPane.showMessageDialog(null, "Silahkan mengganti data yang diinginkan");
        }
    }

    private class selesai2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String data[] = m.getProfil();
            String new_password;
            if (v2.password().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Isi password terlebih dahulu");
            } else {
                if (v2.password().getText().equals(data[12]) && v2.passwordc().getText().equalsIgnoreCase("")) {
                    try {
                        m.simpan(v2.nama().getText(), v2.password().getText(), v2.email().getText(), v2.hp().getText(),
                                v2.telp().getText(), v2.nama_perusahaan().getText(), v2.cbProvinsi().getSelectedItem().toString(),
                                v2.kota().getText(), v2.kecamatan().getText(),
                                v2.alamat().getText(), v2.kodepos().getText(), v2.deskripsi().getText(),
                                v2.web().getText());
                        close2();
                        JOptionPane.showMessageDialog(null, "Berhasil memperbarui profil");
                        v2.password().setText(null);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (v2.password().getText().equals(data[12])) {
                    new_password = v2.passwordc().getText();
                    if (new_password.length() > 6 || new_password.length() < 16) {
                        JOptionPane.showMessageDialog(null, "password kurang memenuhi syarat");
                    } else {
                        try {
                            m.simpan(v2.nama().getText(), v2.passwordc().getText(), v2.email().getText(), v2.hp().getText(),
                                    v2.telp().getText(), v2.nama_perusahaan().getText(), v2.cbProvinsi().getSelectedItem().toString(),
                                    v2.kota().getText(),v2.kecamatan().getText(),
                                    v2.alamat().getText(), v2.kodepos().getText(), v2.deskripsi().getText(),
                                    v2.web().getText());
                            close();
                            JOptionPane.showMessageDialog(null, "Berhasil memperbarui profil dan password");
                        } catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Password salah");
                }
            }

        }

    }
    
    public void close2() {
        v2.nama().enable(false);
        v2.password().enable(false);
        v2.passwordc().enable(false);
        v2.email().enable(false);
        v2.hp().enable(false);
        v2.telp().enable(false);
        v2.nama_perusahaan().enable(false);
        v2.cbProvinsi().enable(false);
        v2.kodepos().enable(false);
        v2.kota().enable(false);
        v2.kecamatan().enable(false);
        v2.alamat().enable(false);
        v2.deskripsi().enable(false);
        v2.web().enable(false);
    }

    public void open2() {
        v2.nama().enable(true);
        v2.password().enable(true);
        v2.passwordc().enable(true);
        v2.email().enable(true);
        v2.hp().enable(true);
        v2.telp().enable(true);
        v2.nama_perusahaan().enable(true);
        v2.cbProvinsi().enable(true);
        v2.kodepos().enable(true);
        v2.kota().enable(true);
        v2.kecamatan().enable(true);
        v2.alamat().enable(true);
        v2.deskripsi().enable(true);
        v2.web().enable(true);
    }
}
