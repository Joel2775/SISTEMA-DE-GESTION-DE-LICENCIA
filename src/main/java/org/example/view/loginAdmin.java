package org.example.view;

import org.example.model.entities.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginAdmin extends JFrame {
    private JPanel loginAdmim;
    private JButton aceptarButton;
    private JTextField textUsuario;
    private JTextField textPassword;
    private JButton salirButton;

    public loginAdmin() throws HeadlessException {

        // Inicializar panel
        loginAdmim = new JPanel();
        loginAdmim.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inicializar campos y botones
        textUsuario = new JTextField(15);
        textPassword = new JPasswordField(15);
        aceptarButton = new JButton("Aceptar");
        salirButton = new JButton("Salir");

        // Agregar componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginAdmim.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1;
        loginAdmim.add(textUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        loginAdmim.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        loginAdmim.add(textPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        loginAdmim.add(aceptarButton, gbc);

        gbc.gridy = 3;
        loginAdmim.add(salirButton, gbc);


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
