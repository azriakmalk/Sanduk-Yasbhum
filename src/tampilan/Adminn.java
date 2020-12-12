/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author azri
 */
public class Adminn extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form Adminn
     */
    public Adminn() {
        initComponents();
        datatable();
        bersih();
    }

    public void datatable(){
       Object[] Baris ={"Id","Nama","Password","Email","Telp","Akses"};
        tabmode = new DefaultTableModel(null,Baris);
        tabel_petugas.setModel(tabmode);
       
        String sql = "select * from petugas";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){               
                String a = hasil.getString("id");
                String b = hasil.getString("nama");
                String c = hasil.getString("password");
                String d = hasil.getString("email");
                String e = hasil.getString("telp");
                String f = hasil.getString("akses");
                
                String[] data={a,b,c,d,e,f};
                tabmode.addRow(data);
            }
        }catch (Exception e){
            
        }
    }
    public void bersih(){
        tadmin.setText(null);
        tnama.setText(null);
        tmail.setText(null);
        ttelp.setText(null);
        tpass.setText(null);
        tpass2.setText(null);
        cakses.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tadmin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tnama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        binput = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ttelp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tpass = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        tpass2 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        cakses = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_petugas = new javax.swing.JTable();
        bcari = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        breport = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("YASBHUM [Login]");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/tampilan/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Id Admin");

        tadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tadminActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nama Admin");

        tnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamaActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email Admin");

        tmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Petugas");

        binput.setBackground(new java.awt.Color(255, 102, 102));
        binput.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        binput.setForeground(new java.awt.Color(255, 255, 255));
        binput.setText("Masukan Data");
        binput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binputActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No Telepon");

        ttelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttelpActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Kata Sandi");

        tpass.setText("jPasswordField1");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ulangi Kata Sandi");

        tpass2.setText("jPasswordField1");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ulangi Kata Sandi");

        cakses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Akses--", "Petugas", "Admin" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(ttelp)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(tmail)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(tnama)
                    .addComponent(binput, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(tadmin)
                    .addComponent(tpass)
                    .addComponent(tpass2)
                    .addComponent(cakses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ttelp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tpass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cakses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(binput, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        tabel_petugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_petugasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_petugas);

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        tcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcariActionPerformed(evt);
            }
        });

        bedit.setBackground(new java.awt.Color(255, 153, 153));
        bedit.setForeground(new java.awt.Color(255, 255, 255));
        bedit.setText("Edit Data");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        breport.setText("Cetak Laporan");
        breport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breportActionPerformed(evt);
            }
        });

        bkembali.setText("Kembali");
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bedit)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(breport))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(bcari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bkembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tadminActionPerformed

    private void tnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamaActionPerformed

    private void tmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmailActionPerformed

    private void binputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binputActionPerformed
        // TODO add your handling code here:
        if(tadmin.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap ID Admin Diisi","Peringatan",0);
        }else if(tpass.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kata Sandi Tidak Boleh Kosong","Peringatan",0);
        }else if(tmail.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong","Peringatan",0);
        }else if(ttelp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No Telpon Tidak Boleh Kosong","Peringatan",0);
        }else if(cakses.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Pilih Akses Terlebih Dahulu19","Peringatan",0);
        }else if(tpass.getText().equals(tpass2.getText())){
            String sql="insert into petugas values(?,?,?,?,?,?)";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tadmin.getText());
                stat.setString(2, tnama.getText());
                stat.setString(3, tpass.getText());
                stat.setString(4, tmail.getText());
                stat.setString(5, ttelp.getText());
                String akses= "";
                if(cakses.getSelectedIndex()==2){
                    akses = "Admin";
                }else{
                    akses="Petugas";
                }
                stat.setString(6,akses);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                datatable();
                bersih();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan : ID Admin sudah ada \n"+e);

            }
        }else{
            JOptionPane.showMessageDialog(null,"Kata Sandi Tidak Sama","Peringatan",0);
        }
    }//GEN-LAST:event_binputActionPerformed

    private void ttelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttelpActionPerformed

    private void tabel_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_petugasMouseClicked
        // TODO add your handling code here:
        int bar = tabel_petugas.getSelectedRow();
        String a =tabmode.getValueAt(bar, 0).toString();
        String b =tabmode.getValueAt(bar, 1).toString();
        String c =tabmode.getValueAt(bar, 2).toString();
        String d =tabmode.getValueAt(bar, 3).toString();
        String e =tabmode.getValueAt(bar, 4).toString();
        String f =tabmode.getValueAt(bar, 5).toString();

        tadmin.setText(a);
        tnama.setText(b);
        tpass.setText(c);
        tpass2.setText(c);
        tmail.setText(d);
        ttelp.setText(e);

        if(f.equals("Admin")){
            cakses.setSelectedIndex(2);
        }else{
            cakses.setSelectedIndex(1);
        }
    }//GEN-LAST:event_tabel_petugasMouseClicked

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        if(tcari.getText().equals("")){
            datatable();
        }else{
            Object[] Baris ={"Id","Nama","Password","Email","Telp","Akses"};
            tabmode = new DefaultTableModel(null,Baris);
            tabel_petugas.setModel(tabmode);

            String sql = "select * from petugas where id = '"+tcari.getText()+"' or nama ='"+tcari.getText()+"' or akses ='"+tcari.getText()+"'";
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String a = hasil.getString("id");
                    String b = hasil.getString("nama");
                    String c = hasil.getString("password");
                    String d = hasil.getString("email");
                    String e = hasil.getString("telp");
                    String f = hasil.getString("akses");

                    String[] data={a,b,c,d,e,f};
                    tabmode.addRow(data);

                }
            }catch (Exception e){

            }
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void tcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if(tadmin.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap ID Admin Diisi","Peringatan",0);
        }else if(tpass.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Kata Sandi Tidak Boleh Kosong","Peringatan",0);
        }else if(tmail.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Email Tidak Boleh Kosong","Peringatan",0);
        }else if(ttelp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"No Telpon Tidak Boleh Kosong","Peringatan",0);
        }else if(cakses.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null,"Pilih Akses Terlebih Dahulu","Peringatan",0);
        }else if(tpass.getText().equals(tpass2.getText())){
            try{
                String sql = "update petugas set nama=?,password=?,email=?,telp=?,akses=? where id=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1,tnama.getText());
                stat.setString(2,tpass.getText());
                stat.setString(3,tmail.getText());
                stat.setString(4,ttelp.getText());
                String akses = "";
                if(cakses.getSelectedIndex()==1){
                    akses="Petugas";
                }else{
                    akses="Admin";
                }
                stat.setString(5,akses);
                stat.setString(6,tadmin.getText());
                stat.executeUpdate();
                datatable();
                bersih();
                JOptionPane.showMessageDialog(null,"Berhasil Diubah");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Diubah : "+e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Kata Sandi Tidak Sama","Peringatan",0);
        }

    }//GEN-LAST:event_beditActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        if(tadmin.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap Pilih Data Terlebih Dahulu","Peringatan",0);
        }else{
            int ok = JOptionPane.showConfirmDialog(null,"Hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
            if(ok==0){
                String sql = "delete from petugas where id='"+tadmin.getText()+"'";
                try{
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                    datatable();
                    bersih();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Data Gagal Dihapus : "+e);
                }
            }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        Login re=new Login();
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void breportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breportActionPerformed
        // TODO add your handling code here:
        try{            
            String namaFile = "src/tampilan/Petugas.jasper";
            HashMap parameter = new HashMap(1);
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_breportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Adminn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adminn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adminn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adminn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton binput;
    private javax.swing.JButton bkembali;
    private javax.swing.JButton breport;
    private javax.swing.JComboBox<String> cakses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_petugas;
    private javax.swing.JTextField tadmin;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tmail;
    private javax.swing.JTextField tnama;
    private javax.swing.JPasswordField tpass;
    private javax.swing.JPasswordField tpass2;
    private javax.swing.JTextField ttelp;
    // End of variables declaration//GEN-END:variables
}
