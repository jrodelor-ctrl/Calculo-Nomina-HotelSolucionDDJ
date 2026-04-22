package com.ddj.nomina.ui;

import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.AutenticacionService;
import com.ddj.nomina.service.EmpleadoRepository;
import com.ddj.nomina.service.NominaService;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Navegador principal entre vistas.
 */
public class AppNavigator {

    private final Stage stage;
    private final AutenticacionService autenticacionService;
    private final EmpleadoRepository empleadoRepository;
    private final NominaService nominaService;

    public AppNavigator(Stage stage) {
        this.stage = stage;
        this.autenticacionService = new AutenticacionService();
        this.empleadoRepository = new EmpleadoRepository();
        this.nominaService = new NominaService();
    }

    public void showLogin() {
        LoginView view = new LoginView(this, autenticacionService);
        Scene scene = new Scene(view.getView(), 1000, 650);
        stage.setScene(scene);
        stage.setTitle("Cálculo de la Nómina de Empleados - Hotel Solución DDJ");
        stage.show();
    }

    public void showDashboard(Usuario usuario) {
        DashboardView view = new DashboardView(this, usuario, empleadoRepository, nominaService);
        Scene scene = new Scene(view.getView(), 1100, 700);
        stage.setScene(scene);
    }

    public void showRegistro(Usuario usuario) {
        RegistroEmpleadoView view = new RegistroEmpleadoView(this, usuario, empleadoRepository);
        Scene scene = new Scene(view.getView(), 1100, 700);
        stage.setScene(scene);
    }

    public void showNomina(Usuario usuario) {
        NominaView view = new NominaView(this, usuario, empleadoRepository, nominaService);
        Scene scene = new Scene(view.getView(), 1100, 700);
        stage.setScene(scene);
    }
}