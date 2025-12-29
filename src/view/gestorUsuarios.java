package view;

import javax.swing.*;
import java.awt.*;

public class gestorUsuarios extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel gestorUsu;

    public gestorUsuarios() throws HeadlessException {
        setTitle("Gestor de Usuarios");
        setContentPane(gestorUsu);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
