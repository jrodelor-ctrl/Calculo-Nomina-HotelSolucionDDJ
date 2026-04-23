/**
 * Servicio encargado de centralizar el cálculo de beneficios.
 */
package com.ddj.nomina.service;

import com.ddj.nomina.model.Empleado;

public class BeneficioService {
  /**
     * Obtiene los beneficios de un empleado según su tipo.
     */
    public double calcularBeneficios(Empleado empleado) {
        return empleado.calcularBeneficios();
    }
}