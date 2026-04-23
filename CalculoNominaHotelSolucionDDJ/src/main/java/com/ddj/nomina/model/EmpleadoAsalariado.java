/**
 * Clase que representa un empleado asalariado.
 * Su salario es fijo y puede recibir bono por antigüedad.
 */
package com.ddj.nomina.model;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(int id, String nombre, String identificacion, int aniosEmpresa, double salarioBase) {
        super(id, nombre, identificacion, aniosEmpresa, salarioBase);
    }
    /**
     * El salario bruto del empleado asalariado corresponde a su salario base.
     */

    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }
  /**
     * Calcula beneficios:
     * - Bono del 10% si tiene más de 5 años
     * - Bono de alimentación por ser empleado permanente
     */
    @Override
    public double calcularBeneficios() {
        double bonoAntiguedad = 0.0;
        if (aniosEmpresa > 5) {
            bonoAntiguedad = salarioBase * 0.10;
        }
        double bonoAlimentacion = 1_000_000;
        return bonoAntiguedad + bonoAlimentacion;
    }
}