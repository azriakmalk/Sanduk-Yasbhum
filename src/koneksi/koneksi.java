/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.io.FileNotFoundException;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author devi
 */
public class koneksi {
    private Connection koneksi;
    private Properties prop = new Properties();
    //File file = new File("C:/Sanduk/");
    public Connection connect(){
        InputStream input = null;
    try {
            input = new FileInputStream("config.txt");
            prop.load(input);// method load digunakan untuk membuka file properties
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("pass");
            Class.forName(driver);
                koneksi = DriverManager.getConnection(url, user, password);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"IOException "+ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Exception "+ex);
            Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE, null, ex);
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
         }return koneksi;
}
}

