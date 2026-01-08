package org.example.view;

import org.example.controller.UsuarioController;
import org.example.model.entities.Usuario;
import org.example.model.exceptions.LicenciaException;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class gestorUsuariosCrear extends JFrame {
    private final UsuarioController controller;
    private DefaultTableModel modeloTabla;
    private Usuario usuarioSeleccionado;

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
    private JComboBox<String> cmbEstado;


    public gestorUsuariosCrear(UsuarioController controller) {
        this.controller = controller;
        inicializarFormulario();
        setTitle("Creación de Datos de Usuarios");
        setContentPane(panelPrincipal);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        inicializarBotonoes();
        inicializarTabla();
        cargarUsuarios();
    }

    /**
     * Inicializa la tabla de usuarios
     */
    private void inicializarTabla() {
        String[] columnas = {"ID", "Cédula", "Nombres", "Apellidos", "Usuario", "Clave", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaUsuarios.setModel(modeloTabla);
        tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Guarda o actualiza un usuario
     */
    private void guardarUsuario() {
        try {
            // Validar campos obligatorios
            if (txtCedula.getText().trim().isEmpty() ||
                    txtNombres.getText().trim().isEmpty() ||
                    txtApellidos.getText().trim().isEmpty()||
                    txtUsuario.getText().trim().isEmpty() ||
                    txtContrasena.getText().trim().isEmpty()){
                controller.mostrarError("Todos los campos son obligatorios");
                return;
            }

            // Crear o actualizar usuario
            Usuario usuario;
            if (usuarioSeleccionado != null) {
                usuario = usuarioSeleccionado;
            } else {
                usuario = new Usuario();
            }

            // Establecer datos
            usuario.setCedula(txtCedula.getText().trim());
            usuario.setNombres(txtNombres.getText().trim());
            usuario.setApellidos(txtApellidos.getText().trim());
            usuario.setUsuario(txtUsuario.getText().trim());
            usuario.setClave(txtContrasena.getText().trim());

            String tipoEstado = (String) cmbEstado.getSelectedItem();
            if (tipoEstado.equals("Activar")) {
                usuario.setEstado(true);
            } else {
                usuario.setEstado(false);
            }

            // Guardar
            Long id = controller.registrarUsuario(usuario);

            if (usuarioSeleccionado != null) {
                controller.mostrarExito("Usuario actualizado exitosamente");
            } else {
                controller.mostrarExito("Usuario registrado exitosamente con ID: " + id);
            }

            limpiarFormulario();
            cargarUsuarios();

        } catch (LicenciaException ex) {
            controller.mostrarError("Error al guardar usuario: " + ex.getMessage());
        } catch (Exception ex) {
            controller.mostrarError("Error: " + ex.getMessage());
        }
    }

    /**
     * Carga los usuarios en la tabla
     */
    private void cargarUsuarios() {
        try {
            List<Usuario> usuarios = controller.obtenerTodosUsuarios();
            modeloTabla.setRowCount(0);

            for (Usuario usuario : usuarios) {
                Object[] fila = {
                        usuario.getId(),
                        usuario.getCedula(),
                        usuario.getNombres(),
                        usuario.getApellidos(),
                        usuario.getUsuario(),
                        usuario.getClave(),
                        usuario.isEstado() ? "ACTIVO": "INACTIVO",
                };
                modeloTabla.addRow(fila);
            }
        } catch (LicenciaException ex) {
            controller.mostrarError("Error al cargar usuarios: " + ex.getMessage());
        }
    }

    public void limpiarFormulario(){
        txtCedula.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
        cmbEstado.setSelectedIndex(0);
        usuarioSeleccionado = null;
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

        scrollTabla = new JScrollPane(tablaUsuarios);
        scrollTabla.setBorder(new TitledBorder("Usuarios Registrados"));
        scrollTabla.setBounds(10, 220, 860, 230);
        panelPrincipal.add(scrollTabla);


        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(10, 470, 860, 60);
        panelPrincipal.add(panelBotones);

        btnGuardar = new JButton("GUARDAR USUARIO");
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

    private void inicializarBotonoes(){

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarUsuarios();
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
