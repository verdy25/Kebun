/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PetaniDftrTrxModel;
import view.PetaniDftrTrx;

/**
 *
 * @author verdy
 */
public class PetaniDftrTrxController {
    PetaniDftrTrxModel m;
    PetaniDftrTrx v;    
       
    public PetaniDftrTrxController(PetaniDftrTrxModel m, PetaniDftrTrx v){
        this.v = v;
        this.m = m;
        v.setVisible(true);
    }
}
