package com.ddj.nomina;

import com.ddj.nomina.ui.AppNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Punto de entrada principal de la aplicacion.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        AppNavigator navigator = new AppNavigator(stage);
        navigator.showLogin();
    }

    public static void main(String[] args) {
        launch(args);
    }
}