package com.ddj.nomina.service;

import com.ddj.nomina.model.Empleado;

/**
 * Servicio principal de cálculo de nómina.
 */
public class NominaService {

    private final DeduccionService deduccionService = new DeduccionService();
    private final BeneficioService beneficioService = new BeneficioService();

    public double calcularSalarioBruto(Empleado empleado) {
        return empleado.calcularSalarioBruto();
    }

    public double calcularBeneficios(Empleado empleado) {
        return beneficioService.calcularBeneficios(empleado);
    }

    public double calcularDeducciones(Empleado empleado) {
        return deduccionService.calcularTotalDeducciones(empleado.calcularSalarioBruto());
    }

    public double calcularSalarioNeto(Empleado empleado) {
        double bruto = calcularSalarioBruto(empleado);
        double beneficios = calcularBeneficios(empleado);
        double deducciones = calcularDeducciones(empleado);

        double neto = bruto + beneficios - deducciones;
        return Math.max(neto, 0);
    }

    public String generarResumenNomina(Empleado empleado) {
        double bruto = calcularSalarioBruto(empleado);
        double beneficios = calcularBeneficios(empleado);
        double deducciones = calcularDeducciones(empleado);
        double neto = calcularSalarioNeto(empleado);

        return "=== RESUMEN DE NÓMINA ===\n" +
                "Empleado: " + empleado.getNombre() + "\n" +
                "Tipo: " + empleado.getTipoEmpleado() + "\n" +
                "Salario bruto: $" + String.format("%,.2f", bruto) + "\n" +
                "Beneficios: $" + String.format("%,.2f", beneficios) + "\n" +
                "Deducciones: $" + String.format("%,.2f", deducciones) + "\n" +
                "Salario neto: $" + String.format("%,.2f", neto);
    }
}