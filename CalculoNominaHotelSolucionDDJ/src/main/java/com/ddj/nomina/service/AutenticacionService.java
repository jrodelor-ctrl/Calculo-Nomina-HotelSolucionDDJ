/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina.service;

import com.ddj.nomina.model.Rol;
import com.ddj.nomina.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado del proceso de autenticación.
 * Maneja los usuarios de prueba del sistema.
 */

public class AutenticacionService {

    private final List<Usuario> usuarios = new ArrayList<>();
    /**
     * Constructor que inicializa los usuarios del sistema.
     */
    public AutenticacionService() {
        usuarios.add(new Usuario("gerente", "1234", Rol.GERENTE));
        usuarios.add(new Usuario("rrhh", "1234", Rol.RECURSO_HUMANO));
    }
    /**
     * Verifica si existe un usuario con las credenciales ingresadas.
     * @param username nombre de usuario
     * @param password contraseña
     * @return Optional con el usuario si existe
     */    
    public Optional<Usuario> iniciarSesion(String username, String password) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
    }
}