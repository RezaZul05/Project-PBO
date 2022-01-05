package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TambahAdminGui extends JFrame {

    public TambahAdminGui() {
        initComponent();
    }
    protected JLabel labeladmin = new JLabel("TAMBAH ADMIN");
    protected JLabel labelNamaAdm = new JLabel("NAMA ADMIN");
    protected JLabel labelpassword = new JLabel("PASSWORD");
    protected JLabel labelnotelp = new JLabel("NO TELP");

    protected JTextField fieldNamaAdm = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();
    protected JTextField fieldnotelp = new JTextField();
    
    protected JButton btnregadmin = new JButton("TAMBAH ?");

    void kosong() {

        fieldNamaAdm.setText(null);
        fieldpassword.setText(null);
        fieldnotelp.setText(null);
    }

    void initComponent() {
        setTitle("Tambah Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 420);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labeladmin.setText("TAMBAH ADMIN");
        labeladmin.setBounds(100, 50, 110, 25);
        add(labeladmin);

        labelNamaAdm.setBounds(35, 140, 80, 25);
        add(labelNamaAdm);
        fieldNamaAdm.setBounds(130, 140, 130, 25);
        add(fieldNamaAdm);

        labelpassword.setBounds(35, 185, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(130, 185, 130, 25);
        add(fieldpassword);

        labelnotelp.setBounds(35, 230, 80, 25);
        add(labelnotelp);
        fieldnotelp.setBounds(130, 230, 130, 25);
        add(fieldnotelp);

        btnregadmin.setBounds(80, 300, 140, 25);
        btnregadmin.setBorder(null);
        btnregadmin.setBackground(Color.black);
        btnregadmin.setForeground(Color.white);
        btnregadmin.setFocusPainted(false);
        add(btnregadmin);

        btnregadmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnregadmin.setForeground(Color.black);
                btnregadmin.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnregadmin.setForeground(Color.white);
                btnregadmin.setBackground(Color.black);
            }
        });

        btnregadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNamaAdm.getText();
                String password = fieldpassword.getText();
                String notelp = fieldnotelp.getText();
                if (nama.length() != 0 && password.length() != 0 && notelp.length() != 0) {
                    AllObjectController.admin.insertData(nama, password, notelp);
                    JOptionPane.showMessageDialog(null, nama + " Adalah Admin");
                    dispose();
                    new LoginAdminGui().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                    kosong();
                }
            }
        });
    }
}
