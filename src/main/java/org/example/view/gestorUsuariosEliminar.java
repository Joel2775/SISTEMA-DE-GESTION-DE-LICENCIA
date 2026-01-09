package org.example.view;

import org.example.controller.UsuarioController;
import org.example.model.entities.Usuario;
import org.example.model.exceptions.UsuarioException;

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

    private Usuario usuarioActual;
    private final UsuarioController controller;

    public gestorUsuariosEliminar(UsuarioController controller) {
        this.controller = controller;
        inicializarEliminar();

        setTitle("Eliminar Usuarios");
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
        panelInfo.setBorder(new TitledBorder("Información del Usuario"));
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
                buscarUsuario();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void buscarUsuario() {
        try {
            usuarioActual = controller.buscarUsuarioPorCedula(txtCedula.getText().trim());
            if (usuarioActual != null) {
                txtInfo.setText(String.format(
                        "Cédula: %s\nNombres: %s\nApellidos: %s\nUsuario: %s\nClave: %s\nEstado: %s",
                        usuarioActual.getCedula(),
                        usuarioActual.getNombres(),
                        usuarioActual.getApellidos(),
                        usuarioActual.getUsuario(),
                        usuarioActual.getClave(),
                        usuarioActual.isEstado() ? "Activo" : "Inactivo"
                ));

            } else {
                controller.mostrarError("Usuario no encontrado");
                txtInfo.setText("");
            }
        } catch (UsuarioException ex) {
            controller.mostrarError("Error: " + ex.getMessage());
        }
    }

    private void eliminarUsuario() {
        try {
            if (usuarioActual == null) {
                controller.mostrarError("Primero busque un usuario");
                return;
            }

            boolean confirmar = controller.confirmar(
                    "¿Está seguro de eliminar al usuario con cédula: " + usuarioActual.getCedula() + "?"
            );

            if (!confirmar) {
                return;
            }

            controller.eliminarUsuario(usuarioActual);

            JOptionPane.showMessageDialog(this,
                    "Usuario Eliminado correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (UsuarioException ex) {
            controller.mostrarError(ex.getMessage());
        }
    }

}
