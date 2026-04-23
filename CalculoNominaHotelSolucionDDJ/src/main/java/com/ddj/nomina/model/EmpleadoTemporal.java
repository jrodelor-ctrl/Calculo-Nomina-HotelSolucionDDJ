/**
 * Clase que representa un empleado temporal.
 * Tiene salario fijo y no recibe beneficios adicionales.
 */
package com.ddj.nomina.model;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(int id, String nombre, String identificacion, int aniosEmpresa, double salarioBase) {
        super(id, nombre, identificacion, aniosEmpresa, salarioBase);
    }
   /**
     * El salario bruto corresponde al salario base del empleado temporal.
     */
    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }
  /**
     * El empleado temporal no recibe beneficios adicionales.
     */
    @Override
    public double calcularBeneficios() {
        return 0.0;
    }
}