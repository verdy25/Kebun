/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.VerifModel;
import view.PengusahaVerif;
import view.PetaniVerif;

/**
 *
 * @author verdy
 */
public class VerifController {

    VerifModel m;
    PetaniVerif v;
    PengusahaVerif v2;

    public VerifController(VerifModel m, PetaniVerif v) {
        this.v = v;
        this.m = m;
        v.setVisible(true);
        this.v.setTabel(v.getTable_verif(), m.tableVerif());
        this.v.btnVerif().addActionListener(new verifikasi());
    }

    public VerifController(VerifModel m, PengusahaVerif v2) {
        this.v2 = v2;
        this.m = m;
        v2.setVisible(true);
        this.v2.setTabel(v2.getTable_verif(), m.tableVerif());
        this.v2.btnVerif().addActionListener(new verifikasi2());
    }

    private class verifikasi implements ActionListener {

        @Override
        @SuppressWarnings("empty-statement")
        public void actionPerformed(ActionEvent e) {
            int row = v.getTable_verif().getSelectedRow();
            String status = v.getTable_verif().getModel().getValueAt(row, 3).toString();;
            if (status.equals("Disetujui")) {
                JOptionPane.showMessageDialog(null, ""
                        + "Tidak bisa diverifikasi lagi");
            } else {
                int ID_VERIFIKASI = Integer.parseInt(v.getTable_verif().getModel().getValueAt(row, 0).toString());
                m.verifikasi(ID_VERIFIKASI);
                JOptionPane.showMessageDialog(null, "Telah disetujui");
                refresh();
                m.transaksiSukses();
            }
        }

    }

    private class verifikasi2 implements ActionListener {

        @Override
        @SuppressWarnings("empty-statement")
        public void actionPerformed(ActionEvent e) {
            int row = v2.getTable_verif().getSelectedRow();
            String status = v2.getTable_verif().getModel().getValueAt(row, 3).toString();;
            if (status.equals("Disetujui")) {
                JOptionPane.showMessageDialog(null, ""
                        + "Tidak bisa diverifikasi lagi");
            } else {
                int ID_VERIFIKASI = Integer.parseInt(v2.getTable_verif().getModel().getValueAt(row, 0).toString());
                m.verifikasi(ID_VERIFIKASI);
                JOptionPane.showMessageDialog(null, "Telah disetujui");
                refresh();
            }
        }

    }

    private void refresh() {
        DefaultTableModel model = (DefaultTableModel) v.getTable_verif().getModel();
        model.setRowCount(0);
        m.updateTableVerif(model);
    }
}
