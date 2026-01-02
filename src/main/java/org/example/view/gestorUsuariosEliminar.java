package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosEliminar extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelBusqueda;
    private JTextField txtCedula;
    private JButton btnBuscar;
    private JScrollPane scrollInfo;
    private JTextArea txtInfo;
    private JPanel panelBotones;
    private JButton btnGuardar;
    private JButton btnCerrar;
    private JPanel gestorUsuariosEliminar;

    public gestorUsuariosEliminar(){
        setTitle("Eliminación de Datos de Usuarios");
        setContentPane(gestorUsuariosEliminar);
        setSize(900, 800);
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
