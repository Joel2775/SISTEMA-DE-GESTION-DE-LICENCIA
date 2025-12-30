package view;

import model.entities.Admin;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAnalista extends JFrame{
    private JTextField txtUsuario;
    private JButton btnSalir;
    private JButton btnAceptar;
    private JTextField txtPassword;
    private JPanel loginAnalista;

    public loginAnalista() throws HeadlessException {
        setTitle("Login Analista");
        setContentPane(loginAnalista);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                String usuario = txtUsuario.getText();
                String password = txtPassword.getText();
                if (usuario.equals(admin.getUsuario()) && password.equals(admin.getContrasena())) {
                    gestorUsuarios gestor = new gestorUsuarios();
                    gestor.setVisible(true);
                }
            }
    });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
