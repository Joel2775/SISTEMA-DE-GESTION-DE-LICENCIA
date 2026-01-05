package org.example.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosEliminar extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBusqueda;
    private JPanel panelInfo;
    private JPanel panelBotones;

    private JTextField txtCedula;
    private JButton btnBuscar;

    private JTextArea txtInfo;
    private JScrollPane scrollInfo;

    private JButton btnEliminar;
    private JButton btnCerrar;

    public gestorUsuariosEliminar() {

        inicializarEliminar();

        setTitle("Eliminación de Datos de Usuarios");
        setContentPane(panelPrincipal);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        eventos();
    }

    private void inicializarEliminar() {

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(null);
        panelBusqueda.setBorder(new TitledBorder("Búsqueda"));
        panelBusqueda.setBounds(10, 10, 860, 70);
        panelPrincipal.add(panelBusqueda);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(20, 30, 60, 25);
        panelBusqueda.add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(80, 30, 250, 25);
        panelBusqueda.add(txtCedula);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(350, 30, 100, 25);
        panelBusqueda.add(btnBuscar);

        panelInfo = new JPanel();
        panelInfo.setLayout(null);
        panelInfo.setBorder(new TitledBorder("Información del Conductor"));
        panelInfo.setBounds(10, 90, 860, 350);
        panelPrincipal.add(panelInfo);

        txtInfo = new JTextArea();
        txtInfo.setEditable(false);

        scrollInfo = new JScrollPane(txtInfo);
        scrollInfo.setBounds(15, 25, 830, 310);
        panelInfo.add(scrollInfo);

        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(10, 460, 860, 70);
        panelPrincipal.add(panelBotones);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(250, 20, 160, 30);
        panelBotones.add(btnEliminar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(450, 20, 160, 30);
        panelBotones.add(btnCerrar);
    }

    private void eventos() {

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de búsqueda
                txtInfo.setText("");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de eliminación
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
