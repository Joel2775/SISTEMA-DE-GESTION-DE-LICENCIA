package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosMostrar extends JFrame{
    private JPanel gestorUsuariosMostrar;
    private JPanel panelBusqueda;
    private JComboBox cmbTipoBusqueda;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JScrollPane scrollTabla;
    private JTable tableLicencias;
    private JPanel panelBotones;
    private JButton btnGenerarPDF;
    private JButton btnCerrar;

    public gestorUsuariosMostrar(){

        gestorUsuariosMostrar = new JPanel();
        panelBusqueda = new JPanel();
        panelBotones = new JPanel();
        panelBotones = new JPanel();

        btnActualizar = new JButton("Actualizar");
        btnGenerarPDF = new JButton("Generar PDF");
        btnBuscar = new JButton("Buscar");
        btnCerrar = new JButton("Cerrar");


        setTitle("Mostar de Datos de Usuarios");
        setContentPane(gestorUsuariosMostrar);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
