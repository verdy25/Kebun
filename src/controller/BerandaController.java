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
        v.setTableLapak(v.getTableLapak(), m.tableKerjasama());
        v.getBtnBuka().addActionListener(new buka());
    }

    public BerandaController(BerandaModel m, PengusahaBeranda v2) {
        this.v2 = v2;
        this.m = m;
        v2.setVisible(true);
    }

    private class buka implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lapak.setVisible(true);
            int row = v.getTableLapak().getSelectedRow();
            String id_lapak = v.getTableLapak().getModel().getValueAt(row, 0).toString();
            System.out.println(id_lapak);
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
            lapak.setEmail(": "+pelapak[0]);
            lapak.setPhone(": "+pelapak[1]);
        }
    }

    
}
