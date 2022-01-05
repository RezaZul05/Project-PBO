package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputBarangGui extends JFrame {
    public InputBarangGui(int cek){
        initComponent(cek);
    }
    protected JTextField fieldid = new JTextField();
    protected JTextField fieldnama = new JTextField();
    protected JTextField fieldjumlah = new JTextField();
    protected JTextField fieldberat = new JTextField();
    
    
    protected JLabel labelbrg = new JLabel("INPUT BARANG");
    protected JLabel labelid = new JLabel("ID");
    protected JLabel labelnama = new JLabel("NAMA");
    protected JLabel labeljumlah = new JLabel("JUMLAH");
    protected JLabel labelberat = new JLabel("BERAT");
    
    protected JButton btninputbrg = new JButton("INPUT BARANG ?");
    protected JButton btnback = new JButton("<< BACK");
    
    
    void kosong(){
        fieldnama.setText(null);
    }
    
    void initComponent(int cek){
        setTitle("Imput Barang");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labelbrg.setBounds(115, 50, 120, 25);
        add(labelbrg);
        
        labelid.setBounds(35, 95, 40, 25);
        add(labelid);
        fieldid.setBounds(130, 95, 130, 25);
        add(fieldid);
        
        labelnama.setBounds(35,140, 40, 25);
        add(labelnama);
        fieldnama.setBounds(130, 140, 130, 25);
        add(fieldnama);
        
        labeljumlah.setBounds(35, 185, 80, 25);
        add(labeljumlah);
        fieldjumlah.setBounds(130, 185, 130, 25);
        add(fieldjumlah);
        
        labelberat.setBounds(35, 230, 80, 25);
        add(labelberat);
        fieldberat.setBounds(130, 230, 130, 25);
        add(fieldberat);
        
        btninputbrg.setBounds(80, 300, 140, 25);
        btninputbrg.setBorder(null);
        btninputbrg.setBackground(Color.black);
        btninputbrg.setForeground(Color.white);
        btninputbrg.setFocusPainted(false);
        add(btninputbrg);
        
        btnback.setBounds(90, 350, 120, 25);
        btnback.setBackground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setBorder(null);
        add(btnback);
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.black);
                btnback.setBackground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.red);
                btnback.setBackground(Color.black);
            }
        });
        
        btninputbrg.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btninputbrg.setForeground(Color.black);
                btninputbrg.setBackground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btninputbrg.setForeground(Color.red);
                btninputbrg.setBackground(Color.black);
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
        
        btninputbrg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String id = fieldid.getText();
                String nama = fieldnama.getText();
                String jumlah = fieldjumlah.getText();
                String berat = fieldberat.getText();
                if(id.length() != 0 && nama.length() != 0 && jumlah.length() != 0 && berat.length() != 0){
                    AllObjectController.barang.insertBarang(id, nama, jumlah, berat);
                    JOptionPane.showMessageDialog(null, "DATA BERHASIL DI INPUT");
                    PilihMenuGui backGui = new PilihMenuGui(cek);
                    backGui.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSOSNG");
                    kosong();
                }
            }
        });
        
       
    }
}
