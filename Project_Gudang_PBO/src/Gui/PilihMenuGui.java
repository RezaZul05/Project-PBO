/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author NandaRahman
 */
public class PilihMenuGui extends JFrame {
    public PilihMenuGui(int cek){
        initComponent(cek);
    }
    protected JButton btndata = new JButton("VIA ADMIN");
    protected JButton btninput = new JButton("INPUT BARANG");
    
    void initComponent(final int cek){
        setTitle("Pilih Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 280);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btndata.setBounds(50,120,100,25);
        btndata.setBackground(Color.black);
        btndata.setForeground(Color.white);
        btndata.setBorder(null);
        add(btndata);
        
        btninput.setBounds(205,120,100,25);
        btninput.setBackground(Color.black);
        btninput.setForeground(Color.white);
        btninput.setBorder(null);
        add(btninput);
        
        btndata.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btndata.setForeground(Color.black);
                btndata.setBackground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btndata.setForeground(Color.white);
                btndata.setBackground(Color.black);
            }
        });
        
        btninput.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btninput.setForeground(Color.black);
                btninput.setBackground(Color.red);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btninput.setForeground(Color.white);
                btninput.setBackground(Color.black);
            }
        });
        
        btndata.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AdminGui adminGui = new AdminGui(cek);
                dispose();
            }
        });
        btninput.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                InputBarangGui inputGui = new InputBarangGui(cek);
                dispose();
            }
        });
    }
}
