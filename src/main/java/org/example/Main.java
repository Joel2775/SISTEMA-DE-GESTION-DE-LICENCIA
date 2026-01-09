package org.example;

import org.example.config.DatabaseConfig;
import org.example.controller.UsuarioController;
import org.example.view.Sistema;
import org.example.view.gestorUsuariosActualizar;

import javax.swing.*;

public class Main {

    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        // Configurar Look and Feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("No se pudo establecer el Look and Feel: " + e.getMessage());
        }

        // Verificar conexión a base de datos
        DatabaseConfig dbConfig = DatabaseConfig.getInstance();

        SwingUtilities.invokeLater(() -> {
            // Mostrar splash screen o mensaje de inicio
            mostrarPantallaInicio();

            // Verificar conexión a BD
            if (!dbConfig.verificarConexion()) {
                mostrarErrorConexion();
                return;
            }

            // Iniciar ventana principal
            Sistema sistema = new Sistema();
            sistema.setVisible(true);
        });
    }

    /**
     * Muestra una pantalla de inicio con información del sistema
     */
    private static void mostrarPantallaInicio() {
        JOptionPane.showMessageDialog(
                null,
                "SISTEMA DE LICENCIAS DE CONDUCIR - ECUADOR\n\n" +
                        "Agencia Nacional de Tránsito\n" +
                        "Versión 2.0\n\n" +
                        "Desarrollado con:\n" +
                        "- Java 21\n" +
                        "- PostgresSQL - Supabase\n" +
                        "- Arquitectura MVC\n" +
                        "- iText PDF\n\n" +
                        "Iniciando sistema...",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Muestra un mensaje de error si no se puede conectar a la base de datos
     */
    private static void mostrarErrorConexion() {
        String mensaje = "ERROR DE CONEXIÓN A BASE DE DATOS\n\n" +
                "No se pudo establecer conexión con supabase.\n\n" +
                "Verifique que:\n" +
                "1. la base de datos 'sistema_Usuarios' exista\n" +
                "2. La base de datos 'sistema_licencias' exista\n" +
                "3. Las credenciales sean correctas ya acorde a los datos del Postgres\n" +
                "La aplicación se cerrará.";

        JOptionPane.showMessageDialog(
                null,
                mensaje,
                "Error de Conexión",
                JOptionPane.ERROR_MESSAGE
        );

        System.exit(1);
    }
}



