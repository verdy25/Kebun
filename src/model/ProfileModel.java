/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author verdy
 */
public class ProfileModel extends connector.connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    int id;
    String propinsi;
    String kota;

    public ProfileModel(int id) {
        this.id = id;
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String[] getProfil() {
        String data[] = new String[14];
        try {
            String sql = "select * from user where id = ?";
            connection = Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            data[0] = resultSet.getString("nama");
            data[1] = resultSet.getString("email");
            data[2] = resultSet.getString("hp");
            data[3] = resultSet.getString("telp");
            data[4] = resultSet.getString("nama_perusahaan");
            data[5] = resultSet.getString("provinsi");
            data[6] = resultSet.getString("kota");
            data[7] = resultSet.getString("kecamatan");
            data[8] = resultSet.getString("alamat");
            data[9] = resultSet.getString("kodepos");
            data[10] = resultSet.getString("deskripsi");
            data[11] = resultSet.getString("website");
            data[12] = resultSet.getString("password");
            data[13] = resultSet.getString("id");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public List<String> dataProvinsi() {
        List<String> provinsi = new ArrayList<>();
        try {
            String sql = "SELECT * FROM propinsi";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                provinsi.add(rs.getString("nama_propinsi"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return provinsi;
    }

//    public List<String> dataKota(String propinsi) {
//        this.propinsi = propinsi;
//        List<String> kota = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM kota join propinsi on kota.id_propinsi = propinsi.id_propinsi where propinsi.nama_propinsi = ? ";
//            connection = Connection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, propinsi);
//            resultSet = preparedStatement.executeQuery();
//            
//            while (resultSet.next()) {
//                kota.add(resultSet.getString("nama_kota"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return kota;
//    }
    
//    public List<String> dataKecamatan(String kota, String propinsi) {
//        this.kota = kota;
//        this.propinsi = propinsi;
//        List<String> kecamatan = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM kecamatan k join kota ko on k.id_kota = ko.id_kota "
//                    + "join propinsi p on k.id_propinsi = p.id_propinsi where ko.nama_kota = ? and p.nama_propinsi = ?";
//            connection = Connection();
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, kota);
//            preparedStatement.setString(2, propinsi);
//            resultSet = preparedStatement.executeQuery();
//            
//            while (resultSet.next()) {
//                kecamatan.add(resultSet.getString("nama_kecamatan"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return kecamatan;
//    }

    public void simpan(String nama, String password, String email,
            String hp, String telp, String nama_perusahaan, String provinsi,
            String kota, String kec, String alamat, String kodepos, String deskripsi,
            String website) {

        try {
            String sql = "UPDATE user SET nama = ?, password = ?, email = ?, hp = ?, telp = ?,"
                    + " nama_perusahaan = ?, provinsi = ?, kota = ?, kecamatan = ?,"
                    + " alamat = ?, kodepos = ?, deskripsi = ?, website = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, hp);
            preparedStatement.setString(5, telp);
            preparedStatement.setString(6, nama_perusahaan);
            preparedStatement.setString(7, provinsi);
            preparedStatement.setString(8, kota);
            preparedStatement.setString(9, kec);
            preparedStatement.setString(10, alamat);
            preparedStatement.setString(11, kodepos);
            preparedStatement.setString(12, deskripsi);
            preparedStatement.setString(13, website);
            preparedStatement.setInt(14, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
