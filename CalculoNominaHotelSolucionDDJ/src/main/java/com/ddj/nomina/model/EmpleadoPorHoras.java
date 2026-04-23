/**
 * Clase que representa un empleado remunerado por horas trabajadas.
 * Incluye manejo de horas extras y fondo de ahorro.
 */
package com.ddj.nomina.model;

public class EmpleadoPorHoras extends Empleado {
    private double horasTrabajadas;
    private double tarifaHora;
    private boolean aceptaFondoAhorro;

    public EmpleadoPorHoras(int id, String nombre, String identificacion, int aniosEmpresa,
                            double tarifaHora, double horasTrabajadas, boolean aceptaFondoAhorro) {
        super(id, nombre, identificacion, aniosEmpresa, 0);

        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas.");
        }
        if (tarifaHora < 0) {
            throw new IllegalArgumentException("La tarifa por hora no puede ser negativa.");
        }

        this.tarifaHora = tarifaHora;
        this.horasTrabajadas = horasTrabajadas;
        this.aceptaFondoAhorro = aceptaFondoAhorro;
    }
/**
     * Calcula el salario bruto.
     * Si supera 40 horas, las horas adicionales se pagan al 1.5.
     */
    @Override
    public double calcularSalarioBruto() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * tarifaHora;
        }

        double normales = 40 * tarifaHora;
        double extras = (horasTrabajadas - 40) * (tarifaHora * 1.5);
        return normales + extras;
    }
  /**
     * Calcula el beneficio del fondo de ahorro.
     * Solo aplica si tiene más de 1 año y acepta el fondo.
     */
    @Override
    public double calcularBeneficios() {
        if (aniosEmpresa > 1 && aceptaFondoAhorro) {
            return calcularSalarioBruto() * 0.02;
        }
        return 0.0;
    }
}