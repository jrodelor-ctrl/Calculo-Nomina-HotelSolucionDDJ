/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina;

import com.ddj.nomina.service.AutenticacionService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutenticacionServiceTest {

    @Test
    void debeIniciarSesionGerente() {
        AutenticacionService service = new AutenticacionService();
        assertTrue(service.iniciarSesion("gerente", "1234").isPresent());
    }

    @Test
    void debeIniciarSesionRecursoHumano() {
        AutenticacionService service = new AutenticacionService();
        assertTrue(service.iniciarSesion("rrhh", "1234").isPresent());
    }

    @Test
    void noDebeIniciarSesionConCredencialesInvalidas() {
        AutenticacionService service = new AutenticacionService();
        assertFalse(service.iniciarSesion("admin", "9999").isPresent());
    }
}