package org.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sistema extends JFrame {
    private JButton btnAdmin;
    private JButton btnAnalista;
    private JPanel sistema;
    private JButton btnSalir;
    private JLabel lblTitulo;

    public Sistema() throws HeadlessException {

        inicializarSistema();

        setTitle("Login");
        setContentPane(sistema);
        setSize(327, 225);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        funcionesBotones();
    }

    private void inicializarSistema() {
        sistema = new JPanel();
        sistema.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(sistema);
        sistema.setLayout(null);

        lblTitulo = new JLabel("SISTEMA DE GESTION");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(66, 25, 199, 26);
        sistema.add(lblTitulo);

        btnAdmin = new JButton("Administrador");
        btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAdmin.setBounds(21, 73, 129, 41);
        sistema.add(btnAdmin);

        btnAnalista = new JButton("Analista");
        btnAnalista.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAnalista.setBounds(160, 73, 129, 41);
        sistema.add(btnAnalista);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSalir.setBounds(115, 147, 84, 31);
        sistema.add(btnSalir);
    }

    private void funcionesBotones() {
        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdmin login = new LoginAdmin();
                login.setVisible(true);
            }

        });
        btnAnalista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAnalista login = new LoginAnalista();
                login.setVisible(true);
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
