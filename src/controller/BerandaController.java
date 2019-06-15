/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.BerandaModel;
import view.Lapaak;
import view.PengusahaBeranda;
import view.PetaniBeranda;

/**
 *
 * @author verdy
 */
public class BerandaController {

    BerandaModel m;
    PetaniBeranda v;
    Lapaak lapak;
    PengusahaBeranda v2;

    public BerandaController(BerandaModel m, PetaniBeranda v, Lapaak v_lapak) {
        this.v = v;
        this.m = m;
        this.lapak = v_lapak;
        v.setVisible(true);
        v.setTableLapak(v.getTableLapak(), m.tableKerjasama("kebutuhan"));
        v.getBtnBuka().addActionListener(new buka());
        v.btnRefresh().addActionListener(new refresh());
    }

    public BerandaController(BerandaModel m, PengusahaBeranda v2, Lapaak v_lapak) {
        this.v2 = v2;
        this.m = m;
        this.lapak = v_lapak;
        v2.setVisible(true);
        v2.setTableLapak(v2.getTableLapak(), m.tableKerjasama("kerjasama"));
        v2.btnBuka().addActionListener(new buka2());
        v2.btnRefresh().addActionListener(new refresh2());
    }

    private class refresh implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTableLapak().getModel();
            model.setRowCount(0);
            m.updateTableKerjasama(model, "kerjasama");
        }
    }
    
    private class refresh2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v2.getTableLapak().getModel();
            model.setRowCount(0);
            m.updateTableKerjasama(model, "kebutuhan");
        }
    }

    private class buka implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lapak.setVisible(true);
            int row = v.getTableLapak().getSelectedRow();
            String id_lapak = v.getTableLapak().getModel().getValueAt(row, 0).toString();
            String pelapak[] = m.getPelapak(Integer.parseInt(id_lapak));

            String judul = v.getTableLapak().getModel().getValueAt(row, 1).toString();
            String deksripsi = v.getTableLapak().getModel().getValueAt(row, 2).toString();
            String komoditi = v.getTableLapak().getModel().getValueAt(row, 3).toString();
            int kebutuhan = Integer.parseInt(v.getTableLapak().getModel().getValueAt(row, 4).toString());
            String unit = v.getTableLapak().getModel().getValueAt(row, 5).toString();

            byte[] foto = (byte[]) v.getTableLapak().getModel().getValueAt(row, 7);
            ImageIcon icon = m.getImage(foto);

            lapak.setJudul(judul);
            lapak.setDeskripsi(": " + deksripsi);
            lapak.setKomoditi(": " + komoditi);
            lapak.setKebutuhan(": " + String.valueOf(kebutuhan) + " " + unit);
            lapak.getImage().setIcon(icon);
            lapak.setEmail(": " + pelapak[0]);
            lapak.setPhone(": " + pelapak[1]);
        }
    }

    private class buka2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lapak.setVisible(true);
            int row = v2.getTableLapak().getSelectedRow();
            String id_lapak = v2.getTableLapak().getModel().getValueAt(row, 0).toString();
            String pelapak[] = m.getPelapak(Integer.parseInt(id_lapak));

            String judul = v2.getTableLapak().getModel().getValueAt(row, 1).toString();
            String deksripsi = v2.getTableLapak().getModel().getValueAt(row, 2).toString();
            String komoditi = v2.getTableLapak().getModel().getValueAt(row, 3).toString();
            int kebutuhan = Integer.parseInt(v2.getTableLapak().getModel().getValueAt(row, 4).toString());
            String unit = v2.getTableLapak().getModel().getValueAt(row, 5).toString();

            lapak.setJudul(judul);
            lapak.setDeskripsi(": " + deksripsi);
            lapak.setKomoditi(": " + komoditi);
            lapak.setKebutuhan(": " + String.valueOf(kebutuhan) + " " + unit);
            lapak.setEmail(": " + pelapak[0]);
            lapak.setPhone(": " + pelapak[1]);
        }
    }

}
