package com.ddj.nomina.service;

import com.ddj.nomina.model.Empleado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repositorio en memoria para almacenar empleados.
 */
public class EmpleadoRepository {

    private final List<Empleado> empleados = new ArrayList<>();

    public void guardar(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> listar() {
        return Collections.unmodifiableList(empleados);
    }
}