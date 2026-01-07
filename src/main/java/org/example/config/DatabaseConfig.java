package org.example.config;

import org.example.model.exceptions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    //logica para conectar a supabase de PostgresSQL

    private static DatabaseConfig instancia;

    private final String url;
    private final String usuario;
    private final String password;
    private final String driver;

    /**
     * Constructor privado para implementar Singleton
     * Carga los parámetros de conexión desde configuración
     */
    public DatabaseConfig() {
        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://db.lwjmrtsfkwsqnkoihmfl.supabase.co:5432/postgres?sslmode=require";
                //usar jdbc para conectarse a la DB: motor de busqueda://host:puero/nombre del DB?requerie seguridad obligatoria ssl con cifrado
        this.usuario = "postgres";
        this.password = "Joel.acosta2004";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver PostgreSQL: " + e.getMessage());
        }
    }

    /**
     * Obtiene la instancia única de DatabaseConfig (Singleton)
     * @return Instancia de DatabaseConfig
     */
    public static synchronized DatabaseConfig getInstance() {
        if (instancia == null) {
            instancia = new DatabaseConfig();
        }
        return instancia;
    }

    /**
     * Crea y retorna una conexión a la base de datos
     * @return Objeto Connection
     * @throws BaseDatosException Si no se puede establecer la conexión
     */
    public Connection obtenerConexion() throws BaseDatosException {
        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            conexion.setAutoCommit(true); // cada insert o cada update,etc se guarde automaticamenete
            return conexion;
        } catch (SQLException e) {
            throw new BaseDatosException(
                    "Error al conectar con Supabase: " + e.getMessage(),
                    e
            );
        }
    }

    /**
     * Cierra una conexión de forma segura
     * @param conexion Conexión a cerrar
     */
    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    /**
     * Verifica si la conexión a la base de datos es válida
     * @return true si la conexión es exitosa, false en caso contrario
     */
    public boolean verificarConexion() {
        try (Connection conn = obtenerConexion()) {
            return conn != null && !conn.isClosed();
        } catch (Exception e) {
            System.err.println("Error al verificar conexión: " + e.getMessage());
            return false;
        }
    }

    // Getters

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDriver() {
        return driver;
    }
}



