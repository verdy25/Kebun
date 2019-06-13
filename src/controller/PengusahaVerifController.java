/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.PengusahaVerifModel;
import view.PengusahaVerif;

/**
 *
 * @author verdy
 */
public class PengusahaVerifController {
    PengusahaVerifModel m;
    PengusahaVerif v;    
       
    public PengusahaVerifController(PengusahaVerifModel m, PengusahaVerif v){
        this.v = v;
        this.m = m;
        v.setVisible(true);
    }
     private class verifikasi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = v.getTableVerif().convertRowIndexToModel(v.getTableVerif().getSelectedRow());
            System.out.println(row);
        }
        
    }
}
