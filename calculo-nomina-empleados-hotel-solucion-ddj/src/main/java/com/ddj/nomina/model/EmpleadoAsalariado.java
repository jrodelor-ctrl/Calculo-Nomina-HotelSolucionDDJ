package com.ddj.nomina.model;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(int id, String nombre, String identificacion, int aniosEmpresa, double salarioBase) {
        super(id, nombre, identificacion, aniosEmpresa, salarioBase);
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }

    @Override
    public double calcularBeneficios() {
        double bono = 0;
        if (aniosEmpresa > 5) {
            bono = salarioBase * 0.10;
        }
        double bonoAlimentacion = 1000000;
        return bono + bonoAlimentacion;
    }
}