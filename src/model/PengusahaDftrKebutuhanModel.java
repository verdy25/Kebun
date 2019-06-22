/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.HeadlessException;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author verdy
 */
public class PengusahaDftrKebutuhanModel extends connector.connection{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id;

    public PengusahaDftrKebutuhanModel(int id) {
        this.id = id;
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public DefaultTableModel tableKebutuhan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("judul");
        model.addColumn("deskripsi");
        model.addColumn("komoditi");
        model.addColumn("kebutuhan");
        model.addColumn("unit");
        model.addColumn("tanggal");

        try {
            String sql = "select * from lapak where id_pemilik = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getInt("id_lapak"),
                    resultSet.getString("Judul"),
                    resultSet.getString("deskripsi"),
                    resultSet.getString("komoditi"),
                    resultSet.getInt("kebutuhan"),
                    resultSet.getString("unit"),
                    resultSet.getString("tanggal")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel kebutuhan : " + e.getMessage());
        }
        return model;

    }

    public void update(DefaultTableModel model) {
        try {
            String sql = "select * from lapak where id_pemilik = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet = ps.executeQuery();

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getInt("id_lapak"),
                    resultSet.getString("Judul"),
                    resultSet.getString("deskripsi"),
                    resultSet.getString("komoditi"),
                    resultSet.getInt("kebutuhan"),
                    resultSet.getString("unit"),
                    resultSet.getString("tanggal")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel kebutuhan : " + e.getMessage());
        }
    }

    public void buatLapakKebutuhan(String judul, String deskripsi, String komoditi, int kebutuhan,
            String unit) throws FileNotFoundException {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String tanggal = dateFormat.format(date);
        try {
            String sql = "INSERT INTO lapak(judul, deskripsi, komoditi, kebutuhan, unit, tanggal, id_pemilik, tipe_lapak) "
                    + "VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, deskripsi);
            preparedStatement.setString(3, komoditi);
            preparedStatement.setInt(4, kebutuhan);
            preparedStatement.setString(5, unit);
            preparedStatement.setString(6, tanggal);
            preparedStatement.setInt(7, id);
            preparedStatement.setString(8, "kebutuhan");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Inserted");
        } catch (SQLException e) {
            System.out.println("buatlapak : " + e.getMessage());
        }

    }
    
    public void updateLapakKebutuhan(String judul, String deskripsi, String komoditi, int kebutuhan,
            String unit, int id_lapak) throws FileNotFoundException {
        
        try {
            String sql = "update lapak set judul = ? , deskripsi = ?, komoditi = ?, kebutuhan = ?, unit = ? where id_lapak = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, deskripsi);
            preparedStatement.setString(3, komoditi);
            preparedStatement.setInt(4, kebutuhan);
            preparedStatement.setString(5, unit);
            preparedStatement.setInt(6, id_lapak);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Updated");
        } catch (SQLException e) {
            System.out.println("update lapak : " + e.getMessage());
        }

    }
    
    public void deleteLapak(int id_lapak){
        try {
            String sql = "delete from lapak where id_lapak = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_lapak);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted");
        } catch (HeadlessException | SQLException e) {
            System.out.println("delete lapak : "+e.getMessage());
        }
    }

}
