/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author verdy
 */
public class BerandaModel extends connector.connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id_pelapak, id_lapak, id;

    public BerandaModel(int id) {
        try {
            this.id = id;
            connection = Connection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public DefaultTableModel tableKerjasama(String apahayo) {
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
            String sql = "select * from lapak where tipe_lapak = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, apahayo);
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

    public void updateTableKerjasama(DefaultTableModel model, String apahayo) {

        try {
            String sql = "select * from lapak where tipe_lapak = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, apahayo);
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

    public ImageIcon getImage(byte[] img) {
        ImageIcon image = new ImageIcon(img);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        return newImage;
    }

    public String[] getPelapak(int id_lapak) {
        String data[] = new String[2];
        try {
            String sql = "select * from user u join lapak l on l.id_pemilik = u.id WHERE l.id_lapak = ?";
            connection = Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_lapak);
            System.out.println(id_lapak);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            this.id_pelapak = resultSet.getInt("id_pemilik");
            this.id_lapak = id_lapak;                    
            data[0] = resultSet.getString("email");
            data[1] = resultSet.getString("hp");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void sayaMau() {
        try {
            String sql = "INSERT INTO verifikasi(id_lapak, peminat, status) VALUES (?,?,?)";
            connection = Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_lapak);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, "Belum disetujui");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
