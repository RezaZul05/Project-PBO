package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAdminGui extends JFrame {

    String pathicon;

    public LoginAdminGui() {
        initComponent();
    }
    protected JLabel labelNamaAdm = new JLabel("NAMA ADMIN");
    protected JLabel labelpassword = new JLabel("PASSWORD");

    protected JButton btnlogin = new JButton("LOG IN");

    protected JTextField fieldNamaAdm = new JTextField();
    protected JPasswordField fieldpassword = new JPasswordField();

    void kosong() {

        fieldNamaAdm.setText(null);
        fieldpassword.setText(null);
    }

    void initComponent() {
        setTitle("Login Admin");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 330);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelNamaAdm.setBounds(35, 50, 130, 25);
        add(labelNamaAdm);
        fieldNamaAdm.setBounds(160, 50, 130, 25);
        add(fieldNamaAdm);

        labelpassword.setBounds(35, 100, 80, 25);
        add(labelpassword);
        fieldpassword.setBounds(160, 100, 130, 25);
        add(fieldpassword);

        btnlogin.setBounds(110, 165, 100, 25);
        btnlogin.setBackground(Color.black);
        btnlogin.setForeground(Color.white);
        btnlogin.setBorder(null);
        add(btnlogin);

        btnlogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnlogin.setForeground(Color.black);
                btnlogin.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnlogin.setForeground(Color.white);
                btnlogin.setBackground(Color.black);
            }
        });

        btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNamaAdm.getText();
                String password = fieldpassword.getText();
                int cek = AllObjectController.admin.login(nama, password);
                if (cek > 0) {
                    dispose();
                    PilihMenuGui pilihGui = new PilihMenuGui(cek);
                    pilihGui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                    kosong();
                }
            }
        });
    }
}
