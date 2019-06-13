/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
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
public class PetaniDftrKerjasamaModel extends connector.connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    int id, id_lapak;
    String propinsi;
    String kota;

    public PetaniDftrKerjasamaModel(int id) {
        this.id = id;
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel tableKerjasama() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Judul");
        model.addColumn("deskripsi");
        model.addColumn("komoditi");
        model.addColumn("kebutuhan");
        model.addColumn("unit");
        model.addColumn("tanggal");
        model.addColumn("foto");

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
                    resultSet.getString("tanggal"),
                    resultSet.getBytes("foto")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel kerjasama : " + e.getMessage());
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
                    resultSet.getString("tanggal"),
                    resultSet.getBytes("foto")
                });
            }

        } catch (SQLException e) {
            System.out.println("tabel kerjasama : " + e.getMessage());
        }
    }

    public void buatLapakKerjasama(String judul, String deskripsi, String komoditi, int kebutuhan,
            String unit, String s) throws FileNotFoundException {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String tanggal = dateFormat.format(date);
        try {
            String sql = "INSERT INTO lapak(judul, deskripsi, komoditi, kebutuhan, unit, tanggal, foto, id_pemilik, tipe_lapak) "
                    + "VALUES (?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            InputStream is = new FileInputStream(new File(s));
            preparedStatement.setString(1, judul);
            preparedStatement.setString(2, deskripsi);
            preparedStatement.setString(3, komoditi);
            preparedStatement.setInt(4, kebutuhan);
            preparedStatement.setString(5, unit);
            preparedStatement.setString(6, tanggal);
            preparedStatement.setBlob(7, is);
            preparedStatement.setInt(8, id);
            preparedStatement.setString(9, "kerjasama");
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Inserted");
        } catch (SQLException e) {
            System.out.println("buatlapak : " + e.getMessage());
        }

    }
    
    public void updateLapakKerjasama(String judul, String deskripsi, String komoditi, int kebutuhan,
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
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ImageIcon getImage(byte[] img) {
        ImageIcon image = new ImageIcon(img);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(200, 90, Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        return newImage;
    }
}
