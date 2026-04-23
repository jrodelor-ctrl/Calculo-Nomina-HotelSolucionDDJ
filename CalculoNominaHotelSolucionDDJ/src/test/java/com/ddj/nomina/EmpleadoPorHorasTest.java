/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina;

import com.ddj.nomina.model.EmpleadoPorHoras;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpleadoPorHorasTest {

    @Test
    void debeCalcularHorasNormales() {
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
                2, "Daniel", "1002", 1, 20000, 40, false
        );

        assertEquals(800000, empleado.calcularSalarioBruto(), 0.01);
    }

    @Test
    void debeCalcularHorasExtras() {
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
                2, "Daniel", "1002", 2, 20000, 50, false
        );

        double esperado = (40 * 20000) + (10 * 30000);
        assertEquals(esperado, empleado.calcularSalarioBruto(), 0.01);
    }

    @Test
    void debeCalcularBeneficioFondoAhorro() {
        EmpleadoPorHoras empleado = new EmpleadoPorHoras(
                2, "Daniel", "1002", 2, 20000, 40, true
        );

        assertEquals(16000, empleado.calcularBeneficios(), 0.01);
    }

    @Test
    void debeLanzarErrorSiHorasSonNegativas() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoPorHoras(2, "Daniel", "1002", 2, 20000, -5, true)
        );
    }
}