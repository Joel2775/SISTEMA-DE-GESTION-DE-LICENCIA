package view;

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
