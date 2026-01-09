package org.example.service;


import org.example.dao.UsuarioDAO;
import org.example.model.entities.Usuario;
import org.example.model.exceptions.BaseDatosException;
import org.example.model.exceptions.DocumentoInvalidoException;
import org.example.model.exceptions.UsuarioException;

import java.util.List;

/**
 * Servicio que encapsula la lógica de negocio para la gestión de licencias.
 * Implementa las reglas de negocio y validaciones complejas.
 *
 * @author Sistema Licencias Ecuador
 * @version 1.0
 */
public class UsuarioService {

    // DAOs necesarios (Inyección de dependencias manual)
    private final UsuarioDAO usuarioDAO;

    /**
     * Constructor que inicializa los DAOs
     */
    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Registra un nuevo usuario en el sistema
     * @param usuario Usuario a registrar
     * @return ID del usuario registrado
     * @throws UsuarioException Si hay errores de validación o persistencia
     */
    public Long registrarUsuario(Usuario usuario) throws UsuarioException {
        try {
            // Validar datos del usuario
            usuario.validar();

            // Verificar que no exista otro usuario con la misma cédula
            Usuario usuarioExistente = usuarioDAO.buscarPorCedula(usuario.getCedula());
            if (usuarioExistente != null) {
                throw new DocumentoInvalidoException(
                        "Ya existe un usuario registrado con la cédula: " + usuario.getCedula()
                );
            }

            // Guardar usuario
            Long id = usuarioDAO.guardar(usuario);
            usuario.setId(id);

            return id;

        } catch (DocumentoInvalidoException e) {
            throw e; // Reenviar excepción de validación
        } catch (BaseDatosException e) {
            throw new UsuarioException("Error al registrar usuario", e);
        }
    }

    /**
     * Actualiza los datos de un usuario existente
     * @param usuario Usuario con datos actualizados
     * @throws UsuarioException Si hay errores
     */
    public void actualizarUsuario(Usuario usuario) throws UsuarioException {
        try {
            // Validar datos
            usuario.validar();

            // Verificar que el usuario existe
            if (usuario.getId() == null || usuarioDAO.buscarPorId(usuario.getId()) == null) {
                throw new DocumentoInvalidoException("El usuario no existe en el sistema");
            }

            // Actualizar
            usuarioDAO.guardar(usuario);

        } catch (BaseDatosException e) {
            throw new UsuarioException("Error al actualizar usuario", e);
        }
    }


    /**
     * Busca un usuario por cédula
     * @param cedula Número de cédula
     * @return Usuario encontrado o null
     * @throws UsuarioException Si hay errores
     */
    public Usuario buscarUsuarioPorCedula(String cedula) throws UsuarioException {
        try {
            return usuarioDAO.buscarPorCedula(cedula);
        } catch (BaseDatosException e) {
            throw new UsuarioException("Error al buscar usuario", e);
        }
    }

    /**
     * Busca un usuario por ID
     * @param id ID del usuario
     * @return Usuario encontrado o null
     * @throws UsuarioException Si hay errores
     */
    public Usuario buscarUsuarioPorId(Long id) throws UsuarioException {
        try {
            return usuarioDAO.buscarPorId(id);
        } catch (BaseDatosException e) {
            throw new UsuarioException("Error al buscar usuario", e);
        }
    }


    /**
     * Obtiene todos los usuarios registrados
     * @return Lista de usuarios
     * @throws UsuarioException Si hay errores
     */
    public List<Usuario> obtenerTodosUsuarios() throws UsuarioException {
        try {
            return usuarioDAO.obtenerTodos();
        } catch (BaseDatosException e) {
            throw new UsuarioException("Error al obtener usuarios", e);
        }
    }
}

