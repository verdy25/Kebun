/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author verdy
 */
public class TransaksiModel extends connector.connection{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id;

    public TransaksiModel(int id) {
        try {
            this.id = id;
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public DefaultTableModel tableTransaksi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id transaksi");
        model.addColumn("Lapak");
        model.addColumn("Tanggal");

        try {
            String sql = "SELECT * FROM transaksi t join verifikasi v on t.id_verifikasi = v.id_verifikasi join lapak l on l.id_lapak = v.id_lapak where l.id_pemilik = ? or v.peminat = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_transaksi"), resultSet.getString("judul"), resultSet.getString("tanggal")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel verif : "+e.getMessage());
        }
        return model;

    }

    public void updateTableTransaksi(DefaultTableModel model) {
        try {
            String sql = "SELECT * FROM transaksi t join verifikasi v on t.id_verifikasi = v.id_verifikasi join lapak l on l.id_lapak = v.id_lapak where l.id_pemilik = ? or v.peminat = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_transaksi"), resultSet.getString("judul"), resultSet.getString("tanggal")
                });
            }

        } catch (SQLException e) {
            System.out.println("update tabel verif : "+e.getMessage());
        }
    }
}
