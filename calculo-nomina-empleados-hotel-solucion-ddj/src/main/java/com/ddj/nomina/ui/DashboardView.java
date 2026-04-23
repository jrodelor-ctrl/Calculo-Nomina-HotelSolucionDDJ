package com.ddj.nomina.ui;

import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.EmpleadoRepository;
import com.ddj.nomina.service.NominaService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Vista principal del sistema.
 */
public class DashboardView {

    private final AppNavigator navigator;
    private final Usuario usuario;
    private final EmpleadoRepository empleadoRepository;
    private final NominaService nominaService;
    private final BorderPane root;

    public DashboardView(AppNavigator navigator, Usuario usuario,
                         EmpleadoRepository empleadoRepository, NominaService nominaService) {
        this.navigator = navigator;
        this.usuario = usuario;
        this.empleadoRepository = empleadoRepository;
        this.nominaService = nominaService;
        this.root = construirVista();
    }

    public Parent getView() {
        return root;
    }

    private BorderPane construirVista() {
        BorderPane pane = new BorderPane();

        Stop[] stops = new Stop[] {
                new Stop(0, Color.web("#0f172a")),
                new Stop(1, Color.web("#1e3a8a"))
        };

        pane.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops),
                CornerRadii.EMPTY, Insets.EMPTY
        )));

        Label titulo = new Label("Cálculo de la Nómina de Empleados - Hotel Solución DDJ");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setTextFill(Color.WHITE);

        Label subtitulo = new Label("Bienvenido, " + usuario.getUsername() + " | Rol: " + usuario.getRol());
        subtitulo.setTextFill(Color.web("#cbd5e1"));
        subtitulo.setFont(Font.font(15));

        VBox top = new VBox(8, titulo, subtitulo);
        top.setPadding(new Insets(20));
        pane.setTop(top);

        Label marcaAgua = new Label("Hotel Solución DDJ");
        marcaAgua.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 50));
        marcaAgua.setTextFill(Color.rgb(255, 255, 255, 0.10));

        Button btnRegistro = new Button("Registrar Empleado");
        Button btnNomina = new Button("Calcular Nómina");
        Button btnCerrar = new Button("Cerrar Sesión");

        String estiloBtn = """
                -fx-background-color: rgba(255,255,255,0.90);
                -fx-text-fill: #0f172a;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-background-radius: 14;
                -fx-padding: 12 20 12 20;
                """;

        btnRegistro.setStyle(estiloBtn);
        btnNomina.setStyle(estiloBtn);
        btnCerrar.setStyle(estiloBtn);

        btnRegistro.setOnAction(e -> navigator.showRegistro(usuario));
        btnNomina.setOnAction(e -> navigator.showNomina(usuario));
        btnCerrar.setOnAction(e -> navigator.showLogin());

        VBox menu = new VBox(16, btnRegistro, btnNomina, btnCerrar);
        menu.setAlignment(Pos.CENTER);
        menu.setMaxWidth(280);

        StackPane center = new StackPane(marcaAgua, menu);
        center.setPadding(new Insets(20));
        pane.setCenter(center);

        return pane;
    }
}