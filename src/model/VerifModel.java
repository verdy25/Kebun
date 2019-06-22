/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pojo.p_verif;

/**
 *
 * @author verdy
 */
public class VerifModel extends connector.connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    int id, id_verifikasi;

    public VerifModel(int id) {
        try {
            this.id = id;
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel tableVerif() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Lapak");
        model.addColumn("Status");

        try {
            String sql = "select * from verifikasi v join user u on v.peminat = u.id JOIN lapak l on v.id_lapak = l.id_lapak WHERE l.id_pemilik = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_verifikasi"), resultSet.getString("nama"), resultSet.getString("judul"),
                    resultSet.getString("status")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel verif : "+e.getMessage());
        }
        return model;

    }

    public void updateTableVerif(DefaultTableModel model) {
        try {
            String sql = "select * from verifikasi v join user u on v.peminat = u.id JOIN lapak l on v.id_lapak = l.id_lapak WHERE l.id_pemilik = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("id_verifikasi"), resultSet.getString("nama"), resultSet.getString("judul"),
                    resultSet.getString("status")
                });
            }

        } catch (SQLException e) {
            System.out.println("update tabel verif : "+e.getMessage());
        }
    }

    public void verifikasi(int id_verifikasi) {
        try {
            String sql = "UPDATE verifikasi SET status = 'Disetujui' WHERE id_verifikasi = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_verifikasi);
            ps.executeUpdate();
            this.id_verifikasi = id_verifikasi;
            
        } catch (SQLException e) {
            System.out.println("verifikasi : "+e.getMessage());
        }

    }
    
    public void transaksiSukses(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String tanggal = dateFormat.format(date);
        try {
            String sql = "INSERT INTO transaksi(id_verifikasi, tanggal) "
                    + "VALUES (?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_verifikasi);
            preparedStatement.setString(2, tanggal);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi sukses");
        } catch (SQLException e) {
            System.out.println("transaksi sukses : " + e.getMessage());
        }

    }
}
