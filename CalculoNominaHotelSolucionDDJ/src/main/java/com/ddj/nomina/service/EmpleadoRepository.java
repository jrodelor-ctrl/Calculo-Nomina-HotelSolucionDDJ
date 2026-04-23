/**
 * Repositorio en memoria para almacenar empleados registrados.
 */
package com.ddj.nomina.service;

import com.ddj.nomina.model.Empleado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmpleadoRepository {

    private final List<Empleado> empleados = new ArrayList<>();
  /**
     * Guarda un empleado en la lista interna.
     */
    public void guardar(Empleado empleado) {
        empleados.add(empleado);
    }
  /**
     * Retorna una lista no modificable de empleados.
     */
    public List<Empleado> listar() {
        return Collections.unmodifiableList(empleados);
    }
}