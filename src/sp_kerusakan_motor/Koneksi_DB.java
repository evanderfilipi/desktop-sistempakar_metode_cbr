/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp_kerusakan_motor;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Evander Filipi
 */
public class Koneksi_DB {
    
    private static Connection koneksi;
    
    public static Connection getConnection() throws SQLException {
        if(koneksi==null) {
            new Driver();
            
            koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sistem_pakar","root","");
             
        }
        return koneksi;
    }
    
}
