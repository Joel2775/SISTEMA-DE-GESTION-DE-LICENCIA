package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sistema extends JFrame {
    private JButton adminButton;
    private JButton analistaButton;
    private JPanel sistema;
    private JButton salirButton;

    public sistema() throws HeadlessException {

        // Inicializar panel y layout
        sistema = new JPanel();
        sistema.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // espaciado

        // Inicializar botones
        adminButton = new JButton("Admin");
        analistaButton = new JButton("Analista");
        salirButton = new JButton("Salir");

        // Colocar botones en el panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        sistema.add(adminButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        sistema.add(analistaButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // ocupa dos columnas
        sistema.add(salirButton, gbc);

        setTitle("Login");
        setContentPane(sistema);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAdmin login = new loginAdmin();
                login.setVisible(true);
            }

        });
        analistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAnalista login = new loginAnalista();
                login.setVisible(true);
            }
        });
    }
}
