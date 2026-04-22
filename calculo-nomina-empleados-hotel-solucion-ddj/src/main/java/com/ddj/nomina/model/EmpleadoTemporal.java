package com.ddj.nomina.model;

/**
 * Empleado temporal.
 * - Salario fijo mensual.
 * - No recibe beneficios adicionales.
 */
public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(int id, String nombre, String identificacion,
                            int aniosEmpresa, double salarioBase) {
        super(id, nombre, identificacion, aniosEmpresa, salarioBase);
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }

    @Override
    public double calcularBeneficios() {
        return 0.0;
    }
}