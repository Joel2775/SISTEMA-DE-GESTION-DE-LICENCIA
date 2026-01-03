package org.example.view;

import org.example.model.entities.Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAdmin extends JFrame {
    private JPanel LoginAdmin;
    private JButton btnAceptar;
    private JTextField textUsuario;
    private JTextField textContra;
    private JButton btnSalir;
    private JLabel lblContra;
    private JLabel lblUsuario;
    private JLabel lblTitulo;
    private JSeparator separator;
    private JSeparator separator1;

    public LoginAdmin() throws HeadlessException {

        inicializarLoginAdmin();

        setTitle("Login Administrador");
        setContentPane(LoginAdmin);
        setSize(377, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin admin = new Admin();
                String usuario = textUsuario.getText();
                String password = textContra.getText();
                if (usuario.equals(admin.getUsuario()) && password.equals(admin.getContrasena())) {
                    GestorUsuarios gestor = new GestorUsuarios();
                    gestor.setVisible(true);
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private  void inicializarLoginAdmin() {
        LoginAdmin = new JPanel();
        LoginAdmin.setBorder(new EmptyBorder(5, 5, 5, 5));
        LoginAdmin.setLayout(null);

        lblTitulo = new JLabel("LOGIN DE ADMINISTRADOR");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(23, 10, 315, 32);
        LoginAdmin.add(lblTitulo);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsuario.setBounds(75, 77, 65, 22);
        LoginAdmin.add(lblUsuario);

        separator = new JSeparator();
        separator.setBounds(10, 52, 345, 7);
        LoginAdmin.add(separator);

        textUsuario = new JTextField();
        textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textUsuario.setBounds(154, 79, 126, 18);
        LoginAdmin.add(textUsuario);
        textUsuario.setColumns(10);

        textContra = new JTextField();
        textContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textContra.setColumns(10);
        textContra.setBounds(154, 118, 126, 18);
        LoginAdmin.add(textContra);

        lblContra = new JLabel("Contraseña:");
        lblContra.setHorizontalAlignment(SwingConstants.LEFT);
        lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblContra.setBounds(45, 116, 95, 22);
        LoginAdmin.add(lblContra);

        separator1 = new JSeparator();
        separator1.setBounds(10, 166, 345, 7);
        LoginAdmin.add(separator1);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(73, 200, 95, 32);
        LoginAdmin.add(btnAceptar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(194, 200, 95, 32);
        LoginAdmin.add(btnSalir);

    }

}
