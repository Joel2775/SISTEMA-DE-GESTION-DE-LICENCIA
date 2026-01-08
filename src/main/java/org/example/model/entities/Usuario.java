package org.example.model.entities;

import org.example.model.exceptions.DocumentoInvalidoException;

public class Usuario {
    private Long id;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String clave;
    private boolean estado;

    public Usuario() {

    }

    public Usuario(Long id, String cedula, String nombres, String apellidos, String usuario, String clave, boolean estado) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Valida la cédula ecuatoriana usando el algoritmo del módulo 10
     * @param cedula Número de cédula a validar
     * @return true si la cédula es válida, false en caso contrario
     */
    private boolean validarCedulaEcuatoriana(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }

        try {
            // Validar que los dos primeros dígitos correspondan a una provincia válida (01-24)
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) {
                return false;
            }

            // Validar el tercer dígito (debe ser menor a 6 para cédulas de personas naturales)
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito > 5) {
                return false;
            }

            // Algoritmo de validación del dígito verificador
            int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
            int suma = 0;

            for (int i = 0; i < 9; i++) {
                int valor = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                if (valor >= 10) {
                    valor -= 9;
                }
                suma += valor;
            }

            int digitoVerificador = Integer.parseInt(cedula.substring(9, 10));
            int residuo = suma % 10;
            int resultado = residuo == 0 ? 0 : 10 - residuo;

            return resultado == digitoVerificador;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public boolean validar() throws DocumentoInvalidoException {
        StringBuilder errores = new StringBuilder();

        // Validar cédula
        if (!validarCedulaEcuatoriana(cedula)) {
            errores.append("- Cédula ecuatoriana inválida\n");
        }


        // Validar campos obligatorios
        if (nombres == null || nombres.trim().isEmpty()) {
            errores.append("- Los nombres son obligatorios\n");
        }

        if (apellidos == null || apellidos.trim().isEmpty()) {
            errores.append("- Los apellidos son obligatorios\n");
        }

        if (usuario == null || usuario.trim().isEmpty()) {
            errores.append("- El usuario es obligatorio\n");
        }

        if (clave == null || clave.trim().isEmpty()) {
            errores.append("- Los clave es obligatorio\n");
        }

        return true;
    }
}