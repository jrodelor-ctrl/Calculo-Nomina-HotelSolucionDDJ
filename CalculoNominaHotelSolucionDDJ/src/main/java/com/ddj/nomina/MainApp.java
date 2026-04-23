package com.ddj.nomina;

import com.ddj.nomina.ui.AppNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase principal del sistema.
 * Desde aquí se inicia la aplicación JavaFX.
 */
public class MainApp extends Application {
      /**
     * Método start de JavaFX.
     * Se ejecuta al iniciar la aplicación y muestra la ventana de login.
     */   
        @Override
    public void start(Stage stage) {
        AppNavigator navigator = new AppNavigator(stage);
        navigator.showLogin();
    }
       /**
     * Método main que lanza la aplicación.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
// Para que corra dar click derecho sobre el proyecto, buscar
// run maven, other goals, y en goals, pegar
// javafx:run, y luego aceptar.