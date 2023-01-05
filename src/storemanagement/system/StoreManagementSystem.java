/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package storemanagement.system;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author angga
 */
public class StoreManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         StoreManagementSystem koneksi = new StoreManagementSystem();
        koneksi.KoneksiDB();
    }
    
    Connection koneksi = null;
    String status = "";
    
    
    public void KoneksiDB() {
        try {
            String url = "jdbc:mysql://localhost/store-manajemen";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection)DriverManager.getConnection(url, username, password);
            status = "Berhasil mengkoneksikan java ke DB MYSQL";
        } catch (Exception error) {
            status = "Gagal mengkoneksikan java ke DB MYSQL";
            System.exit(0);
        }
    }
}
