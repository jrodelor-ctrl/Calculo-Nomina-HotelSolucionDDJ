package com.ddj.nomina.service;

import com.ddj.nomina.model.Empleado;

/**
 * Servicio para centralizar cálculo de beneficios.
 */
public class BeneficioService {

    public double calcularBeneficios(Empleado empleado) {
        return empleado.calcularBeneficios();
    }
}