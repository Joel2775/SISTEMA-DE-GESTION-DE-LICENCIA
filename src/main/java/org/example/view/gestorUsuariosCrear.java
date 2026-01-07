package org.example.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class gestorUsuariosCrear extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelFormulario;
    private JPanel panelBotones;
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTable tablaUsuarios;
    private JScrollPane scrollTabla;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnActualizar;
    private JButton btnCerrar;
    private JTextField txtUsuario;
    private JTextField txtContrasena;
    private JComboBox cmbEstado;

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
        panelFormulario.setBorder(new TitledBorder("Datos del Usuario"));
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


        JLabel lblUsuario= new JLabel("Usuario:");
        lblUsuario.setBounds(420, 65, 200, 25);
        panelFormulario.add(lblUsuario);
        txtUsuario = new JTextField();
        txtUsuario .setBounds(520, 65, 300, 25);
        panelFormulario.add(txtUsuario);


        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(20, 100, 100, 25);
        panelFormulario.add(lblEstado);
        cmbEstado = new JComboBox<>(new String[]{"Activar", "Desactivar"});;
        cmbEstado.setBounds(120, 100, 250, 25);
        panelFormulario.add(cmbEstado);


        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(420, 100, 100, 25);
        panelFormulario.add(lblContrasena);
        txtContrasena = new JTextField();
        txtContrasena.setBounds(520, 100, 300, 25);
        panelFormulario.add(txtContrasena);


        tablaUsuarios = new JTable();
        tablaUsuarios.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Usuario", "Contraseña", "Estado"}
        ));

        scrollTabla = new JScrollPane(tablaUsuarios);
        scrollTabla.setBorder(new TitledBorder("Usuarios Registrados"));
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
