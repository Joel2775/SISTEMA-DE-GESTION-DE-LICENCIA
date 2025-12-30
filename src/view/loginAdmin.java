package view;

import model.entities.Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAdmin extends JFrame {
    private JPanel loginAdmim;
    private JButton aceptarButton;
    private JTextField textUsuario;
    private JTextField textPassword;
    private JButton salirButton;
    private JPanel botones;
    private JButton cerrrarButton;

    public loginAdmin() {
        setTitle("Login Administrador");
        setContentPane(loginAdmim);
        setSize(300, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                String usuario = textUsuario.getText();
                String password = textPassword.getText();
                if (usuario.equals(admin.getUsuario()) && password.equals(admin.getContrasena())) {
                    gestorUsuarios gestor = new gestorUsuarios();
                    gestor.setVisible(true);
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
