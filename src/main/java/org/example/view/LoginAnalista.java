package org.example.view;

import org.example.dao.UsuarioDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAnalista extends JFrame{
    private JTextField textUsuario;
    private JButton btnSalir;
    private JButton btnAceptar;
    private JPasswordField passwordField;
    private JPanel LoginAnalista;
    private JLabel lblContra;
    private JLabel lblUsuario;
    private JLabel lblTitulo;

    private int intentosFallidos = 0;
    private final int MAX_INTENTOS = 3;

    public LoginAnalista() throws HeadlessException {

        inicializarLoginAnalista();

        setTitle("Login Analista");
        setContentPane(LoginAnalista);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textUsuario.getText().trim();
                String password = new String(passwordField.getPassword());

                UsuarioDAO usuario1 = new UsuarioDAO();

                if (usuario1.validarLoginAnalista(usuario, password)) {
                    JOptionPane.showMessageDialog(LoginAnalista.this,"Bienvenido Administrador");

                    GestorUsuarios gestorUsuarios = new GestorUsuarios();
                    gestorUsuarios.setVisible(true);

                    limpiar();
                } else {
                    intentosFallidos++;

                    if (intentosFallidos >= MAX_INTENTOS) {
                        bloquearLogin();
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(
                                LoginAnalista.this,
                                "Credenciales incorrectas.\nIntentos restantes: "
                                        + (MAX_INTENTOS - intentosFallidos),
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                        limpiar();
                    }
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void bloquearLogin() {

        textUsuario.setEnabled(false);
        passwordField.setEnabled(false);
        btnAceptar.setEnabled(false);

        JOptionPane.showMessageDialog(
                this,
                "Has superado el número máximo de intentos.\nLogin bloqueado.",
                "Acceso bloqueado",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public void limpiar() {
        textUsuario.setText("");
        passwordField.setText("");
    }

    public  void inicializarLoginAnalista(){
        LoginAnalista = new JPanel();
        LoginAnalista.setBorder(new EmptyBorder(5, 5, 5, 5));
        LoginAnalista.setLayout(null);

        lblTitulo = new JLabel("LOGIN DE ADMINISTRADOR");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(23, 10, 315, 32);
        LoginAnalista.add(lblTitulo);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsuario.setBounds(75, 77, 65, 22);
        LoginAnalista.add(lblUsuario);

//        separator = new JSeparator();
//        separator.setBounds(10, 52, 345, 7);
//        LoginAnalista.add(separator);

        textUsuario = new JTextField();
        textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textUsuario.setBounds(154, 79, 126, 18);
        LoginAnalista.add(textUsuario);
        textUsuario.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(154, 120, 126, 18);
        LoginAnalista.add(passwordField);

        lblContra = new JLabel("Contraseña:");
        lblContra.setHorizontalAlignment(SwingConstants.LEFT);
        lblContra.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblContra.setBounds(45, 116, 95, 22);
        LoginAnalista.add(lblContra);

//        separator1 = new JSeparator();
//        separator1.setBounds(10, 166, 345, 7);
//        LoginAnalista.add(separator1);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(73, 200, 95, 32);
        LoginAnalista.add(btnAceptar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(194, 200, 95, 32);
        LoginAnalista.add(btnSalir);

    }
}