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
import model.PengusahaDftrKebutuhanModel;
import view.PengusahaDftrKebutuhan;
import view.PengusahaTbhKebutuhan;
/**
 *
 * @author verdy
 */
public class PengusahaDftrKebutuhanController {
    PengusahaDftrKebutuhanModel m;
    PengusahaDftrKebutuhan v;    
    PengusahaTbhKebutuhan v2;
    String judul, deskripsi, kategori, unit;
    int kebutuhan;
       
    public PengusahaDftrKebutuhanController(PengusahaDftrKebutuhanModel m, PengusahaDftrKebutuhan v, PengusahaTbhKebutuhan v2){
        this.v = v;
        this.v2 = v2;
        this.m = m;
        this.v.setTabel(v.getTabelKebutuhan(), m.tableKebutuhan());
        v2.btnSelesai().addActionListener(new PengusahaDftrKebutuhanController.create());
        v.btnEdit().addActionListener(new PengusahaDftrKebutuhanController.edit());
        v.btnSimpan().addActionListener(new PengusahaDftrKebutuhanController.update());
        v.btnHapus().addActionListener(new PengusahaDftrKebutuhanController.hapus());
        
        disabled();
    }
    private class create implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKebutuhan().getModel();
            judul = v2.getJudul().getText();
            deskripsi = v2.getDeskripsi().getText();
            kategori = v2.getKategori().getText();
            kebutuhan = Integer.parseInt(v2.getKebutuhan().getText());
            unit = v2.getCbUnit().getSelectedItem().toString();
            try {
                m.buatLapakKebutuhan(judul, deskripsi, kategori, kebutuhan, unit);
                model.setRowCount(0);
                m.update(model);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PengusahaDftrKebutuhanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class edit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = v.getTabelKebutuhan().getSelectedRow();
            String judul = v.getTabelKebutuhan().getModel().getValueAt(row, 1).toString();
            String deksripsi = v.getTabelKebutuhan().getModel().getValueAt(row, 2).toString();
            String kategori = v.getTabelKebutuhan().getModel().getValueAt(row, 3).toString();
            int kebutuhan = Integer.parseInt(v.getTabelKebutuhan().getModel().getValueAt(row, 4).toString());
            String unit = v.getTabelKebutuhan().getModel().getValueAt(row, 5).toString();

            enabled();
            
            v.setJudul(judul);
            v.setDeskripsi(deksripsi);
            v.setKategori(kategori);
            v.setKebutuhan(kebutuhan);
            v.getCbUnit().setSelectedItem(unit);
        }

    }

    private class update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKebutuhan().getModel();
            int row = v.getTabelKebutuhan().getSelectedRow();
            judul = v.getJudul().getText();
            deskripsi = v.getDeskripsi().getText();
            kategori = v.getKategori().getText();
            kebutuhan = Integer.parseInt(v.getKebutuhan().getText());
            unit = v.getCbUnit().getSelectedItem().toString();
            int id_lapak = Integer.parseInt(v.getTabelKebutuhan().getModel().getValueAt(row, 0).toString());
            try {
                m.updateLapakKebutuhan(judul, deskripsi, kategori, kebutuhan, unit, id_lapak);
                model.setRowCount(0);
                m.update(model);
                disabled();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PengusahaDftrKebutuhanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class hapus implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTabelKebutuhan().getModel();
            int row = v.getTabelKebutuhan().getSelectedRow();
            int id_lapak = Integer.parseInt(v.getTabelKebutuhan().getModel().getValueAt(row, 0).toString());
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
        v.getKategori().setEnabled(false);
        v.getCbUnit().setEnabled(false);
        v.getKebutuhan().setEnabled(false);   
    }
    
    public void enabled(){
        v.getJudul().setEnabled(true);
        v.getDeskripsi().setEnabled(true);
        v.getKategori().setEnabled(true);
        v.getCbUnit().setEnabled(true);
        v.getKebutuhan().setEnabled(true);   
    }
}
