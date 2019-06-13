/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PengusahaDftrKebutuhanModel;
import view.PengusahaDftrKebutuhan;
import view.PengusahaTbhKebutuhan;

/**
 *
 * @author verdy
 */
public class PengusahaDftrKebutuhanController {
     PengusahaDftrKebutuhanModel m;
    PengusahaDftrKebutuhan v;    
    PengusahaTbhKebutuhan v2;
       
    public PengusahaDftrKebutuhanController(PengusahaDftrKebutuhanModel m, PengusahaDftrKebutuhan v, PengusahaTbhKebutuhan v2){
        this.v = v;
        this.v2 = v2;
        this.m = m;
        v.setVisible(true);
    }
}
