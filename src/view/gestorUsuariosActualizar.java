package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gestorUsuariosActualizar extends JFrame {
    private JPanel gestorUsuariosActualizar;
    private JPanel panelBusqueda;
    private JTextField txtCedula;
    private JButton btnBuscar;
    private JScrollPane scrollInfo;
    private JTextArea txtInfo;
    private JPanel panelBotones;
    private JButton btnGuardar;
    private JButton btnCerrar;
    private JPanel panelFormulario;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JComboBox cmbTipoSangre;

    public gestorUsuariosActualizar(){
        setTitle("Actualizar de Datos de Usuarios");
        setContentPane(gestorUsuariosActualizar);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
