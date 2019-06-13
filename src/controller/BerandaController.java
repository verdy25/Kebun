/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
//        v2.setTableLapak(v2.getTableLapak(), m.tableLapak());
    }

    private class buka implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lapak.setVisible(true);
            lapak.setJudul("judul");
        }
    }
}
