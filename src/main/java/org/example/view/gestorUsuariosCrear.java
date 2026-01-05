package org.example.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosCrear extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelFormulario;
    private JPanel panelBotones;
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox<String> cmbTipoSangre;
    private JTable tablaConductores;
    private JScrollPane scrollTabla;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActualizar;
    private JButton btnCerrar;

    public gestorUsuariosCrear() {
        inicializarFormulario();
        setTitle("Creación de Datos de Usuarios");
        setContentPane(panelPrincipal);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        btnCerrar.addActionListener(e -> dispose());
    }

    private void inicializarFormulario() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setBorder(new TitledBorder("Datos del Conductor"));
        panelFormulario.setBounds(10, 10, 860, 200);
        panelPrincipal.add(panelFormulario);

        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(20, 30, 100, 25);
        panelFormulario.add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(120, 30, 250, 25);
        panelFormulario.add(txtCedula);

        JLabel lblNombres = new JLabel("Nombres:");
        lblNombres.setBounds(420, 30, 100, 25);
        panelFormulario.add(lblNombres);

        txtNombres = new JTextField();
        txtNombres.setBounds(520, 30, 300, 25);
        panelFormulario.add(txtNombres);

        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setBounds(20, 65, 100, 25);
        panelFormulario.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(120, 65, 250, 25);
        panelFormulario.add(txtApellidos);

        JLabel lblFecha = new JLabel("Fecha Nac (AAAA-MM-DD):");
        lblFecha.setBounds(420, 65, 200, 25);
        panelFormulario.add(lblFecha);

        txtFechaNacimiento = new JTextField("1990-01-01");
        txtFechaNacimiento.setBounds(620, 65, 200, 25);
        panelFormulario.add(txtFechaNacimiento);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(20, 100, 100, 25);
        panelFormulario.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(120, 100, 250, 25);
        panelFormulario.add(txtDireccion);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(420, 100, 100, 25);
        panelFormulario.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(520, 100, 300, 25);
        panelFormulario.add(txtTelefono);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 135, 100, 25);
        panelFormulario.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(120, 135, 250, 25);
        panelFormulario.add(txtEmail);

        JLabel lblTipoSangre = new JLabel("Tipo Sangre:");
        lblTipoSangre.setBounds(420, 135, 100, 25);
        panelFormulario.add(lblTipoSangre);

        cmbTipoSangre = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        cmbTipoSangre.setBounds(520, 135, 150, 25);
        panelFormulario.add(cmbTipoSangre);

        tablaConductores = new JTable();
        tablaConductores.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Fecha Nacimiento", "Dirección", "Teléfono", "Email", "Tipo Sangre"}
        ));

        scrollTabla = new JScrollPane(tablaConductores);
        scrollTabla.setBorder(new TitledBorder("Conductores Registrados"));
        scrollTabla.setBounds(10, 220, 860, 230);
        panelPrincipal.add(scrollTabla);


        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(10, 470, 860, 60);
        panelPrincipal.add(panelBotones);

        btnGuardar = new JButton("GUARDAR CONDUCTOR");
        btnGuardar.setBounds(50, 15, 180, 30);
        panelBotones.add(btnGuardar);

        btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBounds(260, 15, 120, 30);
        panelBotones.add(btnLimpiar);

        btnActualizar = new JButton("ACTUALIZAR LISTA");
        btnActualizar.setBounds(410, 15, 160, 30);
        panelBotones.add(btnActualizar);

        btnCerrar = new JButton("CERRAR");
        btnCerrar.setBounds(600, 15, 120, 30);
        panelBotones.add(btnCerrar);
    }
}
