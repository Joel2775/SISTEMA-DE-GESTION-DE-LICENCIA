package org.example;

import org.example.view.Sistema;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Sistema().setVisible(true);
        });
    }
}
