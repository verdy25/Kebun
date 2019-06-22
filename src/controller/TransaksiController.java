/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.TransaksiModel;
import view.PengusahaDftrTrx;
import view.PetaniDftrTrx;

/**
 *
 * @author verdy
 */
public class TransaksiController {
    TransaksiModel m;
    PetaniDftrTrx v;  
    PengusahaDftrTrx v2;
       
    public TransaksiController(TransaksiModel m, PetaniDftrTrx v){
        this.v = v;
        this.m = m;
        v.setVisible(true);
        this.v.setTabel(v.getTable(), m.tableTransaksi());
    }
    
    public TransaksiController(TransaksiModel m, PengusahaDftrTrx v2){
        this.v2 = v2;
        this.m = m;
        v2.setVisible(true);
        this.v2.setTabel(v2.getTable(), m.tableTransaksi());
    }
}
