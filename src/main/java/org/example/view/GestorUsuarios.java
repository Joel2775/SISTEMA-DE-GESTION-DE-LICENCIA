package org.example.view;

import org.example.controller.UsuarioController;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorUsuarios extends JFrame{

    private final UsuarioController controller;

    private JPanel gestorUsuarios;
    private JButton btnCrear;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnMostrar;
    private JButton btnGenerarDocumentoPDF;
    private JButton btnSalir;
    private JLabel lblTitulo;

    public GestorUsuarios() throws HeadlessException {

        this.controller = new UsuarioController();

        inicializarGestorUsuarios();

        setTitle("Gestor de Usuarios");
        setContentPane(gestorUsuarios);
        setSize(550, 362);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosCrear mostrar = new gestorUsuariosCrear(controller);
                mostrar.setVisible(true);
                // Lógica para Crear un usuario
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosActualizar mostrar = new gestorUsuariosActualizar();
                mostrar.setVisible(true);
                // Lógica para Actualizar un usuario
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosEliminar mostrar = new gestorUsuariosEliminar();
                mostrar.setVisible(true);
                // Lógica para Eliminar un usuario
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosMostrar mostrar = new gestorUsuariosMostrar();
                mostrar.setVisible(true);
                // Lógica para Mostrar un usuario
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void  inicializarGestorUsuarios() {
        gestorUsuarios = new JPanel();
        gestorUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
        gestorUsuarios.setLayout(null);

        lblTitulo = new JLabel("SISTEMA DE USUARIOS - ECUADOR");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(83, 10, 383, 19);
        gestorUsuarios.add(lblTitulo);

        btnCrear = new JButton("Crear");
        btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnCrear.setBounds(10, 39, 250, 71);
        gestorUsuarios.add(btnCrear);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnActualizar.setBounds(277, 39, 250, 71);
        gestorUsuarios.add(btnActualizar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEliminar.setBounds(10, 122, 250, 71);
        gestorUsuarios.add(btnEliminar);

        btnMostrar = new JButton("Mostrar");
        btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnMostrar.setBounds(277, 122, 250, 71);
        gestorUsuarios.add(btnMostrar);

        btnGenerarDocumentoPDF = new JButton("Generar Documento PDF");
        btnGenerarDocumentoPDF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnGenerarDocumentoPDF.setBounds(10, 203, 517, 71);
        gestorUsuarios.add(btnGenerarDocumentoPDF);

        btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSalir.setBounds(10, 284, 517, 31);
        gestorUsuarios.add(btnSalir);

    }

}
