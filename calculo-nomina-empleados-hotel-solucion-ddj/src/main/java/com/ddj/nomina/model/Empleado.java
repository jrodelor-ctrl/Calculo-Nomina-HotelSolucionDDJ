package com.ddj.nomina.model;

/**
 * Clase abstracta base para todos los empleados del Hotel Solucion DDJ.
 * Aplica el principio de abstraccion y sirve como base para el polimorfismo.
 */
public abstract class Empleado {
    protected int id;
    protected String nombre;
    protected String identificacion;
    protected int aniosEmpresa;
    protected double salarioBase;

    public Empleado(int id, String nombre, String identificacion, int aniosEmpresa, double salarioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificacion no puede estar vacia.");
        }
        if (aniosEmpresa < 0) {
            throw new IllegalArgumentException("Los años en la empresa no pueden ser negativos.");
        }
        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo.");
        }

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.aniosEmpresa = aniosEmpresa;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalarioBruto();

    public abstract double calcularBeneficios();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public int getAniosEmpresa() {
        return aniosEmpresa;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public String getTipoEmpleado() {
        return this.getClass().getSimpleName();
    }
}