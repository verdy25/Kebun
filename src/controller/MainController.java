/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PengusahaBerandaModel;
import model.PengusahaDftrKebutuhanModel;
import model.PengusahaDftrTrxModel;
import model.PengusahaVerifModel;
import model.BerandaModel;
import model.PetaniDftrKerjasamaModel;
import model.PetaniDftrTrxModel;
import model.ProfileModel;
import model.PetaniVerifModel;
import model.UserModel;
import view.Daftar;
import view.Lapaak;
import view.Login;
import view.Main;
import view.Pengusaha;
import view.PengusahaBeranda;
import view.PengusahaDftrKebutuhan;
import view.PengusahaDftrTrx;
import view.PengusahaProfile;
import view.PengusahaTbhKebutuhan;
import view.PengusahaVerif;
import view.Petani;
import view.PetaniBeranda;
import view.PetaniDftrKerjasama;
import view.PetaniDftrTrx;
import view.PetaniProfile;
import view.PetaniTbhKerjasama;
import view.PetaniVerif;

/**
 *
 * @author verdy
 */
public class MainController {

    UserModel model;
    Daftar v_daftar;
    Login v_login;
    Main view;

    public MainController(Main v) {
    }

    public MainController(Login v, UserModel m, Main ve) {
        this.model = m;
        this.v_login = v;
        this.view = ve;
        view.setVisible(true);
        v_login.login().addActionListener(new loginAction());
    }

    public MainController(Daftar v, UserModel m, Main ve) {
        this.model = m;
        this.v_daftar = v;
        this.view = ve;
        view.setVisible(true);
        v_daftar.Daftar().addActionListener(new daftarAction());
    }

    private class daftarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = v_daftar.getNama();
            String email = v_daftar.getEmail();
            String pwd = v_daftar.getPassword();
            int level = v_daftar.getLevel();
            if (nama.equalsIgnoreCase("masukkan nama") || email.equalsIgnoreCase("masukkan email") || pwd.equalsIgnoreCase("password") || level == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                try {
                    model.daftar(nama, email, pwd, level);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }

    }

    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String email = v_login.getEmail().getText();
            String password = v_login.getPass().getText();
            System.out.println(email + password);
            if (email.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            } else {
                try {
                    String level[] = model.login(email, password);
                    System.out.println(level[1]);
                    BerandaModel m1 = new BerandaModel();
                    UserModel m4 = new UserModel();
                    switch (Integer.parseInt(level[1])) {
                        case 1:
                            PetaniBeranda p1 = new PetaniBeranda();
                            PetaniDftrKerjasama p2 = new PetaniDftrKerjasama();
                            PetaniDftrTrx p3 = new PetaniDftrTrx();
                            PetaniProfile p4 = new PetaniProfile();
                            PetaniTbhKerjasama p5 = new PetaniTbhKerjasama();
                            PetaniVerif p6 = new PetaniVerif();
                            Lapaak lapak = new Lapaak();
                            Petani p = new Petani(p1, p4, p5, p2, p3, p6);

                            PetaniDftrKerjasamaModel m2 = new PetaniDftrKerjasamaModel(Integer.parseInt(level[0]));
                            PetaniDftrTrxModel m3 = new PetaniDftrTrxModel();
                            PetaniVerifModel m5 = new PetaniVerifModel();
                            ProfileModel m6 = new ProfileModel(Integer.parseInt(level[0]));

                            BerandaController c1 = new BerandaController(m1, p1, lapak);
                            PetaniKerjasamaController c2 = new PetaniKerjasamaController(m2, p2, p5);
                            PetaniDftrTrxController c3 = new PetaniDftrTrxController(m3, p3);
                            ProfilController c4 = new ProfilController(m6, p4, m4);
                            PetaniVerifController c5 = new PetaniVerifController(m5, p6);

                            p.setNama_user(level[2]);
                            p.setVisible(true);
                            p1.setVisible(true);
                            p2.setVisible(false);
                            p3.setVisible(false);
                            p4.setVisible(false);
                            p5.setVisible(false);
                            p6.setVisible(false);
                            lapak.setVisible(false);
                            view.dispose();
                            view = null;
                            break;
                        case 2:
                            PengusahaBeranda ps1 = new PengusahaBeranda();
                            PengusahaDftrKebutuhan ps2 = new PengusahaDftrKebutuhan();
                            PengusahaDftrTrx ps3 = new PengusahaDftrTrx();
                            PengusahaProfile ps4 = new PengusahaProfile();
                            PengusahaTbhKebutuhan ps5 = new PengusahaTbhKebutuhan();
                            PengusahaVerif ps6 = new PengusahaVerif();
                            Pengusaha ps = new Pengusaha(ps1, ps2, ps5, ps4, ps3, ps6);

                            PengusahaDftrKebutuhanModel mp2 = new PengusahaDftrKebutuhanModel();
                            PengusahaDftrTrxModel mp3 = new PengusahaDftrTrxModel();
                            PengusahaVerifModel mp5 = new PengusahaVerifModel();
                            ProfileModel mp6 = new ProfileModel(Integer.parseInt(level[0]));

                            BerandaController cp1 = new BerandaController(m1, ps1);
                            PengusahaDftrKebutuhanController cp2 = new PengusahaDftrKebutuhanController(mp2, ps2, ps5);
                            PengusahaDftrTrxController cp3 = new PengusahaDftrTrxController(mp3, ps3);
                            ProfilController cp4 = new ProfilController(mp6, ps4, m4);
                            PengusahaVerifController cp5 = new PengusahaVerifController(mp5, ps6);

                            ps.setNama_user(level[2]);
                            ps.setVisible(true);
                            ps1.setVisible(true);
                            ps2.setVisible(false);
                            ps3.setVisible(false);
                            ps4.setVisible(false);
                            ps5.setVisible(false);
                            ps6.setVisible(false);
                            view.dispose();
                            view = null;
                            break;
                        default:

                            break;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Login gagal");
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

}
