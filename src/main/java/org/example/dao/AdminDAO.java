package org.example.dao;

import org.example.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO implements IAdminService {

    @Override
    public boolean validarLogin(String usuario, String clave) {

        String sql = "SELECT 1 FROM public.admins WHERE usuario = ? AND clave = ?";

        try (
                Connection conn = DatabaseConfig.getInstance().obtenerConexion();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, usuario);
            ps.setString(2, clave);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // true si existe

        } catch (Exception e) {
            System.err.println("Error login admin: " + e.getMessage());
            return false;
        }
    }
}
