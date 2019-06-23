/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
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
        v.setTabel(v.getTable(), m.tableTransaksi());
        v.btnRefresh().addActionListener(new refresh());
    }
    
    public TransaksiController(TransaksiModel m, PengusahaDftrTrx v2){
        this.v2 = v2;
        this.m = m;
        v2.setVisible(true);
        v2.setTabel(v2.getTable(), m.tableTransaksi());
        v2.btnRefresh().addActionListener(new refresh());
    }
    
    private class refresh implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v.getTable().getModel();
            model.setRowCount(0);
            m.updateTableTransaksi(model);
        }
    }
    
    private class refresh2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) v2.getTable().getModel();
            model.setRowCount(0);
            m.updateTableTransaksi(model);
        }
    }
}
