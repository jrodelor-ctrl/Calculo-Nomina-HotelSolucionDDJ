package com.ddj.nomina.service;

/**
 * Servicio para cálculo de deducciones.
 */
public class DeduccionService {

    private static final double SEGURIDAD_SOCIAL_PENSION = 0.04;
    private static final double ARL = 0.01;

    public double calcularSeguridadSocialYPension(double salarioBruto) {
        return salarioBruto * SEGURIDAD_SOCIAL_PENSION;
    }

    public double calcularArl(double salarioBruto) {
        return salarioBruto * ARL;
    }

    public double calcularTotalDeducciones(double salarioBruto) {
        return calcularSeguridadSocialYPension(salarioBruto) + calcularArl(salarioBruto);
    }
}