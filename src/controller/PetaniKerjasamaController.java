/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.PetaniDftrKerjasamaModel;
import view.PetaniDftrKerjasama;
import view.PetaniTbhKerjasama;

/**
 *
 * @author verdy
 */
public class PetaniKerjasamaController {

    PetaniDftrKerjasamaModel m;
    PetaniDftrKerjasama v;
    PetaniTbhKerjasama v2;
    String judul, deskripsi, komoditi, unit;
    String s = "D:/Kuliyah/SEM4/PBO/PR/Kebun/src/Assets/image-detail-product_1.png";
    int kebutuhan;

    public PetaniKerjasamaController(PetaniDftrKerjasamaModel m, PetaniDftrKerjasama v, PetaniTbhKerjasama v2) {
        this.v = v;
        this.v2 = v2;
        this.m = m;
        this.v.setTabel(v.getTabelKerjasama(), m.tableKerjasama());

        v2.btnSelesai().addActionListener(new create());
        v2.btnUnggah().addActionListener(new unggah());

        v.btnEdit().addActionListener(new edit());
        v.btnSimpan().addActionListener(new update());
        v.btnHapus().addActionListener(new hapus());
        
        disabled();
    }

    private class unggah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
            fileChooser.addChoosableFileFilter(filter);
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                v2.image().setIcon(ResizeImage(path));
                s = path;
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("No Data");
            }
        }

    }

    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(v2.image().getWidth(), v2.image().getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    private class create implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKerjasama().getModel();
            judul = v2.getJudul().getText();
            deskripsi = v2.getDeskripsi().getText();
            komoditi = v2.getKomoditi().getText();
            kebutuhan = Integer.parseInt(v2.getKebutuhan().getText());
            unit = v2.getCbUnit().getSelectedItem().toString();
            try {
                m.buatLapakKerjasama(judul, deskripsi, komoditi, kebutuhan, unit, s);
                model.setRowCount(0);
                m.update(model);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PetaniKerjasamaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = v.getTabelKerjasama().getSelectedRow();
            String judul = v.getTabelKerjasama().getModel().getValueAt(row, 1).toString();
            String deksripsi = v.getTabelKerjasama().getModel().getValueAt(row, 2).toString();
            String komoditi = v.getTabelKerjasama().getModel().getValueAt(row, 3).toString();
            int kebutuhan = Integer.parseInt(v.getTabelKerjasama().getModel().getValueAt(row, 4).toString());
            String unit = v.getTabelKerjasama().getModel().getValueAt(row, 5).toString();
            
            byte[] foto = (byte[]) v.getTabelKerjasama().getModel().getValueAt(row, 7);
            ImageIcon icon = m.getImage(foto);

            enabled();
            
            v.setJudul(judul);
            v.setDeskripsi(deksripsi);
            v.setKomoditi(komoditi);
            v.setKebutuhan(kebutuhan);
            v.getCbUnit().setSelectedItem(unit);
            v.image().setIcon(icon);
        }

    }

    private class update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKerjasama().getModel();
            int row = v.getTabelKerjasama().getSelectedRow();
            judul = v.getJudul().getText();
            deskripsi = v.getDeskripsi().getText();
            komoditi = v.getKomoditi().getText();
            kebutuhan = Integer.parseInt(v.getKebutuhan().getText());
            unit = v.getCbUnit().getSelectedItem().toString();
            int id_lapak = Integer.parseInt(v.getTabelKerjasama().getModel().getValueAt(row, 0).toString());
            try {
                m.updateLapakKerjasama(judul, deskripsi, komoditi, kebutuhan, unit, id_lapak);
                model.setRowCount(0);
                m.update(model);
                disabled();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PetaniKerjasamaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class hapus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKerjasama().getModel();
            int row = v.getTabelKerjasama().getSelectedRow();
            int id_lapak = Integer.parseInt(v.getTabelKerjasama().getModel().getValueAt(row, 0).toString());
            try {
                m.deleteLapak(id_lapak);
                model.setRowCount(0);
                m.update(model);
            } catch (Exception ex) {
                
            }
        }
    }

    public void disabled(){
        v.getJudul().setEnabled(false);
        v.getDeskripsi().setEnabled(false);
        v.getKomoditi().setEnabled(false);
        v.getCbUnit().setEnabled(false);
        v.getKebutuhan().setEnabled(false);   
    }
    
    public void enabled(){
        v.getJudul().setEnabled(true);
        v.getDeskripsi().setEnabled(true);
        v.getKomoditi().setEnabled(true);
        v.getCbUnit().setEnabled(true);
        v.getKebutuhan().setEnabled(true);   
    }
}
