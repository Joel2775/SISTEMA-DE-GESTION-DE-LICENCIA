package org.example.dao;

import org.example.config.DatabaseConfig;
import org.example.model.entities.Usuario;
import org.example.model.exceptions.BaseDatosException;
import org.example.model.interfaces.IUsuarioService;
import org.example.model.interfaces.Persistible;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioService, Persistible<Usuario> {

    private final DatabaseConfig dbConfig;

    public UsuarioDAO() {
        this.dbConfig = DatabaseConfig.getInstance();
    }

    @Override
    public Long guardar(Usuario usuario) throws BaseDatosException {
        if (usuario.getId() == null) {
            return insertar(usuario);
        } else {
            actualizar(usuario);
            return usuario.getId();
        }
    }

    public Long insertar(Usuario usuario) throws BaseDatosException {
        String sql = " INSERT INTO public.usuarios (cedula, nombres, apellidos, usuario, clave, estado) " +
                " VALUES (?, ?, ?, ?, ?, ?) ";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConfig.obtenerConexion();
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, usuario.getCedula());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getUsuario());
            stmt.setString(5, usuario.getClave());
            stmt.setBoolean(6, usuario.isEstado());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                throw new BaseDatosException("No se puede insertar el usuario");
            }

            // Obtener el ID generado
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else  {
                throw new BaseDatosException("No se pudo obtener el ID generado");
            }

        } catch (SQLException e) {
            throw new BaseDatosException("Error al insertar usuario: " + e.getMessage(), e);
        } finally {
            cerrarRecursos(conn, stmt, rs);
        }
    }

    public void actualizar(Usuario usuario) throws BaseDatosException {
        String sql = " UPDATE public.usuarios SET cedula = ?, nombres = ?, apellidos = ?, usuario = ?, clave = ?, estado = ? " +
                " WHERE id = ? ";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = dbConfig.obtenerConexion();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getCedula());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setString(4, usuario.getUsuario());
            stmt.setString(5, usuario.getClave());
            stmt.setBoolean(6, usuario.isEstado());
            stmt.setLong(7, usuario.getId());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                throw new BaseDatosException("No se encontró el usuario con ID: " + usuario.getId());
            }

        } catch (SQLException e) {
            throw new BaseDatosException("Error al actualizar usuario: " + e.getMessage(), e);
        } finally {
            cerrarRecursos(conn, stmt, null);
        }
    }

    /**
     * Busca un usuario por su ID
     * @param id ID del usuario
     * @return Usuario encontrado o null
     * @throws BaseDatosException Si ocurre un error en la búsqueda
     */
    @Override
    public Usuario buscarPorId(Long id) throws BaseDatosException {
        String sql = " SELECT * FROM public.usuarios WHERE id = ? ";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConfig.obtenerConexion();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearResultSet(rs);
            }

            return null;

        } catch (SQLException e) {
            throw new BaseDatosException("Error al buscar usuario por ID: " + e.getMessage(), e);
        } finally {
            cerrarRecursos(conn, stmt, rs);
        }
    }

    @Override
    public boolean eliminar(Long id) throws BaseDatosException {
        return false;
    }

    /**
     * Busca un usuario por su cédula
     * @param cedula Número de cédula
     * @return Usuario encontrado o null
     * @throws BaseDatosException Si ocurre un error en la búsqueda
     */
    public Usuario buscarPorCedula(String cedula) throws BaseDatosException {
        String sql = " SELECT * FROM public.usuarios WHERE cedula = ? ";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dbConfig.obtenerConexion();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cedula);

            rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearResultSet(rs);
            }

            return null;

        } catch (SQLException e) {
            throw new BaseDatosException("Error al buscar usuario por cédula: " + e.getMessage(), e);
        } finally {
            cerrarRecursos(conn, stmt, rs);
        }
    }

    /**
     * Obtiene todos los usuarios
     * @return Lista de usuarios
     * @throws BaseDatosException Si ocurre un error en la consulta
     */
    public List<Usuario> obtenerTodos() throws BaseDatosException {
        String sql = " SELECT * FROM public.usuarios ORDER BY apellidos, nombres ";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = dbConfig.obtenerConexion();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuarios.add(mapearResultSet(rs));
            }

            return usuarios;

        } catch (SQLException e) {
            throw new BaseDatosException("Error al obtener usuarios: " + e.getMessage(), e);
        } finally {
            cerrarRecursos(conn, stmt, rs);
        }
    }

    @Override
    public boolean login(String usuario, String clave) {
        String sql = " SELECT id FROM public.admins WHERE usuario = ? AND clave = ? AND estado = true ";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConfig.getInstance().obtenerConexion();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);

            rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.err.println("Error login admin: " + e.getMessage());
            return false;
        }
    }

    private void cerrarRecursos(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }

    private Usuario mapearResultSet(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(rs.getLong("id"));
        usuario.setCedula(rs.getString("cedula"));
        usuario.setNombres(rs.getString("nombres"));
        usuario.setApellidos(rs.getString("apellidos"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setClave(rs.getString("clave"));
        usuario.setEstado(rs.getBoolean("estado"));

        return usuario;
    }

    public void eliminar(String cedula) throws BaseDatosException {
        String sql = "DELETE FROM usuarios WHERE cedula = ?";
        try (Connection conn = DatabaseConfig.getInstance().obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cedula);
            int filas = ps.executeUpdate();

            if (filas == 0) {
                throw new BaseDatosException("No se eliminó ningún usuario, cédula no encontrada");
            }

        } catch (SQLException e) {
            throw new BaseDatosException("Error al eliminar usuario", e);
        }
    }
}
