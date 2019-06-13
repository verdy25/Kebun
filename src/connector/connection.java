/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author verdy
 */
public class connection {
    
   static Connection koneksi;

    protected static Connection Connection() {
        if (koneksi == null) {
//            String database = "verdy_pbo";
//            String username = "verdy";
//            String password = "verdyelek";128.199.196.208
                String database = "kebun";
                String username = "root";
                String password = "";
            try {
                koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + database, username, password);
                System.out.println("sukses");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return koneksi;
    }
}
