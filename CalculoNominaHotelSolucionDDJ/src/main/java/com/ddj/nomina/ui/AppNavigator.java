/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddj.nomina.ui;

import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.AutenticacionService;
import com.ddj.nomina.service.EmpleadoRepository;
import com.ddj.nomina.service.NominaService;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase encargada de controlar la navegación entre las vistas.
 */

public class AppNavigator {

    private final Stage stage;
    private final AutenticacionService autenticacionService;
    private final EmpleadoRepository empleadoRepository;
    private final NominaService nominaService;

    /**
     * Constructor del navegador principal.
     */
    
    public AppNavigator(Stage stage) {
        this.stage = stage;
        this.autenticacionService = new AutenticacionService();
        this.empleadoRepository = new EmpleadoRepository();
        this.nominaService = new NominaService();
    }
  /**
     * Muestra el panel principal del sistema.
     */
    public void showLogin() {
        LoginView view = new LoginView(this, autenticacionService);
        Scene scene = new Scene(view.getView(), 1000, 650);
        stage.setTitle("Cálculo de la Nómina de Empleados - Hotel Solución DDJ");
        stage.setScene(scene);
        stage.show();
    }

    public void showDashboard(Usuario usuario) {
        DashboardView view = new DashboardView(this, usuario, empleadoRepository, nominaService);
        stage.setScene(new Scene(view.getView(), 1100, 700));
    }

    public void showRegistro(Usuario usuario) {
        RegistroEmpleadoView view = new RegistroEmpleadoView(this, usuario, empleadoRepository);
        stage.setScene(new Scene(view.getView(), 1100, 700));
    }
 /**
     * Muestra la vista para calcular la nómina.
     */
    public void showNomina(Usuario usuario) {
        NominaView view = new NominaView(this, usuario, empleadoRepository, nominaService);
        stage.setScene(new Scene(view.getView(), 1100, 700));
    }
}