package com.ddj.nomina.model;

/**
 * Empleado por comisión.
 * - Salario base + porcentaje sobre ventas.
 * - Bono adicional del 3% si ventas > 20.000.000.
 * - Bono de alimentación por ser permanente.
 */
public class EmpleadoPorComision extends Empleado {

    private double ventas;
    private double porcentajeComision;

    public EmpleadoPorComision(int id, String nombre, String identificacion,
                               int aniosEmpresa, double salarioBase,
                               double ventas, double porcentajeComision) {
        super(id, nombre, identificacion, aniosEmpresa, salarioBase);

        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas.");
        }
        if (porcentajeComision < 0) {
            throw new IllegalArgumentException("El porcentaje de comisión no puede ser negativo.");
        }

        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase + (ventas * porcentajeComision);
    }

    @Override
    public double calcularBeneficios() {
        double bonoVentas = 0.0;
        if (ventas > 20_000_000) {
            bonoVentas = ventas * 0.03;
        }
        double bonoAlimentacion = 1_000_000;
        return bonoVentas + bonoAlimentacion;
    }
}