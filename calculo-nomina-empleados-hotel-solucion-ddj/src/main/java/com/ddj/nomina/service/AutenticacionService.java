package com.ddj.nomina.service;

import com.ddj.nomina.model.Rol;
import com.ddj.nomina.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio de autenticacion simple en memoria.
 * Para fines academicos se manejan usuarios locales.
 */
public class AutenticacionService {

    private final List<Usuario> usuarios = new ArrayList<>();

    public AutenticacionService() {
        usuarios.add(new Usuario("gerente", "1234", Rol.GERENTE));
        usuarios.add(new Usuario("rrhh", "1234", Rol.RECURSO_HUMANO));
    }

    public Optional<Usuario> iniciarSesion(String username, String password) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
    }
}