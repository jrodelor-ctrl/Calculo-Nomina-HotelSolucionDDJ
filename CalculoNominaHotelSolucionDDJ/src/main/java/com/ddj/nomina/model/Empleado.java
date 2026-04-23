/**
 * Clase abstracta base para todos los tipos de empleados.
 * Define los atributos comunes y obliga a implementar
 * los métodos de cálculo de salario y beneficios.
 */
package com.ddj.nomina.model;

public abstract class Empleado {
    protected int id;
    protected String nombre;
    protected String identificacion;
    protected int aniosEmpresa;
    protected double salarioBase;

    /**
     * Constructor principal de la clase Empleado.
     * Incluye validaciones para evitar datos incorrectos.
     */
    
    public Empleado(int id, String nombre, String identificacion, int aniosEmpresa, double salarioBase) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
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
    /**
     * Método abstracto para calcular el salario bruto.
     * Cada tipo de empleado implementa este cálculo de forma distinta.
     */
    
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

    /**
     * Retorna el nombre de la clase para identificar el tipo de empleado.
     */
    public String getTipoEmpleado() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return nombre + " - " + getTipoEmpleado();
    }
}