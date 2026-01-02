package org.example;

import org.example.view.sistema;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new sistema().setVisible(true);
        });
    }
}
