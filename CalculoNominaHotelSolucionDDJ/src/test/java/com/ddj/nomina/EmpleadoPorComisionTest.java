/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina;

import com.ddj.nomina.model.EmpleadoPorComision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmpleadoPorComisionTest {

    @Test
    void debeCalcularSalarioBrutoPorComision() {
        EmpleadoPorComision empleado = new EmpleadoPorComision(
                3, "Daniela", "1003", 4, 2000000, 10000000, 0.08
        );

        double esperado = 2000000 + (10000000 * 0.08);
        assertEquals(esperado, empleado.calcularSalarioBruto(), 0.01);
    }

    @Test
    void debeCalcularBeneficiosConBonoVentasYAlimentacion() {
        EmpleadoPorComision empleado = new EmpleadoPorComision(
                3, "Daniela", "1003", 4, 2000000, 25000000, 0.08
        );

        double esperado = (25000000 * 0.03) + 1000000;
        assertEquals(esperado, empleado.calcularBeneficios(), 0.01);
    }

    @Test
    void debeLanzarErrorSiVentasSonNegativas() {
        assertThrows(IllegalArgumentException.class, () ->
                new EmpleadoPorComision(3, "Daniela", "1003", 4, 2000000, -1, 0.08)
        );
    }
}
