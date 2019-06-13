/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.PetaniVerifModel;
import view.PetaniVerif;

/**
 *
 * @author verdy
 */
public class PetaniVerifController {
    PetaniVerifModel m;
    PetaniVerif v;    
       
    public PetaniVerifController(PetaniVerifModel m, PetaniVerif v){
        this.v = v;
        this.m = m;
        v.setVisible(true);
        this.v.setTabel(v.getTable_verif(), m.tableVerif());
        this.v.btnVerif().addActionListener(new verifikasi());
    }
    
     private class verifikasi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = v.getTable_verif().convertRowIndexToModel(v.getTable_verif().getSelectedRow());
            System.out.println(row);
        }
        
    }
}
