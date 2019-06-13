/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import connector.connection;
import java.awt.Image;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author verdy
 */
public class UserModel extends connection {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public UserModel() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void daftar(String nama, String email, String password, int level) throws SQLException {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        boolean cocok = matcher.matches();
        try {
            if (password.length() < 6 || password.length() > 16) {
                JOptionPane.showMessageDialog(null, "password kurang memenuhi syarat");
            } else if (cocok == false) {
                JOptionPane.showMessageDialog(null, "email harus nama@web.domain");
            } else {
                try {
                    String sql = "INSERT INTO user(nama, email, password, level) VALUES (?,?,?,?);";
                    connection = Connection();
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nama);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, password);
                    preparedStatement.setInt(4, level);
                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Pendaftaran sukses");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }

    }

    public String[] login(String email, String password) throws SQLException {
        String level[] = new String[3];
        try {
            String sql = "select * from user where email = ? and password = ?";
            connection = Connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            level[0] = resultSet.getString("id");
            level[1] = resultSet.getString("level");
            level[2] = resultSet.getString("nama");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return level;
    }

}
