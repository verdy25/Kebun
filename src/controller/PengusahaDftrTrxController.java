/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PengusahaDftrTrxModel;
import view.PengusahaDftrTrx;

/**
 *
 * @author verdy
 */
public class PengusahaDftrTrxController {
    
    PengusahaDftrTrxModel m;
    PengusahaDftrTrx v;    
       
    public PengusahaDftrTrxController(PengusahaDftrTrxModel m, PengusahaDftrTrx v){
        this.v = v;
        this.m = m;
        v.setVisible(true);
    }
}
