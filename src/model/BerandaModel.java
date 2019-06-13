/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author verdy
 */
public class BerandaModel extends connector.connection{
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id;

    public BerandaModel() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public DefaultTableModel tabelLapak(){
        DefaultTableModel model = new DefaultTableModel();
        return model;
    }
}
