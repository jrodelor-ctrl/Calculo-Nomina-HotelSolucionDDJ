/**
 * Vista encargada de mostrar el cálculo de nómina de un empleado.
 */
package com.ddj.nomina.ui;

import com.ddj.nomina.model.Empleado;
import com.ddj.nomina.model.Usuario;
import com.ddj.nomina.service.EmpleadoRepository;
import com.ddj.nomina.service.NominaService;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NominaView {

    private final AppNavigator navigator;
    private final Usuario usuario;
    private final EmpleadoRepository empleadoRepository;
    private final NominaService nominaService;
    private final BorderPane root;

    public NominaView(AppNavigator navigator, Usuario usuario,
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
        pane.setBackground(new Background(new BackgroundFill(
                Color.web("#f8fafc"), CornerRadii.EMPTY, Insets.EMPTY
        )));

        Label titulo = new Label("Cálculo de Nómina");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setTextFill(Color.web("#0f172a"));

        Button btnVolver = new Button("Volver");
        btnVolver.setOnAction(e -> navigator.showDashboard(usuario));

        HBox top = new HBox(20, titulo, btnVolver);
        top.setPadding(new Insets(20));
        pane.setTop(top);

        ComboBox<Empleado> cmbEmpleados = new ComboBox<>();
        cmbEmpleados.setItems(FXCollections.observableArrayList(empleadoRepository.listar()));

        TextArea resultado = new TextArea();
        resultado.setEditable(false);
        resultado.setPrefHeight(350);

        Button btnCalcular = new Button("Calcular Nómina");
        btnCalcular.setStyle(
                "-fx-background-color: #0f766e;"
                + "-fx-text-fill: white;"
                + "-fx-font-weight: bold;"
                + "-fx-background-radius: 12;"
        );

        btnCalcular.setOnAction(e -> {
            Empleado empleado = cmbEmpleados.getValue();
            if (empleado == null) {
                resultado.setText("Debe seleccionar un empleado.");
                return;
            }
            resultado.setText(nominaService.generarResumenNomina(empleado));
        });

        VBox center = new VBox(15,
                new Label("Empleado:"),
                cmbEmpleados,
                btnCalcular,
                resultado
        );
        center.setPadding(new Insets(20));

        pane.setCenter(center);
        return pane;
    }
}