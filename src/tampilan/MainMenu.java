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
 * @author Azri
 */
public class MainMenu extends javax.swing.JFrame {
    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public String nrp = null;
    public String nomor = null;
    public String nrpedit = null;
    public Properties prop = new Properties();
    
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        datatable();
        tno.disable();
        bersih();
        awal.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        akhir.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        this.setLocationRelativeTo(null);
        new Thread(){
            public void run(){
                while (true){
                    Calendar kal = new GregorianCalendar();
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String waktu = jam+":"+menit+":"+detik;
                    ljam.setText(waktu);
                }
                }
        }.start();
        }
    
    public void duplikatno(){
        String sql = "select * from santunan1 where nomor='"+tno.getText()+"'";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nomor");                
                nomor = a;
            }    
        }catch(SQLException e){
            
        }
    }
    public void duplikatnrp(){        
        String sql = "select * from santunan1 where nrp='"+tnrp.getText()+"' limit 1";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nrp");                
                nrp = a;
            }
        }catch(SQLException e){
            
        }
    }
    public void duplikatnrpedit(){        
        String sql = "select * from santunan1 where nrp='"+tnrp.getText()+"' and not nomor='"+tno.getText()+"' limit 1";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("nrp");                
                nrpedit = a;
            }
        }catch(SQLException e){
            
        }
    }
    
    public void datatable(){
        Object[] Baris ={"Nomor","No Kwitansi","Tanggal","Nama","Pangkat","Kesatuan","NRP","Wilayah","Status","Tgl Meninggal","Ya","Tgl SRT","No SRT"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelyasbhum.setModel(tabmode);
       
        String sql = "select * from santunan1 order by nomor desc";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){               
                String a = hasil.getString("nomor");
                String b = hasil.getString("no_kwitansi");
                String c = hasil.getString("tanggal");
                String d = hasil.getString("Nama");
                String e = hasil.getString("Pangkat");
                String f = hasil.getString("kesatuan");
                String g = hasil.getString("nrp"); 
                String h = hasil.getString("wilayah");
                String i = hasil.getString("Status");
                String j = hasil.getString("tgl_meninggal");
                String k = hasil.getString("ya");
                String l = hasil.getString("tglsrt");
                String m = hasil.getString("nosrt");
                
                String[] data={a,b,c,d,e,f,g,h,i,j,k,l,m,};
                tabmode.addRow(data);
                

            }
        }catch (Exception e){
            
        }
    }
    public void bersih(){
        tno.setText(null);
        tkwi.setText(null);        
        tnama.setText(null);
        tpangkat.setText(null);
        tkesatuan.setText(null);
        tnrp.setText(null);
        twilayah.setText(null);
        tstatus.setText(null);
        cya.setSelected(false);
        tnosrt.setText(null);
        tkwi.requestFocus();
        ctgl.setDate(null);
        ctglmening.setDate(null);
        ctglsrt.setDate(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        awal = new org.freixas.jcalendar.JCalendarCombo();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        akhir = new org.freixas.jcalendar.JCalendarCombo();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        trkesatuan = new javax.swing.JTextField();
        banggota = new javax.swing.JButton();
        trpangkat = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        bkwitansi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tnosrt = new javax.swing.JTextField();
        twilayah = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tpangkat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tno = new javax.swing.JTextField();
        tstatus = new javax.swing.JTextField();
        tkesatuan = new javax.swing.JTextField();
        tnama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tnrp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tkwi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bcari = new javax.swing.JButton();
        tcari = new javax.swing.JTextField();
        ctgl = new com.toedter.calendar.JDateChooser();
        ctglmening = new com.toedter.calendar.JDateChooser();
        ctglsrt = new com.toedter.calendar.JDateChooser();
        cya = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelyasbhum = new javax.swing.JTable();
        ljam = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Yasbhum");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/tampilan/icon.png")).getImage());

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        jButton6.setText("JAKARTA 10710");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText("JL. Pasar Baru Selatan No. 28 Telp:(021) 3588301 (Hunting)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/icon.png"))); // NOI18N
        jButton4.setText("YAYASAN SOSIAL BHUMYAMCA");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jButton2.setText("Report Periodik");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel15.setText("S/D");

        akhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                akhirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(awal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(akhir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(awal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(akhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Periodik", jPanel3);

        jButton3.setText("Report Admin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton3)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel5);

        jLabel16.setText("Masukkan Kesatuan :");

        banggota.setText("Report Anggota");
        banggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banggotaActionPerformed(evt);
            }
        });

        jLabel17.setText("Masukkan Pangkat   :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trkesatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(banggota)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trpangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(trkesatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(trpangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(banggota)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Anggota", jPanel7);

        bkwitansi.setText("Report Petugas");
        bkwitansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkwitansiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bkwitansi)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(bkwitansi)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Petugas", jPanel8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel9.setText("STATUS");

        jLabel11.setText("STATUS MENINGGAL");

        jLabel6.setText("KESATUAN");

        jLabel8.setText("WILAYAH");

        jLabel7.setText("NRP/NIP/NO_KTA");

        jLabel5.setText("PANGKAT");

        jLabel2.setText("NOMOR KWITANSI");

        jLabel12.setText("TGL SRT");

        tnrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnrpActionPerformed(evt);
            }
        });

        jLabel4.setText("N A M A");

        tkwi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkwiActionPerformed(evt);
            }
        });

        jLabel10.setText("TGL MENINGGAL");

        jLabel13.setText("NO SRT");

        jLabel1.setText("NOMOR URUT");

        jLabel3.setText("TGL TRANSFER");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/tambah.png"))); // NOI18N
        jButton1.setText("TAMBAH DATA");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/simpan.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/hapus.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/update.png"))); // NOI18N
        bupdate.setText("UBAH DATA");
        bupdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        bcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tampilan/cari.png"))); // NOI18N
        bcari.setText("CARI NRP");
        bcari.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        tcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tcariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bcari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tcari))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(bcari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ctgl.setDateFormatString("dd/M/yyyy");

        ctglmening.setDateFormatString("dd/M/yyyy");

        ctglsrt.setDateFormatString("dd/M/yyyy");

        cya.setText("Ya");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tstatus)
                            .addComponent(twilayah)
                            .addComponent(tnrp)
                            .addComponent(tkesatuan)
                            .addComponent(tpangkat)
                            .addComponent(tno)
                            .addComponent(tnama)
                            .addComponent(tkwi)
                            .addComponent(ctgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ctglmening, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cya)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tnosrt, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(ctglsrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tkwi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(ctgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tpangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tkesatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(twilayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(ctglmening, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cya))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(ctglsrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tnosrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tabelyasbhum.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelyasbhum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelyasbhumMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelyasbhum);

        ljam.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ljam.setText("WAKTU");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ljam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ljam, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jScrollPane2.setViewportView(jPanel6);

        jMenu1.setText("File");

        jMenuItem1.setText("Restore");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Backup");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelyasbhumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelyasbhumMouseClicked
        // TODO add your handling code here:

        int bar = tabelyasbhum.getSelectedRow();
        String a =tabmode.getValueAt(bar, 0).toString();
        String b =tabmode.getValueAt(bar, 1).toString();
        String d =tabmode.getValueAt(bar, 3).toString();
        String e =tabmode.getValueAt(bar, 4).toString();
        String f =tabmode.getValueAt(bar, 5).toString();
        String g =tabmode.getValueAt(bar, 6).toString();
        String h =tabmode.getValueAt(bar, 7).toString();
        String i =tabmode.getValueAt(bar, 8).toString();
        String k =tabmode.getValueAt(bar, 10).toString();
        String m =tabmode.getValueAt(bar, 12).toString();
        String t1=(String)tabelyasbhum.getModel().getValueAt(bar, 2);
        String t2=(String)tabelyasbhum.getModel().getValueAt(bar, 9);
        String t3=(String)tabelyasbhum.getModel().getValueAt(bar, 11);
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date c,j,l;
            c = sd.parse(t1);
            j = sd.parse(t2);
            l = sd.parse(t3);
            ctgl.setDate(c);
            ctglmening.setDate(j);
            ctglsrt.setDate(l);
        } catch (ParseException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(k.equals("Ya")){
            cya.setSelected(true);
        }else{
            cya.setSelected(false);
        }
        tno.setText(a);
        tkwi.setText(b);
        tnama.setText(d);
        tpangkat.setText(e);
        tkesatuan.setText(f);
        tnrp.setText(g);
        twilayah.setText(h);
        tstatus.setText(i);
        tnosrt.setText(m);
    }//GEN-LAST:event_tabelyasbhumMouseClicked

    private void tcariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcariKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tcariKeyTyped

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        if(tcari.getText().equals("")){
            datatable();
        }else{
            Object[] Baris ={"Nomor","No Kwitansi","Tanggal","Nama","Pangkat","Kesatuan","NRP","Wilayah","Status","Tgl Meninggal","Ya","Tgl SRT","No SRT"};
            tabmode = new DefaultTableModel(null,Baris);
            tabelyasbhum.setModel(tabmode);

            String sql = "select * from santunan1 where nrp = '"+tcari.getText()+"'";
            try{
                java.sql.Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    String a = hasil.getString("nomor");
                    String b = hasil.getString("no_kwitansi");
                    String c = hasil.getString("tanggal");
                    String d = hasil.getString("Nama");
                    String e = hasil.getString("Pangkat");
                    String f = hasil.getString("kesatuan");
                    String g = hasil.getString("nrp");
                    String h = hasil.getString("wilayah");
                    String i = hasil.getString("Status");
                    String j = hasil.getString("tgl_meninggal");
                    String k = hasil.getString("ya");
                    String l = hasil.getString("tglsrt");
                    String m = hasil.getString("nosrt");

                    String[] data={a,b,c,d,e,f,g,h,i,j,k,l,m};
                    tabmode.addRow(data);

                }
            }catch (Exception e){

            }
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        duplikatno();
        duplikatnrpedit();
        if(tno.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap Pilih Data Terlebih Dahulu","Peringatan",0);
        }else if(tkwi.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Kwitansi Tidak Boleh Kosong","Peringatan",0);
        }else if(tnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Nama Tidak Boleh Kosong","Peringatan",0);
        }else if(tpangkat.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Pangkat Tidak Boleh Kosong","Peringatan",0);
        }else if(tkesatuan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Kesatuan Tidak Boleh Kosong","Peringatan",0);
        }else if(tnrp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data NRP Tidak Boleh Kosong","Peringatan",0);
        }else if(twilayah.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Wilayah Tidak Boleh Kosong","Peringatan",0);
        }else if(tstatus.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Status Tidak Boleh Kosong","Peringatan",0);
        }else if(tnosrt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nomor SRT Harus Diisi","Peringatan",0);
        }else if(tnrp.getText().toUpperCase().equals(nrpedit)){
            JOptionPane.showMessageDialog(null,"Data NRP Sudah Ada");
        }else{
            try{
                String tampilan ="yyyy-MM-dd" ;
                SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                String tgl = String.valueOf(fm.format(ctgl.getDate()));
                String tglm = String.valueOf(fm.format(ctglmening.getDate()));
                String tgls = String.valueOf(fm.format(ctglsrt.getDate()));
                String sql = "update santunan1 set No_kwitansi=?,tanggal=?,nama=?,pangkat=?,kesatuan=?,nrp=?,wilayah=?,status=?,tgl_meninggal=?,ya=?,tglsrt=?,nosrt=? where nomor=?";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1,tkwi.getText());
                stat.setString(2,tgl);
                stat.setString(3,tnama.getText());
                stat.setString(4,tpangkat.getText());
                stat.setString(5,tkesatuan.getText());
                stat.setString(6,tnrp.getText().toUpperCase());
                stat.setString(7,twilayah.getText());
                stat.setString(8,tstatus.getText());
                stat.setString(9,tglm);
                String y = "";
                if(cya.isSelected()){
                    y="Ya";
                }else{y="No";}
                stat.setString(10,y);
                stat.setString(11,tgls);
                stat.setString(12,tnosrt.getText());
                stat.setString(13,tno.getText());
                stat.executeUpdate();
                datatable();
                bersih();
                JOptionPane.showMessageDialog(null,"Berhasil Diubah");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Diubah : "+e);
            }
        }
    }//GEN-LAST:event_bupdateActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        if(tno.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap Pilih Data Terlebih Dahulu","Peringatan",0);
        }else{
        int ok = JOptionPane.showConfirmDialog(null,"Hapus","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
                String sql = "delete from santunan1 where nomor='"+tno.getText()+"' and nrp='"+tnrp.getText()+"'";
                try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"data berhasil dihapus");
                datatable();
                bersih();
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus : "+e);
                }
                }
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        duplikatno();
        duplikatnrp();
        if(tno.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Harap Klik Tambah Data Terlebih Dahulu","Peringatan",0);
        }else if(tkwi.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Kwitansi Tidak Boleh Kosong","Peringatan",0);
        }else if (tno.getText().equals("") || tno.getText().equals(nomor)){
            JOptionPane.showMessageDialog(null,"Harap Klik Tambah Data Sebelum Menyimpan");
        }else if(tnama.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Nama Tidak Boleh Kosong","Peringatan",0);
        }else if(tpangkat.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Pangkat Tidak Boleh Kosong","Peringatan",0);
        }else if(tkesatuan.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Kesatuan Tidak Boleh Kosong","Peringatan",0);
        }else if(tnrp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data NRP Tidak Boleh Kosong","Peringatan",0);
        }else if(twilayah.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Wilayah Tidak Boleh Kosong","Peringatan",0);
        }else if(tstatus.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Data Status Tidak Boleh Kosong","Peringatan",0);
        }else if(tnosrt.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nomor SRT Harus Diisi","Peringatan",0);
        }else if(tnrp.getText().toUpperCase().equals(nrp)){
            JOptionPane.showMessageDialog(null,"Data NRP Sudah Ada");
        }else{
            String sql="insert into santunan1 values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try{

                String tampilan ="yyyy-MM-dd" ;
                SimpleDateFormat fm = new SimpleDateFormat(tampilan);
                String tgl = String.valueOf(fm.format(ctgl.getDate()));
                String tglm = String.valueOf(fm.format(ctglmening.getDate()));
                String tgls = String.valueOf(fm.format(ctglsrt.getDate()));
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, tno.getText());
                stat.setString(2, tkwi.getText());
                stat.setString(3, tgl);
                stat.setString(4, tnama.getText());
                stat.setString(5, tpangkat.getText());
                stat.setString(6, tkesatuan.getText());
                stat.setString(7, tnrp.getText().toUpperCase());
                stat.setString(8, twilayah.getText());
                stat.setString(9, tstatus.getText());
                stat.setString(10,tglm);
                String y="";
                if(cya.isSelected()){
                    y="Ya";
                }else{y="No";}
                stat.setString(11,y);
                stat.setString(12, tgls);
                stat.setString(13, tnosrt.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
                datatable();
                bersih();
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan : Nomor Kwitansi Harus Berisi Angka \n"+e);

            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sql = "SELECT * FROM santunan1 ORDER BY nomor DESC LIMIT 1";
        try{
            int b;
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                Integer a = hasil.getInt("nomor");
                b = a+1;
                String nilai=Integer.toString(b);
                tno.setText(nilai);
                tkwi.setText(null);
                tnama.setText(null);
                tpangkat.setText(null);
                tkesatuan.setText(null);
                tnrp.setText(null);
                twilayah.setText(null);
                tstatus.setText(null);
                ctgl.setDate(null);
                cya.setSelected(false);
                ctglmening.setDate(null);
                ctglsrt.setDate(null);
                tnosrt.setText(null);
                tkwi.requestFocus();
            }
        }catch(Exception ex){

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tkwiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkwiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkwiActionPerformed

    private void tnrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnrpActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
            try{
                String akses = "2";
                String namaFile = "src/tampilan/ReportKesatuan.jasper";
                HashMap parameter = new HashMap(1);
                parameter.put("kesatuan",akses);
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void akhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_akhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_akhirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try{
            awal.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            akhir.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            String namaFile = "src/tampilan/ReportPeriode.jasper";
            HashMap parameter = new HashMap(2);
            parameter.put("awal",awal.getSelectedItem());
            parameter.put("akhir",akhir.getSelectedItem());
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        InputStream input = null;
        JFileChooser fc = new JFileChooser("C:/");
        fc.setFileFilter(new FileNameExtensionFilter("SQL File", "sql"));
        fc.showOpenDialog(this);
        String path=null;
                   
        
        try {
            
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');

            if(path==null){
                
            }else{
            input = new FileInputStream("config.txt");
            prop.load(input);
            String user = prop.getProperty("user");
            String pass = prop.getProperty("pass");
            String pathh = prop.getProperty("path")+"mysql.exe ";
            String[] restoreCmd = new String[]{pathh, "--user=" + user, "--password=" + pass, "-e", "source " + path};
            Process runtimProcess;
            runtimProcess = Runtime.getRuntime().exec(restoreCmd);
            int proceCom = runtimProcess.waitFor();
            if (proceCom==0) {
                JOptionPane.showMessageDialog(null,"Berhasil Di Restore");
                MainMenu mn=new MainMenu();
                mn.setExtendedState(JFrame.MAXIMIZED_BOTH);
                mn.setVisible(true);
                this.dispose();
                
            }else{
                JOptionPane.showMessageDialog(null,"Gagal Di Restore");
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        InputStream input = null;
        int ok = JOptionPane.showConfirmDialog(null,"Data Akan di Backup?","Backup",JOptionPane.YES_NO_OPTION);
        if(ok==0){
        try {
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            //File file = new File("C:/Sanduk/");
            //input = new FileInputStream(file.getAbsolutePath()+"/config.txt");
            input = new FileInputStream("config.txt");
            prop.load(input);
            String folderpath = "src" + "\\Backup database";
                
                File fl = new File(folderpath);
                fl.mkdir();
                
                String savepath = "\"" + folderpath + "\\" + "" + "Sanduk_"+ date + ""+".sql\"";
            
            String user=prop.getProperty("user");
            String pass=prop.getProperty("pass");
            String path=prop.getProperty("path")+"mysqldump -u"+user+" --password="+pass+" --add-drop-database -B sanduk -r "+savepath;
            Runtime rn=Runtime.getRuntime();
            Process pr=rn.exec(path);
            int hitung = pr.waitFor();
            if(hitung==0)
            JOptionPane.showMessageDialog(null,"Berhasil Di Backup");
            else JOptionPane.showMessageDialog(null,"Gagal Di Backup");
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void banggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banggotaActionPerformed
        // TODO add your handling code here:
        if(trkesatuan.getText().equals("") && trpangkat.getText().equals("")){
            try{
                String namaFile = "src/tampilan/Keanggotaan_1.jasper";
                HashMap parameter = new HashMap(1);                
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else if(trkesatuan.getText().equals("")){
            try{
                String namaFile = "src/tampilan/Keanggotaan.jasper";
                HashMap parameter = new HashMap(1);
                parameter.put("pangkat",trpangkat.getText().toUpperCase());                
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else if(trpangkat.getText().equals("")){
            try{
                String namaFile = "src/tampilan/Keanggotaan.jasper";
                HashMap parameter = new HashMap(1);
                parameter.put("kesatuan",trkesatuan.getText().toUpperCase());                
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else{
            try{
                String namaFile = "src/tampilan/Keanggotaan_2.jasper";
                HashMap parameter = new HashMap(1);
                parameter.put("kesatuan",trkesatuan.getText().toUpperCase()); 
                parameter.put("pangkat",trpangkat.getText().toUpperCase());
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }
    }//GEN-LAST:event_banggotaActionPerformed

    private void bkwitansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkwitansiActionPerformed
        // TODO add your handling code here:
        
            try{
                String akses = "1";
                String namaFile = "src/tampilan/ReportPangkat.jasper";
                HashMap parameter = new HashMap(1);
                parameter.put("petugas",akses);
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        
    }//GEN-LAST:event_bkwitansiActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu mn=new MainMenu();
                mn.setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.freixas.jcalendar.JCalendarCombo akhir;
    private org.freixas.jcalendar.JCalendarCombo awal;
    private javax.swing.JButton banggota;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkwitansi;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bupdate;
    private com.toedter.calendar.JDateChooser ctgl;
    private com.toedter.calendar.JDateChooser ctglmening;
    private com.toedter.calendar.JDateChooser ctglsrt;
    private javax.swing.JCheckBox cya;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel ljam;
    private javax.swing.JTable tabelyasbhum;
    private javax.swing.JTextField tcari;
    private javax.swing.JTextField tkesatuan;
    private javax.swing.JTextField tkwi;
    private javax.swing.JTextField tnama;
    private javax.swing.JTextField tno;
    private javax.swing.JTextField tnosrt;
    private javax.swing.JTextField tnrp;
    private javax.swing.JTextField tpangkat;
    private javax.swing.JTextField trkesatuan;
    private javax.swing.JTextField trpangkat;
    private javax.swing.JTextField tstatus;
    private javax.swing.JTextField twilayah;
    // End of variables declaration//GEN-END:variables
}
