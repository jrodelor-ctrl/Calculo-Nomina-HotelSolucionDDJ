package com.ddj.nomina.ui;

import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.AutenticacionService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Optional;

/**
 * Vista de inicio de sesion.
 */
public class LoginView {

    private final AppNavigator navigator;
    private final AutenticacionService autenticacionService;
    private final StackPane root;

    public LoginView(AppNavigator navigator, AutenticacionService autenticacionService) {
        this.navigator = navigator;
        this.autenticacionService = autenticacionService;
        this.root = construirVista();
    }

    public Parent getView() {
        return root;
    }

    private StackPane construirVista() {
        StackPane stack = new StackPane();

        Stop[] stops = new Stop[] {
                new Stop(0, Color.web("#0f172a")),
                new Stop(0.5, Color.web("#1d4ed8")),
                new Stop(1, Color.web("#0ea5e9"))
        };
        LinearGradient gradient = new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops
        );

        Background background = new Background(
                new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)
        );
        stack.setBackground(background);

        BorderPane overlay = new BorderPane();

        Label tituloApp = new Label("Cálculo de la Nómina de Empleados");
        tituloApp.setTextFill(Color.WHITE);
        tituloApp.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        BorderPane.setAlignment(tituloApp, Pos.CENTER);
        BorderPane.setMargin(tituloApp, new Insets(20, 0, 0, 0));
        overlay.setTop(tituloApp);

        Label hotelLabel = new Label("Hotel Solución DDJ");
        hotelLabel.setTextFill(Color.rgb(255, 255, 255, 0.18));
        hotelLabel.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 52));

        VBox loginCard = new VBox(15);
        loginCard.setAlignment(Pos.CENTER);
        loginCard.setPadding(new Insets(30));
        loginCard.setMaxWidth(360);
        loginCard.setStyle("""
                -fx-background-color: rgba(255,255,255,0.16);
                -fx-background-radius: 20;
                -fx-border-color: rgba(255,255,255,0.20);
                -fx-border-radius: 20;
                """);

        Label loginTitle = new Label("Inicio de Sesión");
        loginTitle.setTextFill(Color.WHITE);
        loginTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuario");

        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        Label ayuda = new Label("Usuarios de prueba: gerente / 1234   |   rrhh / 1234");
        ayuda.setWrapText(true);
        ayuda.setTextFill(Color.WHITE);

        Label mensaje = new Label();
        mensaje.setTextFill(Color.web("#fde68a"));

        Button btnIngresar = new Button("Ingresar");
        btnIngresar.setStyle("""
                -fx-background-color: white;
                -fx-text-fill: #0f172a;
                -fx-font-weight: bold;
                -fx-background-radius: 12;
                -fx-padding: 10 20 10 20;
                """);
        btnIngresar.setMaxWidth(Double.MAX_VALUE);

        btnIngresar.setOnAction(e -> {
            String usuario = txtUsuario.getText().trim();
            String password = txtPassword.getText().trim();

            Optional<Usuario> user = autenticacionService.iniciarSesion(usuario, password);
            if (user.isPresent()) {
                navigator.showDashboard(user.get());
            } else {
                mensaje.setText("Credenciales inválidas.");
            }
        });

        loginCard.getChildren().addAll(
                loginTitle, txtUsuario, txtPassword, btnIngresar, ayuda, mensaje
        );

        StackPane centerPane = new StackPane(hotelLabel, loginCard);
        centerPane.setPadding(new Insets(20));

        overlay.setCenter(centerPane);
        stack.getChildren().add(overlay);

        return stack;
    }
}