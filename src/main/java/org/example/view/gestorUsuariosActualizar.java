package org.example.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosActualizar extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelBusqueda;
    private JPanel panelInfo;
    private JPanel panelFormulario;
    private JPanel panelBotones;

    private JTextField txtCedulaBusqueda;
    private JButton btnBuscar;

    private JTextArea txtInfo;

    private JTextField txtCedulaBuscar;
    private JTextField txtNombres;
    private JTextField txtApellidos;

    private JButton btnActualizar;
    private JButton btnCerrar;
    private JTextField txtCedula;
    private JTextField txtUsuario;
    private JTextField txtContrasena;
    private JComboBox cmbEstado;

    public gestorUsuariosActualizar() {

        inicializarActualizar();
        setTitle("Actualizar Datos de Usuarios");
        setContentPane(panelPrincipal);
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        eventos();
    }

    private void inicializarActualizar() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        panelBusqueda = new JPanel();
        panelBusqueda.setLayout(null);
        panelBusqueda.setBorder(new TitledBorder("Búsqueda"));
        panelBusqueda.setBounds(10, 10, 860, 70);
        panelPrincipal.add(panelBusqueda);

        JLabel lblBuscar = new JLabel("Cédula:");
        lblBuscar.setBounds(20, 30, 60, 25);
        panelBusqueda.add(lblBuscar);
        txtCedulaBusqueda = new JTextField();
        txtCedulaBusqueda.setBounds(80, 30, 200, 25);
        panelBusqueda.add(txtCedulaBusqueda);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(300, 30, 100, 25);
        panelBusqueda.add(btnBuscar);

        panelInfo = new JPanel();
        panelInfo.setLayout(null);
        panelInfo.setBorder(new TitledBorder("Información del Usuario"));
        panelInfo.setBounds(10, 80, 860, 260);
        panelPrincipal.add(panelInfo);

        txtInfo = new JTextArea();
        txtInfo.setEditable(false);
        JScrollPane scrollInfo = new JScrollPane(txtInfo);
        scrollInfo.setBounds(15, 25, 830, 220);
        panelInfo.add(scrollInfo);


        panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        panelFormulario.setBorder(new TitledBorder("Datos del Usuario"));
        panelFormulario.setBounds(10, 360, 860, 180);
        panelPrincipal.add(panelFormulario);


        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(20, 30, 100, 25);
        panelFormulario.add(lblCedula);
        txtCedulaBuscar = new JTextField();
        txtCedulaBuscar.setBounds(120, 30, 250, 25);
        panelFormulario.add(txtCedulaBuscar);


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


        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(420, 65, 100, 25);
        panelFormulario.add(lblUsuario);
        txtUsuario = new JTextField();
        txtUsuario.setBounds(520, 65, 300, 25);
        panelFormulario.add(txtUsuario);


        JLabel lblEstado = new JLabel("Estado:");
        lblEstado.setBounds(20, 100, 100, 25);
        panelFormulario.add(lblEstado);
        cmbEstado = new JComboBox<>(new String[]{"Activar", "Desactivar"});
        cmbEstado.setBounds(120, 100, 250, 25);
        panelFormulario.add(cmbEstado);


        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(420, 100, 100, 25);
        panelFormulario.add(lblContrasena);
        txtContrasena = new JTextField();
        txtContrasena.setBounds(520, 100, 300, 25);
        panelFormulario.add(txtContrasena);



        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(10, 550, 860, 50);
        panelPrincipal.add(panelBotones);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(260, 10, 160, 30);
        panelBotones.add(btnActualizar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(440, 10, 160, 30);
        panelBotones.add(btnCerrar);
    }


    private void eventos() {

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInfo.setText("");
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
