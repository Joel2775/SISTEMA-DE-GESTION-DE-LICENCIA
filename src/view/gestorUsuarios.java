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
                // Lógica para crear un usuario
            }
        });
    }
}
