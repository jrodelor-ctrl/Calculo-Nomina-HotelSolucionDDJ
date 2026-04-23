/**
 * Clase que representa un usuario del sistema.
 * Cada usuario tiene nombre de usuario, contraseña y un rol asignado.
 */
package com.ddj.nomina.model;

public class Usuario {
    private String username;
    private String password;
    private Rol rol;

    /**
     * Constructor de la clase Usuario.
     * @param username nombre de usuario
     * @param password contraseña del usuario
     * @param rol rol asignado dentro del sistema
     */
    public Usuario(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }
}