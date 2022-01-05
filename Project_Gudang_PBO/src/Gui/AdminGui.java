package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminGui extends JFrame {
    JTable tabelbarang = new JTable();
    JScrollPane spbarang = new JScrollPane(tabelbarang);
    JTextField textpilih = new JTextField();
    int kode;
    
    protected JButton btnacc = new JButton("ACC BARANG");
    protected JButton btndelete = new JButton("DELETE");
    protected JButton btnubahpassword = new JButton("Ubah");
    protected JButton btnback = new JButton("<< BACK");
    protected JButton btninputbrg = new JButton("INPUT BARANG ?");
    
    protected JButton btnubahnama = new JButton("Ubah");
    protected JButton btnubahjum = new JButton("Ubah");
    protected JButton btnubahnotelp = new JButton("Ubah");
    
    public AdminGui(int cek){
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("PROGRAM GUDANG PBO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setVisible(true);
        
        spbarang.setBounds(20, 50, 500, 350);
        tabelbarang.setModel(AllObjectController.barang.dataBarang());
        add(spbarang);
        
        btnacc.setBounds(540, 50, 110, 25);
        btnacc.setFocusPainted(false);
        btnacc.setBorder(null);
        btnacc.setBackground(Color.black);
        btnacc.setForeground(Color.white);
        add(btnacc);
        
        btndelete.setBounds(540, 95, 110, 25);
        btndelete.setFocusPainted(false);
        btndelete.setBorder(null);
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnubahpassword.setText("UBAH PASSWORD");
        btnubahpassword.setBounds(540, 140, 110, 25);
        btnubahpassword.setFocusPainted(false);
        btnubahpassword.setBorder(null);
        btnubahpassword.setBackground(Color.black);
        btnubahpassword.setForeground(Color.white);
        add(btnubahpassword);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btninputbrg.setText("TAMBAH ADMIN");
        btninputbrg.setBounds(540, 185, 110, 25);
        btninputbrg.setFocusPainted(false);
        btninputbrg.setBorder(null);
        btninputbrg.setBackground(Color.black);
        btninputbrg.setForeground(Color.white);
        add(btninputbrg);
        
        tabelbarang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelbarang.getSelectedRow();
                textpilih.setText(AllObjectController.barang.dataBarang().getValueAt(i, 0).toString());
            }
        });
        
        btnacc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.accBarang(kode);
                JOptionPane.showMessageDialog(null, "Berhasil ACC");
                tabelbarang.setModel(AllObjectController.barang.dataBarang());
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                kode = Integer.parseInt(textpilih.getText());
                AllObjectController.admin.deleteData(kode);
                tabelbarang.setModel(AllObjectController.barang.dataBarang());
                JOptionPane.showMessageDialog(null, "Berhasil HAPUS DATA");
            }
        });
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PilihMenuGui menuGui = new PilihMenuGui(cek);
                menuGui.setVisible(true);
                dispose();
            }
        });
        
        btnubahpassword.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String inputpass = JOptionPane.showInputDialog("Masukkan Password Baru");
                    if(inputpass.length() > 0){
                        AllObjectController.admin.updatePassword(inputpass, cek);
                        JOptionPane.showMessageDialog(null, "Berhasil Ubah Password");
                    } else {
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Cancelled");
                }
            }
        });
        
        btninputbrg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TambahAdminGui registerAdminGui = new TambahAdminGui();
                registerAdminGui.setVisible(true);
                dispose();
            }
        });
    } 
}
