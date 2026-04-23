/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina;

import com.ddj.nomina.model.EmpleadoAsalariado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoAsalariadoTest {

    @Test
    void debeCalcularSalarioBrutoAsalariado() {
        EmpleadoAsalariado empleado = new EmpleadoAsalariado(
                1, "Jaime", "1001", 3, 3000000
        );

        assertEquals(3000000, empleado.calcularSalarioBruto(), 0.01);
    }

    @Test
    void debeCalcularBeneficiosConBonoAntiguedadYAlimentacion() {
        EmpleadoAsalariado empleado = new EmpleadoAsalariado(
                1, "Jaime", "1001", 6, 3000000
        );

        double esperado = 300000 + 1000000;
        assertEquals(esperado, empleado.calcularBeneficios(), 0.01);
    }
}