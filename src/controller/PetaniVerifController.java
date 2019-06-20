/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BerandaModel;
import model.PetaniVerifModel;
import model.ProfileModel;
import model.UserModel;
import view.PetaniVerif;

/**
 *
 * @author verdy
 */
public class PetaniVerifController {
    PetaniVerifModel m;
    PetaniVerif v;    
    ProfileModel user;
       
    public PetaniVerifController(ProfileModel user, PetaniVerifModel m, PetaniVerif v){
        this.v = v;
        this.m = m;
        this.user = user;
        v.setVisible(true);
        this.v.setTabel(v.getTable_verif(), m.tableVerif());
        this.v.btnVerif().addActionListener(new verifikasi());
    }
    
     public class verifikasi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = v.getTable_verif().convertRowIndexToModel(v.getTable_verif().getSelectedRow());
            System.out.println(row);
            int id_pemilik = (new BerandaModel()).getIdPemilik(row);
            m.tambahverif(Integer.parseInt(user.getProfil()[13]), id_pemilik, row);
        }
        
    }
}
