package org.example.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosMostrar extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBusqueda;
    private JPanel panelTabla;
    private JPanel panelBotones;

    private JComboBox<String> cmbTipoBusqueda;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnActualizar;

    private JTable tableUsuarios;
    private JScrollPane scrollTabla;

    private JButton btnGenerarPDF;
    private JButton btnCerrar;

    public gestorUsuariosMostrar() {

        inicializarMostrar();

        setTitle("Mostrar Usuario Registrados");
        setContentPane(panelPrincipal);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        eventos();
    }

    private void inicializarMostrar() {

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(null);
        panelBusqueda.setBorder(new TitledBorder("Búsqueda"));
        panelBusqueda.setBounds(10, 10, 860, 70);
        panelPrincipal.add(panelBusqueda);

        JLabel lblBuscarPor = new JLabel("Cedula:");
        lblBuscarPor.setBounds(20, 30, 80, 25);
        panelBusqueda.add(lblBuscarPor);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(290, 30, 250, 25);
        panelBusqueda.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(550, 30, 100, 25);
        panelBusqueda.add(btnBuscar);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(660, 30, 120, 25);
        panelBusqueda.add(btnActualizar);


        panelTabla = new JPanel();
        panelTabla.setLayout(null);
        panelTabla.setBorder(new TitledBorder("Usuarios Registrados"));
        panelTabla.setBounds(10, 90, 860, 380);
        panelPrincipal.add(panelTabla);

        tableUsuarios = new JTable();
        tableUsuarios.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Usuario", "Contraseña", "Estado"}
        ));

        scrollTabla = new JScrollPane(tableUsuarios);
        scrollTabla.setBounds(15, 25, 830, 340);
        panelTabla.add(scrollTabla);

        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(10, 490, 860, 60);
        panelPrincipal.add(panelBotones);

        btnGenerarPDF = new JButton("Generar PDF de Seleccionada");
        btnGenerarPDF.setBounds(250, 15, 260, 30);
        panelBotones.add(btnGenerarPDF);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(530, 15, 120, 30);
        panelBotones.add(btnCerrar);
    }

    private void eventos() {
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica
            }
        });

        btnGenerarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica
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
