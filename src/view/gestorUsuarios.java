package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuarios extends JFrame{
    private JPanel gestorUsuarios;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton eliminarButton;
    private JButton mostrarButton;
    private JButton generarDocumentoPDFButton;
    private JButton salirButton;

    public gestorUsuarios() throws HeadlessException {
        setTitle("Gestor de Usuarios");
        setContentPane(gestorUsuarios);
        setSize(610, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosCrear mostrar = new gestorUsuariosCrear();
                mostrar.setVisible(true);
                // Lógica para Crear un usuario
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosActualizar mostrar = new gestorUsuariosActualizar();
                mostrar.setVisible(true);
                // Lógica para Actualizar un usuario
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosEliminar mostrar = new gestorUsuariosEliminar();
                mostrar.setVisible(true);
                // Lógica para Eliminar un usuario
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorUsuariosMostrar mostrar = new gestorUsuariosMostrar();
                mostrar.setVisible(true);
                // Lógica para Mostrar un usuario
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
