package com.ddj.nomina.model;

public class EmpleadoPorHoras extends Empleado {

    private double horasTrabajadas;
    private double tarifaHora;
    private boolean aceptaFondo;

    public EmpleadoPorHoras(int id, String nombre, String identificacion,
                            int aniosEmpresa, double tarifaHora,
                            double horasTrabajadas, boolean aceptaFondo) {
        super(id, nombre, identificacion, aniosEmpresa, 0);

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Horas no pueden ser negativas");
        }

        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aceptaFondo = aceptaFondo;
    }

    @Override
    public double calcularSalarioBruto() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaHora;
        }
        double normales = 40 * tarifaHora;
        double extras = (horasTrabajadas - 40) * tarifaHora * 1.5;
        return normales + extras;
    }

    @Override
    public double calcularBeneficios() {
        if (aniosEmpresa > 1 && aceptaFondo) {
            return calcularSalarioBruto() * 0.02;
        }
        return 0;
    }
}