/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.BerandaModel;
import view.PengusahaBeranda;
import view.PetaniBeranda;

/**
 *
 * @author verdy
 */
public class BerandaController {

    BerandaModel m;
    PetaniBeranda v;
    PengusahaBeranda v2;

    public BerandaController(BerandaModel m, PetaniBeranda v) {
        this.v = v;
        this.m = m;
        v.setVisible(true);
        v.setTableLapak(v.getTableLapak(), m.tabelLapak());
    }

    public BerandaController(BerandaModel m, PengusahaBeranda v2) {
        this.v2 = v2;
        this.m = m;
        v2.setVisible(true);
        v2.setTableLapak(v2.getTableLapak(), m.tabelLapak());
    }
}
