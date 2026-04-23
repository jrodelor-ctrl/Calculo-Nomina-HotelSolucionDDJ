/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina;

import com.ddj.nomina.model.EmpleadoTemporal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTemporalTest {

    @Test
    void debeCalcularSalarioBrutoTemporal() {
        EmpleadoTemporal empleado = new EmpleadoTemporal(
                4, "Temporal", "1004", 1, 1800000
        );

        assertEquals(1800000, empleado.calcularSalarioBruto(), 0.01);
    }

    @Test
    void noDebeTenerBeneficios() {
        EmpleadoTemporal empleado = new EmpleadoTemporal(
                4, "Temporal", "1004", 1, 1800000
        );

        assertEquals(0, empleado.calcularBeneficios(), 0.01);
    }
}