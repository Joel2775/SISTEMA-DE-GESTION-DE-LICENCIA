package org.example.dao;

import org.example.config.DatabaseConfig;
import org.example.model.interfaces.IAdminService;

import java.sql.*;

public class AdminDAO implements IAdminService {

    @Override
    public boolean validarLogin(String usuario, String clave) {

        String sql = "SELECT 1 FROM public.admins WHERE usuario = ? AND clave = ? AND estado = true";

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
}
