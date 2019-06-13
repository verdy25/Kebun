/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import pojo.p_verif;

/**
 *
 * @author verdy
 */
public class PengusahaVerifModel extends connector.connection{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id;

    public PengusahaVerifModel() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public DefaultTableModel tableVerif() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Lapak");
        model.addColumn("Status");

        try {
            String sql = "select * from verifikasi";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            int no = 0;
            while (resultSet.next()) {
                no++;
                model.addRow(new Object[]{
                    resultSet.getString("nama"), resultSet.getString("lapak"),
                    resultSet.getString("status")
                });
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return model;

    }

    public void verifikasi(String n) {
        p_verif p = new p_verif(n);
        String nama = p.getNama();
        try {
            String sql = "UPDATE verifikasi SET Status = 'Disetujui' WHERE Nama = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, n);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }

    }
}
