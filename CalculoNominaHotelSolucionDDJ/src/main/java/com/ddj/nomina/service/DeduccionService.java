/**
 * Servicio encargado del cálculo de deducciones obligatorias.
 */
package com.ddj.nomina.service;

public class DeduccionService {

    private static final double SEGURIDAD_SOCIAL_PENSION = 0.04;
    private static final double ARL = 0.01;
   /**
     * Calcula el descuento por seguridad social y pensión.
     */
    public double calcularSeguridadSocialYPension(double salarioBruto) {
        return salarioBruto * SEGURIDAD_SOCIAL_PENSION;
    }
    /**
     * Calcula el descuento correspondiente al ARL.
     */

    public double calcularArl(double salarioBruto) {
        return salarioBruto * ARL;
    }
  /**
     * Retorna la suma total de todas las deducciones.
     */
    public double calcularTotalDeducciones(double salarioBruto) {
        return calcularSeguridadSocialYPension(salarioBruto) + calcularArl(salarioBruto);
    }
}