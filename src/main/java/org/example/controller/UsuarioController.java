package org.example.controller;

import org.example.model.entities.Usuario;
import org.example.model.exceptions.UsuarioException;
import org.example.service.UsuarioService;

import javax.swing.*;
import java.util.List;

/**
 * Controlador principal del patrón MVC.
 * Gestiona la comunicación entre la Vista y el Modelo (Servicios).
 * Implementa la lógica de control de flujo de la aplicación.
 *
 * @author Sistema Licencias Ecuador
 * @version 1.0
 */
public class UsuarioController {

    // Servicio de negocio (capa de modelo)
    private final UsuarioService usuarioService;

    /**
     * Constructor que inicializa el servicio
     */
    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    /**
     * Registra un nuevo usuario en el sistema
     * @param usuario Usuario a registrar
     * @return ID del usuario registrado
     * @throws UsuarioException Si hay errores de validación o persistencia
     */
    public Long registrarUsuario(Usuario usuario) throws UsuarioException {
        return usuarioService.registrarUsuario(usuario);
    }

    /**
     * Actualiza los datos de un usuario
     * @param usuario Usuario con datos actualizados
     * @throws UsuarioException Si hay errores
     */
    public void actualizarUsuario(Usuario usuario) throws UsuarioException {
        usuarioService.actualizarUsuario(usuario);
    }



    /**
     * Busca un usuario por cédula
     * @param cedula Número de cédula
     * @return Usuario encontrado o null
     * @throws UsuarioException Si hay errores
     */
    public Usuario buscarUsuarioPorCedula(String cedula) throws UsuarioException {
        return usuarioService.buscarUsuarioPorCedula(cedula);
    }

    /**
     * Busca un usuario por ID
     * @param id ID del usuario
     * @return Usuario encontrado o null
     * @throws UsuarioException Si hay errores
     */
    public Usuario buscarUsuarioPorId(Long id) throws UsuarioException {
        return usuarioService.buscarUsuarioPorId(id);
    }


    /**
     * Muestra un mensaje de error en la interfaz
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de éxito en la interfaz
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(null,
                mensaje,
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un mensaje de confirmación
     * @param mensaje Mensaje a mostrar
     * @return true si el usuario confirma
     */
    public boolean confirmar(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null,
                mensaje,
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        return respuesta == JOptionPane.YES_OPTION;
    }

    /**
     * Obtiene todos los usuarios
     * @return Lista de usuarios
     * @throws UsuarioException Si hay errores
     */
    public List<Usuario> obtenerTodosUsuarios() throws UsuarioException {
        return usuarioService.obtenerTodosUsuarios();
    }

    public void eliminarUsuario(Usuario usuario) throws UsuarioException {
        usuarioService.eliminarUsuario(usuario);
    }
}
