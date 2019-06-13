/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author verdy
 */
public class PengusahaDftrTrxModel extends connector.connection{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public int id;

    public PengusahaDftrTrxModel() {
        try {
            connection = Connection();
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
