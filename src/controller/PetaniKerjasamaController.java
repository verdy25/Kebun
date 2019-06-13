/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PetaniDftrKerjasamaModel;
import view.PetaniDftrKerjasama;
import view.PetaniTbhKerjasama;

/**
 *
 * @author verdy
 */
public class PetaniKerjasamaController {
    PetaniDftrKerjasamaModel m;
    PetaniDftrKerjasama v;    
    PetaniTbhKerjasama v2;
       
    public PetaniKerjasamaController(PetaniDftrKerjasamaModel m, PetaniDftrKerjasama v, PetaniTbhKerjasama v2){
        this.v = v;
        this.v2 = v2;
        this.m = m;
        v.setVisible(true);
    }
}
