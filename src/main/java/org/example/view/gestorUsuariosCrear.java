package org.example.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosCrear extends JFrame {
    private JPanel panelPrincipal;
    private JPanel gestorUsuariosCrear;
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox cmbTipoSangre;
    private JScrollPane scrollTabla;
    private JTable tablaConductores;
    private JPanel panelBotones;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActualizar;
    private JButton btnCerrar;

    public gestorUsuariosCrear(){
        setTitle("Creación de Datos de Usuarios");
        setContentPane(gestorUsuariosCrear);
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
